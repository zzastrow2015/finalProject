package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Scores {
	
	private int score;
	private String scenario;
	
	public Scores(int num, String scen){
		score = num;
		scenario = scen;
	}
	
	public void compareScore() throws IOException{
		
		 ArrayList<String> highNames = new ArrayList<>();
		 ArrayList<String> highScores = new ArrayList<>();
		 ArrayList<String> highScenarios = new ArrayList<>();
		 String line;
		 String newName;
		 
		 try {
			BufferedReader br = new BufferedReader(new FileReader("highScores"));
			String[] topSplit;
			while((line = br.readLine()) != null){
				topSplit = line.split("\t");
				highNames.add(topSplit[0]);
				highScores.add(topSplit[1]);
				highScenarios.add(topSplit[2]);
			}
			
			for(int i = 0; i < highScores.size(); i++){
				if(highScores.get(i).equals("-")){
					highScores.set(i, "0");
				}
				if(score > Integer.parseInt(highScores.get(i))){
					newName = JOptionPane.showInputDialog("<html><br>Congrats! New High Score!<br>Please enter your name: </html>");
					
					if(newName != null){
						highNames.add(highNames.get(highNames.size() - 1));
						highScores.add(highScores.get(highScores.size() - 1));
						highScenarios.add(highScenarios.get(highScenarios.size() - 1));
						for(int j = highScores.size(); j >= i; j--){
							
							if(j == i){
								highScores.set(j, String.valueOf(score));
								highNames.set(j, newName);
								highScenarios.set(j, scenario);
							}else{
								
								if(j == 1){
									highScores.set(j-1, String.valueOf(score));
									highNames.set(j-1, newName);
									highScenarios.set(j-1, scenario);
									break;
								}
								highScores.set(j-1, highScores.get(j-2));
								highNames.set(j-1, highNames.get(j-2));
								highScenarios.set(j-1, highScenarios.get(j-2));
							}

						}
					}else{
						JOptionPane.showMessageDialog(null, "No name was entered. High score was not recorded.");
					}

					break;
				}
			}
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("highScores"));
			
			for(int i = 0; i < highScores.size(); i++){
				if(highScores.get(i).equals("0")){
					highScores.set(i, "-");
				}
				bw.write(highNames.get(i)+"\t"+highScores.get(i)+"\t"+highScenarios.get(i));
				bw.newLine();

				if(i == 9){
					break;
				}
				
			}
			
			bw.close();
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<String> getScores() throws IOException{
		
		ArrayList<String> topScores = new ArrayList<>();
		String line;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("highScores"));
		
			while((line = reader.readLine()) != null){
				topScores.add(line);
			}
			
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return topScores;
		
	}

}
