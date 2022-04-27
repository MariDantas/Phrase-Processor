import java.util.ArrayList;
import java.util.Scanner;

public class PhraseProcessor {
	public static void main(String[] args) {
		ArrayList<String> phrases = new ArrayList<>();
		String teste[];
		Scanner readPhrase = new Scanner(System.in);
		Scanner readOp = new Scanner(System.in);
		int option;
		String phrase;
		boolean cont = false;
		String snip;
		Scanner readSnip = new Scanner(System.in);
		ArrayList<String> foundSnip = new ArrayList<>();
		boolean found;
		
		System.out.println("Enter a phrase: ");
		phrase = readPhrase.nextLine();
		
		if (phrase.matches("[+-]?\\d*(\\.\\d+)?") || phrase.contains("@") || phrase.contains("#")) {
			System.out.println("Invalid characters!");
		} else {
			phrases.add(phrase);
		}
		
		if (!phrases.isEmpty()) {
			System.out.println("");
			System.out.println("Choose (enter a number corresponding to the desired option): ");
			System.out.println("1 - Insert another phrase");
			System.out.println("2 - Search text");
			System.out.println("3 - Exit");
			
			try {
				option = readOp.nextInt();
				
				if (option == 3) {
					System.out.println("End of program");
				} else {
					cont = true;
					while (cont) {
						if (option == 1) {
							System.out.println("Enter a phrase: ");
							phrase = readPhrase.nextLine();
							
							if (phrase.matches("[+-]?\\d*(\\.\\d+)?") || phrase.contains("@") || phrase.contains("#")) {
								System.out.println("Invalid characters!");
							} else {
								phrases.add(phrase);
							}
							System.out.println("");
						} else if (option == 2) {
							System.out.println("Enter the snippet you want to search for: ");
							snip = readSnip.nextLine();
							System.out.println("");
							
							for (int i = 0; i < phrases.size(); i++) {
								if ((phrases.get(i).toLowerCase()).contains(snip.toLowerCase())) {
									foundSnip.add(phrases.get(i));
								}
							}
							
							if (foundSnip.size() != 0) {
								found = true;
							} else {
								found = false;
							}
							
							if (found) {
								System.out.println("Phrases found: ");
								
								for(int i = 0; i < foundSnip.size(); i++) {
									System.out.println(foundSnip.get(i));
								}
							} else {
								System.out.println("No phrases found");
							}
						}
						System.out.println("Choose (enter a number corresponding to the desired option): ");
						System.out.println("1 - Insert another phrase");
						System.out.println("2 - Search text");
						System.out.println("3 - Exit");
						option = readOp.nextInt();
						System.out.println("");
						
						if (option == 3) {
							System.out.println("End of program");
							cont = false;
						}
					}
				}
			} catch (Exception e) {
				System.out.println("Error: the option entered is not a number!");
			}
			
		} else {
			System.out.println("No phrases were entered. End of program");
		}
		
		
	}
}

