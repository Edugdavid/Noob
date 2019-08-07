package com.pessoa.entidade;

import static java.time.LocalDateTime.now;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.pessoa.util.ConvertsDate;

public class Pessoa extends GenericModel {

	private static final long serialVersionUID = 1L;
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private LocalDateTime dataCadastro = now();
	private String dataCadastroStr;

	public Pessoa() {
	}

	public Pessoa(String cpf) {
		super();
		this.cpf = cpf;
	}

	public Pessoa(String cpf, String nome) {
		super();
		this.cpf = cpf;
		this.nome = nome;
	}

	public Pessoa(String cpf, String nome, String telefone, String email, LocalDateTime dataCadastro,
			String dataCadastroStr) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.dataCadastro = dataCadastro;
		this.dataCadastroStr = dataCadastroStr;
	}

	public Pessoa(Integer id, String cpf, String nome, String telefone, String email, LocalDateTime dataCadastro,
			String dataCadastroStr) {
		super.setId(id);
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.dataCadastro = dataCadastro;
		this.dataCadastroStr = dataCadastroStr;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCpf(String l) {
		this.cpf = l;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
				+ ", dataCadastro=" + getDataCadastro() + "]";
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDataCadastroStr() {
		return dataCadastroStr;
	}

	public void setDataCadastroStr(Timestamp dataCadastroStr) {
		this.dataCadastroStr = dataCadastroStr != null ? ConvertsDate.convertToEntityAttribute(dataCadastroStr)
				.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) : "Sem data";
	}
}
