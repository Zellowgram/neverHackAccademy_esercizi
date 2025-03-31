package Traduttore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Traduttore.entities.ParolaIt;
import Traduttore.services.ParolaItService;

@RestController
@RequestMapping("/parolaIt")
public class ParolaItController {
	@Autowired
	public ParolaItService parolaItService;

	@PostMapping("/parolaIt/create")
	public ParolaIt createParolaIt(@RequestParam String parolaIt) {
		return parolaItService.createParolaIt(parolaIt);
	}

	@GetMapping("/parolaIt/parole")
	public List<ParolaIt> getAllItWorlds() {
		return parolaItService.getAllItWorlds();
	}

}
