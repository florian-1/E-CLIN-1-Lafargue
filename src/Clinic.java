import java.util.ArrayList;

public class Clinic extends GestionPatient {

    private ArrayList<Patient> listForMedecin;
    private ArrayList<Patient> listForRadiologie;

    public Clinic(TriageType triageType) {
        this.triageType = triageType;
        listForMedecin = new ArrayList<Patient>();
        listForRadiologie = new ArrayList<Patient>();
    }

    public void triagePatient(Patient patient) {
        super.triagePatientInList(patient , listForMedecin );
        if (NeedRadiologie(patient.getVisible_symptom())) {
            super.triagePatientInList(patient , listForRadiologie );
        }
    }

    public boolean NeedRadiologie(VisibleSymptom visibleSymptom) {// go to radiologie or not
        if (visibleSymptom == VisibleSymptom.BROKEN_BONE || visibleSymptom == VisibleSymptom.SPRAIN) {
            return true;
        }
        return false;
    }

    public ArrayList<Patient> getListFifoMedecin() {
        return listForMedecin;
    }

    public ArrayList<Patient> getListFifoRadiologie() {
        return listForRadiologie;
    }

}
