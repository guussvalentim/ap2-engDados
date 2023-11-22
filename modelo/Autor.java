package modelo;

import java.util.ArrayList;

public class Autor {

	private int id_autor;
	private String cpf, nome_original, nome_artistico;

	public int get_id_autor() {
		return id_autor;
	} 

	public void set_id_autor(int id_autor) {
		this.id_autor = id_autor;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome_original() {
		return nome_original;
	}

	public void setNome_original(String nome_original) {
		this.nome_original = nome_original;
	}

	public String getNome_artistico() {
		return nome_artistico;
	}

	public void setNome_artistico(String nome_artistico) {
		this.nome_artistico = nome_artistico;
	}

	public Autor(String cpf, String nome_original, String nome_artistico) {
		this.cpf = cpf;
		this.nome_original = nome_original;
		this.nome_artistico = nome_artistico;
	}
	
	public Autor(int id_autor, String cpf, String nome_original, String nome_artistico) {
		this.id_autor = id_autor;
		this.cpf = cpf;
		this.nome_original = nome_original;
		this.nome_artistico = nome_artistico;
	}
}