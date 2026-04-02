package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Exceptions.Businessexceptions;

public class Usuario {
	private String nome;
	private String email;
	private LocalDate datadenascimento;
	
	public static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Usuario() {
		super();
	}

	public Usuario(String nome, String email, LocalDate datadenascimento) {
		super();
		this.nome = nome;
		this.email = email;
		this.datadenascimento = datadenascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDatadenascimento() {
		return datadenascimento;
	}

	public void setDatadenascimento(LocalDate datadenascimento) {
		this.datadenascimento = datadenascimento;
	}
	
	public void isValid(String nome, String email, LocalDate datadenascimento) {
		if (getNome() == null || getNome().isEmpty()) {
			throw new Businessexceptions(" Não é valido ");
		}
		if (getNome() == null || getEmail().isEmpty()) {
			throw new Businessexceptions(" email não é valido ");
		}
		if (getDatadenascimento() == null ) {
			
		}
		if (getDatadenascimento().isAfter(LocalDate.now())) {
			throw new Businessexceptions(" não pode datas no futuro ");
		}
	}

}
