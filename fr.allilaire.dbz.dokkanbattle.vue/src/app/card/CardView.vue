<template>
  <div>
	  <div class="col-md-12">
		  <table class="table table-striped">
			  <tr>
  				<td rowspan="3"><img :src="card.icon" width="120" height="105"></a></td>
	  			<td colspan="4"><b><center>{{card.name}}</center></b></td>
		  	</tr>
			  <tr>
				  <td><center><b>Max LvL</b></center></td>
				  <td><center><b>Rarity</b></center></td>
				  <td><center><b>Type</b></center></td>
				  <td><center><b>Cost</b></center></td>
			  </tr>
			  <tr>
				  <td><center>{{card.maxLvl}}</center></td>
				  <td><center>{{card.minRarity}}</center></td>
				  <td><center>{{card.type}}</center></td>
				  <td><center>{{card.minCost}}</center></td>
			  </tr>
		  </table>
	  </div>
	  <div class="col-md-12">
		  <table class="table table-striped">
			  <tr>
  				<td rowspan="8"><center><img :src="card.img" width="250" height="333" /></center></td>
	  			<td colspan="2"></td>
		  	</tr>
			  <tr>
				  <td><strong>Leader Skill</strong></td>
				  <td>{{card.leaderSkill}}</td>
			  </tr>
			  <tr>
				  <td><strong>Super atk</strong></td>
				  <td>{{card.superAtk}}</td>
			  </tr>
			  <tr>
				  <td><strong>Passive skill</strong></td>
				  <td>{{card.passiveSkill}}</td>
  			</tr>
	  		<tr>
		  		<td><strong>Link skill</strong></td>
			  	<td>{{card.linkSkill}}</td>
			  </tr>
			  <tr>
				  <td><strong>Ki meter</strong></td>
				  <td><img :src="card.kiMeter" /></td>
			  </tr>
			  <tr>
				  <td><strong>How to obtain</strong></td>
				  <td>{{card.obtain}}</td>
			  </tr>
			  <tr>
				  <td><strong>Additional information</strong></td>
				  <td>{{card.addInfo}}</td>
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
  props: ['card']
}
</script>

<style scoped>

</style>
