package fr.allilaire.dbz.dokkanbattle.web;

import org.springframework.ui.ModelMap;

import fr.allilaire.dbz.dokkanbattle.web.business.DokkanCardManager;
import fr.allilaire.dbz.dokkanbattle.web.business.IDokkanCardManager;
import fr.allilaire.dbz.dokkanbattle.web.persistence.AbstractFactory;

public class DokkanControllerUtils {

	public static final String BUSINESS_MANAGER = "BUSINESS_MANAGER";

	public static IDokkanCardManager getDokkanManager(ModelMap model) {
		if (model.get(DokkanControllerUtils.BUSINESS_MANAGER) == null) {
			// TODO Trouver comment le déplacer à l'initialisation du serveur
			IDokkanCardManager dokkanCardManager = new DokkanCardManager(AbstractFactory.getInstance().getCard());
			model.addAttribute(DokkanControllerUtils.BUSINESS_MANAGER, dokkanCardManager);
		}
		return (IDokkanCardManager) model.get(DokkanControllerUtils.BUSINESS_MANAGER);
	}

}
