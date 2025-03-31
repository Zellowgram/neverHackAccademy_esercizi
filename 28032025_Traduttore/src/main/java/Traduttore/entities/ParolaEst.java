package Traduttore.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "parole_est")
public class ParolaEst {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String parolaEst;
	@ManyToOne
	@JoinColumn(name = "parola_it_id", nullable = false)
	private ParolaIt parolaIt;
	@ManyToOne
	@JoinColumn(name = "lingua_id", nullable = false)
	private Lingua lingua;

	public ParolaEst(String parolaEst, ParolaIt parolaIt, Lingua lingua) {
		this.parolaEst = parolaEst;
		this.parolaIt = parolaIt;
		this.lingua = lingua;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParolaEst() {
		return parolaEst;
	}

	public void setParolaEst(String parolaEst) {
		this.parolaEst = parolaEst;
	}

	public ParolaIt getParolaIt() {
		return parolaIt;
	}

	public void setParolaIt(ParolaIt parolaIt) {
		this.parolaIt = parolaIt;
	}

	public Lingua getLingua() {
		return lingua;
	}

	public void setLingua(Lingua lingua) {
		this.lingua = lingua;
	}

}
