// vuex store module
import http from "@/http/http";



export default {
    state: {
        heroes: [],
        hero_classes: [],
        hero: {},
    },
    getters: {
        getHeroes: (state) => state.heroes,
        getHeroClasses: (state) => state.hero_classes,
        getHero: (state) => state.hero,
    },
    mutations: {
        setHeroes(state, heroes) {
            state.heroes = heroes
        },
        setHeroClasses(state, hero_classes) {
            state.hero_classes = hero_classes
        },
        addHero(state, hero) {
            state.heroes.push(hero)
        },
        setHero(state, hero) {
            state.hero = hero
        }
    },
    actions: {
        async fetchHeroes({commit}) {
            await http.get('/HeroJourney/hero/')
                    .then(response => {
                        const heroes = response.data;
                        commit('setHeroes', heroes)
                    })
                    .catch(error => {
                        console.log(error)
                    })
        },
        async fetchHeroClasses({commit}) {
            await http.get('/HeroJourney/hero/hero_class/')
                    .then(response => {
                        const hero_classes = response.data;
                        commit('setHeroClasses', hero_classes)
                    })
                    .catch(error => {
                        console.log(error)
                    })
        },
        async createHero({commit}, hero) {
            await http.post('/HeroJourney/hero/', hero)
                .then(response => {
                    const hero = response.data;
                    commit('addHero', hero)
                    console.log(response)
                })
                .catch(error => {
                    console.log(error)
                })
        },
        selectHero({commit}, hero) {
            commit('setHero', hero)
        }
    }
}