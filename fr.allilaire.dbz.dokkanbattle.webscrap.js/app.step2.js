'use strict';

var fs      = require('fs');
var rp = require('request-promise-native');
var cheerio = require('cheerio');
const uuidv5 = require('uuid/v5');

// Define JSON File
console.log("\n *STARTING* \n");
// Get content from file
var contents = fs.readFileSync("output/cards_url.json");
var jsonContent = JSON.parse(contents);
var listing = [];

jsonContent.forEach(function(url) {
    parseOneCard(url);
});

function parseOneCard(url) {

    var options = {
        uri: url,
        transform: function (body) {
            return cheerio.load(body);
        }
    };
 
    rp(options)
    .then(function ($) {
            // Finally, we'll define the variables we're going to capture
            var json = {
                id : "",//uuidv5(url, uuidv5.DNS),
                addInfo : "",
                awaken : "",
                baseAtk : "",
                baseDef : "",
                baseHp : "",
                icon : "",
                img : "",
                kiMeter : "",
                leaderSkill : "",
                linkSkill : "",
                maxAtk : "",
                maxCost : "",
                maxDef : "",
                maxHp : "",
                maxLvl : "",
                maxRarity : "",
                minCost : "",
                minLvl : "",
                minRarity : "",
                name : "",
                obtain : "",
                passiveSkill : "",
                superAtk : "",
                type : "",
                url : url
                // specialAtkLevel
	            // specialCapabilities
	            // nuker
	            // blocker
	            // healer
            };
            // name
            $('h1').filter(function() {
                let data = $(this);
                json.name = data.text();
            })
            // icon
            $('#mw-content-text > table > tbody > tr > td > a').filter(function() {
                let data = $(this);
                let src = data[0]['attribs']['href'];
                json.icon = src;
            })
            // img
            $('#mw-content-text > div[style="clear: both; overflow:hidden;"] > div[style="float:left; width:30%;"] > table > tbody > tr > td > center > a').filter(function() {
                let data = $(this);
                let src = data[0]['attribs']['href'];

                json.img = src;
            })
            // kimeter
            $('img[alt*="Kimeter"]').filter(function() {
                let data = $(this).parent();
                let src = data[0]['attribs']['href'];

                json.kiMeter = src;
            })
            // Min/Max Lvl - Min/Max Cost - Min/Max Rarity - Type
            $('b:contains("Max LvL")').filter(function() {
                let data = $(this);
                let tmp = data.parent().parent().parent().next().find('td');
                // TODO Split
                let lvl = tmp.eq(0).text().split('/');
                json.minLvl = lvl[0];
                json.maxLvl = lvl[1];
                let cost = tmp.eq(3).text().split('/');
                json.minCost = cost[0];
                json.maxCost = cost[1];
                json.minRarity = tmp.eq(1).find('img')[0]['attribs']['alt'].replace(' icon', '');
                // TODO Manage the case where there is only one rarity
                //json.maxRarity = tmp.eq(1).find('img')[4]['attribs']['alt'].replace(' icon', '');
                json.type = tmp.eq(2).find('img')[0]['attribs']['alt'].replace(' icon', '');
            })
            // MaxHp - MaxAtk - MaxDef
            $('#mw-content-text table td a img[alt="HP"]').filter(function() {
                let data = $(this);
                
                if (data.parent()[0]['name'] == 'a') {
                    let tmp = data.parent().parent().parent().parent().next('tr').children('td');
                    json.baseHp = tmp[1]['children'][0]['children'][0]['data'];
                    json.baseAtk = tmp[2]['children'][0]['children'][0]['data'];
                    json.baseDef = tmp[3]['children'][0]['children'][0]['data'];

                    tmp = data.parent().parent().parent().parent().next('tr').next('tr').children('td');
                    json.maxHp = tmp[1]['children'][0]['children'][0]['data'];
                    json.maxAtk = tmp[2]['children'][0]['children'][0]['data'];
                    json.maxDef = tmp[3]['children'][0]['children'][0]['data'];
                }
            })

            $('b:contains("How to obtain")').filter(function() {
                let data = $(this);
                let tmp = data.parent().parent().parent().next().find('center').first().html();
                json.obtain = tmp;
            })

            $('b:contains("Additional information")').filter(function() {
                let data = $(this);
                let tmp = data.parent().parent().parent().next().find('center').first();
                tmp = tmp.find('noscript').remove();
                json.addInfo = tmp.html();
            })

            $('#mw-content-text table td a img[alt="Leader Skill"]').filter(function() {
                let data = $(this);
                let tmp = data.parent().parent().parent().parent();
                if (data.parent()[0]['name'] == 'a') {
                    json.leaderSkill = tmp.next().find("center").html();
                    json.superAtk = tmp.next().next().next().find("center").html();
                    json.passiveSkill = tmp.next().next().next().next().next().find("center").html();
                    json.linkSkill = tmp.next().next().next().next().next().next().next().find("center").text().split(' - ');
                }
            })

            listing.push(json);

            fs.writeFile('output/output.json', JSON.stringify(listing, null, 4), function(err) {
                console.log('Serializing ' + url + ' in the output.json file');
            })
    })
    .catch(console.log.bind(console));

}
