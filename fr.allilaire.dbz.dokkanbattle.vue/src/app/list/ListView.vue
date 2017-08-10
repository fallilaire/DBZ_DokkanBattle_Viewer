<template>
	<div class="container-fluid">
		<div class="row">
      <filters />
		  <small-card v-for="card in cards" :key="card.name" :card="card" />
		</div>
	</div>
</template>

<script>
import Filters from './component/Filters.vue'
import SmallCard from './component/SmallCard.vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

export default {
  components: { Filters, SmallCard },
  data () {
    return {
      cards: this.$store.state.cards
    }
  }
}
</script>

<style scoped>

</style>
