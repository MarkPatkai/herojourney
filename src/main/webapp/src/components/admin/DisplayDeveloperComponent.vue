<template>
  <div>
    <DataTable>
      <template #header>
        <div class="table-header">
          {{ title }}
          <Button icon="pi pi-plus" @click="addItem"/>
        </div>
      </template>
      <Column class="uppercase" v-for="col in cols" :field="col.name"
              :header="col.name" :key="col.name">
        <Row v-for="row in data" :key="row.id">
          <InputText v-if="col.editable" v-model="row[col.name]" />
        </Row>
      </Column>
    </DataTable>
    <AddItemComponent @close="showAddItem = false" v-model:visible="showAddItem"/>
  </div>
</template>

<script>
import DataTable from 'primevue/datatable';
import Column from 'primevue/column';
import Row from 'primevue/row';
import InputText from 'primevue/inputtext';
import Button from 'primevue/button';
import AddItemComponent from "@/components/admin/AddItemComponent";
export default {
  name: "DisplayDeveloperComponent",
  components: {AddItemComponent, DataTable, Column, Row, InputText, Button},
  data() {
    return {
      showAddItem: false,
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
      this.showAddItem = true;
    },
  },
}
</script>

<style scoped>
.uppercase {
  text-transform: uppercase;
}
</style>