<template>
  <div v-if="cols">
    <DataTable :value="data">
      <template #header>
        <div class="table-header">
          {{ title }}
          <Button icon="pi pi-plus" @click="addItem"/>
        </div>
      </template>
      <Column class="uppercase" v-for="col in cols" :field="col.name"
              :header="col.name" :key="col.name">
          <div>
            <span v-if="col.complex">
              {{ data[col.name].name }}
            </span>
            <span v-else>
              {{ data[col.name] }}
            </span>
          </div>
      </Column>
    </DataTable>
    <AddItemComponent />
  </div>
</template>

<script>
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';
import Button from 'primevue/button';
import AddItemComponent from "@/components/admin/AddItemComponent";
export default {
  name: "DisplayDeveloperComponent",
  components: {AddItemComponent, DataTable, Column, Button},
  data() {
    return {
    }
  },
  computed: {
    title() {
      return this.$store.getters.getTitle;
    },
    cols() {
      return this.$store.getters.getCols;
    },
    data() {
      return this.$store.getters.getData;
    },
  },
  methods: {
    addItem() {
      debugger
      this.$store.dispatch("openDialog");
    },
  },
}
</script>

<style scoped>
.uppercase {
  text-transform: uppercase;
}
</style>