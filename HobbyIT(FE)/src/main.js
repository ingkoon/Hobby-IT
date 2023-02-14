/**
 * main.js
 *
 * Bootstraps Vuetify and other plugins then mounts the App`
 */

// Components
import App from './App.vue';

// Composables
import { createApp, markRaw } from 'vue';
import { createPinia } from 'pinia';
// Plugins
import { registerPlugins } from '@/plugins';
import VueVirtualScroller, { DynamicScroller, DynamicScrollerItem } from 'vue-virtual-scroller';

import 'v-calendar/dist/style.css';
import { SetupCalendar } from 'v-calendar';
import VCalendar from 'v-calendar';
import router from '@/router';
import 'vue-virtual-scroller/dist/vue-virtual-scroller.css';

const pinia = createPinia();

const app = createApp(App);

registerPlugins(app);
app.use(pinia);
app.use(router);
app.mount('#app');
// Use plugin with defaults
app.use(SetupCalendar, {});
app.use(VCalendar, {});
app.use(VueVirtualScroller);
