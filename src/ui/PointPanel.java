package ui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * ·ÖÊýÃæ°å
 * @author Administrator
 *
 */
public class PointPanel extends JPanel{
    private JLabel score=null;
    private JLabel level=null;
    private JLabel score_num=null;
    private JLabel level_num=null;
   public PointPanel(){
	   this.setLayout(new FlowLayout(FlowLayout.LEFT));
	   this.setBounds(32,32, 100,100);
	   score=new JLabel("Your score:");
	   level=new JLabel("Your level:");
	   score_num=new JLabel("0");
	   level_num=new JLabel("0");
	   score.setForeground(Color.white);
	   level.setForeground(Color.white);
	   score_num.setForeground(Color.white);
	   level_num.setForeground(Color.white);
	   this.add(score);
	   this.add(score_num);
	   this.add(level);
	   this.add(level_num);
	   
   }

public void setPoint(int point) {
	// TODO Auto-generated method stub
	this.score_num.setText(String.valueOf(point));
}
 public void setLevel(int level){
	this.level_num.setText(String.valueOf(level));
 }
}
