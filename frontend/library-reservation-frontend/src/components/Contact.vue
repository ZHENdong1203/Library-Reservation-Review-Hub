<template>
  <div class="min-h-screen flex flex-col relative overflow-hidden bg-gradient-to-br from-gray-950 via-gray-900 to-gray-950 text-white">
    <!-- Particle Background -->
    <vue-particles id="tsparticles" :options="particlesOptions" />

    <NavBar />

    <!-- Page body -->
    <main class="flex-1 relative z-10">
      <div class="max-w-4xl mx-auto px-4 py-16 flex flex-col items-center gap-10">
        <!-- Title -->
        <h1
        class="text-xl sm:text-2xl md:text-3xl font-bold text-cyan-300 tracking-wide break-words text-center"
        >
        ELEC5619_Practical02_Group_1
        </h1>
        <!-- Member Card -->
        <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-6 w-full">
          <div
            v-for="(member, index) in teamMembers"
            :key="index"
            class="rounded-xl border border-cyan-400/20 bg-gradient-to-br from-cyan-500/10 to-blue-500/10 backdrop-blur-xl p-6 shadow-lg shadow-cyan-500/10 hover:shadow-cyan-400/20 transition-all flex items-center justify-center"
          >
            <span class="text-lg font-semibold text-white">{{ member }}</span>
          </div>
        </div>

        <!-- GitHub Button -->
        <button
          @click="goGithub"
          class="mt-10 px-8 py-3 rounded-lg bg-gradient-to-r from-cyan-500 to-blue-600 hover:from-cyan-500 to-blue-600 text-white text-lg font-semibold shadow-md shadow-purple-500/30 transition-all"
        >
          Visit GitHub
        </button>
      </div>
    </main>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import NavBar from './NavBar.vue'

const teamMembers = ref([
  'Yoyo Jin',
  'Tianlang Liu',
  'Zeyi Xu',
  'Shu Yang',
  'Zhendong Yang'
])

const particlesOptions = ref({
  background: { color: 'transparent' },
  fpsLimit: 60,
  interactivity: {
    events: { onHover: { enable: true, mode: 'repulse' }, resize: true },
    modes: { repulse: { distance: 100, duration: 0.4 } }
  },
  particles: {
    color: { value: ['#06b6d4', '#3b82f6', '#a855f7'] },
    links: { color: '#38bdf8', distance: 120, enable: true, opacity: 0.3, width: 1 },
    move: { enable: true, speed: 1, outModes: { default: 'bounce' } },
    number: { value: 80, density: { enable: true, area: 800 } },
    opacity: { value: 0.5 },
    shape: { type: 'circle' },
    size: { value: { min: 1, max: 4 } }
  },
  detectRetina: true
})

function goGithub() {
  window.open('https://github.sydney.edu.au/2025S2-Object-Oriented-App-Frameworks/ELEC5619_Practical02_Group_1', '_blank')
}
</script>

<style scoped>
</style>
