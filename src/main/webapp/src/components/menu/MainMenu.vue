<template>
  <div>
    <Menubar style="max-height:3.5rem; margin-bottom: 2rem;" v-if="isGameView" :model="items" />
  </div>
</template>

<script>
import Menubar from "primevue/menubar";
export default {
  name: "MainMenu",
  components: {
    Menubar,
  },
  data() {
    return {
      items: [
        {
          label: "Game",
          icon: "pi pi-fw pi-file",
          visible: () => this.$route.path !== "/game",
          command: () => this.$router.push("/game"),
        },
        {
          label: "Profile",
          icon: "pi pi-fw pi-user",
          command: () => {
            this.$router.push("/game/profile");
          },
        },
        {
          label: "Hero Selection",
          icon: "pi pi-fw pi-users",
          command: () => {
            this.$store.dispatch("hero_selection", true);
            this.$store.dispatch("hero_creation", false);
            this.$store.dispatch("selectHero", null);
            this.$router.push("/home");
          },
        }
      ]
    }
  },
  computed: {
    isGameView() {
      return this.$store.getters.isGameView;
    },
  }
}
</script>

<style scoped>

</style>