<template>
  <div class="col-md-1">
    <div>
      <img :alt="card.name" style="width: 120px; height: 105px;" :src="card.icon" />
    </div>
  </div>
</template>

<script>
export default {
  props: ['card']
}
</script>
