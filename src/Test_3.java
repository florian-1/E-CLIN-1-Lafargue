

import org.junit.jupiter.api.Test;

import static org.testng.Assert.fail;

class Test_3 {

    @Test
    void test_2patient_prioritary_for_medecin_et_radiologie() {
        // Celui où un patient est prioritaire et passe devant les autres en medecin et
        // radiologie
        Clinic clinic = new Clinic(TriageType.GRAVITY);
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

    @Test
    void test_1patient_prioritary_solo_for_medecin_and_radiologie() {
        // Celui où un patient est prioritaire et seul pour medecin et radiologie
        Clinic clinic = new Clinic(TriageType.GRAVITY);
        Patient p1 = new Patient("Gérard", 8, VisibleSymptom.SPRAIN);
        clinic.triagePatient(p1);

        if (clinic.getListFifoMedecin().get(0) != p1) {
            fail("Gérard not first in Medecin queue");
        }
        if (clinic.getListFifoRadiologie().get(0) != p1) {
            fail("Gérard not first in Radiologie queue");
        }
    }
}
