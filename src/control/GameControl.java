package control;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import dto.GameDto;
import service.GameService;
import ui.MainFrame;
import ui.MainPanel;
import util.Bearing;
public class GameControl {
	private GameDto dto=null;
	private MainPanel mainPanel=null;
	private GameService gameService=null;
	private PlayerControl playerControl=null;
	private Map<Integer,Bearing> actionList=null;
	private Map<Bearing,Method> moveBearing=null;
	private MainThread gameThread=null;
 public GameControl(){
	   this.dto=new GameDto();
	   this.mainPanel=new MainPanel();
	   this.mainPanel.getGamePanel().setDto(this.dto);
	   new MainFrame(mainPanel,this);
	   this.playerControl=new PlayerControl(this);
	   this.gameService=new GameService(this.dto);
	   this.mainPanel.getGamePanel().setPlayerControl(this.playerControl);
	   this.actionList=new HashMap<Integer,Bearing>();
	   this.moveBearing=new HashMap<Bearing,Method>();
		try {
			actionList.put(37,Bearing.LEFT);//左
			actionList.put(38,Bearing.UP);//上
			actionList.put(39,Bearing.RIGHT);//右
			actionList.put(40,Bearing.DOWN);//下
			moveBearing.put(Bearing.LEFT, this.gameService.getClass().getMethod("turnLeft"));
			moveBearing.put(Bearing.UP, this.gameService.getClass().getMethod("turnUp"));
			moveBearing.put(Bearing.RIGHT,this.gameService.getClass().getMethod("turnRight"));
			moveBearing.put(Bearing.DOWN,this.gameService.getClass().getMethod("turnDown"));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
 }

public void actionByKeyCode(int keyCode) {
	try {
		if(this.actionList.containsKey(keyCode))
		{
			this.moveBearing.get(this.actionList.get(keyCode)).invoke(this.gameService);//调用gameService对象中的方法
		}

		}  catch (Exception e) {
			e.printStackTrace();
		}
	     this.mainPanel.getGamePanel().repaint();
	
}
public void startGame(){
	this.dto.dtoInit();
	this.gameThread=new MainThread();
	this.gameThread.start();
	this.mainPanel.getOverPanel().setVisible(false);
	this.mainPanel.getGamePanel().requestFocus();
	this.mainPanel.getGamePanel().repaint();
}
public void GameOver(){
	this.dto.setLevel(this.dto.getPoint()/30);
	this.mainPanel.getOverPanel().setVisible(true);
	this.mainPanel.getOverPanel().setLose(this.dto.isLose());
	this.mainPanel.repaint();
	
}

public class MainThread extends Thread{
 @Override
 public void run(){
	 while(dto.isStart())
	 {
	 try {
		   moveBearing.get(dto.getBearing()).invoke(gameService); 
		   mainPanel.getPointPanel().setPoint(dto.getPoint());
		   mainPanel.getGamePanel().repaint();
			Thread.sleep(dto.getSpeed());	 
		 } catch (Exception e) {
			e.printStackTrace();
		}
	 
	 }
	  GameOver();
 }
}
}
