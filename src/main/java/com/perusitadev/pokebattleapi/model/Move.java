package com.perusitadev.pokebattleapi.model;

import java.util.List;

public class Move {
	private String name;
	private List<NameMoves> names;
	
	public Move() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<NameMoves> getNames() {
		return names;
	}

	public void setNames(List<NameMoves> names) {
		this.names = names;
	}

	@Override
	public String toString() {
		return "Move [name=" + name + "]";
	}
	
}
