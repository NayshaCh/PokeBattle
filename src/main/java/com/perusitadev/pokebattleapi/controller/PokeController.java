package com.perusitadev.pokebattleapi.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perusitadev.pokebattleapi.error.PokemonNotFoundEx;
import com.perusitadev.pokebattleapi.model.Pokemon;
import com.perusitadev.pokebattleapi.model.Type;
import com.perusitadev.pokebattleapi.service.BattleService;

@RestController
@RequestMapping("/v1/poke")
public class PokeController {
	
	@Autowired
	private BattleService service;
	
	@RequestMapping("/battle/{pkm1}/{pkm2}")
	public ResponseEntity<?> startBattle(@PathVariable("pkm1") String pokemon1, @PathVariable("pkm2") String pokemon2) {
			
		Pokemon pk1 = service.getPokemon(pokemon1);
		Pokemon pk2 = service.getPokemon(pokemon2);
			
		if(pk1 == null) {
			return new ResponseEntity<>( new PokemonNotFoundEx(pokemon1) , HttpStatus.NOT_FOUND);
		} else if (pk2 == null) {
			return new ResponseEntity<>( new PokemonNotFoundEx(pokemon2) , HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(service.getAdbantage(pk1, pk2), HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/compare/{language}/{limit}")
	public ResponseEntity<?> comparePokemons(@RequestBody String[] pokelist, @PathVariable("language") String language, @PathVariable("limit") int limit){
		
		List<Pokemon> pokemons = new ArrayList<>();
		for (String namePokemon : pokelist) {
			Pokemon pokemon = service.getPokemon(namePokemon);
			if(pokemon != null) {
				pokemons.add(pokemon);
			}
		}
			
		return new ResponseEntity<>(service.comparePokemons(pokemons, limit, language), HttpStatus.OK);
	}
	
	@RequestMapping("/pokemon/{nameOrId}")
	private ResponseEntity<?> getPokemon(@PathVariable("nameOrId") String nameOrId) {
		return new ResponseEntity<>(service.getPokemon(nameOrId), HttpStatus.OK);			
	}
	
	@RequestMapping("/type/{nameOrId}")
	private ResponseEntity<Type> getType(@PathVariable("nameOrId") String nameOrId) {
		return new ResponseEntity<>( service.getType(nameOrId) , HttpStatus.OK);
	}
	
	
	
}
