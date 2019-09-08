import java.util.ArrayList;

public class CommunityCenter extends GestionPatient {
	private ArrayList<Patient> listforInfirmier;

	public ArrayList<Patient> getListforInfirmier() {
		return listforInfirmier;
	}

	public CommunityCenter(TriageType triageType) {
		this.triageType = triageType;
		listforInfirmier = new ArrayList<Patient>();
	}

	@Override
	public void triagePatient(Patient patient) {
		if (patient.getGravity() == 1) {
			return;
		}
		if (triageType == TriageType.FIFO) {
			listforInfirmier.add(patient);
		}
		if (triageType == TriageType.GRAVITY) {
			listforInfirmier.add(patient);
			listforInfirmier.sort(comparatorPatient);
		}
	}
}
