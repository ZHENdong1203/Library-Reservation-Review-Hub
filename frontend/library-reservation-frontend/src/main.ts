import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from './router'
import Particles from '@tsparticles/vue3'
import { loadFull } from 'tsparticles'

const app = createApp(App)

app
  .use(router)
  .use(Particles, {
    init: async (engine) => {
      await loadFull(engine)
    },
  })
  .mount('#app')
