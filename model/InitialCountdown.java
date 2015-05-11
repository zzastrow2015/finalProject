package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class InitialCountdown extends JPanel{

	private int count;
	
	public InitialCountdown(){
		count = 3;
	}
	
	public void incrementCount(){
		count--;
	}
	
	public int getCount(){
		return count;
	}
}
