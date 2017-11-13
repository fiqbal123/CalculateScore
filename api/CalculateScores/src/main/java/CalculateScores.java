package main.java;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CalculateScores {
	
	int patientid=123;
	
	ArrayList<String> listOfOptionsSelected= new ArrayList<>();
	
	public ArrayList<String> getListOfOptionsSelected() {
		listOfOptionsSelected.add("male");
		listOfOptionsSelected.add("Religion");
		listOfOptionsSelected.add("Language");
		listOfOptionsSelected.add("Ethnicity");
		listOfOptionsSelected.add("Floor");
		listOfOptionsSelected.add("Citizenship");
		
		return listOfOptionsSelected;
	}
	
	public PatientVO getPatientDetails() {
		PatientVO p1= new PatientVO(1, "male", "", "islam", "2", "Asian", "Canadian");
		return p1;		
	}
	
	public PatientVO getPatientDetails2() {
		PatientVO p1= new PatientVO(2, "male", "", "islam", "2", "Asian", null);
		return p1;		
	}

	
	
	/**
	 * Returns an score, 0 -100%, which represents the similarity between two patients.
	 * Higher the score = higher the similarity.
	 * @param options - the options selected by user in MatchOpyions popup page
	 * @param p1- the potential patient for match
	 * @param p2- the patient to match up with.
	 * @return score between 0% - 100%.
	 */
	public double calculateScore(PatientVO mainPatient, PatientVO patient, List<String> options) {
		double score = 0.0;

		for (int i=0; i < options.size(); i++) {			
			switch (options.get(i).toLowerCase()) {
				case "male":
					if(checkNotNullOrEmpty(mainPatient.getGender()) && checkNotNullOrEmpty(patient.getGender()) ) {
						if(patient.getGender().equalsIgnoreCase("male"))
							score++;	
					}
					break;
				case "female":
					if(checkNotNullOrEmpty(mainPatient.getGender()) && checkNotNullOrEmpty(patient.getGender()) ) {
						if(patient.getGender().equalsIgnoreCase("female"))
							score++;	
					}
					break;
				case "religion":
					if(checkNotNullOrEmpty(mainPatient.getReligion()) && checkNotNullOrEmpty(patient.getReligion()) ) {
						if(patient.getReligion().equalsIgnoreCase(mainPatient.getReligion()))
							score++;	
					}
					break;
				case "language":
					if(checkNotNullOrEmpty(mainPatient.getLanguageDesc()) && checkNotNullOrEmpty(patient.getLanguageDesc()) ) {
						if(patient.getLanguageDesc().equalsIgnoreCase(mainPatient.getLanguageDesc()))
							score++;	
					}
					break;
				case "ethnicity":
					if(checkNotNullOrEmpty(mainPatient.getEthnicityDesc()) && checkNotNullOrEmpty(patient.getEthnicityDesc()) ) {
						if(patient.getEthnicityDesc().equalsIgnoreCase(mainPatient.getEthnicityDesc()))
							score++;	
					}
					break;
				case "floor":
					if(checkNotNullOrEmpty(mainPatient.getFloorDesc()) && checkNotNullOrEmpty(patient.getFloorDesc()) ) {
						if(patient.getFloorDesc().equalsIgnoreCase(mainPatient.getFloorDesc()))
							score++;	
					}
					break;	
				case "citizenship":
					if(checkNotNullOrEmpty(mainPatient.getCitizenship()) && checkNotNullOrEmpty(patient.getCitizenship()) ) {
						if(patient.getCitizenship().equalsIgnoreCase(mainPatient.getCitizenship()))
							score++;	
					}
					break;	
				default:
					break;
			}			
		}
		
		double result = score/options.size() * 100;
		DecimalFormat df= new DecimalFormat("#.00");
		df.setRoundingMode(RoundingMode.UP);
		return Double.parseDouble(df.format(result)); 
	}
	
    /**
     * Checks if String is NOT null or empty.
     * @param s - the String to test
     * @return true if not null or empty; false otherwise.
     */
    public boolean checkNotNullOrEmpty(String s) {
        return (s!=null && !s.isEmpty());         
    }
	

}
