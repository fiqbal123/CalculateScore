package main.java;

public class PatientVO {
	
	private int patient_id;
	private String gender;
	private String languageDesc;
	private String religion;
	private String floor;
	private String ethnicity;
	private String citizenship;
	
	public PatientVO(int patient_id, String gender, String language, String religion, String floor, String ethnicity, String citizenship) {
		this.patient_id= patient_id;
		this.gender = gender;
		this.languageDesc = language;
		this.religion = religion;
		this.floor = floor;
		this.ethnicity = ethnicity;
		this.citizenship = citizenship;
	}
	
	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLanguageDesc() {
		return languageDesc;
	}
	public void setLanguage(String language) {
		this.languageDesc = language;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getFloorDesc() {
		return floor;
	}

	public String getEthnicityDesc() {
		return ethnicity;
	}

	public String getCitizenship() {
		return citizenship;
	}

}
