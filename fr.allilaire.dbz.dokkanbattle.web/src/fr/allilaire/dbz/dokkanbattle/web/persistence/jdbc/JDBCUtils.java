package fr.allilaire.dbz.dokkanbattle.web.persistence.jdbc;

import fr.allilaire.dbz.dokkanbattle.web.model.Rarity;
import fr.allilaire.dbz.dokkanbattle.web.model.Type;

public class JDBCUtils {

	public static Rarity computeRarity(String rarity) {
		Rarity toReturn;
		switch (rarity) {
		case "LR":
			toReturn = Rarity.lr;
			break;
		case "UR":
			toReturn = Rarity.ur;
			break;
		case "SSR":
			toReturn = Rarity.ssr;
			break;
		case "SR":
			toReturn = Rarity.sr;
			break;
		case "R":
			toReturn = Rarity.r;
			break;
		case "N":
			toReturn = Rarity.n;
			break;
		default:
			toReturn = Rarity.n;
			break;
		}

		return toReturn;
	}

	public static Type computeType(String type) {
		Type toReturn;
		switch (type) {
		case "TEQ":
			toReturn = Type.teq;
			break;
		case "AGI":
			toReturn = Type.agi;
			break;
		case "PHY":
			toReturn = Type.phy;
			break;
		case "STR":
			toReturn = Type.str;
			break;
		case "INT":
			toReturn = Type.intel;
			break;
		default:
			toReturn = Type.agi;
			break;
		}

		return toReturn;
	}

}
