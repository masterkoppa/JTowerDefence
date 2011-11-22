package com.andresjruiz.demos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GamePanel extends JPanel {
	
	private Ball[] b;
	public static int refreshes = 0;
	private Timer t = new Timer(5, new Refresh());
	
	public GamePanel(){
		super();
		this.setDoubleBuffered(true);
		b = new Ball[10];
		for(int i = 0; i < 10; i++){
			b[i] = new Ball(i*10,i);
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(!t.isRunning()){
			t.start();
		}
		
		this.detectCollitions();
		
		for(Ball i : b){
			int[] oval = i.getOval();
			i.move();
			g.fillOval(oval[0], oval[1], oval[2], oval[3]);
			
		}
	}
	
	private void detectCollitions(){
		Rectangle[] balls = new Rectangle[b.length];
		for(int  i = 0; i < b.length; i++){
			int[] bounds = b[i].getOval();
			int[] next = b[i].getNextMove();
			balls[i] = new Rectangle(next[0], next[1], bounds[2]/2, bounds[3]/2);
		}
		for(int i = 0; i < balls.length; i++){
			for(int ii = 0; ii < balls.length; ii++){
				if(i != ii){
					//System.out.println("Detecting!");
					if(balls[i].intersects(balls[ii])){
						b[i].collision();
					}
				}
		}
			
		}
	}
	
	private class Refresh implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
			if(!isShowing()){
				((Timer)e.getSource()).stop();
			}
		}
		
	}

}
