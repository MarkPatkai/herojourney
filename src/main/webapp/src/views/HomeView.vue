<template>
  <div class="home">
    <h1>Hero Journey</h1>
    <HeroListComponent v-if="isHeroSelection" />
    <HeroCreateComponent v-if="isHeroCreation" />
  </div>
</template>

<script>
import HeroListComponent from "@/components/HeroListComponent";
import HeroCreateComponent from "@/components/HeroCreateComponent";
export default {
  name: "HomeView",
  components: {HeroCreateComponent, HeroListComponent},
  computed: {
    isHeroSelection() {
      return this.$store.getters.getHeroSelection;
    },
    isHeroCreation() {
      return this.$store.getters.getHeroCreation;
    }
  }
}
</script>

<style scoped>

</style>