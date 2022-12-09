<template>
   <div class="p-grid p-justify-center">
     <HeadsUpDisplayComponent />
      <div class="p-col-12 p-md-6">
          {{hero.name}} - ({{hero.level}})
      </div>
     <div class="p-col-12 p-md-6">
       {{ hero.heroClass.name }}
     </div>

    </div>
</template>

<script>
import HeadsUpDisplayComponent from "@/components/game/HeadsUpDisplayComponent";
export default {
  name: "GameView",
  components: {HeadsUpDisplayComponent},
  async mounted() {
    await this.$store.dispatch("fetchHeroPurse", this.hero);
  },
  computed: {
    hero() {
      return this.$store.getters.getHero;
    },
  }
}
</script>

<style scoped>

</style>