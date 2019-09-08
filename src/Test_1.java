import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class Test_1 {

	@Test
	void test_1patient_for_medecin() {
		// Celui où un patient se présente à la clinique avec une migraine
		Clinic clinic = new Clinic(TriageType.FIFO);
		Patient p1 = new Patient("Gérard", 4, VisibleSymptom.MIGRAINE);
		clinic.triagePatient(p1);
		if (clinic.getListFifoMedecin().get(0) != p1) {
			fail("patient not in queue");
		}
	}

	@Test
	void test_1patient_for_medecin_et_radiologie() {
		// Celui où un patient se présente à la clinique avec une entorse
		// et vas a la radiologie aussi
		Clinic clinic = new Clinic(TriageType.FIFO);
		Patient p1 = new Patient("Gérard", 4, VisibleSymptom.SPRAIN);
		clinic.triagePatient(p1);
		if (clinic.getListFifoMedecin().get(0) != p1) {
			fail("patient not in Medecin queue");
		}
		if (clinic.getListFifoRadiologie().get(0) != p1) {
			fail("patient not in Radiologie queue");
		}
	}

	@Test
	void test_2patient_for_medecin() {
		// Celui où deux patient se présente à la clinique
		Clinic clinic = new Clinic(TriageType.FIFO);
		Patient p1 = new Patient("Gérard", 4, VisibleSymptom.COLD);
		Patient p2 = new Patient("Luke", 1, VisibleSymptom.EBOLA);
		clinic.triagePatient(p1);
		clinic.triagePatient(p2);
		if (clinic.getListFifoMedecin().get(0) != p1) {
			fail("Gérard not first in Medecin queue");
		}
		if (clinic.getListFifoMedecin().get(1) != p2) {
			fail("Luke not second in Medecin queue");
		}
	}

	@Test
	void test_1patient_prioritary_for_medecin() {
		// Celui où un patient est prioritaire et passe devant les autres en medecin
		Clinic clinic = new Clinic(TriageType.FIFO);
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

	@Test
	void test_1patient_prioritary_for_medecin_et_radiologie() {
		// Celui où un patient est prioritaire et passe devant les autres en medecin et
		// radiologie
		Clinic clinic = new Clinic(TriageType.FIFO);
		Patient p1 = new Patient("Gérard", 4, VisibleSymptom.SPRAIN);
		Patient p2 = new Patient("Luke", 8, VisibleSymptom.BROKEN_BONE); // luke is prioritary
		clinic.triagePatient(p1);
		clinic.triagePatient(p2);
		if (clinic.getListFifoMedecin().get(0) != p2) {
			fail("Luke not first in Medecin queue");
		}
		if (clinic.getListFifoRadiologie().get(0) != p2) {
			fail("Luke not in first Radiologie queue");
		}
		if (clinic.getListFifoMedecin().get(1) != p1) {
			fail("Gérard not second in Medecin queue");
		}
		if (clinic.getListFifoRadiologie().get(1) != p1) {
			fail("Gérard not second in Radiologie queue");
		}
	}

}
