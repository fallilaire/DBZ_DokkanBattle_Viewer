<template>
	<div class="container-fluid">
		<div class="row">
		  <small-card v-for="card in cards" :key="card.name" :card="card" />
		</div>
	</div>
</template>

<script>
import SmallCard from './component/SmallCard.vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

export default {
  components: { SmallCard },
  data () {
    return {
      cards: this.$store.state.cards
    }
  }
}
</script>

<style scoped>

</style>
