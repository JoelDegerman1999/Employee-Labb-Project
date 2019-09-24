package ui;

import utilities.Utilities;

public class Main {

	public static void main(String[] args) {
		Menu.loadStartEmployees();

		boolean exit = false;
		do {
			Menu.printMenu();

			System.out.print("Enter a choice: ");
			int choice = Utilities.sc.nextInt();

			switch (choice) {
			case 1:
				Menu.printEmployeeManagementMenu();
				break;
			case 2:
				Menu.printEmployeeStatisticsMenu();
				break;
			case 0:
				System.out.println("Exiting program!");
				exit = true;
				break;
			default:
				System.out.println("Enter a correct number between (0-2)\n (Press enter)");
				Utilities.sc.nextLine();// rensa cache
				Utilities.sc.nextLine();
				break;
			}
		} while (!exit);
		Utilities.sc.close();
	}
}
