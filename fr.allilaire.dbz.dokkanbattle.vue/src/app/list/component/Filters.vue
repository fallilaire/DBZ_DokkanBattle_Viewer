<template>
  <div class="col-12">
	<nav class="navbar navbar-toggleable-md navbar-light" style="background-color: #e3f2fd;">
	    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
      		span class="navbar-toggler-icon"></span>
    	</button>
    	<a class="navbar-brand" href="#">Navbar</a>
		<div class="collapse navbar-collapse" id="navbarColor03">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
        			<a class="nav-link" href="#" @click.prevent="allCards()">All</a>
      			</li>
				<li class="nav-item active">
        			<a class="nav-link" href="#" @click.prevent="filterByType('PHY')">Owned <span class="sr-only">(current)</span></a>
      			</li>
				<li class="nav-item dropdown">
        			<a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        				Sort
        			</a>
        			<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
       					<a class="dropdown-item" href="#">Rarity</a>
       					<a class="dropdown-item" href="#">Type</a>
       					<a class="dropdown-item" href="#">HP Max</a>
						<a class="dropdown-item" href="#">ATK Max</a>
						<a class="dropdown-item" href="#">DEF Max</a>
        			</div>
      			</li>
				<li class="nav-item dropdown">
        			<a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          				Filter by: Rarity
        			</a>
        			<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          				<a class="dropdown-item" href="/cards/rarity/LR">LR</a>
          				<a class="dropdown-item" href="/cards/rarity/UR">UR</a>
          				<a class="dropdown-item" href="/cards/rarity/SSR">SSR</a>
						<a class="dropdown-item" href="/cards/rarity/SR">SR</a>
						<a class="dropdown-item" href="/cards/rarity/R">R</a>
						<a class="dropdown-item" href="/cards/rarity/N">N</a>
        			</div>
      			</li>
				<li class="nav-item dropdown">
        			<a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          				Filter by: Type
        			</a>
        			<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          				<a class="dropdown-item" href="/cards/type/INT">INT</a>
          				<a class="dropdown-item" href="/cards/type/TEQ">TEQ</a>
          				<a class="dropdown-item" href="/cards/type/AGL">AGL</a>
						<a class="dropdown-item" href="/cards/type/STR">STR</a>
						<a class="dropdown-item" href="/cards/type/PHY">PHY</a>
        			</div>
      			</li>
			</ul>
			<form class="form-inline">
				<input class="form-control mr-sm-2" type="text" placeholder="Search">
				<button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
  	</nav>
  </div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

export default {
  methods: {
    allCards () {
      this.$store.commit('allCards')
    },
    ownedCards (state) {
      console.log('coucou')
      this.$store.commit('ownedCards')
    },
    filterByType (type) {
      console.log(type)
      this.$store.commit('filterByType', type)
    }
  }
}
</script>
