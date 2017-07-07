package br.gov.ufms.SGCteam04.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Conferencia {

	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Integer id;
	   private String nomeAbreviado;
	   
	   public Conferencia() {
		// TODO Auto-generated constructor stub
	}

}
