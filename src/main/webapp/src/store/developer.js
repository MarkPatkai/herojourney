// vuex store module
import http from "@/http/http";

export default {
    state: {
        cols: [],
        data: [],
        title: ''
    },
    getters: {
        isDeveloper: (state) =>
            state.authority === "ROLE_DEVELOPER" ||
            state.authority === "ROLE_ADMIN" ||
            state.authority === "ROLE_SUPER_ADMIN",
        getCols: (state) => state.cols,
        getData: (state) => state.data,
        getTitle: (state) => state.title,
    },
    mutations: {
        setData(state, data) {
            state.data = data;
        },
        setCols(state, cols) {
            state.cols = cols;
        },
        setTitle(state, title) {
            state.title = title;
        }
    },
    actions: {
        fetchSpellHeaders({ commit }) {
                http.get("/HeroJourney/developer/spell/headers").then((response) => {
                const data = response.data;
                commit("setCols", data);
            });
        },
        fetchSpellData({ commit, dispatch }) {
            dispatch("fetchSpellHeaders");
            commit("setTitle", "Hero Spells");
            http.get("/HeroJourney/developer/spell/")
                .then((response) => {
                    const data = response.data;
                    commit("setData", data);
                })
                .catch((error) => {
                    console.log(error);
                });
        },
        fetchEnemyHeaders({ commit }) {
            http.get("/HeroJourney/developer/enemy/headers").then((response) => {
                const data = response.data;
                commit("setCols", data);
            });
        },
        fetchEnemyData({ commit, dispatch }) {
            dispatch("fetchEnemyHeaders");
            commit("setTitle", "Enemy Types");
            http.get("/HeroJourney/developer/enemy/")
                .then((response) => {
                    const data = response.data;
                    commit("setData", data);
                })
                .catch((error) => {
                    console.log(error);
                });
        }
    }
};
