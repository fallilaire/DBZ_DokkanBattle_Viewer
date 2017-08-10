import Vue from 'vue'
import Router from 'vue-router'
import ListView from '@/app/list/ListView'
import CardView from '@/app/card/CardView'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      component: ListView
    },
    {
      path: '/card/',
      component: CardView
    }
  ]
})
