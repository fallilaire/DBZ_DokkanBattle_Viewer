'use strict'

const fs = require('fs')
const rp = require('request-promise-native')
const cheerio = require('cheerio')
const uuidv5 = require('uuid/v5')

// Define JSON File
console.log('\n *STARTING* \n')
// Get content from file
const contents = fs.readFileSync('output/cards_url.json')
const jsonContent = JSON.parse(contents)
let listing = []

jsonContent.forEach(function (url) {
  listing.push(parseOneCard(url))
})

Promise.all(listing).then(
  function (resolve) {
    console.log(resolve.length)
    fs.writeFile('output/output.json', JSON.stringify(resolve, null, 4), (err) => {
      if (err) throw err
      console.log('Serializing in the output.json file')
    })
  }
)

function parseOneCard (url) {
  let options = {
    uri: url,
    transform: function (body) {
      return cheerio.load(body)
    }
  }

  let p2 = rp(options).then(function ($) {
    // console.log(process.memoryUsage().heapUsed)
    // Finally, we'll define the variables we're going to capture
    let json = {
      id: uuidv5(url, uuidv5.DNS),
      url: url
    }
    // name
    $('h1').filter(function () {
      json.name = $(this).text()
    })
    // icon
    $('#mw-content-text > table > tbody > tr > td > a').filter(function () {
      json.icon = $(this)[0]['attribs']['href']
    })

    // img
    $('#mw-content-text > div[style="clear: both; overflow:hidden;"] > div[style="float:left; width:30%;"] > table > tbody > tr > td > center > a').filter(function () {
      json.img = $(this)[0]['attribs']['href']
    })

    // kimeter
    $('img[alt*="Kimeter"]').filter(function () {
      json.kiMeter = $(this).parent()[0]['attribs']['href']
    })

    // Min/Max Lvl - Min/Max Cost - Min/Max Rarity - Type
    $('b:contains("Max LvL")').filter(function () {
      let tmp = $(this).parent().parent().parent().next().find('td')
      // TODO Split
      let lvl = tmp.eq(0).text().split('/')
      json.minLvl = lvl[0]
      json.maxLvl = lvl[1]
      let cost = tmp.eq(3).text().split('/')
      json.minCost = cost[0]
      json.maxCost = cost[1]
      json.minRarity = tmp.eq(1).find('img')[0]['attribs']['alt'].replace(' icon', '')
      // TODO Manage the case where there is only one rarity
      // json.maxRarity = tmp.eq(1).find('img')[4]['attribs']['alt'].replace(' icon', '')
      json.type = tmp.eq(2).find('img')[0]['attribs']['alt'].replace(' icon', '')
    })

    // MaxHp - MaxAtk - MaxDef
    $('#mw-content-text table td a img[alt="HP"]').filter(function () {
      let data = $(this)

      if (data.parent()[0]['name'] === 'a') {
        let tmp = data.parent().parent().parent().parent().next('tr').children('td')
        json.baseHp = tmp[1]['children'][0]['children'][0]['data']
        json.baseAtk = tmp[2]['children'][0]['children'][0]['data']
        json.baseDef = tmp[3]['children'][0]['children'][0]['data']

        tmp = data.parent().parent().parent().parent().next('tr').next('tr').children('td')
        json.maxHp = tmp[1]['children'][0]['children'][0]['data']
        json.maxAtk = tmp[2]['children'][0]['children'][0]['data']
        json.maxDef = tmp[3]['children'][0]['children'][0]['data']
      }
    })

    $('b:contains("How to obtain")').filter(function () {
      json.obtain = $(this).parent().parent().parent().next().find('center').first().html()
    })

    $('b:contains("Additional information")').filter(function () {
      let data = $(this)
      let tmp = data.parent().parent().parent().next().find('center').first()
      tmp = tmp.find('noscript').remove()
      json.addInfo = tmp.html()
    })

    $('#mw-content-text table td a img[alt="Leader Skill"]').filter(function () {
      let data = $(this)
      let tmp = data.parent().parent().parent().parent()
      if (data.parent()[0]['name'] === 'a') {
        json.leaderSkill = tmp.next().find('center').html()
        json.superAtk = tmp.next().next().next().find('center').html()
        json.passiveSkill = tmp.next().next().next().next().next().find('center').html()
        json.linkSkill = tmp.next().next().next().next().next().next().next().find('center').text().split(' - ')
      }
    })

    return json
  }).catch(console.log.bind(console))
  return p2
}
