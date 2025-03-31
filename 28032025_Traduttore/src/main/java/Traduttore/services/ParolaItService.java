package Traduttore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Traduttore.entities.ParolaIt;
import Traduttore.repositories.ParolaItRep;

@Service
public class ParolaItService {
	@Autowired
	private ParolaItRep parolaItRep;
	
	public ParolaIt createParolaIt(String parolaIt) {
		ParolaIt pi = new ParolaIt();
		pi.setParolaIt(parolaIt);
		return parolaItRep.save(pi);
	}

	public List<ParolaIt> getAllItWorlds() {
		return parolaItRep.findAll();
	}
	
}
