package fr.allilaire.dbz.dokkanbattle.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListingController {

	@RequestMapping("/listing")
	public String all(ModelMap model) {

		model.addAttribute("list", DokkanControllerUtils.getDokkanManager(model).listAllCards());
		return "listing";
	}

	@RequestMapping("/listing/mycards")
	public String allMyCards(ModelMap model) {

		model.addAttribute("list", DokkanControllerUtils.getDokkanManager(model).listMyCards());
		return "listing";
	}

}
