package Traduttore.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "parole_it")
public class ParolaIt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String parolaIt;
	@OneToMany(mappedBy = "parolaIt", cascade = CascadeType.ALL)
	private List<ParolaEst> paroleEst;

	public ParolaIt() {
		
	}
	public ParolaIt(String parolaIt) {
		this.parolaIt = parolaIt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParolaIt() {
		return parolaIt;
	}

	public void setParolaIt(String parolaIt) {
		this.parolaIt = parolaIt;
	}

	public List<ParolaEst> getParoleEst() {
		return paroleEst;
	}

	public void setParoleEst(List<ParolaEst> paroleEst) {
		this.paroleEst = paroleEst;
	}

}
