package entities;

import Exceptions.Businessexceptions;

public abstract class ItemBiblioteca {
	protected String titulo;
	protected Integer anoPublicacao;
	
	public ItemBiblioteca() {
		
	}
	
	public ItemBiblioteca(String titulo, Integer anoPublicacao) {
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(Integer anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	
	public void isValid(String titulo, Integer anoPublicacao ) {
		if (titulo == null) {
			throw new Businessexceptions(" Não foi validado ");
		}
		if (anoPublicacao == null ) {
			throw new Businessexceptions(" Não foi validado ");
		}
	}
	
	public abstract String pegarDescricao ();
	

}
