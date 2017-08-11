'use strict';

var fs      = require('fs');
var rp = require('request-promise-native');
var cheerio = require('cheerio');
const uuidv5 = require('uuid/v5');

// Define JSON File
console.log("\n *STARTING* \n");
// Get content from file
var contents = fs.readFileSync("input/listing.json");
// Define to JSON type
var jsonContent = JSON.parse(contents);
var listing = [];

jsonContent.forEach(function(url) {

    console.log(url)
    var options = {
        uri: url,
        transform: function (body) {
            return cheerio.load(body);
        }
    };

    rp(options)
    .then(function ($) {
        $('table[border="1"]').filter(function() {
            let data = $(this);
            // finding all links in the main table
            let links = data.find('tr').find('a');

            links.each(function(i, elem) {
                let url = $(this)[0]['attribs']['href'];
                if (url.startsWith("/wiki/") && !url.startsWith("/wiki/Category:")) {
                    listing.push("http://dbz-dokkanbattle.wikia.com" + url);
                    fs.writeFile('output/cards_url.json', JSON.stringify(listing, null, 4), function(err) {
                        console.log('Serializing ' + url + ' in the output.json file');
                    })
                }
            });
        })
    })
    .catch(console.log.bind(console));
});

