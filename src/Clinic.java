import java.util.ArrayList;

public class Clinic extends GestionPatient {

	private ArrayList<Patient> listForMedecin;
	private ArrayList<Patient> listForRadiologie;

	public Clinic(TriageType triageType) {
		this.triageType = triageType;
		listForMedecin = new ArrayList<Patient>();
		listForRadiologie = new ArrayList<Patient>();
	}

	@Override
	public void triagePatient(Patient patient) {
		if (patient.getGravity() == 1) {
			return;
		}
		if (triageType == TriageType.FIFO) {
			listForMedecin.add(patient);
			if (NeedRadiologie(patient.getVisible_symptom())) {
				listForRadiologie.add(patient);
			}
		}
		if (triageType == TriageType.GRAVITY) {
			listForMedecin.add(patient);
			listForMedecin.sort(comparatorPatient);
			if (NeedRadiologie(patient.getVisible_symptom())) {
				listForRadiologie.add(patient);
				listForRadiologie.sort(comparatorPatient);
			}
		}
	}

	public boolean NeedRadiologie(VisibleSymptom visibleSymptom) {// go to radiologie or not
		if (visibleSymptom == VisibleSymptom.BROKEN_BONE || visibleSymptom == VisibleSymptom.SPRAIN) {
			return true;
		}
		return false;
	}

	public ArrayList<Patient> getListFifoMedecin() {
		return listForMedecin;
	}

	public ArrayList<Patient> getListFifoRadiologie() {
		return listForRadiologie;
	}

}
