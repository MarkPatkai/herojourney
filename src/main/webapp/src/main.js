import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import PrimeVue from 'primevue/config';
import ToastService from 'primevue/toastservice';
import Tooltip from 'primevue/tooltip';
import ConfirmationService from 'primevue/confirmationservice';


createApp(App)
    .use(store)
    .use(router)
    .use(PrimeVue)
    .use(ConfirmationService)
    .use(ToastService)
    .directive('tooltip', Tooltip)
    .mount('#app')
