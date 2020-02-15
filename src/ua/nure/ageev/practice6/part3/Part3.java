package ua.nure.ageev.practice6.part3;

public class Part3 {
	public static void main(String[] args) {
		Parking park = new Parking(10);
		park.print();
		park.parkCar(2);
		park.print();
		park.parkCar(0);
		park.print();
		park.unparkCar(2);
		park.print();
		park.parkCar(9);
		park.print();
		park.parkCar(8);
		park.print();
		park.parkCar(7);
		park.print();
		park.parkCar(8);
		park.print();
	}

}
