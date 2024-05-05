package Noleggio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

 
public class Login {
	Scanner scan=new Scanner(System.in);
	String filePath = "src/userPasswordFile.txt";
	public int inserisciUserPsw(String userInput, String pswInput) {
		
		int flag=0;
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
			String line;
			String userRead;
			String passwordRead;
			String typeRead;
			
			while( (line =reader.readLine()) != null) {
			
				  userRead="";
				  passwordRead=""; 
				  typeRead="";
				
				
			String[] parti = line.split(",");
			if(parti.length==3) {
				  userRead=parti[0].trim(); 
				  passwordRead=parti[1].trim(); 
				  typeRead=parti[2].trim() ;
			}
			if (userInput.equals(userRead) && passwordRead.equals(pswInput))
			{	
				if (typeRead.equals("Cliente"))
					flag=1;
				else if (typeRead.equals("Manager"))
					flag=2;
				else if (typeRead.equals("Batman"))
					flag=3;
			}
			
			if (flag==0)
			{ 
				System.out.println("Username o Password errati");
				return 0;
			}
			else 
			{
				System.out.println("Accesso effettuato per "+typeRead);
				return flag;
			}
			}
		}
		catch (IOException e) {return flag;};		
//		if (userInput.equals(user))
		System.out.println("Wrong password or user");
 		return flag;
	}
}
//LOGIN deve ritornare NULL se non � verificato (utente inesistente) oppure valore numerico 1,2,3 per la tipologia
