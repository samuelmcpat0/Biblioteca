package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Exceptions.Businessexceptions;
import entities.enums.EstatusBibi;


public class Emprestimo {
	private LocalDate dataemprestimoDate;
	private LocalDate detadevolucao;
	private EstatusBibi estado;
	
	private Usuario usuario;
	
	private List<ItemEmprestimo> itens = new ArrayList<>();
	
	public Emprestimo() {
		
	}
	
	public Emprestimo(LocalDate dataemprestimoDate, LocalDate detadevolucao, EstatusBibi estado, Usuario usuario) {
		super();
		this.dataemprestimoDate = dataemprestimoDate;
		this.detadevolucao = detadevolucao;
		this.estado = estado;
		this.usuario = usuario;
	}

	public LocalDate getDataemprestimoDate() {
		return dataemprestimoDate;
	}

	public void setDataemprestimoDate(LocalDate dataemprestimoDate) {
		this.dataemprestimoDate = dataemprestimoDate;
	}

	public LocalDate getDetaevolucao() {
		return detadevolucao;
	}

	public void setDetadevolucao(LocalDate detadevolucao) {
		this.detadevolucao = detadevolucao;
	}

	public EstatusBibi getEstado() {
		return estado;
	}

	public void setEstado(EstatusBibi estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void isValid (LocalDate dataemprestimoDate, LocalDate detadevolucao, EstatusBibi estado, Usuario usuario, List<ItemEmprestimo> itens) {
		if (dataemprestimoDate == null) {
			throw new Businessexceptions(" Valor invalido ");
		}
		if (dataemprestimoDate.isAfter(LocalDate.now())) {
			throw new Businessexceptions(" Não pode datas futuras ");
		}
		if (detadevolucao == null) {
			throw new Businessexceptions(" Valor invalido ");
		}
		if (detadevolucao.isBefore(dataemprestimoDate)) {
			throw new Businessexceptions(" Não pode datas passadas ");
		}
		if (usuario == null) {
			throw new Businessexceptions(" valor invalido ");
		}
		for (ItemEmprestimo item : itens) {
		    if (item == null) {
		        throw new Businessexceptions("Item do empréstimo inválido");
		    }
		}
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ItemEmprestimo> getItens() {
		return itens;
	}

	public void adicionarItens(ItemEmprestimo item) {
		itens.add(item);
	}
	
	public void removerItens(ItemEmprestimo item) {
		itens.remove(item);
	}
	
	public Integer totalItens() {
		return itens.size();
	}
}
