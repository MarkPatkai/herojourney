
export default {
    state: {
        hero_selection: true,
        hero_creation: false,
        login_screen: false,
    },
    getters: {
        getHeroSelection: (state) => state.hero_selection,
        getHeroCreation: (state) => state.hero_creation,
        isGameView: (state) => state.hero_selection === false
            && state.hero_creation === false
            && state.login_screen === false,
    },
    mutations: {
        setHeroSelection(state, hero_selection) {
            state.hero_selection = hero_selection
        },
        setHeroCreation(state, hero_creation) {
            state.hero_creation = hero_creation
        },
        setLoginScreen(state, login_screen) {
            state.login_screen = login_screen
        }
    },
    actions: {
        hero_selection({commit}, hero_selection) {
            commit('setHeroSelection', hero_selection)
        },
        hero_creation({commit}, hero_creation) {
            commit('setHeroCreation', hero_creation)
        },
        login_screen({commit}, login_screen) {
            commit('setLoginScreen', login_screen)
        }
    }
}