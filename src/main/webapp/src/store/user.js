import http from "@/http/http";


export default {
    state: {
        token: ''
    },
    getters: {
        getToken: (state) => state.token
    },
    mutations: {
        setToken(state, token) {
            state.token = token
        }
    },
    actions: {
        login({commit}, user) {
            return new Promise((resolve, reject) => {
                http.post('/HeroJourney/auth/', user)
                    .then(response => {
                        const token = response.data.token
                        localStorage.setItem('token', token)
                        commit('setToken', token)
                        resolve(response)
                    })
                    .catch(error => {
                        localStorage.removeItem('token')
                        reject(error)
                    })
            });
        }
    },
    modules: {
    }
}