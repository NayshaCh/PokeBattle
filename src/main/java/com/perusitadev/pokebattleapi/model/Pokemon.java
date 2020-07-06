package com.perusitadev.pokebattleapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pokemon implements Serializable{

	private int id;
	private String name;
	private List<PokemonType> types;
	private List<PokeMove> moves;
	
	public Pokemon() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTypes(List<PokemonType> types) {
		this.types = types;
	}
	
	public List<PokemonType> getTypes() {
		return types;
	}

	public List<PokeMove> getMoves() {
		return moves;
	}
	
	public void setMoves(List<PokeMove> moves) {
		this.moves = moves;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", types=" + types + ", moves=" + moves + "]";
	}
	
	public List<String> getMovesStrings() {
		List<String> moves = new ArrayList<>();
		
		for (PokeMove pokeMove : this.moves) {
			moves.add(pokeMove.getMove().getName());
		}
		return moves;
	}
	
	
}
