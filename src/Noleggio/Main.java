package Noleggio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String user;
		String psw;
		int sceltaMenu;
		String menu;
		int idAuto;
		String nomeAuto;
		double prezzo;

		Scanner scan = new Scanner(System.in);
		// Login utente
		System.out.println("Inserisci user: ");
		user = scan.nextLine();
		System.out.println("Inserisci password: ");
		psw = scan.nextLine();
		// login.inserisciUserPsw restituisce null se utente inesistente o valore
		// numerico in base al tipo utente
		Login login = new Login();
		int utente = login.inserisciUserPsw(user, psw);

		boolean start = true;
		while (start) {
			Noleggio noleggio = new Noleggio();
			// Verifica sulla tipologia utente per presentare il menu, quindi gestire il
			// menu con lo switch

			if (utente == 1) {

				// l'utente è un cliente
				System.out.println("BENVENUTO NEL SITO DELL'AUTONOLEGGIO MOVEIT");
				menu = "Cosa vuoi fare? \n 1. Ricerca un'auto per prezzo \n 2. Ricerca un'auto per nome \n3. Noleggia un'auto \n 4. Esci";
				sceltaMenu = GestioneMenu.CreaMenuIniz(menu);
				switch (sceltaMenu) {
				case 1:
					System.out.println("Inserisci il massimo prezzo giornaliero dell'auto: (es.40,99)");
					prezzo = scan.nextDouble();
					scan.nextLine();
					noleggio.ricercaAuto(prezzo);
					break;
				case 2:
					System.out.println("Inserisci la marca e il modello dell'auto: ");
					nomeAuto = scan.nextLine();
					noleggio.ricercaAuto(nomeAuto);
					break;
				case 3:
					System.out.println("Inserisci l'identificativo dell'auto da noleggiare: ");
					idAuto = scan.nextInt();
					scan.nextLine();
					noleggio.selezioneAuto(idAuto);
					break;
				case 4:
					start = GestioneMenu.esciOprosegui();
					break;
				default:
					System.out.println("Scelta non valida. Riprova.");
				}
			} else if (utente == 2) {
				// l'utente è un manager
				System.out.println("CONSOLLE AUTONOLEGGIO MOVEIT");
				menu = "Cosa vuoi fare? \n 1. Inserisci un'auto \n 2. Rimuovi un'auto \n 3. Ricerca un'auto per prezzo \n 4. Ricerca un'auto per nome \n 5. Esci";
				sceltaMenu = GestioneMenu.CreaMenuIniz(menu);
				switch (sceltaMenu) {
				case 1:
					System.out.println("Inserisci l'identificativo dell'auto: ");
					idAuto = scan.nextInt();
					scan.nextLine();
					System.out.println("Inserisci la marca e il modello dell'auto: ");
					nomeAuto = scan.nextLine();
					System.out.println("Inserisci il prezzo giornaliero dell'auto: (es. 40,99)");
					prezzo = scan.nextDouble();
					scan.nextLine();
					noleggio.aggiungiAuto(new Auto(idAuto, nomeAuto, prezzo, false, null));
					break;
				case 2:
					System.out.println("Inserisci l'identificativo dell'auto: ");
					idAuto = scan.nextInt();
					scan.nextLine();
					noleggio.rimuoviAuto(idAuto);
					break;
				case 3:
					System.out.println("Inserisci il massimo prezzo giornaliero dell'auto: (es. 40,99");
					prezzo = scan.nextDouble();
					scan.nextLine();
					noleggio.ricercaAuto(prezzo);
					break;
				case 4:
					System.out.println("Inserisci la marca e il modello dell'auto: ");
					nomeAuto = scan.nextLine();
					noleggio.ricercaAuto(nomeAuto);
					break;
				case 5:
					start = GestioneMenu.esciOprosegui();
					break;
				default:
					System.out.println("Scelta non valida. Riprova.");
				}
			} else {
				// l'utente è Batman
				System.out.println("BATGARAGE");
				menu = "Cosa vuoi fare? \n 1. Inserisci un mezzo \n 2. Rimuovi un mezzo \n 3. Ricerca un mezzo \n 4. Seleziona un mezzo \n 5. Esci";
				sceltaMenu = GestioneMenu.CreaMenuIniz(menu);
				switch (sceltaMenu) {
				case 1:
					System.out.println("Inserisci l'identificativo del mezzo: ");
					idAuto = scan.nextInt();
					scan.nextLine();
					System.out.println("Inserisci il nome del mezzo: ");
					nomeAuto = scan.nextLine();
					noleggio.aggiungiBatMobile(new BatMobile(idAuto, nomeAuto));
					break;
				case 2:
					System.out.println("Inserisci l'identificativo del mezzo: ");
					idAuto = scan.nextInt();
					scan.nextLine();
					noleggio.rimuoviBatMobile(idAuto);
					break;
				case 3:
					System.out.println("Inserisci il nome del mezzo: ");
					nomeAuto = scan.nextLine();
					noleggio.ricercaBatMobile(nomeAuto);
					break;
				case 4:
					System.out.println("Inserisci l'identificativo del mezzo da usare: ");
					idAuto = scan.nextInt();
					scan.nextLine();
					noleggio.selezionaBatMobile(idAuto);
					break;
				case 5:
					start = GestioneMenu.esciOprosegui();
					break;
				default:
					System.out.println("Scelta non valida. Riprova.");
				}
			}
		}	
	}
}
