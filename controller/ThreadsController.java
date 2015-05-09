package controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.*;
import view.*;

public class ThreadsController extends Thread {
	 ArrayList<ArrayList<GridSquares>> Squares= new ArrayList<ArrayList<GridSquares>>();
	 Position headSnakePos;
	 int score = 0;
	 int sizeSnake=3;
	 long speed = 55;//50;//60;
	 int sizeX = Settings.sizeX;
	 int sizeY = Settings.sizeY;
	 public static int directionSnake;
	 private int time = 0;
	 JLabel timeLabel = new JLabel();
	 JLabel scoreLabel = new JLabel();
	 private Settings settings;
	 private boolean running;
	 ArrayList<Position> positions = new ArrayList<Position>();
	 Position foodPosition;
	 
	 ArrayList<Position> obstacles = new ArrayList<Position>();
	 
	 
	 public ThreadsController(Position positionDepart, Settings settings) {
		 this.settings = settings;
		 running = true;
		 Squares = GameWindow.Grid;
		
		timeLabel.setText(" ");
		
		scoreLabel.setText("0");
		scoreLabel.setHorizontalAlignment(JLabel.CENTER);
		scoreLabel.setVerticalAlignment(JLabel.CENTER);
		
		headSnakePos = new Position(positionDepart.getX(),positionDepart.getY());
		directionSnake = 1;
		Position headPos = new Position(headSnakePos.getX(),headSnakePos.getY());
		positions.add(headPos);
		
		for(int i=0; i<this.settings.getAmountObstacles(); i++){
			obstacles.add(notSnakeObstacle());
		}
				
		Position foodPos = notSnakeObstacle();
		foodPosition= new Position(foodPos.getX(), foodPos.getY());
		spawnFood(foodPosition);
	 }
	 
	 public void run() {
		 
		 refreshColor();
		 initialPauser();
		 
		 while(running){
			 moveSnake(directionSnake);
			 checkCollision();
			 refreshColor();
			 deleteTail();
			 pauser();
		 }
	 }
	 
	 public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	//Initial delay for 3 seconds
	 public void initialPauser(){
		 
		 InitialCountdown countdown = new InitialCountdown();
		 
		 time = 3;
		 timeLabel.setText(String.valueOf(time));
		 
		 try{
			 for(int x = 3; x > 0; x--){
				 sleep(1000);
				 countdown.incrementCount();
				 time = countdown.getCount();
				 timeLabel.setText(String.valueOf(time));
				 
			 }
			 

		 }catch(Exception e){
			 e.printStackTrace();
		}
		 
		 timeLabel.setText("");

		 
	 }
	 
	 public JLabel getLabel(){
		 return timeLabel;
	 }
	 
	 public JLabel getScoreLabel(){
		 return scoreLabel;
	 }

	 //delay between each move of the snake
	 private void pauser(){
		 try {
				sleep(settings.getDelayTime());
		 } catch (InterruptedException e) {
				e.printStackTrace();
		 }
	 }
	 
	 //Checking if the snake bites itself or is eating
	 private void checkCollision() {
		 Position pos = positions.get(positions.size()-1);
		 for(int i = 0;i<=positions.size()-2;i++){
			 boolean biteItself = pos.getX()==positions.get(i).getX() && pos.getY()==positions.get(i).getY();
			 if(biteItself){
				gameOver();
			 }
		 }
		 
		 for(int i = 0;i<=obstacles.size()-1;i++){
			 boolean hitObstacle = pos.getX()==obstacles.get(i).getX() && pos.getY()==obstacles.get(i).getY();
			 if(hitObstacle){
				gameOver();
			 }
		 }
		 
		 boolean eatingFood = pos.getX()==foodPosition.getY() && pos.getY()==foodPosition.getX();
		 if(eatingFood){
			 score++;
			 scoreLabel.setText(String.valueOf(score));
			 sizeSnake++;
			 foodPosition = notSnakeObstacle();

			 spawnFood(foodPosition);	
		 }
	 }
	 
	 //game over
	 private void gameOver(){
		 running = false;
		 String scen = "";
		 if(settings.isBorderLimited()){
			 scen = "Classic";
		 }else{
			 scen = "No wall";
		 }
		 
		 if(settings.getAmountObstacles() != 0){
			 scen = scen + " w/ obstacles";
		 }
		 
		 Scores s = new Scores(score, scen);
		 
		 try {
			s.compareScore();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 while(true){
			 pauser();
		 }
	 }
	 
	 //Put food in a position and displays it
	 private void spawnFood(Position foodPositionIn){
		 Squares.get(foodPositionIn.getX()).get(foodPositionIn.getY()).setColor(1);
	 }
	 
	 //return a position not occupied by the snake neither obstacle
	 private Position notSnakeObstacle(){
		 Position p ;
		 int ranX= 0 + (int)(Math.random()*sizeX-1); 
		 int ranY= 0 + (int)(Math.random()*sizeY-1); 
		 p=new Position(ranX,ranY);
		 for(int i = 0;i<=positions.size()-1;i++){
			 if(p.getY()==positions.get(i).getX() && p.getX()==positions.get(i).getY()){
				 ranX= 0 + (int)(Math.random()*sizeX-1); 
				 ranY= 0 + (int)(Math.random()*sizeY-1); 
				 p=new Position(ranX,ranY);
				 i=0;
			 }
		 }
		 
		 for(int i = 0;i<=obstacles.size()-1;i++){
			 if(p.getY()==obstacles.get(i).getX() && p.getX()==obstacles.get(i).getY()){
				 p = notSnakeObstacle();
			 }
		 }
		 
		 return p;
	 }
	 
	 //moves the head of the snake
	 private void moveSnake(int dir){
		 switch(dir){
		 	case 4://down
		 		if(headSnakePos.getY()+1==sizeY) {
		 			if(settings.isBorderLimited())
		 				gameOver();
		 			else{
		 				headSnakePos.ChangeData(headSnakePos.getX(), 0);
		 				positions.add(new Position(headSnakePos.getX(),headSnakePos.getY()));
		 			}
		 		} 
		 		else {
		 			headSnakePos.ChangeData(headSnakePos.getX(),(headSnakePos.getY()+1)%sizeY);
		 			positions.add(new Position(headSnakePos.getX(),headSnakePos.getY()));
		 		}
		 		break;
		 	case 3://up
		 		if(headSnakePos.getY()-1<0){
		 			if(settings.isBorderLimited())
		 				gameOver();
		 			else{
		 				headSnakePos.ChangeData(headSnakePos.getX(), sizeY-1);
		 				positions.add(new Position(headSnakePos.getX(),headSnakePos.getY()));
		 			}
		 		}
		 		else {
		 			headSnakePos.ChangeData(headSnakePos.getX(),Math.abs(headSnakePos.getY()-1)%sizeY);
		 			positions.add(new Position(headSnakePos.getX(),headSnakePos.getY()));
		 		}
		 		break;
		 	case 2://left
		 		if(headSnakePos.getX()-1<0){
		 			if(settings.isBorderLimited())
		 				gameOver();
		 			else{
		 				headSnakePos.ChangeData(sizeX-1, headSnakePos.getY());
		 				positions.add(new Position(headSnakePos.getX(),headSnakePos.getY()));
		 			}
		 		}
		 		else{
		 			headSnakePos.ChangeData(Math.abs(headSnakePos.getX()-1)%sizeX,headSnakePos.getY());
		 			positions.add(new Position(headSnakePos.getX(),headSnakePos.getY()));
		 		} 
		 		break;
		 	case 1://right
		 		if(headSnakePos.getX()+1==sizeX) {
		 			if(settings.isBorderLimited())
		 				gameOver();
		 			else{
		 				headSnakePos.ChangeData(0, headSnakePos.getY());
	 					positions.add(new Position(headSnakePos.getX(),headSnakePos.getY()));
		 			}
		 		}
		 		else {
					headSnakePos.ChangeData(Math.abs(headSnakePos.getX()+1)%sizeX,headSnakePos.getY());
					positions.add(new Position(headSnakePos.getX(),headSnakePos.getY()));
		 		}
		 		break;
		 }
	 }
	 
	 //refresh grid squares
	 private void refreshColor(){
		 for(Position t : positions){
			 int y = t.getX();
			 int x = t.getY();
			 Squares.get(x).get(y).setColor(0);
		 }
		 
		 for(Position t : obstacles){
			 int y = t.getX();
			 int x = t.getY();
			 Squares.get(x).get(y).setColor(3);
		 }
	 }
	 
	 //refresh the tail of the snake
	 private void deleteTail(){
		 int size = sizeSnake;
		 for(int i = positions.size()-1;i>=0;i--){
			 if(size==0){
				 Position t = positions.get(i);
				 Squares.get(t.getY()).get(t.getX()).setColor(2);
			 }
			 else{
				 size--;
			 }
		 }
		 size = sizeSnake;
		 for(int i = positions.size()-1;i>=0;i--){
			 if(size==0){
				 positions.remove(i);
			 }
			 else{
				 size--;
			 }
		 }
	 }
}
