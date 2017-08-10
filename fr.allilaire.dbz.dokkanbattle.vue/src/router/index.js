import Vue from 'vue'
import Router from 'vue-router'
import ListView from '@/app/components/ListView'
import CardView from '@/app/components/CardView'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      component: ListView
    },
    {
      path: '/card/:id',
      component: CardView
    }
  ]
})

/*
,
      children: [
        {
          path: ':name',
          component: CardView
        }
      ]
*/
