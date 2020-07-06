package com.perusitadev.pokebattleapi.model;

public class PokemonType {
	private SimpleType type;
	
	public PokemonType() {
		// TODO Auto-generated constructor stub
	}


	public SimpleType getType() {
		return type;
	}

	public void setType(SimpleType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "type=" + type;
	}
	
	
}
