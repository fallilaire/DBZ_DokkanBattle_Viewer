/**
 * 
 */
package fr.allilaire.dbz.dokkanbattle.web.persistence.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.allilaire.dbz.dokkanbattle.web.model.Card;
import fr.allilaire.dbz.dokkanbattle.web.persistence.IDAO;

/**
 * @author imiedev
 *
 */
public class CardDAOJDBC implements IDAO<Card> {
	
	@Override
	public List<Card> findAll() {
		
		Statement statement = null;
		ResultSet resultSet = null;
		List<Card> cards = new ArrayList<Card>();
		try {
			String selectAllCardsQuery = "Select id, name, shortName, url, maxLevel, rarity, type, cost, leaderSkill, superATK, passiveSkill, hpMax, atkMax, owned from dokkan.\"card\"";

			statement = ConnectionJDBCPostgreSQL.createStatement();
			resultSet = statement.executeQuery(selectAllCardsQuery);
			while (resultSet.next()) {
				cards.add(CardDAOJDBC.initCard(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionJDBCPostgreSQL.closeJDBC(statement, resultSet);
		}
		return cards;
	}

	private static Card initCard(ResultSet resultSet) throws SQLException {
		Card card = new Card().initDTO(Integer.valueOf(resultSet.getInt("id")), resultSet.getString("name"),
				resultSet.getString("shortName"), resultSet.getString("url"),
				Integer.valueOf(resultSet.getInt("maxLevel")), JDBCUtils.computeRarity(resultSet.getString("rarity")),
				JDBCUtils.computeType(resultSet.getString("type")), Integer.valueOf(resultSet.getInt("cost")),
				resultSet.getString("leaderSkill"), resultSet.getString("superATK"),
				resultSet.getString("passiveSkill"), Integer.valueOf(resultSet.getInt("hpMax")),
				Integer.valueOf(resultSet.getInt("atkMax")), Boolean.valueOf(resultSet.getBoolean("owned")));
		return card;
	}

	@Override
	public Card findOneById(Integer id) {
		Statement statement = null;
		ResultSet resultSet = null;
		Card card = null;
		try {
			String selectCardsQuery = "Select id, name, shortName, url, maxLevel, rarity, type, cost, leaderSkill, superATK, passiveSkill, hpMax, atkMax, owned from dokkan.\"card\" where id = '"
					+ id + "'";
			statement = ConnectionJDBCPostgreSQL.createStatement();
			resultSet = statement.executeQuery(selectCardsQuery);

			if (resultSet.isBeforeFirst()) {
				resultSet.next();
				card = CardDAOJDBC.initCard(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionJDBCPostgreSQL.closeJDBC(statement, resultSet);
		}
		return card;
	}

	private Boolean findOneByName(String name) {
		Statement statement = null;
		ResultSet resultSet = null;
		Boolean toReturn = false;
		try {
			String selectCardsQuery = "Select id from dokkan.\"card\" where name = '" + name + "'";
			statement = ConnectionJDBCPostgreSQL.createStatement();
			resultSet = statement.executeQuery(selectCardsQuery);

			if (resultSet.isBeforeFirst()) {
				resultSet.next();
				toReturn = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionJDBCPostgreSQL.closeJDBC(statement, resultSet);
		}
		return toReturn;
	}

	@Override
	public void create(Card dto) {
		if (!findOneByName(dto.getName())) {
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			try {
				String createCard = "INSERT INTO dokkan.\"card\" ("
					+ "name, shortName, url, maxLevel, rarity, type, cost, leaderSkill, superATK, passiveSkill, hpMax, atkMax, owned) VALUES ('"
						+ dto.getName() + "', '" + dto.getShortName() + "','" + dto.getUrl() + "'," + dto.getMaxLevel()
						+ ",'" + dto.getRarity() + "','" + dto.getType() + "'," + dto.getCost() + ",'"
						+ dto.getLeaderSkill() + "','" + dto.getSuperATK() + "','" + dto.getPassiveSkill() + "',"
						+ dto.getHpMax() + "," + dto.getAtkMax() + "," + dto.isOwned() + ")";
				statement = ConnectionJDBCPostgreSQL.createPreparedStatement(createCard);
				statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectionJDBCPostgreSQL.closeJDBC(statement, resultSet);
			}
		}

	}

	@Override
	public void createAll(List<Card> dtos) {
		for (Card card : dtos) {
			create(card);
		}
	}

}
