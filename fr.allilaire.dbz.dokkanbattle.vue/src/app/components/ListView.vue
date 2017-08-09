<template>
	<div class="container">
		<div class="row">
		  <small-card v-for="card in cards" :key="card.name" :card="card" />
		</div>
	</div>
</template>

<script>
import dataJson from '../../assets/output.json'
import SmallCard from './SmallCard.vue'

export default {
  components: { SmallCard },
  data () {
    return {
      cards: dataJson
    }
  }
}
</script>

<style scoped>

</style>
