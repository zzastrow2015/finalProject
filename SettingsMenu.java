
package view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

import model.Settings;

public class SettingsMenu extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int xPos;
	private int yPos;
	private JFrame previous;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private ButtonGroup buttonGroup1 = new ButtonGroup();
	
	public SettingsMenu(JFrame j) throws IOException{
		previous = j;
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    xPos = (int) ((dimension.getWidth() - 500) / 2);
	    yPos = (int) ((dimension.getHeight() - 600) / 2);
		setBounds(new Rectangle(xPos, yPos, 450, 380));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(xPos, yPos, 450, 450));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 38, 122, 137);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Easy");
		rdbtnNewRadioButton_1.setActionCommand("Easy");
		rdbtnNewRadioButton_1.setBounds(6, 5, 109, 23);
		panel.add(rdbtnNewRadioButton_1);
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setSelected(true);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Medium");
		rdbtnNewRadioButton_2.setActionCommand("Medium");
		rdbtnNewRadioButton_2.setBounds(6, 33, 109, 23);
		panel.add(rdbtnNewRadioButton_2);
		buttonGroup.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Hard");
		rdbtnNewRadioButton_3.setActionCommand("Hard");
		rdbtnNewRadioButton_3.setBounds(6, 61, 109, 23);
		panel.add(rdbtnNewRadioButton_3);
		buttonGroup.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Very hard");
		rdbtnNewRadioButton.setActionCommand("Very_Hard");
		rdbtnNewRadioButton.setBounds(6, 89, 109, 23);
		panel.add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(185, 37, 280, 242);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Classic");
		rdbtnNewRadioButton_4.setActionCommand("Classic");
		rdbtnNewRadioButton_4.setBounds(78, 18, 155, 23);
		panel_1.add(rdbtnNewRadioButton_4);
		buttonGroup1.add(rdbtnNewRadioButton_4);
		rdbtnNewRadioButton_4.setSelected(true);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("No wall");
		rdbtnNewRadioButton_5.setActionCommand("No wall");
		rdbtnNewRadioButton_5.setBounds(78, 70, 155, 23);
		panel_1.add(rdbtnNewRadioButton_5);
		buttonGroup1.add(rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Classic w/ obstacles");
		rdbtnNewRadioButton_6.setActionCommand("ClassicObstacles");
		rdbtnNewRadioButton_6.setBounds(78, 122, 194, 23);
		panel_1.add(rdbtnNewRadioButton_6);
		buttonGroup1.add(rdbtnNewRadioButton_6);
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("No wall w/ obstacles");
		rdbtnNewRadioButton_7.setActionCommand("NoWallObstacles");
		rdbtnNewRadioButton_7.setBounds(78, 174, 194, 23);
		panel_1.add(rdbtnNewRadioButton_7);
		buttonGroup1.add(rdbtnNewRadioButton_7);
		
		Image img;
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(10, 18, 53, 41);
		panel_1.add(label_3);
		img = new ImageIcon(this.getClass().getResource("/images2.png")).getImage();
		label_3.setIcon(new ImageIcon(img));
		
		JLabel label = new JLabel("");
		label.setBounds(10, 70, 53, 41);
		panel_1.add(label);
		img = new ImageIcon(this.getClass().getResource("/images1.png")).getImage();
		label.setIcon(new ImageIcon(img));
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(10, 122, 53, 41);
		panel_1.add(label_1);
		img = new ImageIcon(this.getClass().getResource("/images3.png")).getImage();
		label_1.setIcon(new ImageIcon(img));
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(10, 174, 53, 41);
		panel_1.add(label_2);
		img = new ImageIcon(this.getClass().getResource("/images4.png")).getImage();
		label_2.setIcon(new ImageIcon(img));
		
		
		JLabel lblSelect = new JLabel("Select difficulty:");
		lblSelect.setBounds(10, 11, 188, 14);
		contentPane.add(lblSelect);
		
		JLabel lblSelectAScenario = new JLabel("Select a scenario:");
		lblSelectAScenario.setBounds(185, 11, 226, 14);
		contentPane.add(lblSelectAScenario);
		
		final JFrame ref = this;
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ref.dispose();
				previous.setVisible(true);
			}
		});
		
		final SettingsMenu ref2 = this;
		btnNewButton.setBounds(120, 303, 77, 31);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Start game");
		btnNewButton_1.setBounds(207, 303, 132, 31);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ref2.setEnabled(false);
				
				String difficulty = buttonGroup.getSelection().getActionCommand();
				String scenario = buttonGroup1.getSelection().getActionCommand();
				
				boolean wall, obstacles;
				wall = scenario == "Classic" || scenario == "ClassicObstacles";
				
				obstacles = scenario == "NoWallObstacles" || scenario == "ClassicObstacles";
				
				GameWindow game = new GameWindow(ref2, new Settings(difficulty, wall, obstacles));
				
				game.setTitle("Snake");
				//game.setSize(400,400);
				game.setLocation(xPos, yPos);
				game.setVisible(true);
				//game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				if(previous != null){
					previous.setVisible(true);
				}
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.setResizable(false);
	}
}
