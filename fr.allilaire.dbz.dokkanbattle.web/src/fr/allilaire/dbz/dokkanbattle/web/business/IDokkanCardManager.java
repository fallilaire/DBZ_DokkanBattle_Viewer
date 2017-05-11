/**
 * 
 */
package fr.allilaire.dbz.dokkanbattle.web.business;

import java.util.List;

import fr.allilaire.dbz.dokkanbattle.web.model.Card;
import fr.allilaire.dbz.dokkanbattle.web.model.Link;
import fr.allilaire.dbz.dokkanbattle.web.model.Team;

public interface IDokkanCardManager {
	
	// Service CARD
	public List<Card> listAllCards();
	public List<Card> listMyCards();
	public Card getCard(Card card);
	public void ownACard(Card card);
	public void notOwnACard(Card card);

	// Service TEAM
	public void listAllTeams();
	public void createTeam(Team team);
	public void deleteTeam(Team team);
	public Team getTeam(Team team);
	public void addCardToTeam(Card card, Team team);
	public void removeCardOfTeam(Card card, Team team);

	// Service EVENT

	public void listAllEvents();
	public Event getEvent(Event event);

	// Service LINK

	public void listAllLinks();
	public Link getLink(Link link);

	// Service CAPACITY

	public void listAllCapacities();
	public Capacity getCapacity(Capacity capacity);

	// Service IMPORT
	public void importData();

}
