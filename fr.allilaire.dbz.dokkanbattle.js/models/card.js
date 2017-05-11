var mongoose = require('mongoose');

var CardSchema = new mongoose.Schema({
  	id: Number,
	addInfo: String,
	awaken: String,
	baseAtk: String,
	baseDef: String,
	baseHp: String,
	icon: String,
	img: String,
	kiMeter: String,
	leaderSkill: String,
	linkSkill: String,
	maxAtk: String,
	maxCost: String,
	maxDef: String,
	maxHp: String,
	maxLvl: String,
	maxRarity: String,
	minCost: String,
	minLvl: String,
	minRarity: String,
	name: String,
	obtain: String,
	owned: Boolean,
	passiveSkill: String,
	superAtk: String,
	type: String,
	url: String
	// specialAtkLevel
	// specialCapabilities
	// nuker
	// blocker
	// healer
});

module.exports = mongoose.model('cards', CardSchema);
