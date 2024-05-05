package Noleggio;

import java.time.LocalDate;

public class Auto {
	private int idAuto;
	private String nome;
	private double prezzo;
	private boolean statoNoleggio;
 
	private LocalDate dataNoleggio;


	public Auto(int idAuto, String nome, double prezzo, boolean statoNoleggio, LocalDate dataNoleggio) {
		this.idAuto = idAuto;
		this.nome = nome;
		this.prezzo = prezzo;
		this.statoNoleggio = statoNoleggio;
		this.dataNoleggio = dataNoleggio;
	}

	public int getIdAuto() {
		return idAuto;
	}

	public void setIdAuto(int idAuto) {
		this.idAuto = idAuto;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public boolean isStatoNoleggio() {
		return statoNoleggio;
	}

	public void setStatoNoleggio(boolean statoNoleggio) {
		this.statoNoleggio = statoNoleggio;
	}

	public LocalDate getDataNoleggio() {
		return dataNoleggio;
	}

	public void setDataNoleggio(LocalDate dataNoleggio) {
		this.dataNoleggio = dataNoleggio;
	}

	@Override
	public String toString() {
		return "Auto [idAuto=" + idAuto + ", nome=" + nome + ", prezzo=" + prezzo + ", statoNoleggio=" + statoNoleggio + ", dataNoleggio="
				+ dataNoleggio + "]";
	}
	
	 public String toStringPrint() {
	        return idAuto + ", " + nome + ", " + prezzo + ", " + statoNoleggio + ", " + dataNoleggio;
	    }
}