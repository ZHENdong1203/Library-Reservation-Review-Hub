import { createRouter, createWebHashHistory } from 'vue-router'
import Home from '../components/Home.vue'
import BookDetail from '../components/BookDetail.vue'
import Contact from '../components/Contact.vue'
import Register from '../components/Register.vue'

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    { path: '/', name: 'home', component: Home },
    { path: '/book/:id', name: 'book-detail', component: BookDetail, props: true },
    {
    path: '/contact',
    name: 'Contact',
    component: Contact
  },
  {
    path: '/register',
    name: 'Register',
    component: Register
  }
  ],
  scrollBehavior() {
    return { top: 0 }
  }
})

export default router
