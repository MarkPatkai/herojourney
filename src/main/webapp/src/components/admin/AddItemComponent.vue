<template>
  <div>
    <Dialog v-model:visible="display">
      <template #header>
        <h3>Create {{ title }}</h3>
      </template>

      <div class="grid">
        <div class="col" v-for="col in cols" :key="col.name" >
        <span class="p-input-icon-left p-input-icon-right" v-if="col.editable">
            <InputText :id="col.name" v-model="col.value" v-if="!col.complex" />
            <label class="uppercase" :for="col.name">{{ col.name }}</label>
        </span>
        </div>
      </div>

      <template #footer>
        <Button label="Cancel" icon="pi pi-times" class="p-button-text" @click="cancel"/>
        <Button label="Save" icon="pi pi-check" autofocus @click="save"/>
      </template>
    </Dialog>
    <ConfirmDialog></ConfirmDialog>
  </div>
</template>

<script>
import Dialog from 'primevue/dialog';
import InputText from 'primevue/inputtext';
import Button from 'primevue/button';
import ConfirmDialog from 'primevue/confirmdialog';
export default {
  name: "AddItemComponent",
  components: {Dialog, InputText, Button, ConfirmDialog},
  data() {
    return {
    }
  },
  computed:  {
    cols() {
      return this.$store.getters.getCols.filter(col => col.editable);
    },
    title() {
      return this.$store.getters.getTitle;
    },
  },
  methods: {
    cancel() {
      // confirm cancel
      this.$confirm.require({
        message: 'Are you sure you want to cancel?',
        header: 'Confirmation',
        icon: 'pi pi-exclamation-triangle',
        accept: () => {
          this.$emit('close');
        },
        reject: () => {
          // do nothing
        }
      });
    },
    save() {
      // confirm save
      this.$confirm.require({
        message: 'Are you sure you want to save?',
        header: 'Confirmation',
        icon: 'pi pi-exclamation-triangle',
        accept: () => {
         // this.$store.dispatch("saveItem", this.cols);
          this.$emit('close');
        },
        reject: () => {
          // do nothing
        }
      });
    }
  },

}
</script>

<style scoped>
.uppercase {
  text-transform: uppercase;
}
</style>