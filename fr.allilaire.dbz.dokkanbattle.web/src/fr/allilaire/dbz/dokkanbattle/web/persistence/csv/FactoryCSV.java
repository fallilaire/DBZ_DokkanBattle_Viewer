package fr.allilaire.dbz.dokkanbattle.web.persistence.csv;

import fr.allilaire.dbz.dokkanbattle.web.model.Card;
import fr.allilaire.dbz.dokkanbattle.web.persistence.AbstractFactory;
import fr.allilaire.dbz.dokkanbattle.web.persistence.IDAO;

public class FactoryCSV extends AbstractFactory {

	@Override
	public IDAO<Card> getCard() {
		return new CardDAOCSV();
	}

}
