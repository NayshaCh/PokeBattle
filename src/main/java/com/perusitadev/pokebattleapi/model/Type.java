package com.perusitadev.pokebattleapi.model;

import java.io.Serializable;

public class Type implements Serializable{
	
	private int id;
	private String name;
	private TypeRelations damage_relations;
	
	public Type() {
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
	public TypeRelations getDamage_relations() {
		return damage_relations;
	}
	public void setDamage_relations(TypeRelations damage_relations) {
		this.damage_relations = damage_relations;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name + ", damage_relations=" + damage_relations + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getDamage_relations()=" + getDamage_relations() + "]";
	}

	

}
