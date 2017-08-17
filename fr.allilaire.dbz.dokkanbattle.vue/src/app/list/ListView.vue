<template>
	<div class="container-fluid">
    <div class="row">
      <filters />
		  <small-card v-for="card in cards" :card="card" key="card.id"/>
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
  computed: {
    cards () {
      return this.$store.state.cards
    }
  }
}
</script>

<style scoped>

</style>
