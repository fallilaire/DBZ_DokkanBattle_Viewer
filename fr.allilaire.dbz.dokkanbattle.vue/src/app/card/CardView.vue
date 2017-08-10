<template>
  <div>
		<div>Todo</div>
	  <div class="col-md-12">
		  <table class="table table-striped">
			  <tr>
  				<td rowspan="3"><img :src="data.icon" width="120" height="105"></a></td>
	  			<td colspan="4"><b><center>{{data.name}}</center></b></td>
		  	</tr>
			  <tr>
				  <td><center><b>Max LvL</b></center></td>
				  <td><center><b>Rarity</b></center></td>
				  <td><center><b>Type</b></center></td>
				  <td><center><b>Cost</b></center></td>
			  </tr>
			  <tr>
				  <td><center>{{data.maxLvl}}</center></td>
				  <td><center>{{data.minRarity}}</center></td>
				  <td><center>{{data.type}}</center></td>
				  <td><center>{{data.minCost}}</center></td>
			  </tr>
		  </table>
	  </div>
	  <div class="col-md-12">
		  <table class="table table-striped">
			  <tr>
  				<td rowspan="8"><center><img :src="data.img" width="250" height="333" /></center></td>
	  			<td colspan="2"></td>
		  	</tr>
			  <tr>
				  <td><strong>Leader Skill</strong></td>
				  <td>{{data.leaderSkill}}</td>
			  </tr>
			  <tr>
				  <td><strong>Super atk</strong></td>
				  <td>{{data.superAtk}}</td>
			  </tr>
			  <tr>
				  <td><strong>Passive skill</strong></td>
				  <td>{{data.passiveSkill}}</td>
  			</tr>
	  		<tr>
		  		<td><strong>Link skill</strong></td>
			  	<td>{{data.linkSkill}}</td>
			  </tr>
			  <tr>
				  <td><strong>Ki meter</strong></td>
				  <td><img :src="data.kiMeter" /></td>
			  </tr>
			  <tr>
				  <td><strong>How to obtain</strong></td>
				  <td>{{data.obtain}}</td>
			  </tr>
			  <tr>
				  <td><strong>Additional information</strong></td>
				  <td>{{data.addInfo}}</td>
			  </tr>
		  </table>
	  </div>
	  <div>
		  <button type="button" class="btn btn-lg btn-default"><a href="/">Back</a></button>
	  </div>
  </div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

export default {
  data () {
    return {
      data: this.$store.state.selectedCard
    }
  },
  created () {
    console.log(this.data)
  }
}
</script>

<style scoped>

</style>
