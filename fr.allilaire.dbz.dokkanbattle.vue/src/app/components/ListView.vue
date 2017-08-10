<template>
	<div class="container-fluid">
		<div class="row">
		  <small-card v-for="card in cards" :key="card.name" :card="card" />
		</div>
	</div>
</template>

<script>
import dataJson from '../../assets/output.json'
import SmallCard from './SmallCard.vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

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
