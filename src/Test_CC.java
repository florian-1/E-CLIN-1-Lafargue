import org.junit.jupiter.api.Test;

import static org.junit.Assert.fail;

public class Test_CC {

    @Test
    public void whenTriagingPatient_thenPatientIsAddedToTheInfirmierWaitingList() {
        CommunityCenter cc = new CommunityCenter(TriageType.FIFO);
        Patient p1 = new Patient("Gérard", 4, VisibleSymptom.MIGRAINE);
        cc.triagePatient(p1);
        if (cc.getListforInfirmier().get(0) != p1) {
            fail("patient not in queue");
        }
    }
}
