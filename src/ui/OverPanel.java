package ui;

import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * ��Ϸ�������
 * @author Administrator
 *
 */
public class OverPanel extends JPanel{
private JButton restart_btn=null;
private JButton next=null;
private JLabel  point=null;
private boolean lose=true;
public OverPanel(){
 this.setOpaque(false);//�������͸�����������������壿��
 this.setLayout(null);
 this.initComponent();
}
@Override
public void paintComponent(Graphics g){
   super.paintComponent(g);
 //���ƹؿ����������ӰЧ��
   g.drawImage(Img.SHADOW,0,0,this.getWidth(),this.getHeight(),0,0,32,32,null);
   if(lose)
   g.drawImage(Img.LOST,(this.getWidth()-256)/2,(this.getHeight()-256)/2,(this.getWidth()-256)/2+256,(this.getHeight()-256)/2+128,0,0,256,128,null);
   else
   g.drawImage(Img.WIN,(this.getWidth()-256)/2,(this.getHeight()-256)/2,(this.getWidth()-256)/2+256,(this.getHeight()-256)/2+128,0,0,256,128,null);
}
public void initComponent(){
	// ���԰�ť
	restart_btn=new JButton(Img.RETRY_0);
	restart_btn.setRolloverIcon(Img.RETRY_1);
	restart_btn.setPressedIcon(Img.RETRY_2);
	restart_btn.setContentAreaFilled(false);
	restart_btn.setBorder(null);
	restart_btn.setBounds(324,230,128,64);
	this.add(restart_btn);
}
public JButton getRestart_btn() {
	return restart_btn;
}
public void setLose(boolean lose){
	this.lose=lose;
}
}
