package TraductorWebSQL.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import TraductorWebSQL.entities.*;
import TraductorWebSQL.repositories.*;

@Service
public class AlienWordService {
	
	private final AlienWordRep alienWordRepository;
    private final ItaWordService itaWordService;
    private final LanguageService languageService;

    public AlienWordService(AlienWordRep alienWordRepository, ItaWordService itaWordService, LanguageService languageService) {
        this.alienWordRepository = alienWordRepository;
        this.itaWordService = itaWordService;
        this.languageService = languageService;
    }

    public AlienWord addAlienWord(String parolaItaliana, String siglaLingua, String nomeLingua, String parolaEstera) {
        // 1. Se la lingua non esiste, la creo
        Language language = languageService.addLanguage(siglaLingua, nomeLingua);

        // 2. Se la parola italiana non esiste, la creo
        ItaWord itaWord = itaWordService.addItaWord(parolaItaliana);

        // 3. Creo la parola estera
        AlienWord alienWord = new AlienWord();
        alienWord.setAlienWord(parolaEstera);
        alienWord.setLinguaggio(language);
        alienWord.setItaWord(itaWord);

        return alienWordRepository.save(alienWord);
    }
}
