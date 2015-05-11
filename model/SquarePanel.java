package model;

import java.awt.Color;
import javax.swing.JPanel;

public class SquarePanel extends JPanel{

	private static final long serialVersionUID = 1L;

	//Sets the background color of the panel.
	public SquarePanel(Color d){
		this.setBackground(d);
	}

	//changes the backround color
	public void ChangeColor(Color d){
		this.setBackground(d);
		this.repaint();
	}
}

