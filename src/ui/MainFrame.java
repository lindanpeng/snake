package ui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import control.GameControl;
import util.Util;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private MainPanel mainPanel=null;
	private GameControl gameControl;
   public MainFrame(MainPanel mainPanel,GameControl gameControl){
	     this.gameControl=gameControl;
	     this.mainPanel=mainPanel;
	     this.setContentPane(mainPanel);
		 this.addAction();
		 this.setTitle("Ã∞≥‘…ﬂ");
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 this.setSize(774,476);
		 this.setResizable(false);
	     Util.setFrameCenter(this);
		 this.setVisible(true);
   }
   public void addAction(){
		this.mainPanel.getSnakeUI().getStart_btn().addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout)mainPanel.getLayout()).show(mainPanel, "second");
				gameControl.startGame();
			}
			
		});
	   this.mainPanel.getOverPanel().getRestart_btn().addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			gameControl.startGame();
			
		}
		   
	   });
   }
}
