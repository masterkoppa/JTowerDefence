package com.andresjruiz.demos;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public class Ball extends Component{
	
	private int x;
	private int y;
	private boolean reverseX;
	private boolean reverseY;
	
	public Ball(){
		super();
		x = 0;
		y = 0;
		
		reverseX = false;
		reverseY = false;
	}
	
	public Ball(int initX, int initY){
		super();
		x = initX;
		y = initY;
		
		reverseX = false;
		reverseY = false;
	}
	
	public void move(){
		
		int[] coord = getNextMove();
		
		x = coord[0];
		y = coord[1];

		if(y == 600-40){
			reverseY = true;
		} else if(y == 0+5){
			reverseY = false;
		}
		
		if(x == 800-10){
			reverseX = true;
		} else if(x == 0+5){
			reverseX = false;
		}
		//System.out.println("(" + x + ", " + y + ")");
	}
	
	public void collision(){
		reverseX = !reverseX;
		reverseY = !reverseY;
		System.out.println("LOL!");
	}
	
	public int[] getNextMove(){
		int[] coords = new int[2];
		if(reverseX){
			coords[0] = x-1;
		} else{
			coords[0] = x+1;
		}
		if(reverseY){
			coords[1] = y-1;
		} else{
			coords[1] = y+1;
		}
		return coords;
	}
	
	public int[] getOval(){
		return new int[] {x,y,10,10};
	}
	
}
