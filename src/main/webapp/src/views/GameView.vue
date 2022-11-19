<template>
   <div class="p-grid p-justify-center">
      <div class="p-col-12 p-md-6">
          {{hero.name}} - ({{hero.level}})
      </div>
     <div class="p-col-12 p-md-6">
       {{ hero.heroClass.name }}
     </div>

    </div>
</template>

<script>
export default {
  name: "GameView",
  computed: {
    hero() {
      return this.$store.getters.getHero;
    },
  }
}
</script>

<style scoped>

</style>