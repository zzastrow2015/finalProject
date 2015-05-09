package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class MainMenu extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int xPos;
	private int yPos;
	
	
	public static void main(String[] args) throws IOException {
		MainMenu menu = new MainMenu();
		menu.setVisible(true);
	}
	
	public MainMenu() throws IOException{
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    xPos = (int) ((dimension.getWidth() - 500) / 2);
	    yPos = (int) ((dimension.getHeight() - 600) / 2);
		setBounds(new Rectangle(xPos, yPos, 450, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JFrame ref = this;
		
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(xPos, yPos, 450, 450));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStart = new JButton("Play");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SettingsMenu set = new SettingsMenu(ref);
					ref.setVisible(false);
					set.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnScores = new JButton("High Scores");
		btnScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				
				try {
					HighScoreWindow highScores = new HighScoreWindow();
					highScores.setTitle("High Scores");
					highScores.setSize(400, 400);
					highScores.setLocation(xPos, yPos);
					highScores.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnStart.setBounds(150, 109, 140, 40);
		getContentPane().add(btnStart);
		btnScores.setBounds(150, 160, 140, 40);
		getContentPane().add(btnScores);
		
		JLabel lblSnakeGame = new JLabel("SNAKE GAME");
		lblSnakeGame.setFont(new Font("Viner Hand ITC", Font.BOLD, 45));
		lblSnakeGame.setBounds(45, 32, 351, 50);
		contentPane.add(lblSnakeGame);
		this.setResizable(false);
	}
}
