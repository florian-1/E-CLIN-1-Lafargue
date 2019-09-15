import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class Test_5 {

    @Test
    void test_1patient_gravity_weak_medecin_fifo() {
        // Celui où un patient avec une gravité de 1 se présente au medecin
        Clinic clinic = new Clinic(TriageType.FIFO);
        Patient p1 = new Patient("Gérard", 1, VisibleSymptom.MIGRAINE);
        clinic.triagePatient(p1);
        if (clinic.getListFifoMedecin().size() != 0) {
            fail("gérard didn't need to be in queue");
        }
    }

    @Test
    void test_1patient_gravity_weak_radiologie_fifo() {
        // Celui où un patient avec une gravité de 1 se présente au radiologie
        Clinic clinic = new Clinic(TriageType.FIFO);
        Patient p1 = new Patient("Gérard", 1, VisibleSymptom.BROKEN_BONE);
        clinic.triagePatient(p1);
        if (clinic.getListFifoMedecin().size() != 0) {
            fail("gérard didn't need to be in queue");
        }
        if (clinic.getListFifoRadiologie().size() != 0) {
            fail("gérard didn't need to be in queue");
        }
    }

    @Test
    void test_1patient_gravity_weak_infirmerie_fifo() {
        // Celui où un patient avec une gravité de 1 se présente au infirmerie
        CommunityCenter cc = new CommunityCenter(TriageType.FIFO);
        Patient p1 = new Patient("Gérard", 1, VisibleSymptom.MIGRAINE);
        cc.triagePatient(p1);
        if (cc.getListforInfirmier().size() != 0) {
            fail("gérard didn't need to be in queue");
        }
    }

    @Test
    void test_1patient_gravity_weak_medecin_gravity() {
        // Celui où un patient avec une gravité de 1 se présente au medecin
        Clinic clinic = new Clinic(TriageType.GRAVITY);
        Patient p1 = new Patient("Gérard", 1, VisibleSymptom.MIGRAINE);
        clinic.triagePatient(p1);
        if (clinic.getListFifoMedecin().size() != 0) {
            fail("gérard didn't need to be in queue");
        }
    }

    @Test
    void test_1patient_gravity_weak_radiologie_gravity() {
        // Celui où un patient avec une gravité de 1 se présente au radiologie
        Clinic clinic = new Clinic(TriageType.GRAVITY);
        Patient p1 = new Patient("Gérard", 1, VisibleSymptom.BROKEN_BONE);
        clinic.triagePatient(p1);
        if (clinic.getListFifoMedecin().size() != 0) {
            fail("gérard didn't need to be in queue");
        }
        if (clinic.getListFifoRadiologie().size() != 0) {
            fail("gérard didn't need to be in queue");
        }
    }

    @Test
    void test_1patient_gravity_weak_infirmerie_gravity() {
        // Celui où un patient avec une gravité de 1 se présente au infirmerie
        CommunityCenter cc = new CommunityCenter(TriageType.GRAVITY);
        Patient p1 = new Patient("Gérard", 1, VisibleSymptom.MIGRAINE);
        cc.triagePatient(p1);
        if (cc.getListforInfirmier().size() != 0) {
            fail("gérard didn't need to be in queue");
        }
    }

}
