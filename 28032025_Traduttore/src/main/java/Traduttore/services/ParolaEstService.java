package Traduttore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Traduttore.entities.ParolaEst;
import Traduttore.entities.ParolaIt;
import Traduttore.repositories.ParolaEstRep;
import Traduttore.repositories.ParolaItRep;

@Service
public class ParolaEstService {
	@Autowired
	private ParolaEstRep parolaEstRep;
	
	public ParolaEst createParolaIt(String parolaEst, String parolaIt, String lingua) {
		ParolaEst pe = new ParolaEst();
		pe.setParolaEst(parolaEst);
		pe.setParolaIt(parolaIt);
		pe.setLingua(lingua);
		return parolaEstRep.save(pe);
	}

	public List<ParolaEst> getAllItWorlds() {
		return parolaEstRep.findAll();
	}
}
