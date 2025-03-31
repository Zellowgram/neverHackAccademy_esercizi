package Traduttore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Traduttore.entities.Lingua;
import Traduttore.services.LinguaService;

@RestController
@RequestMapping("/lingua")
public class LinguaController {
	@Autowired
	private LinguaService linguaService;
	@PostMapping("/lingua/create")
	public Lingua createLingua(@RequestParam String sigla, @RequestParam String nazionalità) {
		return linguaService.createLingua(sigla, nazionalità);
	}
	@GetMapping("/lingua/lingue")
	public List<Lingua> getAllLang(){
		return linguaService.getAllLang();
		}
	

}
