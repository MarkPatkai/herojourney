<template>
  <div class="grid p-justify-center">
    <div class="col-3">
      <div class="col-2 shadow-5">
        <div class="p-dock-left">
            {{ purse.gold ?? 0 }}
        </div>
        <div class="p-dock-right">
          <img class="currency-image" src="@/assets/gold_icon.png" alt="coin"  />
        </div>
      </div>
    </div>
    <div class="col-3">
      <div class="col-2 shadow-5">
        <div class="p-dock-left">
            {{ purse.crystal ?? 0}}
        </div>
        <div class="p-dock-right">
          <img class="currency-image" src="@/assets/crystal_icon.png" alt="coin"  />
        </div>
      </div>
    </div>
    <div class="col-3">
      <div class="col-2 shadow-5">
        <div class="p-dock-left">
            {{ purse.heavenCoin ?? 0}}
        </div>
        <div class="p-dock-right">
          <img class="currency-image" src="@/assets/coin_icon.jpg" alt="coin"  />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "CurrencyComponent",
  computed: {
    purse() {
      return this.$store.getters.getHeroPurse;
    },
  },
}
</script>

<style scoped>
.currency-image {
  width: 25px;
  height: 25px;
}
.p-justify-center{
  justify-content: center;
}
</style>