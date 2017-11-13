import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class PatientMatch {
	
	private static final double THRESHOLD_LOW = 33.3;
	private static final double THRESHOLD_MED = 66.6;
	
	private List<PatientVO> lowSimilarityPatients = new ArrayList<>();
	private List<PatientVO> medSimilarityPatients = new ArrayList<>();
	private List<PatientVO> highSimilarityPatients = new ArrayList<>();
	
	/**
	 * This method will populate categories and return a list of patient matches.
	 * @param mainPatient - patient who is in need for intervention.
	 * @param patientList - list of patients from facility; call from API
	 * @param options - array of options selected for match making.
	 * @return list of patients that have similar characteristics to selected patient in need of intervention.
	 */
	public List<PatientVO> calculateMatchList(PatientVO mainPatient, List<PatientVO> patientList, List<String> options) {
		//assign each patient in correct category
		fillCategories(mainPatient, patientList, options);
		
		//determine a quality list to return
		return matches();
	}
	
	/**
	 * Populates array with patients that fall in certain category: low, med, high.
	 * @param patientID - patient who is in need for intervention.
	 * @param patientList - list of patients from facility; call from API
	 * @param options - array of options selected for match making.
	 */
	public void fillCategories(PatientVO mainPatient, List<PatientVO> patientList, List<String> options) {
		// assigns patients from patientList to correct category based on score.
		for (PatientVO patient : patientList) {
			if (patient.getPatientId() != mainPatient.getPatientId()) {
				double score = calculateScore(mainPatient, patient, options);
				if (score <= THRESHOLD_LOW)
					lowSimilarityPatients.add(patient);
				else if (score > THRESHOLD_LOW && score <= THRESHOLD_MED)
					medSimilarityPatients.add(patient);
				else
					highSimilarityPatients.add(patient);
			}
		}
	}
	
	/**
	 * Returns list of patients that are best matches.
	 * @return List of patients that are best matches.
	 */
	public List<PatientVO> matches() {
		int min = 5;
		int max = 15;
		List<PatientVO> matches = new ArrayList<>();
		
		if(patientListNotNullOrEmpty(highSimilarityPatients)) {
			if(highSimilarityPatients.size()>=min && highSimilarityPatients.size()<=max)
				matches.addAll(highSimilarityPatients);
			else if (highSimilarityPatients.size()>max) {
				for(int i=0; i<max-min; i++)
					matches.add(highSimilarityPatients.get(i));
			}
			else {
				matches.addAll(highSimilarityPatients);
				max = max-highSimilarityPatients.size();
				if(patientListNotNullOrEmpty(medSimilarityPatients)) {
					if(medSimilarityPatients.size()>=min && medSimilarityPatients.size()<=max)
						matches.addAll(medSimilarityPatients);
					else if (medSimilarityPatients.size()>max) {
						for(int i=0; i<min; i++)
							matches.add(medSimilarityPatients.get(i));
					}
					else {
						matches.addAll(medSimilarityPatients);
						max = max-medSimilarityPatients.size();
						if(patientListNotNullOrEmpty(lowSimilarityPatients)) {
							if(lowSimilarityPatients.size()>=min && lowSimilarityPatients.size()<=max)
								matches.addAll(lowSimilarityPatients);
							else if (lowSimilarityPatients.size()>max) {
								for(int i=0; i<min; i++)
									matches.add(lowSimilarityPatients.get(i));
							}
							else
								matches.addAll(lowSimilarityPatients);
						}
					}
				}
			}
		}
		else if(patientListNotNullOrEmpty(medSimilarityPatients)) {
			if(medSimilarityPatients.size()>=min && medSimilarityPatients.size()<=max)
				matches.addAll(medSimilarityPatients);
			else if (medSimilarityPatients.size()>max) {
				for(int i=0; i<max-min; i++)
					matches.add(medSimilarityPatients.get(i));
			}
			else {
				matches.addAll(medSimilarityPatients);
				max = max-medSimilarityPatients.size();
				if(patientListNotNullOrEmpty(lowSimilarityPatients)) {
					if(lowSimilarityPatients.size()>=min && lowSimilarityPatients.size()<=max)
						matches.addAll(lowSimilarityPatients);
					else if (lowSimilarityPatients.size()>max) {
						for(int i=0; i<min; i++)
							matches.add(lowSimilarityPatients.get(i));
					}
					else
						matches.addAll(lowSimilarityPatients);
				}
			}
		}
		else if(patientListNotNullOrEmpty(lowSimilarityPatients)) {
			if(lowSimilarityPatients.size()>=min && lowSimilarityPatients.size()<=max)
				matches.addAll(lowSimilarityPatients);
			else if (lowSimilarityPatients.size()>max) {
				for(int i=0; i<max-min; i++)
					matches.add(lowSimilarityPatients.get(i));
			}
			else
				matches.addAll(lowSimilarityPatients);
		}
		
		return matches;
	}
	
	/**
	 * Checks if list is empty or not.
	 * @param patientList - list of patients
	 * @return true if list is empty otherwise false
	 */
	public boolean patientListNotNullOrEmpty(List<PatientVO> patientList) {
		if(patientList!=null & !patientList.isEmpty())
			return true;
		else
			return false;
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
