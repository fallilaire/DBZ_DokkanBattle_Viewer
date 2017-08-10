import Vue from 'vue'
import Vuex from 'vuex'
import dataJson from '@/assets/output.json'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    cards: dataJson,
    selectedCard: undefined
  },
  mutations: {
    selectCard (state, card) {
      state.selectedCard = card
    },
    ownedCards (state) {
      state.cards = dataJson.filter(card => card.owned === true)
    },
    allCards (state) {
      state.cards = dataJson
    },
    filterByType (state, type) {
      state.cards = dataJson.filter(card => card.type === type)
      console.log('store - ' + type)
    }
  }
})
