package Noleggio;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class GestioneMenu {
	private static Scanner myScan= new Scanner(System.in);
	private static String sIntRegex = "[0-9]+";	
	
	public GestioneMenu() {
		
	}
	
	public static int CreaMenuIniz(String menu) {
		System.out.println(menu);
		int sScelta = myScan.nextInt();
		String s = myScan.nextLine();
		return sScelta;
	}
	
	public static boolean esciOprosegui() {
		System.out.println("Vuoi effettuare una nuova azione? \n1. Sì \n2. Esci");
		int number = myScan.nextInt();
		myScan.nextLine();
		if (number == 1) {
			return true;
		} else if (number == 2){
			System.out.println("Grazie e arrivederci!");
			return false;
		} else {
			System.out.println("Scelta non valida. riprova.");
			esciOprosegui();
		}
		return false;
	}
	
	public static String[] DammiIntero(String dato, String sRetMsg, String sErrMsg, int iNumTent) {
		int iTent = 0;
		String[] sRet = new String[2];
		String sNumero = null;

		while (true) {
			System.out.println(dato);
			sNumero = myScan.nextLine();
			if (sNumero.matches(sIntRegex)) {
				sRet[0] = "1";
				sRet[1] = sNumero;
				break;
			} else {
				iTent++;
				if (iTent == iNumTent) {
					System.out.println(sErrMsg);
					sRet[0] = "0";
					break;
				}
				System.out.println(sRetMsg + " - Tentativi rimasti: " + (iNumTent-iTent));
			}
		}
		return sRet;
	}
	
	public static String[] DammiData(String dato, String sRetMsg, String sErrMsg, int iNumTent) {
		int iTent = 0;
		String[] sRet = new String[2];
		String sData = null;

		while (true) {
			System.out.println(dato);
			sData = myScan.nextLine();

			if (sData == null || sData.length() != 10) {
				System.out.println("La data non è valida"); 
			} else {
				sData = sData.replace('-', '/'); 
				try { 
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					formatter.setLenient(false) ;
					if(!(formatter.parse(sData)==null)) {
						sRet[0] = "1";
						sRet[1] = sData;
						break;
					} 		
				} catch (Exception e) {
					iTent++;
					if (iTent == iNumTent) {
						System.out.println(sErrMsg);
						sRet[0] = "0";
						break;
					}
					System.out.println(sRetMsg + " - Tentativi rimasti: " + (iNumTent-iTent));
				} 
			}
		}
		return sRet;
	}
}
