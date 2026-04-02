package entities;

import Exceptions.Businessexceptions;

public class ItemEmprestimo {
	private ItemBiblioteca itens;
	private Integer diasEmprestado;
	
	public ItemEmprestimo() {
		super();
	}
	
	public ItemEmprestimo(ItemBiblioteca itens, Integer diasEmprestado) {
		super();
		this.itens = itens;
		this.diasEmprestado = diasEmprestado;
	}

	public ItemBiblioteca getItens() {
		return itens;
	}
	public void setItens(ItemBiblioteca itens) {
		this.itens = itens;
	}
	public Integer getDiasEmprestado() {
		return diasEmprestado;
	}
	public void setDiasEmprestado(Integer diasEmprestado) {
		this.diasEmprestado = diasEmprestado;
	}
	
	public void isValid(ItemBiblioteca itens, Integer diasEmprestado) {
		if (itens == null) {
	        throw new Businessexceptions("Item da biblioteca inválido");
	    }

	    if (diasEmprestado == null || diasEmprestado <= 0) {
	        throw new Businessexceptions("Dias de empréstimo inválidos");
	    }
	}
	
	public double calcularMulta() {
		double multa = 2;
		if (diasEmprestado <= 7) {
			return 0.0;
		}
		double atraso = diasEmprestado - 7;
		
		return atraso * multa;
	}
}
