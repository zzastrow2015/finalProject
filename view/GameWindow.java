package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;

import model.GridSquares;
import model.Position;
import model.Settings;
import controller.KeyboardListener;
import controller.ThreadsController;

public class GameWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	public static ArrayList<ArrayList<GridSquares>> Grid;
	public static int width = Settings.sizeX;
	public static int height = Settings.sizeY;
	private JLayeredPane layeredPane = new JLayeredPane();
	private JPanel gameGrid = new JPanel();
	private JPanel countdown = new JPanel();
	private JPanel score = new JPanel();
	Timer removeCountdown = new Timer();
	private ThreadsController c;
	
	private JFrame previous;
	
	public GameWindow(SettingsMenu setMenu, Settings settings){
		previous = setMenu;
		this.addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				if(previous != null){
					previous.setEnabled(true);
				}
				if(c.isRunning()){
					c.setRunning(false);
				}
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
		Grid = new ArrayList<ArrayList<GridSquares>>();
		ArrayList<GridSquares> data;

		for(int i=0;i<width;i++){
			data= new ArrayList<GridSquares>();
			for(int j=0;j<height;j++){
				GridSquares c = new GridSquares(2);
				data.add(c);
			}
			Grid.add(data);
		}
		
		gameGrid.setLayout(new GridLayout(width,height,0,0));

		if(settings.isBorderLimited())
			gameGrid.setBorder(BorderFactory.createLineBorder(Color.blue, 10));
		
		
		for(int i=0;i<width;i++){
			for(int j=0;j<height;j++){
				gameGrid.add(Grid.get(i).get(j).getSquare());
			}
		}
		
		layeredPane.setPreferredSize(new Dimension(getContentPane().getPreferredSize()));
		layeredPane.add(gameGrid, new Integer(0));

		
		this.add(layeredPane);

		gameGrid.setBounds(0, 0, Settings.screenWidth, Settings.screenHeight);
		getContentPane().setBounds(0, 0, Settings.screenWidth, Settings.screenHeight);
		setSize(Settings.screenWidth+6, Settings.screenHeight+29);
		
		//initial position of the snake
		Position position = new Position(12,12);
		c = new ThreadsController(position, settings);
		
		//start the game
		c.start();

		countdown.setLayout(new GridLayout(1,1,0,0));
		countdown.add(c.getLabel());
		countdown.setBackground(Color.WHITE);
		countdown.setBounds(Settings.screenWidth/2, Settings.screenHeight/2-30, 20, 20);
		layeredPane.add(countdown, new Integer(1));
		
		score.setLayout(new GridLayout(1, 1, 0, 0));
		score.add(c.getScoreLabel());
		score.setOpaque(false);
		score.setBounds(Settings.screenWidth-30, Settings.screenHeight-34, 20, 20);
		layeredPane.add(score, new Integer(2));
		
		this.addKeyListener((KeyListener) new KeyboardListener());
		
		
		
        removeCountdown.schedule(new TimerTask() {

            @Override
            public void run() {
                layeredPane.remove(countdown);
            }
        }, 3050);
		
        this.setResizable(false);
	}
}
