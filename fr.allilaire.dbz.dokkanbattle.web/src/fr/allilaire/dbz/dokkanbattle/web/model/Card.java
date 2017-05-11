package fr.allilaire.dbz.dokkanbattle.web.model;

import java.util.List;

public class Card {

	private Integer id;
	private String name;
	private String shortName;
	private String url;
	private Integer maxLevel;
	private Rarity rarity;
	private Type type;
	private Integer costMax;
	private Integer costBase;
	private String leaderSkill;
	private String superATK;
	private String passiveSkill;
	private Integer hpMax;
	private Integer hpBase;
	private Integer atkMax;
	private Integer atkBase;
	private Boolean owned;
	private Boolean versionMax;
	private String additionnalInfo;
	private List<Team> teams;
	private List<Link> links;
	private Event obtain;
	private List<Event> boss;
	private List<Medal> awake;
	private List<Capacity> capacities;
	
	public Card initDTO(Integer id, String name, String shortName, String url, Integer maxLevel, Rarity rarity, Type type,
			Integer cost, String leaderSkill, String superATK, String passiveSkill,
			Integer hpMax, Integer atkMax, Boolean owned) {
		this.id = id;
		this.name = name;
		this.shortName = shortName;
		this.url = url;
		this.maxLevel = maxLevel;
		this.rarity = rarity;
		this.type = type;
		this.costMax = cost;
		this.leaderSkill = leaderSkill;
		this.superATK = superATK;
		this.passiveSkill = passiveSkill;
		this.hpMax = hpMax;
		this.atkMax = atkMax;
		this.owned = owned;
		return this;
	}
	
	

	public Card initDTO(String name, String shortName, String url, Integer maxLevel, Rarity rarity, Type type, Integer cost,
			String leaderSkill, String superATK, String passiveSkill, Integer hpMax,
			Integer atkMax, Boolean owned) {
		this.name = name;
		this.shortName = shortName;
		this.url = url;
		this.maxLevel = maxLevel;
		this.rarity = rarity;
		this.type = type;
		this.costMax = cost;
		this.leaderSkill = leaderSkill;
		this.superATK = superATK;
		this.passiveSkill = passiveSkill;
		this.hpMax = hpMax;
		this.atkMax = atkMax;
		this.owned = owned;
		return this;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(Integer maxLevel) {
		this.maxLevel = maxLevel;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Integer getCost() {
		return costMax;
	}

	public void setCost(Integer cost) {
		this.costMax = cost;
	}

	public String getLeaderSkill() {
		return leaderSkill;
	}

	public void setLeaderSkill(String leaderSkill) {
		this.leaderSkill = leaderSkill;
	}

	public String getSuperATK() {
		return superATK;
	}

	public void setSuperATK(String superATK) {
		this.superATK = superATK;
	}

	public String getPassiveSkill() {
		return passiveSkill;
	}

	public void setPassiveSkill(String passiveSkill) {
		this.passiveSkill = passiveSkill;
	}

	public List<Link> getLinkSkills() {
		return links;
	}

	public void setLinkSkills(List<Link> linkSkills) {
		this.links = linkSkills;
	}

	public Integer getHpMax() {
		return hpMax;
	}

	public void setHpMax(Integer hpMax) {
		this.hpMax = hpMax;
	}

	public Integer getAtkMax() {
		return atkMax;
	}

	public void setAtkMax(Integer atkMax) {
		this.atkMax = atkMax;
	}

	public Boolean isOwned() {
		return owned;
	}

	public void setOwned(Boolean owned) {
		this.owned = owned;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
}
