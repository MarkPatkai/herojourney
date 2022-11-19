<template>
  <div class="grid">
    <div class="center col-8 shadow-8">
      <div class="col-8">
        <div class="col-12">
          <h1>Hero Profile</h1>
          <h2>{{hero.name}}</h2>
        </div>
        <div class="col-12">
          <h1>Hero Level</h1>
          <h2>{{hero.level}}</h2>
        </div>
        <div class="col-12">
          <h1>Hero Experience</h1>
          <h2>{{hero.exp}}</h2>
        </div>
        <div class="col-12">
          <h1>Hero Class</h1>
          <h2>{{hero.heroClass.name}}</h2>
        </div>
      </div>
      <div class="col-8">
        <div class="col-12">
          <h1>Hero Stats</h1>
        </div>
        <div class="col-12">
          <h2>Strength: {{hero.str}}</h2>
        </div>
        <div class="col-12">
          <h2>Dexterity: {{hero.dex}}</h2>
        </div>
        <div class="col-12">
          <h2>Mind: {{hero.mnd}}</h2>
        </div>
        <div class="col-12">
          <h2>Vitality: {{hero.vit}}</h2>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HeroProfileView",
  components: {

  },
  data() {
    return {

    }
  },
  computed: {
    hero() {
      return this.$store.getters.getHero;
    }
  }
}
</script>
<style scoped>
.center {
  display: grid;
  grid-template-columns: repeat(12, 1fr);
  grid-gap: 10px;
  margin: 0 auto;
  width: 100%;
  max-width: 1200px;
  padding: 0 20px;
}
</style>
