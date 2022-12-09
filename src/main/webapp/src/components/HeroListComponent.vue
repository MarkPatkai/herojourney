<template>
  <div class="p-grid">
    <Carousel :value="heroes">
      <template #header>
        <h1>Your heroes: </h1>
      </template>
      <template #item="slotProps">
        <div class="p-grid" @click="selectHero(slotProps.data)">
          <div class="p-col">
            <h2 v-if="slotProps.data?.id === 0">{{slotProps.data?.name}}</h2>
            <h2 v-else>{{slotProps.data?.name}} - ({{slotProps.data?.heroClass?.name}}[{{slotProps.data?.level}}])</h2>
          </div>
          <div class="p-col" v-if="slotProps.data?.id === 0">
            <i style="font-size: 10em;" class="fas fa-plus"></i>
          </div>
          <div class="p-col" v-if="slotProps.data?.id !== 0">
            <img v-if="slotProps.data.heroClass?.name === 'Warrior'" src="../assets/warrior.jpg" />
            <img v-if="slotProps.data.heroClass?.name === 'Mage'" src="../assets/mage.jpg" />
            <img v-if="slotProps.data.heroClass?.name === 'Rogue'" src="../assets/rogue.jpg" />
            <img v-if="slotProps.data.heroClass?.name === 'Paladin'" src="../assets/paladin.jpg" />
          </div>
          <div class="p-col">
            <Button v-if="slotProps.data?.id !== 0" icon="pi pi-trash" class="p-button-rounded p-button-danger" @click="deleteHero(slotProps.data?.id)"></Button>
          </div>

        </div>
      </template>
    </Carousel>
    <div v-if="loading" class="loading">
      <ProgressSpinner />
    </div>
  </div>
</template>

<script>
//primevue carousel
import Carousel from 'primevue/carousel';
import Button from 'primevue/button';
import ProgressSpinner from 'primevue/progressspinner';
export default {
  name: "HeroListComponent",
  data() {
    return {
      loading: true,
    };
  },
  components: {
    Carousel,
    Button,
    ProgressSpinner,
  },
  methods: {
    selectHero(hero) {
      if (hero.id === 0) this.createHero();
      else {
        this.$store.dispatch("selectHero", hero);
        this.$store.dispatch("hero_selection", false);
        this.$store.dispatch("hero_creation", false);
        this.$router.push('/game');
      }
    },
    createHero() {
      this.$store.dispatch("hero_creation", true);
      this.$store.dispatch("hero_selection", false);
    },
  },
  mounted() {
    this.$store.dispatch('fetchHeroes');
    this.heroes = this.$store.getters.getHeroes;
    this.loading = false;
  },
  watch: {
    heroes: function (val) {
      if (val.length > 0) {
        this.loading = false;
      }
    }
  },
  computed: {
    heroes() {
      return [{id: 0, name: 'Add Hero'}, ...this.$store.getters.getHeroes];
    }
  }


}
</script>

<style scoped>
.loading {
  position: fixed;
  z-index: 999;
  height: 2em;
  width: 2em;
  margin: auto;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
}
</style>