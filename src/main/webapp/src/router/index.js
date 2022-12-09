import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'

const routes = [
  {
    path: '/',
    name: 'login',
    component: LoginView,
  },
  {
    path: '/home',
    name: 'home',
    component: () => import(/* webpackChunkName: "about" */ '../views/HomeView.vue')
  },
  {
    path: '/game',
    name: 'game',
    component: () => import(/* webpackChunkName: "about" */ '../views/GameView.vue')
  },
  {
    path: '/game/profile',
    name: 'profile',
    component: () => import(/* webpackChunkName: "about" */ '../views/HeroProfileView.vue')
  },
  {
    path: '/admin',
    name: 'admin',
    component: () => import(/* webpackChunkName: "about" */ '../views/AdminView.vue')
  },
  {
    path: '/admin/dev/spell',
    name: 'spell',
    component: () => import(/* webpackChunkName: "about" */ '../views/AdminView.vue')
  },
  {
    path: '/admin/dev/enemy',
    name: 'enemy',
    component: () => import(/* webpackChunkName: "about" */ '../views/AdminView.vue')
  },
  {
  path: '/admin/dev/spelltype',
  name: 'spelltype',
  component: () => import(/* webpackChunkName: "about" */ '../views/AdminView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

router.beforeEach((to, from, next) => {
    if (to.name !== 'login' && !sessionStorage.getItem('token')) next({ name: 'LoginView' })
    else next()
});

export default router
