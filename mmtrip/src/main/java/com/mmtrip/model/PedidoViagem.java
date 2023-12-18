package com.mmtrip.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PedidoViagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;
	@Column(nullable = false)
	private String nomeDestino;
	private String localOrigem;
	@Column(nullable = false)
	private String localDestino;
	@Column(nullable = false)
	private LocalDateTime dtIda;
	@Column(nullable = false)
	private LocalDateTime dtVolta;
	@Column(nullable = false)
	private Double valorPedido;
	@Column(nullable = false)
	private String formaPag;
	@Column(nullable = false)
	private String status;
	
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
	
	public PedidoViagem() {
		
	}
	public PedidoViagem(Long idPedido, String nomeDestino, String localOrigem, String localDestino, LocalDateTime dtIda,
			LocalDateTime dtVolta, Double valorPedido, String formaPag, String status) {
		super();
		this.idPedido = idPedido;
		this.nomeDestino = nomeDestino;
		this.localOrigem = localOrigem;
		this.localDestino = localDestino;
		this.dtIda = dtIda;
		this.dtVolta = dtVolta;
		this.valorPedido = valorPedido;
		this.formaPag = formaPag;
		this.status = status;
	}
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public String getNomeDestino() {
		return nomeDestino;
	}
	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}
	public String getLocalOrigem() {
		return localOrigem;
	}
	public void setLocalOrigem(String localOrigem) {
		this.localOrigem = localOrigem;
	}
	public String getLocalDestino() {
		return localDestino;
	}
	public void setLocalDestino(String localDestino) {
		this.localDestino = localDestino;
	}
	public LocalDateTime getDtIda() {
		return dtIda;
	}
	public void setDtIda(LocalDateTime dtIda) {
		this.dtIda = dtIda;
	}
	public LocalDateTime getDtVolta() {
		return dtVolta;
	}
	public void setDtVolta(LocalDateTime dtVolta) {
		this.dtVolta = dtVolta;
	}
	public Double getValorPedido() {
		return valorPedido;
	}
	public void setValorPedido(Double valorPedido) {
		this.valorPedido = valorPedido;
	}
	public String getFormaPag() {
		return formaPag;
	}
	public void setFormaPag(String formaPag) {
		this.formaPag = formaPag;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
