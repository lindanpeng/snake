package service;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import dto.GameDto;
import util.Bearing;
import util.Util;
import util.MapData;

public class GameService {
	private GameDto dto;
	private final int WIN_POINT=25;
	public GameService(GameDto dto) {
		this.dto = dto;
	}

	public void turnLeft() {
		if (this.isOver()) {
			return;
		}
		if (this.dto.getBearing() == Bearing.RIGHT)
			return;
		synchronized (this.dto) {
			LinkedList<Point> snake = (LinkedList<Point>) dto.getSnakeBody();
			Point tail = (Point) snake.getLast().clone();
			this.moveBody(snake);
			snake.get(0).x--;
			this.UpdateMap();
			this.dto.setBearing(Bearing.LEFT);
			if (this.eatFood(snake.get(0))) {
				this.getLonger(tail);
			}
		}
	}

	public void turnRight() {
		if (this.isOver()) {
			return;
		}
		if (this.dto.getBearing() == Bearing.LEFT)
			return;
		synchronized (this.dto) {
			LinkedList<Point> snake = (LinkedList<Point>) dto.getSnakeBody();
			Point tail = (Point) snake.getLast().clone();
			this.moveBody(snake);
			// TODO 没有墙壁要进行模运算
			snake.get(0).x++;
			this.UpdateMap();
			this.dto.setBearing(Bearing.RIGHT);
			if (this.eatFood(snake.get(0))) {
				this.getLonger(tail);
			}
		}
	}

	public void turnUp() {
		if (this.isOver()) {
			return;
		}
		if (this.dto.getBearing() == Bearing.DOWN)
			return;
		synchronized (this.dto) {
			LinkedList<Point> snake = (LinkedList<Point>) dto.getSnakeBody();
			Point tail = (Point) snake.getLast().clone();
			this.moveBody(snake);
			snake.get(0).y--;
			this.UpdateMap();
			this.dto.setBearing(Bearing.UP);
			if (this.eatFood(snake.get(0))) {
				this.getLonger(tail);
			}
			
		}
	}

	public void turnDown() {
		if (this.isOver()) {
			return;
		}
		if (this.dto.getBearing() == Bearing.UP)
			return;
		synchronized (this.dto) {
			LinkedList<Point> snake = (LinkedList<Point>) dto.getSnakeBody();
			Point tail = (Point) snake.getLast().clone();
			this.moveBody(snake);
			snake.get(0).y++;
			this.UpdateMap();
			this.dto.setBearing(Bearing.DOWN);
			if (this.eatFood(snake.get(0))) {
				this.getLonger(tail);
			}
		}
	}

	public void Pause() {
      this.dto.setPause(true);
	}
    public boolean isOver(){
    	if(isDead()||isWin())
    	{
    		this.dto.setStart(false);
    		if(isDead())
    		  this.dto.setLose(true);
    		else
    		  this.dto.setLose(false);
    		return true;
    	}
    	return false;
    }
	public boolean isDead() {
		List<Point> snake = dto.getSnakeBody();
		MapData[][] map = dto.getGameMap();
		// TODO 有问题
		if (map[snake.get(0).y][snake.get(0).x] == MapData.wall) {
			return true;
		}
		else if (map[snake.get(0).y][snake.get(0).x] == MapData.body) {
			for (int i = 1; i < snake.size(); i++) {
				if (snake.get(0).equals(snake.get(i))) {
					return true;
				}
			}
		} 
			return false;
	}
  public boolean isWin(){
	  if(this.dto.getPoint()>=this.WIN_POINT)
		  return true;
	  return false;
  }
	public boolean eatFood(Point head) {
		Point food = this.dto.getFood_Position();
		if (food.equals(head)) {
			return true;
		}
		return false;
	}

	public void getLonger(Point tail) {
		int point=this.dto.getPoint();
		point++;
		this.dto.setPoint(point);
		LinkedList<Point> snake = (LinkedList<Point>) dto.getSnakeBody();
		MapData[][] map = this.dto.getGameMap();
		snake.addLast(tail);
		this.dto.setFood_Position(Util.getNewPoint(map));
	}
	public void moveBody(List<Point> snake) {
		for (int i = snake.size() - 1; i > 0; i--) {
			snake.get(i).x = snake.get(i - 1).x;
			snake.get(i).y = snake.get(i - 1).y;
		}
	}
	public void UpdateMap() {
		List<Point> snake = this.dto.getSnakeBody();
		MapData[][] map = this.dto.getGameMap();
		Util.initMap(map);
		for (int i = 0; i < snake.size(); i++) {
			if(map[snake.get(i).y][snake.get(i).x]!=MapData.wall)
			map[snake.get(i).y][snake.get(i).x] = MapData.body;
		}
	}
}
