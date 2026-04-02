package entities;

import Exceptions.Businessexceptions;

public class Revista extends ItemBiblioteca {
	private Integer edicao;
	
	public Revista(String titulo, Integer anoPublicacao, Integer edicao) {
		super(titulo, anoPublicacao);
		this.edicao = edicao;
	}

	public Integer getEdicao() {
		return edicao;
	}

	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
	}
	public void isValid(Integer edicao) {
		if (edicao == null) {
			throw new Businessexceptions("Valor invalido");
		}
	}
	@Override
	public String pegarDescricao() {
		return "revista  " + getTitulo() + " ano:  " + getAnoPublicacao() + "ano da publicação " + edicao;
	}

}
