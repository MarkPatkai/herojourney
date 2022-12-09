import { createStore } from 'vuex'
import user from './user'
import heroes from "@/store/heroes";
import view from "@/store/view";
import developer from "@/store/developer";
import admin from "@/store/admin";

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
    view,
    developer,
    admin
  }
})
