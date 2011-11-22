package com.andresjruiz.demos;

import java.util.*;
import java.awt.*;

import javax.swing.JFrame;

public class MainRun {
	
	private static JFrame mainWindow;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		init();
		createAndShowGUI();
	}
	
	
	public static void init(){
		mainWindow = new JFrame("Java 2D Demo");
		mainWindow.setSize(800, 600);
		mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainWindow.getContentPane().add(new GamePanel());
		
	}
	
	public static void createAndShowGUI(){
		mainWindow.setVisible(true);
	}

}
