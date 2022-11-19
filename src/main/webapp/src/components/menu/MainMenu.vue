<template>
  <div>
    <Menu v-if="isGameView" :model="items" />
  </div>
</template>

<script>
import Menu from "primevue/menu";
export default {
  name: "MainMenu",
  components: {
    Menu,
  },
  data() {
    return {
      items: [
        {
          label: "Profile",
          icon: "pi pi-fw pi-user",
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