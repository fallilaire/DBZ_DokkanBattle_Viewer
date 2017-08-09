import Vue from 'vue'
import Router from 'vue-router'
import ListView from '@/app/components/ListView'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'ListView',
      component: ListView
    }
  ]
})
