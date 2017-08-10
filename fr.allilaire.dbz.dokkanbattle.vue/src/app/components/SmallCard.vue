<template>
  <div class="col-1">
    <a :href="getUri()"><img :alt="card.name" style="width: 120px; height: 105px;" :src="card.icon" /></a>
  </div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

export default {
  props: ['card'],
  methods: {
    getUri () {
      return '/card/' + this.card.name
    }
  }
}
</script>
