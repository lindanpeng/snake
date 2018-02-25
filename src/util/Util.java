package util;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;

public class Util {
	public static void setFrameCenter(JFrame jf){
		 Toolkit toolkit=Toolkit.getDefaultToolkit();
		 Dimension screen=toolkit.getScreenSize();
		 int x=(screen.width-jf.getWidth())/2;
		 int y=(screen.height-jf.getHeight())/2;
		 jf.setLocation(x,y);
	}
 public static Point getNewPoint(MapData[][] map){
	   Random random=new Random();
		int newX=random.nextInt(24);
		int newY=random.nextInt(14);
		while(map[newY][newX]!=MapData.blank)
		{
			newX=random.nextInt(24);
			newY=random.nextInt(14);
		}
		return new Point(newX,newY);
 }
 public static void initMap(MapData[][] gameMap){
	 for(int i=0;i<gameMap.length;i++)//y×ø±ê
		{
			for(int j=0;j<gameMap[i].length;j++)//x×ø±ê
				if(i==0||i==gameMap.length-1||j==0||j==gameMap[i].length-1){
					gameMap[i][j]=MapData.wall;
				}
				else{
					gameMap[i][j]=MapData.blank;
				}
		}
 }
}
