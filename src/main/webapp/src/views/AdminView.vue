<template>
  <div>
    <h2>Admin Dashboard</h2>
    <DisplayDeveloperComponent />
  </div>
</template>

<script>
import DisplayDeveloperComponent from "@/components/admin/DisplayDeveloperComponent";
export default {
  name: "AdminView",
  components: {DisplayDeveloperComponent},
  watch: {
    // eslint-disable-next-line no-unused-vars
    $route(to, from) {
     if (to.path === "/admin/dev/spell")
      this.$store.dispatch("fetchSpellData");
     if (to.path === "/admin/dev/enemy")
      this.$store.dispatch("fetchEnemyData");
     if (to.path === "/admin/dev/spelltype")
      this.$store.dispatch("fetchSpellTypeData");
    },
  },

}
</script>

<style scoped>

</style>