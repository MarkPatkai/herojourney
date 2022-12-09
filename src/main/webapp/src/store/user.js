import http from "@/http/http";

function parseJwt (token) {
    const base64Url = token.split('.')[1];
    const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    const jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function (c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
}

export default {
    state: {
        token: '',
        authority: '',
    },
    getters: {
        getToken: (state) => state.token,
        isLoggedIn: (state) => !!state.token,
        getAuthority: (state) => state.authority,
        isAdmin: (state) => state.authority === 'ROLE_ADMIN' ||
            state.authority === 'ROLE_SUPER_ADMIN' ||
            state.authority === 'ROLE_DEVELOPER',
    },
    mutations: {
        setToken(state, token) {
            state.token = token
        },
        setAuthority(state) {
            state.authority = parseJwt(state.token).roles[0].authority
        }
    },
    actions: {
        async login({commit}, user) {
            await http.post('/HeroJourney/auth/', user)
                    .then(response => {
                        const token = response.data;
                        sessionStorage.setItem('token', token)
                        commit('setToken', token)
                        commit('setAuthority')
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