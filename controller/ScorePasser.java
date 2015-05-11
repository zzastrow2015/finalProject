package controller;

import java.io.IOException;
import java.util.ArrayList;

import model.Scores;

public class ScorePasser {
	
	private ArrayList<String> scores = new ArrayList<String>();
	private ArrayList<String> names = new ArrayList<String>();
	private ArrayList<String> scenarios = new ArrayList<String>();
	
	
	public ScorePasser() throws IOException{
		
		//Splits the score, name, and scenario by tabs.
		Scores topScores = new Scores(0, "");
		ArrayList<String> top =  topScores.getScores();
		String[] topSplit;
		for(int i = 0; i < top.size(); i++){
			topSplit = top.get(i).split("\t");
			names.add(topSplit[0]); //adds name
			scores.add(topSplit[1]); //adds score
			scenarios.add(topSplit[2]); //adds scenario
		}
	}
	
	public ArrayList<String> getScores(){
		return scores;
	}
	
	public ArrayList<String> getNames(){
		return names;
	}
	
	public ArrayList<String> getScenarios(){
		return scenarios;
	}

}
