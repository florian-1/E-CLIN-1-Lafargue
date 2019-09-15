import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class Test_4 {

    @Test
    void test_1patient_for_infimerie() {
        // Celui où un patient se présente au community Center avec une migraine
        CommunityCenter cc = new CommunityCenter(TriageType.FIFO);
        Patient p1 = new Patient("Gérard", 4, VisibleSymptom.MIGRAINE);
        cc.triagePatient(p1);
        if (cc.getListforInfirmier().get(0) != p1) {
            fail("patient not in queue");
        }
    }

    @Test
    void test_2patient_for_infimerie() {
        // Celui où deux patient se présente au community Center
        CommunityCenter cc = new CommunityCenter(TriageType.FIFO);
        Patient p1 = new Patient("Gérard", 4, VisibleSymptom.COLD);
        Patient p2 = new Patient("Luke", 8, VisibleSymptom.EBOLA);
        cc.triagePatient(p1);
        cc.triagePatient(p2);
        if (cc.getListforInfirmier().get(0) != p1) {
            fail("Gérard not first in Medecin queue");
        }
        if (cc.getListforInfirmier().get(1) != p2) {
            fail("Luke not second in Medecin queue");
        }
    }

    @Test
    void test_1patient_prioritary_solo_for_infimerie() {
        // Celui où un patient est prioritaire et passe devant les autres en infimerie
        CommunityCenter cc = new CommunityCenter(TriageType.GRAVITY);
        Patient p1 = new Patient("Gérard", 8, VisibleSymptom.COLD);
        cc.triagePatient(p1);
        if (cc.getListforInfirmier().get(0) != p1) {
            fail("Gérard not first in Medecin queue");
        }
    }

}
