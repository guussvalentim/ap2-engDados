package modelo;

public class Categoria {

	private int id_categoria;
	private String nome;

	public int get_id_categoria() {
		return id_categoria;
	}

	public void set_id_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria(String nome) {
		this.nome = nome;
	}

	public Categoria(int id_categoria, String nome) {
		this.nome = nome;
		this.id_categoria = id_categoria;
	}
}
