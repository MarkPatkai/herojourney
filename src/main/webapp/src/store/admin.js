// vuex store module
// import http from "@/http/http";


export default {
    state: {

    },
    getters: {
        isAdminOnly: (state) => state.authority === "ROLE_ADMIN" || state.authority === "ROLE_SUPER_ADMIN",
    },
    mutations: {

    },
    actions: {

    }
}