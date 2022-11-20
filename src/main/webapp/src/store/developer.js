// vuex store module
// import http from "@/http/http";


export default {
    state: {

    },
    getters: {
        isDeveloper: (state) =>
            state.authority === "ROLE_DEVELOPER" ||
            state.authority === "ROLE_ADMIN" ||
            state.authority === "ROLE_SUPER_ADMIN",
    },
    mutations: {

    },
    actions: {

    }
}