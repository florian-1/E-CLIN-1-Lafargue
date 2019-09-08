import java.util.ArrayList;
import java.util.Comparator;

public class Clinic {

	private ArrayList<Patient> listFifoMedecin;
	private ArrayList<Patient> listFifoRadiologie;
	private TriageType triageType;
	private int priorityGravity = 5;
	private Comparator<Patient> comparatorPatient = new Comparator<Patient>() {
		@Override
		public int compare(Patient p1, Patient p2) {
			if (p1.getGravity() > priorityGravity || p2.getGravity() > priorityGravity) {
				// on ne fait les priorité que pour une valeurs au dessus de 5
				return p2.getGravity() - p1.getGravity();
			}
			return 0;
		}
	};

	public Clinic(TriageType triageType) {
		this.triageType = triageType;
		listFifoMedecin = new ArrayList<Patient>();
		listFifoRadiologie = new ArrayList<Patient>();
	}

	public void triagePatient(Patient patient) {
		if (triageType == TriageType.FIFO) {
			listFifoMedecin.add(patient);
			if (NeedRadiologie(patient.getVisible_symptom())) {
				listFifoRadiologie.add(patient);
			}
		}
		if (triageType == TriageType.GRAVITY) {
			listFifoMedecin.add(patient);
			listFifoMedecin.sort(comparatorPatient);
			if (NeedRadiologie(patient.getVisible_symptom())) {
				listFifoRadiologie.add(patient);
				listFifoRadiologie.sort(comparatorPatient);
			}
		}
	}

	public boolean NeedRadiologie(VisibleSymptom visibleSymptom) {// go to radiologie or not
		if (visibleSymptom == VisibleSymptom.BROKEN_BONE || visibleSymptom == VisibleSymptom.SPRAIN) {
			return true;
		}
		return false;
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

	public Comparator<Patient> getComparatorPatient() {
		return comparatorPatient;
	}

}
