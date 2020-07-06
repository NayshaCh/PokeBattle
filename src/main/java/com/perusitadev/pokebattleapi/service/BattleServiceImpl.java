package com.perusitadev.pokebattleapi.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.perusitadev.pokebattleapi.model.DataBattle;
import com.perusitadev.pokebattleapi.model.Move;
import com.perusitadev.pokebattleapi.model.NameMoves;
import com.perusitadev.pokebattleapi.model.Pokemon;
import com.perusitadev.pokebattleapi.model.SimplePokemon;
import com.perusitadev.pokebattleapi.model.SimpleType;
import com.perusitadev.pokebattleapi.model.Type;

@Service
public class BattleServiceImpl implements BattleService{

	private final String url = "https://pokeapi.co/api/v2/";
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private HttpEntity<String> entity;
	
	@Override
	public Type getType(String nameOrId) {
		Type type = null;
		try {
			ResponseEntity<Type> typeResponse = template.exchange(url+"type/"+nameOrId,
					HttpMethod.GET,
					entity,
					Type.class);
			
			type = typeResponse.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return type;
	}

	@Override
	public Pokemon getPokemon(String nameOrId){
		Pokemon pokemon = null;
		
		try {
			ResponseEntity<Pokemon> pokemonResponse = template.exchange(url+"pokemon/"+nameOrId,
					HttpMethod.GET,
					entity,
					Pokemon.class);
			
			pokemon = pokemonResponse.getBody();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return pokemon;
	}	
	
	@Override
	public DataBattle getAdbantage(Pokemon pk1, Pokemon pk2) {
		DataBattle battle = null;
		
		Set<String> doubleDamage = new HashSet<>();
		Set<String> halfDamage = new HashSet<>();
		battle = new DataBattle(pk1, pk2);
		SimplePokemon p1 = battle.getPokemon1();
		SimplePokemon p2 = battle.getPokemon2();
		
		for (String sType : p1.getTypes()) {
			Type type = getType(sType);
			
			if(type != null) {
				for (SimpleType simType : type.getDamage_relations().getHalf_damage_from()) {
					halfDamage.add(simType.getName());
				}
				
				for (SimpleType simType : type.getDamage_relations().getDouble_damage_from()) {
					doubleDamage.add(simType.getName());
				}
			}
		}
		
		for (String sType : p2.getTypes()) {
			if(halfDamage.contains(sType)) {
				battle.setF_recive_halfDam_S(true);
			}
			if(doubleDamage.contains(sType)) {
				battle.setF_dealDoubleDam_S(true);
			}
		}
		
		return battle;
	}

	public Set<String> comparePokemons(List<Pokemon> pokelist, int limit, String language){
		Set<String> movesCommons = new HashSet<>();
		Set<String> moves = new HashSet<>();
		for (Pokemon pokemon : pokelist) {
			if(pokelist.indexOf(pokemon) > 0)
				movesCommons.retainAll(pokemon.getMovesStrings());
			else
				movesCommons = new HashSet<>(pokemon.getMovesStrings());
		}
		
		for(String nameMove : movesCommons) {
			if(!language.equals("en")) {
				Move move = getMove(nameMove);
				String name = null;
				for(NameMoves nMoves : move.getNames()) {
					if(nMoves.getLanguage().getName().equals(language))
						name = nMoves.getName();
				}
				if(name != null) {
					moves.add(name);
				}
			} else {
				moves.add(nameMove);
			}
			if(moves.size() == limit) {
				return moves;
			}
		}
		
		return moves;
	}
	
	private Move getMove(String nameOrId){
		Move move = null;
		
		try {
			ResponseEntity<Move> moveResponse = template.exchange(url+"move/"+nameOrId,
					HttpMethod.GET,
					entity,
					Move.class);
			
			move = moveResponse.getBody();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return move;
	}

}
