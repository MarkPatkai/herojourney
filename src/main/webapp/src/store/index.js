import { createStore } from 'vuex'
import user from './user'
import heroes from "@/store/heroes";
import view from "@/store/view";

export default createStore({
  state: {
  },
  getters: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    user,
    heroes,
    view
  }
})
