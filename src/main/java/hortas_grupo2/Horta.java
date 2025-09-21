package hortas_grupo2;

import java.time.LocalDate;

import java.util.ArrayList;

public class Horta {
	private String nome;
	private String localizacao;
	private ArrayList<Talhao> talhoes;

	public Horta(String nome, String localizacao) {
		this.nome = nome;
		this.localizacao = localizacao;
		talhoes = new ArrayList<Talhao>();
	}
	
	
	public void adicionarTalhao(int numero, int area) {
		talhoes.add(new Talhao(numero, area));
	}
	
	
	public String getNome() {
		return nome;
	}
	
	
	public Talhao procurarTalhao(int numeroTalhao) {
		for (Talhao talhao : talhoes) {
			if (talhao.getNumero() == numeroTalhao) {
				return talhao;
			}
		}
		System.out.println("Talhão não encontrado");
		return null;
	}
	
	
	public void registarPlantacao(int numeroT, LocalDate data, String tipo) {
		Talhao talhao = procurarTalhao(numeroT);
		if (talhao != null) {
			talhao.adicionarPlantacao(data, tipo);
		}
	}
	
	public void imprimirPlantacoes() {
		for (Talhao talhao : talhoes) {
			talhao.imprimirPlantacoes();
		}
	}
	
	
	public int calcularAreaTotal() {
		int total = 0;
		for (Talhao talhao : talhoes) {
			total += talhao.getArea();
		}
		return total;
	}
	
	
	public void imprimirAreaTotal() {
		System.out.println(calcularAreaTotal() + " metros quadrados");
	}
	
	public boolean verificarTipoTalhoes(String tipo) {
		for (Talhao talhao : talhoes) {
			if (talhao.hasTipo(tipo)) {
				return true;
			}
		}
		return false;
	}
}