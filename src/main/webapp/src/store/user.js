import http from "@/http/http";


export default {
    state: {
        token: ''
    },
    getters: {
        getToken: (state) => state.token,
        isLoggedIn: (state) => !!state.token
    },
    mutations: {
        setToken(state, token) {
            state.token = token
        }
    },
    actions: {
        async login({commit}, user) {
            await http.post('/HeroJourney/auth/', user)
                    .then(response => {
                        const token = response.data;
                        sessionStorage.setItem('token', token)
                        commit('setToken', token)
                    })
                    .catch(error => {
                        sessionStorage.removeItem('token')
                        console.log(error)
                    })
        }
    },
    modules: {
    }
}