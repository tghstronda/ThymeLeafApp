/**
 * 
 */
package br.ueg.ThymeLeafApp.model;

import javax.persistence.Entity;

/**
 * @author tghstronda
 *
 */
@Entity
public class UserContato extends Usuario{
	
	
	
	private String numero;
	private String email;
	private String imagem;
	
	public String getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the imagem
	 */
	public String getImagem() {
		return imagem;
	}
	/**
	 * @param imagem the imagem to set
	 */
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}


	

}
