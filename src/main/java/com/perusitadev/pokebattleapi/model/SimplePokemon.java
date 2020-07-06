package com.perusitadev.pokebattleapi.model;

import java.util.ArrayList;
import java.util.List;

public class SimplePokemon {
	private String name;
	private List<String> types;
	
	public SimplePokemon() {
		// TODO Auto-generated constructor stub
	}
	
	public SimplePokemon(Pokemon pokemon) {
		this.name = pokemon.getName();
		this.types = new ArrayList<>();
		for (PokemonType sp : pokemon.getTypes()) {
			types.add(sp.getType().getName());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTypes() {
		return types;
	}
	
	public void setTypes(List<String> types) {
		this.types = types;
	}
	
}
