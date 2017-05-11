package fr.allilaire.dbz.dokkanbattle.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.allilaire.dbz.dokkanbattle.web.model.Card;

@Controller
public class CardController {

	@RequestMapping("/card")
	public String all(ModelMap model) {
		return "card";
	}

	@RequestMapping("/card/select")
	public String select(Card card, ModelMap model) {
		model.addAttribute("card", DokkanControllerUtils.getDokkanManager(model).getCard(card));
		return all(model);
	}

}
