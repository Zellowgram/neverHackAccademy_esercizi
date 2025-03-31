package TraductorWebSQL.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TraductorWebSQL.entities.Language;
import TraductorWebSQL.repositories.LanguageRep;

@Service
public class LanguageService {
	private final LanguageRep languageRepository;

    public LanguageService(LanguageRep languageRepository) {
        this.languageRepository = languageRepository;
    }

    public Language addLanguage(String sigla, String nome) {
        Optional<Language> existingLanguage = languageRepository.findBySiglaLingua(sigla);
        return existingLanguage.orElseGet(() -> {
            Language newLanguage = new Language();
            newLanguage.setSiglaLingua(sigla);
            newLanguage.setLinguaggio(nome);
            return languageRepository.save(newLanguage);
        });
    }

}
