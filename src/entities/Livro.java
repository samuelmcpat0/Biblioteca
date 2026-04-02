package entities;

import Exceptions.Businessexceptions;

public class Livro extends ItemBiblioteca {
	
	private String autor;
	private Integer paginas;
	
	public Livro() {
		
	}
	
	public Livro(String titulo, Integer anoPublicacao, String autor, Integer paginas) {
		super(titulo, anoPublicacao);
		this.autor = autor;
		this.paginas = paginas;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}
	public void isValid(String autor, Integer paginas) {
		if(autor == null || autor.isEmpty()) {
			throw new Businessexceptions(" Autor está vazio ");
		}
		if (paginas == null) {
			throw new Businessexceptions(" não tem paginas ");
		}
	}
	@Override
	public String pegarDescricao() {
		
		return "livro  " + getTitulo() + " ano:  " + getAnoPublicacao() +" autor " + autor + " paginas " + paginas;
	}

}
