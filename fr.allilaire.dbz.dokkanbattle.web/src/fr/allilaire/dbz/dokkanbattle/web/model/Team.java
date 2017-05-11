package fr.allilaire.dbz.dokkanbattle.web.model;

import java.util.List;

public class Team {

	private Integer id;
	private String name;
	private String description;
	private List<Card> cards;
	
	public Team initDTO(Integer id, String name, String description, List<Card> cards) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.cards = cards;
		return this;
	}

	public Team initDTO(String name, String description, List<Card> cards) {
		this.name = name;
		this.description = description;
		this.cards = cards;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
}
