import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class Test_2 {

	@Test
	void test_1patient_prioritary_solo_for_medecin() {
		// Celui où un patient est prioritaire et passe devant les autres en medecin
		Clinic clinic = new Clinic(TriageType.GRAVITY);
		Patient p1 = new Patient("Gérard", 8, VisibleSymptom.COLD);
		clinic.triagePatient(p1);
		if (clinic.getListFifoMedecin().get(0) != p1) {
			fail("Gérard not first in Medecin queue");
		}
		if (clinic.getListFifoRadiologie().size() != 0) {
			fail("Why is there someone here");
		}
	}

	@Test
	void test_2patient_prioritary_for_medecin() {
		// Celui où un patient est prioritaire et passe devant les autres en medecin
		Clinic clinic = new Clinic(TriageType.GRAVITY);
		Patient p1 = new Patient("Gérard", 4, VisibleSymptom.SPRAIN);
		Patient p2 = new Patient("Luke", 8, VisibleSymptom.EBOLA); // luke is prioritary
		clinic.triagePatient(p1);
		clinic.triagePatient(p2);
		if (clinic.getListFifoMedecin().get(0) != p2) {
			fail("Luke not prioritary in Medecin queue");
		}
		if (clinic.getListFifoMedecin().get(1) != p1) {
			fail("Gérard not second in Medecin queue");
		}
		if (clinic.getListFifoRadiologie().get(0) != p1) {
			fail("Gérard not first in Radiologie queue");
		}
	}

}
