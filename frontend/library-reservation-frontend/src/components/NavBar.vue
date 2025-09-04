<script setup lang="ts">
import { ref } from 'vue'

const menuOpen = ref(false)
</script>

<template>
  <header class="sticky top-0 z-20 backdrop-blur bg-black/20 border-b border-white/10">
    <div class="max-w-6xl mx-auto px-4 h-14 flex items-center justify-between">
      <!-- Left navigation -->
      <div class="hidden md:flex items-center gap-3">
        <router-link to="/" class="px-3 py-1 rounded border border-white/20 bg-white/10 hover:bg-white/15">home</router-link>
        <router-link to="/contact" class="px-3 py-1 rounded border border-white/20 bg-white/10 hover:bg-white/15">contact</router-link>
      </div>

      <!-- Middle Title -->
      <div class="hidden md:flex items-center gap-2">
        <div class="h-8 w-8 rounded bg-gradient-to-tr from-tech-500 to-tech-700 shadow" />
        <span class="text-white/90 font-semibold tracking-wide">Library Reservation & Review Hub</span>
      </div>

      <!-- Login and register on the right -->
      <div class="hidden md:flex items-center gap-2 text-sm">
        <router-link to="#" class="px-3 py-1 rounded border border-white/20 bg-white/10 hover:bg-white/15 text-white/90">log in</router-link>
        <span class="text-white/70">|</span>
        <router-link to="/register" class="px-3 py-1 rounded border border-white/20 bg-white/10 hover:bg-white/15 text-white/90">register</router-link>
      </div>

      <!-- Small screen menu button -->
      <button class="md:hidden text-white" @click="menuOpen = !menuOpen">☰</button>
    </div>

    <!-- Expanded menu on small screen -->
    <div v-if="menuOpen" class="md:hidden px-4 pb-3 space-y-2 bg-black/30">
      <router-link to="/" class="block py-2 text-white/80 hover:text-white">home</router-link>
      <router-link to="/contact" class="block py-2 text-white/80 hover:text-white">contact</router-link>
      <div class="pt-2 border-t border-white/10" />
      <router-link to="#" class="block py-2 text-white/80 hover:text-white">log in</router-link>
      <router-link to="/register" class="block py-2 text-white/80 hover:text-white">register</router-link>
    </div>
  </header>
</template>
