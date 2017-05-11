'use strict';

var fs      = require('fs');
var rp = require('request-promise-native');
var cheerio = require('cheerio');

// Define JSON File
console.log("\n *STARTING* \n");
// Define to JSON type
var listing = [];

parseOneCard("http://dbz-dokkanbattle.wikia.com/wiki/Leading_to_Victory_Super_Gogeta");

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
                let name = data.text();
                json.name = name;
            })
            // icon
            $('#mw-content-text table td a img[width=120]').filter(function() {
                let data = $(this);
                let src = data[0]['attribs']['src'];

                if (src.substring(0, 4) === 'http') {
                    json.icon = src;
                }
            })
            // kimeter & img
            $('#mw-content-text table td a img[width=250]').filter(function() {
                let data = $(this);

                let src = data[0]['attribs']['src'];

                if (src.substring(0, 4) === 'http') {
                    if (src.includes("Kimeter")) {
                        json.kiMeter = src;
                    }
                    else {
                        json.img = src;
                    }
                }
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

            $('b:contains("How to Obtain")').filter(function() {
                let data = $(this);
                let tmp = data.parent().parent().parent().next().find('center').first().html();
                json.obtain = tmp;
            })

            $('b:contains("Additional Information")').filter(function() {
                let data = $(this);
                let tmp = data.parent().parent().parent().next().find('center').first();
                console.log(tmp);
                tmp = tmp.not('noscript');
                console.log(tmp);
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

            fs.writeFile('output/sample.json', JSON.stringify(listing, null, 4), function(err) {
                console.log('Serializing ' + url + ' in the sample.json file');
            })
    })
    .catch(console.log.bind(console));

}