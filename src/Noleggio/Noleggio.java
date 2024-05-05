package Noleggio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Noleggio {
	private ArrayList<Auto> autoDisponibili;
	private ArrayList<BatMobile> listaBatmobili;

	// costruttore che definisce una nuova array contenente l'oggetto Auto, che
	// deriva dalla classe Auto
	Noleggio() {
		this.autoDisponibili = new ArrayList<>();
		this.listaBatmobili = new ArrayList<>();
	}

	public void aggiungiBatMobile(BatMobile batMobile) throws FileNotFoundException, IOException {
		System.out.println("Aggiunta di Batmobile in corso:");
		listaBatmobili = getBatmobileFile("src/listaBatmobili.txt");
		listaBatmobili.add(batMobile);
		aggiungiBatmobileFile(batMobile);
		System.out.println("Hai aggiunto" + batMobile + "alla lista delle BatMobili.");
	}

	public void rimuoviBatMobile(int IDbatMobile) {// int IDbatMobile invece che BatMobile batMobile
		// int idAuto invece che Auto auto
		for (BatMobile bat : listaBatmobili) // ciclo for di ricerca seguito da un remove+break
		{
			try {
				if (bat.getIdAuto() == IDbatMobile) {
					System.out.println(bat);
					autoDisponibili.remove(bat);
					System.out.println("rimossa auto " + bat.getIdAuto());
					break;
				}
			} catch (java.util.ConcurrentModificationException e) {
			}
		}
		listaBatmobili.remove(IDbatMobile);
	}

	public void ricercaBatMobile(String nome) {
		System.out.println("Ricerca Batmobili in corso:");
		if (nome.equals("tutte")) {
			for (BatMobile bat : listaBatmobili) {
				System.out.println(bat);
			}
		} else {
			for (BatMobile bat : listaBatmobili) {
				if (bat.getNome().equals(nome)) {
					System.out.println(bat);
				}
			}
		}
	}

	public void selezionaBatMobile(int idAuto) {
		System.out.println("Selezione di Batmobile per ID in corso:");
		for (BatMobile bat : listaBatmobili) {
			if (bat.getIdAuto() == idAuto) {
				System.out.println(bat);
			}
		}
	}

	public void aggiungiAuto(Auto auto) throws FileNotFoundException, IOException {
		autoDisponibili = getAutoFile("src/listaAuto.txt");
		autoDisponibili.add(auto);
		aggiungiAutoFile(auto);
		System.out.println("Hai aggiunto" + auto + "alla lista delle auto.");
	}

	public void rimuoviAuto(int idAuto) {// int idAuto invece che Auto auto
		for (Auto auto : autoDisponibili) // ciclo for di ricerca seguito da un remove+break
		{
			try {
				if (auto.getIdAuto() == idAuto) {
					System.out.println(auto);
					autoDisponibili.remove(auto);
					System.out.println("rimossa auto " + auto.getIdAuto());
					break;
				}
			} catch (java.util.ConcurrentModificationException e) {
			}
		}
	}

	public void ricercaAuto(String nome) {
		System.out.println("Ricerca Auto per nome in corso:");
		for (Auto auto : autoDisponibili) {
			if (auto.getNome().equals(nome)) {
				System.out.println(auto);
			}
		}
	}

	public void ricercaAuto(double prezzo) {
		System.out.println("Ricerca Auto per prezzo in corso:");
		for (Auto auto : autoDisponibili) {
			if (auto.getPrezzo() <= prezzo) {
				System.out.println(auto);
			}
		}
	}

	public void selezioneAuto(int idAuto) {
		System.out.println("Selezione di Auto per ID in corso:");
		for (Auto auto : autoDisponibili) {
			if (auto.getIdAuto() == idAuto) {
				auto.setStatoNoleggio(true);
				auto.setDataNoleggio(LocalDate.now());
				System.out.println(auto);
			}
		}
	}

	public ArrayList<Auto> getAutoFile(String path) throws FileNotFoundException, IOException {
		String filePath = path;
		File file = new File(filePath);
		if (!file.exists())
			file.createNewFile();
		String line;
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			while ((line = reader.readLine()) != null) {
				String[] parti = line.split(",");
				LocalDate localDate;
				if (parti[4].trim().equals("null")) {
					localDate = null;
				} else {
					localDate = LocalDate.parse(parti[4].trim());
				}
				Auto a = new Auto(Integer.parseInt(parti[0].trim()), parti[1].trim(),
						Double.parseDouble(parti[2].trim()), Boolean.parseBoolean(parti[3].trim()), localDate);
				autoDisponibili.add(a);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return autoDisponibili;
	}

	public void aggiungiAutoFile(Auto auto) throws FileNotFoundException, IOException {
		String filePath = "src/listaAuto.txt";
		String line;
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
			writer.write(auto.toStringPrint());
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BatMobile> getBatmobileFile(String path) throws FileNotFoundException, IOException {
		String filePath = path;
		File file = new File(filePath);
		if (!file.exists())
			file.createNewFile();
		String line;
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			while ((line = reader.readLine()) != null) {
				String[] parti = line.split(",");
				BatMobile b = new BatMobile(Integer.parseInt(parti[0].trim()), parti[1].trim());
				listaBatmobili.add(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaBatmobili;
	}
	
	public void aggiungiBatmobileFile(BatMobile batmobile) throws FileNotFoundException, IOException {
		String filePath = "src/listaBatmobili.txt";
		String line;
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
			writer.write(batmobile.toStringPrint());
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void rimuoviAutoFile() {

	}
}