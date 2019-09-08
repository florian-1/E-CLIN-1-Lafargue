
public class Patient {
	private VisibleSymptom visible_symptom;
	private int gravity;
	private String name;

	public Patient(String name, int gravity, VisibleSymptom visible_symptom) {
		this.name = name;
		this.gravity = gravity;
		this.visible_symptom = visible_symptom;
	}

	public VisibleSymptom getVisible_symptom() {
		return visible_symptom;
	}

	public int getGravity() {
		return gravity;
	}

	public String getName() {
		return name;
	}

}
