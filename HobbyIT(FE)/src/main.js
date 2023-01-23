/**
 * main.js
 *
 * Bootstraps Vuetify and other plugins then mounts the App`
 */

// Components
import App from './App.vue'

// Composables
import { createApp } from 'vue'

// Plugins
import { registerPlugins } from '@/plugins'

import 'v-calendar/dist/style.css';
import { SetupCalendar } from 'v-calendar';
import VCalendar from 'v-calendar';

const app = createApp(App)

registerPlugins(app)

app.mount('#app')
// Use plugin with defaults
app.use(SetupCalendar, {})
app.use(VCalendar, {})