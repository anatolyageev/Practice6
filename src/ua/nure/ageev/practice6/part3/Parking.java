package ua.nure.ageev.practice6.part3;

import java.util.ArrayList;
import java.util.List;

public class Parking {
	private int numberPlaces;
	private int numberFreePlaces;
	List<Integer> parkingList;

	public Parking(int numberPlaces) {
		this.numberPlaces = numberPlaces;
		this.numberFreePlaces = numberPlaces;
		parkingList = new ArrayList<Integer>(numberPlaces);
		initiateParking();
	}

	private void initiateParking() {
		for (int i = 0; i < numberPlaces; i++) {
			parkingList.add(0);
		}
	}

	public boolean parkCar(int initParkingNum) {
		if (numberFreePlaces == 0) {
			return false;
		}
		for (int i = initParkingNum; i < numberPlaces; i++) {
			if (parkingList.get(i)==0) {
				parkingList.set(i,1);
				numberFreePlaces--;
				return true;
			}
		}
		for (int j = 0; j < initParkingNum; j++) {
			if (parkingList.get(j)==0) {
				parkingList.set(j,1);
				numberFreePlaces--;
				return true;
			}
		}
		return false;
	}

	public boolean unparkCar(int parkingPlace) {
		if (parkingList.get(parkingPlace)==0) {
			return false;
		} else {
			parkingList.set(parkingPlace,0);
			numberFreePlaces++;
			return true;
		}
	}

	void print(){
		for (Integer p:
			parkingList ) {
			System.out.print(p);
		}
		System.out.println("");
	}

	@Override
	public String toString() {
		return "Parking [numberPlaces=" + numberPlaces + ", numberFreePlaces=" + numberFreePlaces + ", parkingList="
				+ parkingList + "]";
	}

}
