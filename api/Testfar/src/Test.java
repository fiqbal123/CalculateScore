import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		//dummy main resident
		PatientVO mainPatient = new PatientVO(1, "Male", "floor1", "indian", "hindi", "hindu", "canadian");
		
		//dummy resident list
		List<PatientVO> patientList = new ArrayList<>();
		patientList.add(new PatientVO(1, "Male", "floor1", "na", "na", "na", "canadian"));
		patientList.add(new PatientVO(2,"Male", "floor1", "na", "na", "na", "canadian"));
//		patientList.add(new PatientVO(3, "Male", "floor1", "na", "na", "na", "canadian"));
//		patientList.add(new PatientVO(4,"Male", "floor1", "na", "na", "na", "canadian"));
//		patientList.add(new PatientVO(19,"Male", "floor1", "na", "na", "na", "canadian"));
//		patientList.add(new PatientVO(22,"Male", "floor1", "na", "na", "na", "canadian"));
//		patientList.add(new PatientVO(3, "Male", "floor1", "na", "na", "na", "canadian"));
//		patientList.add(new PatientVO(4,"Male", "floor1", "na", "na", "na", "canadian"));
//		patientList.add(new PatientVO(19,"Male", "floor1", "na", "na", "na", "canadian"));
//		patientList.add(new PatientVO(2,"Male", "floor1", "na", "na", "na", "canadian"));
//		patientList.add(new PatientVO(3, "Male", "floor1", "na", "na", "na", "canadian"));
//		patientList.add(new PatientVO(4,"Male", "floor1", "na", "na", "na", "canadian"));
//		patientList.add(new PatientVO(19,"Male", "floor1", "na", "na", "na", "canadian"));
//		patientList.add(new PatientVO(2,"Male", "na", "na", "na", "na", "na"));
//		patientList.add(new PatientVO(3, "Male", "na", "na", "na", "na", "na"));
//		patientList.add(new PatientVO(4,"Male", "na", "na", "na", "na", "na"));
//		patientList.add(new PatientVO(19,"Male", "na", "na", "na", "na", "na"));
		
//		patientList.add(new PatientVO(5, "Female", "floor1", "na", "na", "na", "canadian"));
//		patientList.add(new PatientVO(6, "Female", "floor1", "na", "na", "na", "canadian"));
		patientList.add(new PatientVO(7, "Female", "floor1", "na", "na", "na", "canadian"));
		patientList.add(new PatientVO(8, "Female", "floor1", "na", "na", "na", "canadian"));
//		
//		
		patientList.add(new PatientVO(9, "Female", "floor1", "na", "na", "na", "na"));
		patientList.add(new PatientVO(10,"Female", "floor1", "na", "na", "na", "na"));
		patientList.add(new PatientVO(11, "Female", "floor1", "na", "na", "na", "na"));
		patientList.add(new PatientVO(12, "Female", "floor1", "na", "na", "na", "na"));
		patientList.add(new PatientVO(13, "Female", "floor1", "na", "na", "na", "na"));
		patientList.add(new PatientVO(14, "Female", "floor1", "na", "na", "na", "na"));
		patientList.add(new PatientVO(15, "Female", "floor1", "na", "na", "na", "na"));
		patientList.add(new PatientVO(16, "Female", "floor1", "na", "na", "na", "na"));
//		patientList.add(new PatientVO(17, "Female", "floor1", "na", "na", "na", "na"));
//		patientList.add(new PatientVO(18,"Female", "floor1", "na", "na", "na", "na"));
//		patientList.add(new PatientVO(20, "Female", "floor1", "na", "na", "na", "na"));
//		patientList.add(new PatientVO(21, "Female", "floor1", "na", "na", "na", "na"));
//		patientList.add(new PatientVO(22, "Female", "floor1", "na", "na", "na", "na"));
//		patientList.add(new PatientVO(23,"Female", "floor1", "na", "na", "na", "na"));
//		patientList.add(new PatientVO(23,"Female", "floor1", "na", "na", "na", "na"));
//		
		
		//dummy list of options
		List<String> options = new ArrayList<>();
		options.add("Male");
		options.add("floor");
		options.add("Language");
		options.add("Citizenship");
		
		//test
		PatientMatch pm = new PatientMatch();
		List<PatientVO> list = pm.calculateMatchList(mainPatient, patientList, options);
		
		
			
			System.out.println(list.size());
			for(PatientVO p : list)
				System.out.println(p.toString());

	}

}
