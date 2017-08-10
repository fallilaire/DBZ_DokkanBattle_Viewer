<template>
  <div class="col-1">
    <img :alt="card.name" style="width: 120px; height: 105px;" :src="card.icon" @click="selectCard()" />
  </div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

export default {
  props: ['card'],
  methods: {
    selectCard () {
      this.$store.commit('selectCard', this.card)
      // this.$router.push('/card')
      this.$router.push({name: 'card', params: { card: this.card }})
    }
  }
}
</script>
