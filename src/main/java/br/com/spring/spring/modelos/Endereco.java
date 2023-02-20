package br.com.spring.spring.modelos;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
	private String rua;
	private String bairro;
	private String cidade;
	private String numero;
	
	public Endereco() {
		
	}
	
	public Endereco(
		      String rua, 
			  String bairro, 
			  String cidade, 
			  String numero) {
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.numero = numero;
	}
}
