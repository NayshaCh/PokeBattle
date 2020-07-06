package com.perusitadev.pokebattleapi.error;

public class PokemonNotFoundEx extends RuntimeException{
	
	public PokemonNotFoundEx(String id) {
		super(String.format("Pokemon con el id: %s", id));
	}
}
