package Traduttore.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "lingue")
public class Lingua {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String sigla;
	private String nazionalità;

	public Lingua() {

	}

	public Lingua(String sigla, String nazionalità) {
		this.sigla = sigla;
		this.nazionalità = nazionalità;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNazionalità() {
		return nazionalità;
	}

	public void setNazionalità(String nazionalità) {
		this.nazionalità = nazionalità;
	}

}
