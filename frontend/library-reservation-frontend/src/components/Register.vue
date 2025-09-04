<template>
  <div class="min-h-screen flex flex-col relative overflow-hidden bg-gradient-to-br from-gray-950 via-gray-900 to-gray-950 text-white">
    <!-- Particle Background -->
    <vue-particles id="tsparticles" :options="particlesOptions" />

    <NavBar />

    <!-- Registration Form -->
    <main class="flex-1 flex items-center justify-center relative z-10 px-4">
      <div class="w-full max-w-md rounded-2xl border border-cyan-400/20 bg-gradient-to-br from-cyan-500/10 to-blue-500/10 backdrop-blur-xl p-8 shadow-xl shadow-cyan-500/10">
        <!-- Title -->
        <h1 class="text-2xl font-bold text-center text-cyan-300 mb-6">Create Account</h1>

        <!-- Form -->
        <form @submit.prevent="register" class="space-y-4">
          <!-- Username -->
          <div>
            <label class="block text-sm mb-1 text-white/70">Username</label>
            <input
              v-model="username"
              type="text"
              placeholder="Enter your username"
              class="w-full rounded-lg border border-cyan-400/30 bg-white/5 text-white placeholder:text-white/50 px-4 py-3 focus:outline-none focus:ring-2 focus:ring-cyan-500 focus:border-cyan-500 backdrop-blur"
              required
            />
          </div>

          <!-- Email -->
          <div>
            <label class="block text-sm mb-1 text-white/70">Email</label>
            <input
              v-model="email"
              type="email"
              placeholder="Enter your email"
              class="w-full rounded-lg border border-cyan-400/30 bg-white/5 text-white placeholder:text-white/50 px-4 py-3 focus:outline-none focus:ring-2 focus:ring-cyan-500 focus:border-cyan-500 backdrop-blur"
              required
            />
          </div>

          <!-- Password -->
          <div>
            <label class="block text-sm mb-1 text-white/70">Password</label>
            <input
              v-model="password"
              type="password"
              placeholder="Enter your password"
              class="w-full rounded-lg border border-cyan-400/30 bg-white/5 text-white placeholder:text-white/50 px-4 py-3 focus:outline-none focus:ring-2 focus:ring-cyan-500 focus:border-cyan-500 backdrop-blur"
              required
            />
          </div>

          <!-- Confirm Password -->
          <div>
            <label class="block text-sm mb-1 text-white/70">Confirm Password</label>
            <input
              v-model="confirmPassword"
              type="password"
              placeholder="Confirm your password"
              class="w-full rounded-lg border border-cyan-400/30 bg-white/5 text-white placeholder:text-white/50 px-4 py-3 focus:outline-none focus:ring-2 focus:ring-cyan-500 focus:border-cyan-500 backdrop-blur"
              required
            />
          </div>

          <!-- Register Button -->
          <button
            type="submit"
            class="w-full mt-4 px-6 py-3 rounded-lg bg-gradient-to-r from-cyan-500 to-blue-600 hover:from-cyan-400 hover:to-blue-500 text-white font-semibold shadow-md shadow-cyan-500/30 transition-all"
          >
            Register
          </button>
        </form>

        <!-- Already have an account -->
        <p class="text-sm text-center text-white/60 mt-6">
          Already have an account?
          <button @click="goLogin" class="text-cyan-400 hover:underline">Login here</button>
        </p>
      </div>
    </main>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import NavBar from './NavBar.vue'

const router = useRouter()

const username = ref('')
const email = ref('')
const password = ref('')
const confirmPassword = ref('')

function register() {
  if (password.value !== confirmPassword.value) {
    alert('Passwords do not match!')
    return
  }
  
  // Register Api

  alert(`Register success!\nUsername: ${username.value}\nEmail: ${email.value}`)
  router.push({ name: 'login' }) 
}

function goLogin() {
  router.push({ name: 'login' })
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
</script>

<style scoped>
</style>
