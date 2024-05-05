package Noleggio;

public class BatMobile {
	private int idAuto;
	private String nome;
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
	@Override
	public String toString() {
		return "BatMobile [idAuto=" + idAuto + ", nome=" + nome + "]";
	}
	public BatMobile(int idAuto, String nome) {
		super();
		this.idAuto = idAuto;
		this.nome = nome;
	}	


	public String toStringPrint() {
		return idAuto + ", " + nome;
	}
}