package fr.allilaire.dbz.dokkanbattle.web.persistence.csv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.allilaire.dbz.dokkanbattle.web.model.Link;
import fr.allilaire.dbz.dokkanbattle.web.model.Rarity;
import fr.allilaire.dbz.dokkanbattle.web.model.Type;

public class CSVUtils {

	public static Integer computeMax(String maxLevel) {
		Integer toReturn = null;

		if (maxLevel.matches("[0-9]*/[0-9]*")) {
			toReturn = Integer.valueOf(maxLevel.split("/")[1]);
		} else {
			toReturn = new Integer(0);
		}

		return toReturn;
	}

	public static Rarity computeRarity(String rarity) {
		Rarity toReturn;
		// SSR icon
		switch (rarity) {
		case "LR icon":
			toReturn = Rarity.lr;
			break;
		case "UR icon":
			toReturn = Rarity.ur;
			break;
		case "SSR icon":
			toReturn = Rarity.ssr;
			break;
		case "SR icon":
			toReturn = Rarity.sr;
			break;
		case "R icon":
			toReturn = Rarity.r;
			break;
		case "N icon":
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
		case "TEQ icon":
			toReturn = Type.teq;
			break;
		case "AGI icon":
			toReturn = Type.agi;
			break;
		case "PHY icon":
			toReturn = Type.phy;
			break;
		case "STR icon":
			toReturn = Type.str;
			break;
		case "INT icon":
			toReturn = Type.intel;
			break;
		default:
			toReturn = Type.agi;
			break;
		}

		return toReturn;
	}

	public static String computeLeaderSkill(String leaderSkill) {
		return computeDataLine(leaderSkill);
	}

	public static String computeSuperATK(String superATK) {
		return computeDataLine(superATK);
	}

	public static String computePassiveSkill(String passiveSkill) {
		return computeDataLine(passiveSkill);
	}

	private static String computeDataLine(String line) {
		String toReturn = CSVUtils.cleanString(line);
		if (toReturn.startsWith("<")) {
			// TODO extract data from html tag
			toReturn = "";
		}
		else if (toReturn.length() > 400) {
			toReturn = toReturn.substring(0, 400);
		}

		return toReturn;
	}

	public static List<Link> computeLinkSkills(String linkSkills) {
		// "Golden Warrior; Saiyan Warrior Race; Super Saiyan; Kamehameha; Blazing Battle"
		
		List<Link> skills = new ArrayList<Link>();
		for (String linkSkill : Arrays.asList(linkSkills.split(";"))) {
			skills.add(new Link().initDTO(linkSkill, ""));
		}

		return skills;
	}

	public static Integer computeInteger(String hpMax) {
		Integer toReturn;

		if (hpMax.equals("") || hpMax.equals("N/A")) {
			toReturn = new Integer(0);
		} else {
			toReturn = Integer.valueOf(hpMax);
		}

		return toReturn;

	}

	private static String cleanString(String line) {
		return line.replace("'", " ");
	}

	public static String computeName(String line) {
		return CSVUtils.cleanString(line);
	}

}
