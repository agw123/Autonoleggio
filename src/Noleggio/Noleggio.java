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

	public void aggiungiBatMobile(BatMobile batMobile) {
		System.out.println("Aggiunta di Batmobile in corso:");
		listaBatmobili.add(batMobile);
		System.out.println(batMobile);
	}

	public void rimuoviBatMobile(int idAuto) {
		listaBatmobili.remove(idAuto);
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
		autoDisponibili = getAutoFile();
		autoDisponibili.add(auto);
		aggiungiAutoFile(auto);
		System.out.println("Hai aggiunto" + auto + "alla lista delle auto.");
	}

	public void rimuoviAuto(int idAuto) {
		autoDisponibili.remove(idAuto);
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

	public ArrayList<Auto> getAutoFile() throws FileNotFoundException, IOException {
		String filePath = "src/listaAuto.txt";
		File file = new File(filePath);
		if (!file.exists()) file.createNewFile();
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

	public void rimuoviAutoFile() {

	}
}