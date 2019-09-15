import java.util.ArrayList;

public class CommunityCenter extends GestionPatient {
    private ArrayList<Patient> listforInfirmier;

    public ArrayList<Patient> getListforInfirmier() {
        return listforInfirmier;
    }

    public CommunityCenter(TriageType triageType) {
        this.triageType = triageType;
        listforInfirmier = new ArrayList<Patient>();
    }

    public void triagePatient(Patient patient) {
        super.triagePatientInList(patient , listforInfirmier );
    }


}
