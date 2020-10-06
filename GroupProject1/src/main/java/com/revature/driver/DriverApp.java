package com.revature.driver;

import java.util.List;
import java.util.Scanner;

import com.revature.DAOImpls.*;
import com.revature.interfaces.*;
import com.revature.models.*;
import com.revature.services.*;

public class DriverApp {
	static ManagerServiceInter managerServices;
	static MoveInServiceInter moveIn;
	static MoveOutServiceInter moveOut;
	
	public static void main(String... args) {
		boolean toContinue = true;
		while (toContinue){
			Scanner scan = new Scanner(System.in);
			System.out.println("_______________________________________________________________________");
			System.out.println("|Move In------- Move in a new resident                                |");
			System.out.println("|Move Out------ Move a resident out                                   |");
			System.out.println("|Vacant-------- Get all vacant apartments                             |");
			System.out.println("|Pets---------- Get the apartments with pets                          |");
			System.out.println("|Gross Income-- Get the gross monthly income of the property          |");
			System.out.println("|Exit---------- Exit the application                                  |");
			System.out.println("|_____________________________________________________________________|");
			System.out.print("What would you like to do: ");
			String userInput = scan.nextLine();
			
			switch (userInput){
				case "Move In":
					moveIn();
					break;
				case "Move Out":
					moveOut();
					break;
				case "Vacant":
					vacant();
					break;
				case "Pets":
					pets();
					break;
				case "Gross Income":
					grossIncome();
					break;
				case "Exit":
					System.out.println("Exiting...");
					toContinue = false;
					break;
				default :
					System.out.println("Invalid Input");
					break;
			}
			boolean keepGoing = true;
			while(keepGoing && toContinue) {
				System.out.print("Enter 'C' to continue: ");
				userInput = scan.nextLine();
				if(userInput.equals("C")) {
					keepGoing = false;
				}
				else {
					System.out.println("Invalid Input");
				}
			}
		}
		System.out.println("Goodbye");
	}

	private static void grossIncome() {
		System.out.println("The properties gross monthly income is " + managerServices.getGrossMonthlyIncome() +"$");
	}

	private static void pets() {
		List<Pet> pets = managerServices.getPets();
		for(int i = 0; i < pets.size() ; ++i) {
			if(pets.get(i).isServiceAnimal()) {
				System.out.print("Service Dog ");
			}
			System.out.print(pets.get(i).getName() + " the " + pets.get(i).getBreed() + "lives in: ");
			System.out.print("Apartment " + pets.get(i).getApartment().getId() +
					" room number " + pets.get(i).getApartment().getRoomNumber() +
					" building " + pets.get(i).getApartment().getBuildingLetter());
			System.out.println("");
		}
	}

	private static void vacant() {
		List<Apartment> vacantApart = managerServices.getVacantApartments();
		for(int i = 0; i < vacantApart.size() ; ++i) {
			System.out.println("Apartment " + vacantApart.get(i).getId() +
					" room number " + vacantApart.get(i).getRoomNumber() +
					" building " + vacantApart.get(i).getBuildingLetter() + " is vacant");
		}
	}

	private static void moveOut() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the id of the resident moving out: ");
		int userInput = scan.nextInt();
		moveOut.deleteResident(userInput);
		System.out.println("The resident is moved out.");
	}

	private static void moveIn() {
		Scanner scan = new Scanner(System.in);
		System.out.print("What is the new residents first name: ");
		String firstName = scan.nextLine();
		System.out.print("What is the new residents last name: ");
		String lastName = scan.nextLine();
		System.out.print("What apartment are they moving into: ");
		int apartNum = scan.nextInt();
		moveIn.addResident(firstName, lastName, apartNum);
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.print("Add pet (Y/N): ");
			String addPet = scan.next();
			if (addPet.equals("Y")) {
				System.out.print("What is the pets name: ");
				String petName = scan.nextLine();
				System.out.print("What is the pets breed: ");
				String breed = scan.nextLine();
				System.out.print("Is the pet a service animal? enter Y for yes or anything else for no: ");
				String isService = scan.next();
				if (isService.equals("Y")) {
					moveIn.addPet(breed, petName, apartNum, true);
				}
				else{
					moveIn.addPet(breed, petName, apartNum, false);
				}
			}
			else if (addPet.equals("N")) {
				keepGoing = false;
			}
			else {
				System.out.println("Invalid Input");
			}
		}
		keepGoing = true;
		while (keepGoing) {
			System.out.print("Add car (Y/N): ");
			String addCar = scan.next();
			if (addCar.equals("Y")) {
				System.out.print("What is the cars make: ");
				String make = scan.nextLine();
				System.out.print("What is the cars model: ");
				String model = scan.nextLine();
				System.out.print("What is the cars year: ");
				int year = scan.nextInt();
				System.out.print("What is the cars plate number: ");
				String plate = scan.nextLine();
				
				//---------------------------------------------------------------------------------
				//need get to somehow get resident id
				//---------------------------------------------------------------------------------
				int ownerid = 0;
				
				moveIn.addCar(make, model, year, plate, 0);
			}
			else if (addCar.equals("N")) {
				keepGoing = false;
			}
			else {
				System.out.println("Invalid Input");
			}
		}
	}
	
}
