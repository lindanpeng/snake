package ui;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * 游戏开始面板
 * @author Administrator
 *
 */
public class SnakeInterface extends JPanel {
private JButton start_btn=null;
private JButton about_btn=null;

public SnakeInterface(){
	this.initComponent();
	this.setLayout(null);
}
public JButton getStart_btn() {
	return start_btn;
}
public JButton getAbout_btn() {
	return about_btn;
}
private void initComponent(){
	start_btn=new JButton(Img.START_0);
	start_btn.setRolloverIcon(Img.START_1);
	start_btn.setPressedIcon(Img.START_2);
	start_btn.setContentAreaFilled(false);
	start_btn.setBorder(null);
	start_btn.setBounds(324,240,128,64);
	this.add(start_btn);
}
@Override
public void paintComponent(Graphics g){
	g.drawImage(Img.SNAKE_UI, 0, 0, null);
}

}
