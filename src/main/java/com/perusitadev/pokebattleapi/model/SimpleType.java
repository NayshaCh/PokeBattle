package com.perusitadev.pokebattleapi.model;

public class SimpleType {
	private String name;
	private String url;
	
	public SimpleType() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "name=" + name;
	}
	
	

}
