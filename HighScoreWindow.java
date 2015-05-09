package view;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ScorePasser;

//High Scores screen
public class HighScoreWindow extends JFrame{
	
	private static final long serialVersionUID = 1L;
	ArrayList<String> highNames;
	ArrayList<String> highScores;
	ArrayList<String> highScenarios;
	ArrayList<JLabel> namesDisplay = new ArrayList<>();
	ArrayList<JLabel> scoresDisplay = new ArrayList<>();
	ArrayList<JLabel> scenarioDisplay = new ArrayList<>();
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel;
	
	public HighScoreWindow() throws IOException{
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel = new JPanel();
		panel3 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		ScorePasser passer = new ScorePasser();
		
		highScores = passer.getScores();
		highNames = passer.getNames();
		highScenarios = passer.getScenarios();
		
		namesDisplay.add(new JLabel());
		namesDisplay.get(0).setText("NAME");
		panel1.add(namesDisplay.get(0));
		
		scoresDisplay.add(new JLabel());
		scoresDisplay.get(0).setText("SCORE");
		panel2.add(scoresDisplay.get(0));
		
		scenarioDisplay.add(new JLabel());
		scenarioDisplay.get(0).setText("SCENARIO");
		panel.add(scenarioDisplay.get(0));
		
		namesDisplay.add(new JLabel());
		namesDisplay.get(1).setText("---------------------------");
		panel1.add(namesDisplay.get(1));
		
		scoresDisplay.add(new JLabel());
		scoresDisplay.get(1).setText("--------------");
		panel2.add(scoresDisplay.get(1));
		
		scenarioDisplay.add(new JLabel());
		scenarioDisplay.get(1).setText("-------------------------------");
		panel.add(scenarioDisplay.get(1));
		
		for(int x = 2; x < highNames.size() + 2; x++){
			
			namesDisplay.add(new JLabel());
			namesDisplay.get(x).setText(highNames.get(x-2));
			panel1.add(namesDisplay.get(x));
			
			scoresDisplay.add(new JLabel());
			scoresDisplay.get(x).setText(highScores.get(x-2));
			panel2.add(scoresDisplay.get(x));
			
			scenarioDisplay.add(new JLabel());
			scenarioDisplay.get(x).setText(highScenarios.get(x-2));
			panel.add(scenarioDisplay.get(x));
		}
		
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3.add(panel1);
		panel3.add(panel2);
		panel3.add(panel);
		this.setContentPane(panel3);
		this.setResizable(false);
	}
		
}
