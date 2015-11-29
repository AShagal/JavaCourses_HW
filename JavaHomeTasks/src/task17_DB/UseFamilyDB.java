package task17_DB;

import java.util.Scanner;

public class UseFamilyDB {
	private static final String ADD_KEY = "a";
	private static final String SHOW_KEY = "s";
	private static final String QUIT_KEY = "q";

	public static void main(String[] args) {
		Family dbmanager = new Family("family", "root", "password", "family_members");
		Scanner scanner = new Scanner(System.in);
		String task = null;
		String arguments = null;

		while (true) {
			task = scanner.nextLine();

			switch (task) {
			case ADD_KEY:
				System.out.println("Adding record. Enter initialization arguments:");
				arguments = scanner.nextLine();
				boolean result = dbmanager.add(arguments);
				if (result) {
					System.out.println("Success. Record was added");
				} else {
					System.out.println("Error. Record wasn't added");
				}
				break;
			case SHOW_KEY:
				System.out.println("\nFamily members table: ");
				dbmanager.show();
				System.out.println("");
				break;
			case QUIT_KEY:
				dbmanager.show();
				dbmanager.close();
				System.out.println("Finishing");
				break;
			default:
				System.out.println(
						"Wrong command. Avaliable:\na to add new record \ns to show existing records\nq to quit program");
				break;
			}
		}
	}
}
