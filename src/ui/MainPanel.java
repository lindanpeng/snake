package ui;

import java.awt.CardLayout;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private SnakeInterface snakeUI=null;
	private OverPanel overPanel=null;
	private GamePanel gamePanel=null;
	private PointPanel pointPanel=null;
	private JLayeredPane layeredPanel=null;
	public MainPanel(){
	   	 layeredPanel=new JLayeredPane();
	   	 pointPanel=new PointPanel();
		 overPanel=new OverPanel();
		 snakeUI=new SnakeInterface();
		 gamePanel=new GamePanel();
		 overPanel.setBounds(0, 0,768,448);
		 gamePanel.setBounds(0,0,768,448);
		 overPanel.setVisible(false);
		 pointPanel.setOpaque(false);
		 layeredPanel.add(overPanel, new Integer(3));
		 layeredPanel.add(pointPanel, new Integer(2));
		 layeredPanel.add(gamePanel, new Integer(1));
		 this.setLayout(new CardLayout());
		 this.add(snakeUI,"first");
		 this.add(layeredPanel, "second");
	}
	public PointPanel getPointPanel() {
		return pointPanel;
	}
	public void setPointPanel(PointPanel pointPanel) {
		this.pointPanel = pointPanel;
	}
	public SnakeInterface getSnakeUI() {
		return snakeUI;
	}
	public OverPanel getOverPanel() {
		return overPanel;
	}
	public JLayeredPane getLayeredPanel() {
		return layeredPanel;
	}
	public GamePanel getGamePanel() {
		return gamePanel;
	}


}
