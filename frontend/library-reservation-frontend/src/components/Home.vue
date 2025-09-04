<template>
  <div class="min-h-screen flex flex-col relative overflow-hidden bg-gradient-to-br from-gray-950 via-gray-900 to-gray-950">
    <!-- Particle Background -->
    <vue-particles
      id="tsparticles"
      :options="particlesOptions"
    />

    <NavBar />

    <section>
      <div class="max-w-6xl mx-auto px-4 py-10 grid grid-cols-1 gap-6 relative z-10">
        <div class="flex items-center gap-6">
          
          <div class="flex-1">
            <div class="relative">
              <input
                v-model="query"
                type="text"
                placeholder="Search for books..."
                class="w-full rounded-lg border border-cyan-400/30 bg-white/5 text-white placeholder:text-white/50 pl-4 pr-28 py-3 focus:outline-none focus:ring-2 focus:ring-cyan-500 focus:border-cyan-500 backdrop-blur"
              />
              <button
                @click="search"
                class="absolute right-2 top-1/2 -translate-y-1/2 px-5 py-2 rounded-lg bg-gradient-to-r from-cyan-500 to-blue-600 hover:from-cyan-400 hover:to-blue-500 text-white text-sm shadow-md shadow-cyan-500/30 transition-all"
              >
                Search
              </button>
            </div>
          </div>
        </div>
      </div>
    </section>

    <main class="flex-1 relative z-10">
      <div class="max-w-6xl mx-auto px-4 py-10 grid grid-cols-1 md:grid-cols-2 gap-8">
        <!-- Popular Books -->
        <div class="rounded-2xl border border-cyan-400/20 bg-gradient-to-br from-cyan-500/10 to-blue-500/10 backdrop-blur-xl p-6 shadow-xl shadow-cyan-500/10 hover:shadow-cyan-400/20 transition-all">
          <h2 class="text-cyan-300 text-xl font-bold mb-6 tracking-wide">Top Popular Books</h2>
          <ul class="space-y-4">
            <li v-for="b in filteredPopular" :key="b.id">
              <button
                @click="goDetail(b.id)"
                class="w-full text-left p-5 rounded-xl border border-white/10 bg-white/5 text-white hover:bg-cyan-500/10 hover:shadow-md hover:shadow-cyan-500/20 transition-all"
              >
                <div class="font-semibold text-lg">{{ b.title }}</div>
                <div class="text-sm text-white/60">{{ b.author }}</div>
              </button>
            </li>
          </ul>
        </div>

        <!-- New Book Recommendations -->
        <div class="rounded-2xl border border-cyan-400/20 bg-gradient-to-br from-blue-500/10 to-purple-500/10 backdrop-blur-xl p-6 shadow-xl shadow-blue-500/10 hover:shadow-blue-400/20 transition-all">
          <h2 class="text-blue-300 text-xl font-bold mb-6 tracking-wide">New Added Books</h2>
          <ul class="space-y-4">
            <li v-for="b in filteredNew" :key="b.id">
              <button
                @click="goDetail(b.id)"
                class="w-full text-left p-5 rounded-xl border border-white/10 bg-white/5 text-white hover:bg-blue-500/10 hover:shadow-md hover:shadow-blue-500/20 transition-all"
              >
                <div class="font-semibold text-lg">{{ b.title }}</div>
                <div class="text-sm text-white/60">{{ b.author }}</div>
              </button>
            </li>
          </ul>
        </div>
      </div>
    </main>
  </div>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue'
import { useRouter } from 'vue-router'
import NavBar from './NavBar.vue'

const particlesOptions = ref({
  background: { color: "transparent" },
  fpsLimit: 60,
  interactivity: {
    events: {
      onHover: { enable: true, mode: "repulse" },
      resize: true
    },
    modes: {
      repulse: { distance: 100, duration: 0.4 }
    }
  },
  particles: {
    color: { value: ["#06b6d4", "#3b82f6", "#a855f7"] }, 
    links: {
      color: "#38bdf8",
      distance: 120,
      enable: true,
      opacity: 0.3,
      width: 1
    },
    move: {
      direction: "none",
      enable: true,
      outModes: { default: "bounce" },
      random: false,
      speed: 1,
      straight: false
    },
    number: { density: { enable: true, area: 800 }, value: 80 },
    opacity: { value: 0.5 },
    shape: { type: "circle" },
    size: { value: { min: 1, max: 4 } }
  },
  detectRetina: true
})

type Book = {
  id: string
  title: string
  author: string
}

const router = useRouter()
const query = ref('')

const popularBooks = ref<Book[]>([
  { id: '1', title: 'The Pragmatic Programmer', author: 'Andrew Hunt' },
  { id: '2', title: 'Clean Code', author: 'Robert C. Martin' },
  { id: '3', title: 'Design Patterns', author: 'Erich Gamma' },
  { id: '4', title: 'Refactoring', author: 'Martin Fowler' },
])

const newBooks = ref<Book[]>([
  { id: '5', title: 'Learning Vue 3', author: 'John Doe' },
  { id: '6', title: 'Modern TypeScript', author: 'Jane Smith' },
  { id: '7', title: 'Advanced Tailwind', author: 'Alex Johnson' },
  { id: '8', title: 'Web Performance 101', author: 'Emily Chen' },
])

const filteredPopular = computed(() =>
  popularBooks.value.filter(b => b.title.toLowerCase().includes(query.value.toLowerCase()))
)
const filteredNew = computed(() =>
  newBooks.value.filter(b => b.title.toLowerCase().includes(query.value.toLowerCase()))
)

function search() {
}

function goDetail(id: string) {
  router.push({ name: 'book-detail', params: { id } })
}
</script>

<style scoped>
</style>
