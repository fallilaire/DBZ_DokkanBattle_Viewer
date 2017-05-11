package fr.allilaire.dbz.dokkanbattle.web.persistence.csv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import fr.allilaire.dbz.dokkanbattle.web.model.Card;
import fr.allilaire.dbz.dokkanbattle.web.persistence.IDAO;

public class CardDAOCSV implements IDAO<Card> {

	@Override
	public List<Card> findAll() {

		// TODO Renommer en une feature d'import
		ClassPathResource cpr = new ClassPathResource("fr/allilaire/dbz/dokkanbattle/web/persistence/csv/dokkan.csv");

		List<List<String>> cardsCsv;
		List<Card> cards = new ArrayList<Card>();
		try {
			cardsCsv = CSVParserUtils.parse(cpr.getFile());

			for (List<String> list : cardsCsv) {
				Card card = new Card();
				card.setName(CSVUtils.computeName(list.get(1)));
				card.setShortName("");
				card.setUrl(list.get(0));
				card.setMaxLevel(CSVUtils.computeMax(list.get(2)));
				card.setRarity(CSVUtils.computeRarity(list.get(4)));
				card.setType(CSVUtils.computeType(list.get(6)));
				card.setCost(CSVUtils.computeMax(list.get(2)));
				card.setLeaderSkill(CSVUtils.computeLeaderSkill(list.get(8)));
				card.setSuperATK(CSVUtils.computeSuperATK(list.get(9)));
				card.setPassiveSkill(CSVUtils.computePassiveSkill(list.get(10)));
				card.setLinkSkills(CSVUtils.computeLinkSkills(list.get(11)));
				card.setHpMax(CSVUtils.computeInteger(list.get(12)));
				card.setAtkMax(CSVUtils.computeInteger(list.get(13)));
				card.setOwned(new Boolean(false));

				cards.add(card);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cards;
	}

	@Override
	public Card findOneById(Integer id) {
		throw new UnsupportedOperationException("Only findAll operation is available from a CSV file.");
	}

	@Override
	public void create(Card dto) {
		throw new UnsupportedOperationException("CSV File is read-only. Creation operation is unsupported.");
	}

	@Override
	public void createAll(List<Card> dtos) {
		throw new UnsupportedOperationException("CSV File is read-only. Creation operation is unsupported.");
	}

}
