package main.java;

public class Main {
	
	public static void main(String[] args){
		CalculateScores cs = new CalculateScores();
		cs.calculateScore(cs.getPatientDetails2(), cs.getPatientDetails(), cs.getListOfOptionsSelected());
	}

}
