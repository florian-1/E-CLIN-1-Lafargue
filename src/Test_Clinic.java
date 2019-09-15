import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class Test_Clinic {

    @Test
    public void whenTriagingPatient_thenPatientIsAddedToTheDoctorWaitingList() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        Patient p1 = new Patient("Gérard", 4, VisibleSymptom.FLU);
        clinic.triagePatient(p1);
        if (clinic.getListFifoMedecin().get(0) != p1) {
            fail("patient not in Medecin queue");
        }
    }

    @Test
    public void whenTriagingPatientWithTheFlu_thenPatientIsNotAddedToTheRadiologyWaitingList() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        Patient p1 = new Patient("Gérard", 4, VisibleSymptom.FLU);
        clinic.triagePatient(p1);
        if (clinic.getListFifoRadiologie().size() > 0) {
            fail("patient is in Radiologie queue");
        }
    }

    @Test
    public void whenTriagingPatientWithABrokenBone_thenPatientIsAddedToTheRadiologyWaitingList() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        Patient p1 = new Patient("Gérard", 4, VisibleSymptom.BROKEN_BONE);
        clinic.triagePatient(p1);
        if (clinic.getListFifoRadiologie().get(0) != p1) {
            fail("patient is not in Radiologie queue");
        }
    }

    @Test
    public void whenTriagingPatientWithASprain_thenPatientIsAddedToTheRadiologyWaitingList() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        Patient p1 = new Patient("Gérard", 4, VisibleSymptom.SPRAIN);
        clinic.triagePatient(p1);
        if (clinic.getListFifoRadiologie().get(0) != p1) {
            fail("patient is not in Radiologie queue");
        }
    }
}
