import java.util.ArrayList;

public class Clinic {

	private ArrayList<Patient> listFifoMedecin;
	private ArrayList<Patient> listFifoRadiologie;
	private TriageType triageType;

	public Clinic(TriageType triageType) {
		this.triageType = triageType;
		if (triageType == TriageType.FIFO) {
			listFifoMedecin = new ArrayList<Patient>();
			listFifoRadiologie = new ArrayList<Patient>();
		}
	}

	public void triagePatient(Patient patient) {
		int priorityGravity = 5;
		if (triageType == TriageType.FIFO) {
			if (patient.getVisible_symptom() == VisibleSymptom.BROKEN_BONE // go to radiologie or not
					|| patient.getVisible_symptom() == VisibleSymptom.SPRAIN) {
				if (patient.getGravity() > priorityGravity) {// gravity evaluation
					listFifoRadiologie.add(0, patient);
				} else {
					listFifoRadiologie.add(patient);
				}
			}
			if (patient.getGravity() > priorityGravity) {// gravity evaluation
				listFifoMedecin.add(0, patient);
			} else {
				listFifoMedecin.add(patient);
			}
		}
	}

	public TriageType getTriageType() {
		return triageType;
	}

	public ArrayList<Patient> getListFifoMedecin() {
		return listFifoMedecin;
	}

	public ArrayList<Patient> getListFifoRadiologie() {
		return listFifoRadiologie;
	}

}
