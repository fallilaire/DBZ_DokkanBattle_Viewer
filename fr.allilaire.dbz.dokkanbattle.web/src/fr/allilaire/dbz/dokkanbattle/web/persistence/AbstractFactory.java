package fr.allilaire.dbz.dokkanbattle.web.persistence;

import fr.allilaire.dbz.dokkanbattle.web.model.Card;
import fr.allilaire.dbz.dokkanbattle.web.persistence.jdbc.FactoryJDBC;

public abstract class AbstractFactory {

	public static AbstractFactory getInstance() {
		return new FactoryJDBC();
	}

	public abstract IDAO<Card> getCard();

}
