package com.perusitadev.pokebattleapi.model;

public class DataBattle {
	
	private SimplePokemon pokemon1;
	private SimplePokemon pokemon2;
	private boolean f_dealDoubleDam_S;
	private boolean f_recive_halfDam_S;

	public DataBattle() {
		
	}

	public DataBattle(Pokemon pokemon1, Pokemon pokemon2) {
		this.pokemon1 = new SimplePokemon(pokemon1);
		this.pokemon2 = new SimplePokemon(pokemon2);
	}
	
	public SimplePokemon getPokemon1() {
		return pokemon1;
	}

	public void setPokemon1(SimplePokemon pokemon1) {
		this.pokemon1 = pokemon1;
	}

	public SimplePokemon getPokemon2() {
		return pokemon2;
	}

	public void setPokemon2(SimplePokemon pokemon2) {
		this.pokemon2 = pokemon2;
	}

	public boolean isF_dealDoubleDam_S() {
		return f_dealDoubleDam_S;
	}

	public void setF_dealDoubleDam_S(boolean f_dealDoubleDam_S) {
		this.f_dealDoubleDam_S = f_dealDoubleDam_S;
	}

	public boolean isF_recive_halfDam_S() {
		return f_recive_halfDam_S;
	}

	public void setF_recive_halfDam_S(boolean f_recive_halfDam_S) {
		this.f_recive_halfDam_S = f_recive_halfDam_S;
	}
	
}
