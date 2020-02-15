package ua.nure.ageev.practice6.part3;

public class ParkingPlace {
	private boolean isEmpty;

	public ParkingPlace() {
		this.isEmpty = true;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public void carParked() {
		this.isEmpty = false;
	}

	public void carOut() {
		this.isEmpty = true;
	}

	@Override
	public String toString() {
		return "ParkingPlace is " + (isEmpty ? "Free" : "Ocupated");
	}

}
