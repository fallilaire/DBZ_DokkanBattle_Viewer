var request = require('request');
var card = require('../models/card.js');
var bodyParser = require('body-parser');
var ObjectID = require('mongodb').ObjectID;

var express = require('express');
var router = express.Router();

var Card = require('../models/card.js');

router.get('/', function(req, res){
	res.send('Hello World!');
});

router.get('/init', function(req, res){
	console.log('Tentative init de la base');
	var mongodb = require('mongodb').MongoClient;

	var arr = require('../data/output.json');

	mongodb.connect('mongodb://localhost:27017/cards', function(err, db) {
		for (var idx in arr) {
			db.collection('cards').insert(arr[idx]);
		}
		console.log('Import over');
		res.send('Import cards');
	});
});

router.get('/clean', function(req, res){
	console.log('Clean cards collection');
	var mongodb = require('mongodb').MongoClient;

	mongodb.connect('mongodb://localhost:27017/cards', function(err, db) {
		db.collection('cards').drop();
		console.log('Drop cards!');
		res.send('Clean cards collection');
	});
});

// EJS redirection
router.get('/cards', function(req, res) {
	Card.find(function (err, data) {
		if (err) return next(err);
		res.render('cards', { data: data });
	});
});

// sort : maxAtk
// sort : maxDef
// sort : maxHp
// sort : minRarity
// sort : type
router.get('/cards/sort', function(req, res) {
	Card.find().sort([[req.params.sort, 'descending']]).all(function (data) {
  	if (err) return next(err);
		res.render('cards', { data: data });
  });	
});

// filter : minRarity
router.get('/cards/rarity/:rarity', function(req, res) {
	Card.find({"minRarity":req.params.rarity},function (err, data) {
  	if (err) return next(err);
		res.render('cards', { data: data });
  });	
});
// filter : type
router.get('/cards/type/:type', function(req, res) {
	Card.find({"type":req.params.type},function (err, data) {
  	if (err) return next(err);
		res.render('cards', { data: data });
  });	
});
// filter : owned
router.get('/cards/owned', function(req, res, next) {
	Card.find({"owned":true},function (err, data) {
   	if (err) return next(err);
   	res.render('cards', { data: data });
  });
});

router.get('/card/:id', function(req, res, next) {
	Card.findById(req.params.id, function (err, data) {
		console.log('/card/:id');
		console.log(data);
		if (err) return next(err);
		console.log('/card/:id - 2');
    res.render('card', { data: data });
  });
});

// API
router.get('/api/cards', function(req, res, next) {
	Card.find(function (err, cards) {
   	if (err) return next(err);
   	res.json(cards);
  });
});

router.get('/api/cards/owned', function(req, res, next) {
	Card.find({"owned":true},function (err, cards) {
   	if (err) return next(err);
   	res.json(cards);
  });
});

router.get('/api/card/:id', function(req, res, next) {
	Card.findById(req.params.id, function (err, data) {
   	if (err) return next(err);
   	res.json(data);
 	});
});

router.post('/api/cards', function(req, res, next) {
  Card.create(req.body, function (err, post) {
    if (err) return next(err);
    res.json(post);
  });
});

router.put('/api/card/:id', function(req, res, next) {
  Card.findByIdAndUpdate(req.params.id, req.body, function (err, post) {
    if (err) return next(err);
    res.json(post);
  });
});

router.delete('/api/card/:id', function(req, res, next) {
  Card.findByIdAndRemove(req.params.id, req.body, function (err, post) {
    if (err) return next(err);
    res.json(post);
  });
});

module.exports = router;