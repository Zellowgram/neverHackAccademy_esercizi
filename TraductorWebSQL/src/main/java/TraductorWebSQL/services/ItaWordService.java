package TraductorWebSQL.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TraductorWebSQL.entities.ItaWord;
import TraductorWebSQL.repositories.ItaWordRep;

@Service
public class ItaWordService {
	private final ItaWordRep itaWordRepository;

	public ItaWordService(ItaWordRep itaWordRepository) {
		this.itaWordRepository = itaWordRepository;
	}

	public ItaWord addItaWord(String parolaItaliana) {
		Optional<ItaWord> existingWord = itaWordRepository.findByItaWord(parolaItaliana);
		return existingWord.orElseGet(() -> {
			ItaWord newWord = new ItaWord();
			newWord.setItaWord(parolaItaliana);
			return itaWordRepository.save(newWord);
		});
	}
}
