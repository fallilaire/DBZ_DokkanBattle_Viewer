/**
 * 
 */
package fr.allilaire.dbz.dokkanbattle.web.business;

import java.util.ArrayList;
import java.util.List;

import fr.allilaire.dbz.dokkanbattle.web.model.Card;
import fr.allilaire.dbz.dokkanbattle.web.model.Team;
import fr.allilaire.dbz.dokkanbattle.web.persistence.IDAO;
import fr.allilaire.dbz.dokkanbattle.web.persistence.csv.CardDAOCSV;

public class DokkanCardManager implements IDokkanCardManager {

	private IDAO<Card> cardDAO;
	private List<Card> cards = null;

	public DokkanCardManager(IDAO<Card> cardDAO) {
		this.cardDAO = cardDAO;
		this.cards = cardDAO.findAll();
	}

	@Override
	public List<Card> listAllCards() {
		if (this.cards == null) {
			this.cards = cardDAO.findAll();
		}

		return this.cards;
	}

	@Override
	public List<Card> listMyCards() {
		List<Card> myCards = new ArrayList<Card>();
		for (Card card : listAllCards()) {
			if (card.isOwned()) {
				myCards.add(card);
			}
		}
		return myCards;
	}

	@Override
	public Card getCard(Card card) {
		Card toReturn = null;

		for (Card card2 : cards) {
			if (card2.getId() == card.getId()) {
				toReturn = card2;
			}
		}

		return toReturn;
	}

	@Override
	public void ownACard(Card card) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notOwnACard(Card card) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createTeam(Team team) {
		// TODO Auto-generated method stub

	}

	@Override
	public Team getTeam(Team team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void importData() {
		// TODO delete direct dependancy to CardDAOCSV()
		this.cards = new CardDAOCSV().findAll();
		cardDAO.createAll(this.cards);
		this.cards = cardDAO.findAll();

	}
	
}
