package Traduttore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Traduttore.entities.Lingua;
import Traduttore.repositories.LinguaRep;

@Service
public class LinguaService {
	@Autowired
	private LinguaRep linguaRep;
	
	public Lingua createLingua(String sigla, String nazionalità) {
		Lingua l = new Lingua();
		l.setSigla(sigla);
		l.setNazionalità(nazionalità);
		return linguaRep.save(l);
	}
	
	public List<Lingua> getAllLang(){
		return linguaRep.findAll();
	}
}
