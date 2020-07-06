package com.perusitadev.pokebattleapi.service;

import java.util.List;
import java.util.Set;

import com.perusitadev.pokebattleapi.model.DataBattle;
import com.perusitadev.pokebattleapi.model.Pokemon;
import com.perusitadev.pokebattleapi.model.Type;

public interface BattleService {
	Type getType(String nameOrId);
	Pokemon getPokemon(String nameOrId);
	DataBattle getAdbantage(Pokemon pk1, Pokemon pk2);
	Set<String> comparePokemons(List<Pokemon> pokelist, int limit, String language);
}
