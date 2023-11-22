package modelo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Musica {
	
	private String titulo, letra;
	private Date data_lancamento;
	private Categoria categoria;
	private int id_musica, duracao;
	private ArrayList<Autor> autores;
	
	public int get_id_musica() {
		return id_musica;
	}
	public void set_id_musica(int id_musica) {
		this.id_musica = id_musica;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public Date getData_lancamento() {
		return data_lancamento;
	}

	public void setData_lancamento(Date data_lancamento) {
		this.data_lancamento = data_lancamento;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public ArrayList<Autor> getAutores() {
		return autores;
	}
	
	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}

	public void addAutor(Autor autor) {
		this.autores.add(autor);
    }
	
	public Musica(int id_musica, String titulo, String letra, Date data_lancamento, Categoria categoria, int duracao,
			ArrayList<Autor> autores) {
		this.id_musica = id_musica;
		this.titulo = titulo;
		this.letra = letra;
		this.data_lancamento = data_lancamento;
		this.categoria = categoria;
		this.duracao = duracao;
		this.autores = autores;
	}

	public Musica(String titulo, String letra, Date data_lancamento, Categoria categoria, int duracao,
			ArrayList<Autor> autores) {
		this.titulo = titulo;
		this.letra = letra;
		this.data_lancamento = data_lancamento;
		this.categoria = categoria;
		this.duracao = duracao;
		this.autores = autores;
	}

	public Musica(int id_musica, String titulo, String letra, Date data_lancamento, Categoria categoria, int duracao) {
		this.id_musica = id_musica;
		this.titulo = titulo;
		this.letra = letra;
		this.data_lancamento = data_lancamento;
		this.categoria = categoria;
		this.duracao = duracao;
		this.autores = new ArrayList <Autor>();
	}

	public Musica(String titulo, String letra, Date data_lancamento, Categoria categoria, int duracao) {
		this.titulo = titulo;
		this.letra = letra;
		this.data_lancamento = data_lancamento;
		this.categoria = categoria;
		this.duracao = duracao;
		this.autores = new ArrayList <Autor>();
	}
}
