import java.util.Comparator;

public class GestionPatient {

	protected TriageType triageType;
	private int priorityGravity = 5;
	protected Comparator<Patient> comparatorPatient = new Comparator<Patient>() {
		@Override
		public int compare(Patient p1, Patient p2) {
			if (p1.getGravity() > priorityGravity || p2.getGravity() > priorityGravity) {
				// on ne fait les priorité que pour une valeurs au dessus de 5
				return p2.getGravity() - p1.getGravity();
			}
			return 0;
		}
	};

	public void triagePatient(Patient patient) {
		if (patient.getGravity() == 1) {
			return;
		}
	}

}
