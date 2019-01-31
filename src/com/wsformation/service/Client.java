package com.wsformation.service;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Client implements Serializable {
	
	private int code;
	private String nom;
	
	public Client(int code, String nom) {
		super();
		this.code = code;
		this.nom = nom;
	}

	public Client() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
