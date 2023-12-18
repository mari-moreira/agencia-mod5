package com.mmtrip.model;

import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String sobrenome;
	@Column(nullable = false)
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dtNasc;
	@Column(nullable = false)
	private String sexo;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String telefone;
	@Column(nullable = false)
	private String uf;
	@Column(nullable = false)
	private String cidade;
	@Column(nullable = false, columnDefinition = "TEXT")
	private String endereco;
	@Column(nullable = false)
	private String senha;

	
	 @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	    private Set<PedidoViagem> pedidoViagem;
	public Cliente() {

	}

	public Cliente(Long idCliente, String nome, String sobrenome, Date dtNasc, String sexo, String email,
			String uf, String cidade, String endereco, String senha) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dtNasc = dtNasc;
		this.sexo = sexo;
		this.email = email;
		this.uf = uf;
		this.cidade = cidade;
		this.endereco = endereco;
		this.senha = senha;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<PedidoViagem> getPedidoViagem() {
		return pedidoViagem;
	}

	public void setPedidoViagem(Set<PedidoViagem> pedidoViagem) {
		this.pedidoViagem = pedidoViagem;
	}
	

}
