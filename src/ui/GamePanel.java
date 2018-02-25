package ui;

import java.awt.Graphics;
import java.awt.Point;
import java.util.List;
import javax.swing.JPanel;

import control.PlayerControl;
import dto.GameDto;
import util.MapData;
/**
 * 游戏运行面板
 * @author Administrator
 *
 */
public class GamePanel extends JPanel {
	private GameDto dto = null;
    private final int WALL_LENGTH=32;
    private final int BODY_LENGTH=32;

	public GamePanel() {

	}
	@Override
	public void paintComponent(Graphics g) {
		
		this.drawMap(g);
		this.drawFood(g);
		this.drawSnake(g);		
	}

	public void setDto(GameDto dto) {
		this.dto = dto;
	}
	   public void  setPlayerControl(PlayerControl control){
		   this.addKeyListener(control);
	   }
	//绘制地图
	private void drawMap(Graphics g) {
		//g.setColor(Color.black);
		//g.fillRect(0, 0, 768, 448);
		g.drawImage(Img.BG_1, 0, 0,null);
		MapData[][] map = this.dto.getGameMap();
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[i].length;j++)
				if(map[i][j]==MapData.wall){
					this.drawRect(j*WALL_LENGTH, i*WALL_LENGTH, g);
				}
		}
	}
    //绘制蛇
	private void drawSnake(Graphics g){
	  List<Point> snake=this.dto.getSnakeBody();
	 for(int i=0;i<snake.size();i++)
	 {
		 if(i==0)
			 {
	        //TODO 改成Map查找		 
			 switch(this.dto.getBearing()){
			     case LEFT:g.drawImage(Img.HEAD_L, snake.get(i).x*BODY_LENGTH,snake.get(i).y*BODY_LENGTH, null);break; 
			     case RIGHT:g.drawImage(Img.HEAD_R, snake.get(i).x*BODY_LENGTH,snake.get(i).y*BODY_LENGTH, null);break; 
			     case UP:g.drawImage(Img.HEAD_U, snake.get(i).x*BODY_LENGTH,snake.get(i).y*BODY_LENGTH, null);break;
			     case DOWN:g.drawImage(Img.HEAD_D, snake.get(i).x*BODY_LENGTH,snake.get(i).y*BODY_LENGTH, null);break;
			   }
			 }
		 else 
			 g.drawImage(Img.BODY, snake.get(i).x*BODY_LENGTH,snake.get(i).y*BODY_LENGTH, null);
	 }
	}
	//绘制方块
	private void drawRect(int x,int y,Graphics g){
	  g.drawImage(Img.WALL, x, y,x+WALL_LENGTH,y+WALL_LENGTH, 0, 0, WALL_LENGTH,WALL_LENGTH,null);
	}

	private void drawFood(Graphics g){
		Point food=this.dto.getFood_Position();
		g.drawImage(Img.FOOD,food.x*32,food.y*32,null);

	}

}
