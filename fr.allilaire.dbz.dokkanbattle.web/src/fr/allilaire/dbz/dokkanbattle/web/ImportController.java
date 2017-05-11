package fr.allilaire.dbz.dokkanbattle.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImportController {

	@RequestMapping("/import")
	public String importCards(ModelMap model) {
		DokkanControllerUtils.getDokkanManager(model).importData();

		model.addAttribute("list", DokkanControllerUtils.getDokkanManager(model).listAllCards());
		// TODO display result message: ok or not ok
		return "listing";
	}

}
