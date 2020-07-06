package com.perusitadev.pokebattleapi.model;

public class PokeMove {
	private Move move;
	public PokeMove() {
		// TODO Auto-generated constructor stub
	}
	public Move getMove() {
		return move;
	}
	public void setMove(Move move) {
		this.move = move;
	}
	@Override
	public String toString() {
		return "PokeMove [move=" + move + "]";
	}
}
