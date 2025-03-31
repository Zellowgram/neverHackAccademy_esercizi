package TraductorWebSQL.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import TraductorWebSQL.entities.AlienWord;
import TraductorWebSQL.entities.ItaWord;
import TraductorWebSQL.entities.Language;
import TraductorWebSQL.services.*;

public class Controller {
	@RestController
	@RequestMapping("/api")
	public class TranslationController {

		private final LanguageService languageService;
		private final ItaWordService itaWordService;
		private final AlienWordService alienWordService;

		public TranslationController(LanguageService languageService, ItaWordService itaWordService,
				AlienWordService alienWordService) {
			this.languageService = languageService;
			this.itaWordService = itaWordService;
			this.alienWordService = alienWordService;
		}

		// Aggiungi una lingua
		@PostMapping("/languages")
		public ResponseEntity<Language> addLanguage(@RequestParam String sigla, @RequestParam String nome) {
			return ResponseEntity.ok(languageService.addLanguage(sigla, nome));
		}

		// Aggiungi una parola italiana
		@PostMapping("/itaWords")
		public ResponseEntity<ItaWord> addItaWord(@RequestParam String parolaItaliana) {
			return ResponseEntity.ok(itaWordService.addItaWord(parolaItaliana));
		}

		// Aggiungi una parola estera con verifica della lingua e della parola italiana
		@PostMapping("/alienWords")
		public ResponseEntity<AlienWord> addAlienWord(@RequestParam String parolaItaliana,
				@RequestParam String siglaLingua, @RequestParam String nomeLingua, @RequestParam String parolaEstera) {

			AlienWord alienWord = alienWordService.addAlienWord(parolaItaliana, siglaLingua, nomeLingua, parolaEstera);
			return ResponseEntity.ok(alienWord);
		}
	}
}
