package com.perusitadev.pokebattleapi.model;

import java.util.List;

public class TypeRelations {
	private List<SimpleType> no_damage_to;
	private List<SimpleType> half_damage_to;
	private List<SimpleType> double_damage_to;
	private List<SimpleType> no_damage_from;
	private List<SimpleType> half_damage_from;
	private List<SimpleType> double_damage_from;
	
	public TypeRelations() {
	}

	public List<SimpleType> getNo_damage_to() {
		return no_damage_to;
	}

	public void setNo_damage_to(List<SimpleType> no_damage_to) {
		this.no_damage_to = no_damage_to;
	}

	public List<SimpleType> getHalf_damage_to() {
		return half_damage_to;
	}

	public void setHalf_damage_to(List<SimpleType> half_damage_to) {
		this.half_damage_to = half_damage_to;
	}

	public List<SimpleType> getDouble_damage_to() {
		return double_damage_to;
	}

	public void setDouble_damage_to(List<SimpleType> double_damage_to) {
		this.double_damage_to = double_damage_to;
	}

	public List<SimpleType> getNo_damage_from() {
		return no_damage_from;
	}

	public void setNo_damage_from(List<SimpleType> no_damage_from) {
		this.no_damage_from = no_damage_from;
	}

	public List<SimpleType> getHalf_damage_from() {
		return half_damage_from;
	}

	public void setHalf_damage_from(List<SimpleType> half_damage_from) {
		this.half_damage_from = half_damage_from;
	}

	public List<SimpleType> getDouble_damage_from() {
		return double_damage_from;
	}

	public void setDouble_damage_from(List<SimpleType> double_damage_from) {
		this.double_damage_from = double_damage_from;
	}

	@Override
	public String toString() {
		return "TypeRelations [no_damage_to=" + no_damage_to + ", half_damage_to=" + half_damage_to
				+ ", double_damage_to=" + double_damage_to + ", no_damage_from=" + no_damage_from
				+ ", half_damage_from=" + half_damage_from + ", double_damage_from=" + double_damage_from + "]";
	}
	
	
	
}
