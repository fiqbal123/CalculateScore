public class PatientVO {
	private Integer patientId;
	private String gender;
	private String floorDesc;
	private String ethnicityDesc;
	private String languageDesc;
	private String religion;
	private String citizenship;
	
	public PatientVO(Integer patientId, String gender, String floorDesc, String ethnicityDesc, String languageDesc, String religion, String citizenship) {
		this.patientId= patientId;
		this.gender = gender;
		this.floorDesc= floorDesc;
		this.ethnicityDesc= ethnicityDesc;
		this.languageDesc= languageDesc;
		this.religion= religion;
		this.citizenship= citizenship;
	}
	
	public String toString() {

	return "Patient id: " + getPatientId() + "\n" +
			"Gender: " + getGender() + "\n" +
			"Floor: " + getFloorDesc() + "\n" +
			"Ethnicity: " + getEthnicityDesc() + "\n" +
			"Language: " + getLanguageDesc() + "\n" +
			"Religion: " + getReligion() + "\n" +
			"Citizenship: " + getCitizenship() + "\n";
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFloorDesc() {
		return floorDesc;
	}
	public void setFloorDesc(String floorDesc) {
		this.floorDesc = floorDesc;
	}

	public String getEthnicityDesc() {
		return ethnicityDesc;
	}
	public void setEthnicityDesc(String ethnicityDesc) {
		this.ethnicityDesc = ethnicityDesc;
	}

	public String getLanguageDesc() {
		return languageDesc;
	}
	public void setLanguageDesc(String languageDesc) {
		this.languageDesc = languageDesc;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getCitizenship() {
		return citizenship;
	}
	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public Integer getPatientId() {
		// TODO Auto-generated method stub
		return patientId;
	}

}
