package dto;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import util.Bearing;
import util.Util;
import util.MapData;

public class GameDto {
private MapData[][] gameMap;
private List<Point> SnakeBody;
private Point food_Position;
private Bearing bearing;
private boolean start;
private boolean lose;
private boolean pause;
private int level;
private int point;//·ÖÊý
private int speed;
private final int WALL_WIDTH=24;
private final int WALL_HEIGHT=14;
public GameDto(){

}
public void dtoInit() {
	//TODOÓ²±àÂë
	this.gameMap=new MapData[WALL_HEIGHT][WALL_WIDTH];
	Util.initMap(gameMap);
	this.SnakeBody=new LinkedList<Point>();
	this.food_Position=new Point();
	this.gameMap[7][12]=MapData.body;
	this.SnakeBody.add(new Point(12,7));
    this.food_Position=Util.getNewPoint(this.gameMap);
	this.bearing=Bearing.LEFT;
	this.start=true;
	this.lose=false;
	this.speed=500;
	this.point=0;
	this.level=0;
}
public int getSpeed() {
	return speed;
}
public void setSpeed(int speed) {
	this.speed = speed;
}
public boolean isLose() {
	return lose;
}
public void setLose(boolean lose) {
	this.lose = lose;
}
public Point getFood_Position() {
	return food_Position;
}
public void setFood_Position(Point food_Position) {
	this.food_Position = food_Position;
}
public Bearing getBearing() {
	return bearing;
}
public void setBearing(Bearing bearing) {
	this.bearing = bearing;
}
public List<Point> getSnakeBody() {
	return SnakeBody;
}
public boolean isStart() {
	return start;
}
public void setStart(boolean start) {
	this.start=start;
}
public MapData[][] getGameMap() {
	return gameMap;
}
public void setGameMap(MapData[][] map) {
	this.gameMap = map;
}
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}
public int getPoint() {
	return point;
}
public void setPoint(int point) {
	this.point = point;
}
public boolean isPause() {
	return pause;
}
public void setPause(boolean pause) {
	this.pause = pause;
}

}
