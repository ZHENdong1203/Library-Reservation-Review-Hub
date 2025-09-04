<template>
  <div class="min-h-screen flex flex-col relative overflow-hidden bg-gradient-to-br from-gray-950 via-gray-900 to-gray-950 text-white">
    <!-- Particle Background -->
    <vue-particles id="tsparticles" :options="particlesOptions" />

    <NavBar />

    <!-- Page body -->
    <main class="flex-1 relative z-10">
      <div class="max-w-6xl mx-auto px-4 py-10 grid grid-cols-1 gap-8">
        <!-- Book Details Card -->
        <div class="rounded-2xl border border-cyan-400/20 bg-gradient-to-br from-cyan-500/10 to-blue-500/10 backdrop-blur-xl p-6 shadow-xl shadow-cyan-500/10">
          <!-- Return to homepage button -->
          <button
            @click="goHome"
            class="absolute top-4 right-4 px-4 py-2 rounded-lg bg-gradient-to-r from-gray-700 to-gray-800 hover:from-cyan-500 hover:to-blue-600 text-white text-sm font-semibold shadow-md shadow-cyan-500/30 transition-all"
          >
            ← Back
          </button>
          
          <div class="flex flex-col md:flex-row gap-6">
            <!-- Book cover on the left -->
            <div class="w-40 h-56 bg-white/10 border border-white/20 rounded-lg flex items-center justify-center text-white/60">
              Book
            </div>

            <!-- Right content -->
            <div class="flex-1 flex flex-col gap-4">
              <!-- Book Title -->
              <h1 class="text-2xl font-bold text-cyan-300">{{ book.title }}</h1>

              <!-- Introduction -->
              <p class="text-white/70">{{ book.introduction }}</p>

              <!-- Tag navigation -->
              <div class="flex gap-4 mt-4">
                <button
                  v-for="tab in tabs"
                  :key="tab"
                  @click="activeTab = tab"
                  class="px-4 py-2 rounded-lg text-sm font-medium transition-all"
                  :class="activeTab === tab 
                    ? 'bg-gradient-to-r from-cyan-500 to-blue-600 text-white shadow-md shadow-cyan-500/30' 
                    : 'bg-white/5 text-white/70 hover:bg-white/10'"
                >
                  {{ tab }}
                </button>
              </div>

              <!-- Tab content -->
              <div class="mt-4 rounded-xl border border-white/10 bg-white/5 p-4">
                <div v-if="activeTab === 'details'" class="space-y-2">
                  <div><span class="font-semibold text-cyan-400">Writer:</span> {{ book.author }}</div>
                  <div><span class="font-semibold text-cyan-400">Publish Year:</span> {{ book.publishYear }}</div>
                  <div><span class="font-semibold text-cyan-400">ISBN:</span> {{ book.isbn }}</div>
                </div>
                <div v-else-if="activeTab === 'reviews'">
                  <p class="text-white/70">No reviews yet...</p>
                </div>
                <div v-else-if="activeTab === 'availability'">
                  <p class="text-white/70">Available: {{ book.available ? 'Yes' : 'No' }}</p>
                </div>
                <div v-else-if="activeTab === 'reserve'">
                  <button
                    @click="reserveBook"
                    class="px-6 py-2 rounded-lg bg-gradient-to-r from-cyan-500 to-blue-600 hover:from-cyan-500 to-blue-600 text-white font-semibold shadow-md shadow-purple-500/30 transition-all"
                  >
                    Reserve Now
                  </button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import NavBar from './NavBar.vue'
import { useRouter } from 'vue-router'

const router = useRouter()

function goHome() {
  router.push({ name: 'home' }) 
}

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

const book = ref({
  title: 'The Pragmatic Programmer',
  introduction: 'A classic book about software craftsmanship and practical programming advice.',
  author: 'Andrew Hunt & David Thomas',
  publishYear: '1999',
  isbn: '978-0201616224',
  available: true
})

const tabs = ['details', 'reviews', 'availability', 'reserve']
const activeTab = ref('details')

function reserveBook() {
  alert('You have reserved this book!')
}
</script>

<style scoped>
</style>
