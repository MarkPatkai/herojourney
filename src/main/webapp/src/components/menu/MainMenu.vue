<template>
  <div>
    <div v-show="isGameView">
      <Menubar style="max-height:3.5rem; margin-bottom: 2rem;"  :model="items" />
    </div>
    <div v-show="isAdminView" >
      <Menubar style="max-height:3.5rem; margin-bottom: 2rem;" :model="adminItems" />
    </div>
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
        },
        {
          label: "Admin Dashboard",
          icon: "pi pi-fw pi-cog",
          visible: () => this.$store.getters.isAdmin,
          command: () => {
            this.$router.push("/admin");
          },
        }
      ],
      adminItems: [
        {
          label: "Go back to game",
          icon: "pi pi-fw pi-cog",
          command: () => {
            this.$router.push("/game");
          },
        },
        {
          label: "Developer",
          icon: "pi pi-fw pi-cog",
          items: [
            {
              label: "Spell",
              icon: "pi pi-fw pi-cog",
              command: () => {
                this.$router.push("/admin/dev/spell");
              },
            },
            {
              label: "Enemy",
              icon: "pi pi-fw pi-cog",
              command: () => {
                this.$router.push("/admin/dev/enemy");
              },
            },
            {
              label: "Spell Type",
              icon: "pi pi-fw pi-cog",
              command: () => {
                this.$router.push("/admin/dev/spelltype");
              },
            }
          ]
        }
      ]
    }
  },
  computed: {
    isGameView() {
      return this.$route.path === "/game" && !this.isAdminView;
    },
    isAdminView() {
      return this.$route.path.includes("/admin") && !this.isGameView;
    }
  }
}
</script>

<style scoped>

</style>