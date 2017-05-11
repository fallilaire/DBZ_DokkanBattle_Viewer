var express = require('express');
var path = require('path');
var bodyParser = require('body-parser');

var routes = require('./routes/cards');

// load mongoose package
var mongoose = require('mongoose');

// Use native Node promises
mongoose.Promise = global.Promise;

// connect to MongoDB
mongoose.connect('mongodb://localhost:27017/cards')
  .then(() =>  console.log('Successful connection'))
  .catch((err) => console.error(err));

var app = express();
app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views/ejs'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use('/public', express.static(__dirname + '/public'));
app.use('/', routes);

var port = process.argv[2] || 1337;

var server = app.listen(port, function() {
	console.log('Server is listening on  http://localhost:' + port);
});

module.exports = app;