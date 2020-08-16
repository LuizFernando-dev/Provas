package br.com.makeProva.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Questao {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String arquivo;
	private String titulo;
	private String resposta;
	private String q1;
	private String q2;
	private String q3;
	private String q4;
	@ManyToOne
	private Teste teste;
	
	public String getQ1() {
		return q1;
	}

	public void setQ1(String q1) {
		this.q1 = q1;
	}

	public String getQ2() {
		return q2;
	}

	public void setQ2(String q2) {
		this.q2 = q2;
	}

	public String getQ3() {
		return q3;
	}

	public void setQ3(String q3) {
		this.q3 = q3;
	}

	public String getQ4() {
		return q4;
	}

	public void setQ4(String q4) {
		this.q4 = q4;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Questao() {
		
	}
	
	public Teste getTeste() {
		return teste;
	}

	public void setTeste(Teste teste) {
		this.teste = teste;
	}

	public int getId() {
		return id;
	}

	public Questao(String titulo, String resposta) {
		this.titulo = titulo;
		this.resposta = resposta;
	}
	
	public String getArquivo() {
		return arquivo;
	}
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

}
