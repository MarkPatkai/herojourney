<template>
  <div>
    <form>
      <InputText v-model="hero.name" placeholder="Name" />
      <Dropdown v-model="hero.heroClass" :options="heroClasses" optionLabel="name"  placeholder="Hero Class" />
      <Button label="Create Hero" @click="createHero" />
    </form>
  </div>
</template>

<script>
import Dropdown from "primevue/dropdown";
import InputText from "primevue/inputtext";
import Button from "primevue/button";
export default {
  name: "HeroCreateComponent",
  components: {
    InputText,
    Dropdown,
    Button,
  },
  data() {
    return {
      hero: {
        name: "",
        heroClass: "",
      },
    }
  },
  mounted() {
    this.$store.dispatch("fetchHeroClasses");
  },
  methods: {
  createHero() {
        this.$store.dispatch("createHero", this.hero);
        this.$store.dispatch("hero_creation", false);
        this.$store.dispatch("hero_selection", true);
      },
    },
  computed: {
    heroClasses() {
      return this.$store.getters.getHeroClasses;
    },
  },
}
</script>

<style scoped>

</style>