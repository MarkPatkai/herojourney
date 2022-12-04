// vuex store module
import http from "@/http/http";
import DeveloperConstants from "@/core/DeveloperConstants";

export default {
    state: {
        cols: [],
        data: [],
        title: '',
        devType: '',
    },
    getters: {
        isDeveloper: (state) =>
            state.authority === "ROLE_DEVELOPER" ||
            state.authority === "ROLE_ADMIN" ||
            state.authority === "ROLE_SUPER_ADMIN",
        getCols: (state) => state.cols,
        getData: (state) => state.data,
        getTitle: (state) => state.title,
        getDevType: (state) => state.devType,

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
        },
        setDevType(state, devType) {
            state.devType = devType;
        }
    },
    actions: {
        fetchSpellHeaders({ commit }) {
                http.get("/HeroJourney/developer/spell/headers").then((response) => {
                const data = response.data;
                commit("setCols", data);
                commit("setDevType", DeveloperConstants.HERO_SPELL);
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
                commit("setDevType", DeveloperConstants.ENEMY);
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
        },
        fetchSpellTypeHeaders({ commit }) {
            http.get("/HeroJourney/developer/spellType/headers").then((response) => {
                const data = response.data;
                commit("setCols", data);
                commit("setDevType", DeveloperConstants.SPELL_TYPE);
            });
        },
        fetchSpellTypeData({ commit, dispatch }) {
            dispatch("fetchSpellTypeHeaders");
            commit("setTitle", "Spell Types");
            http.get("/HeroJourney/developer/spellType/")
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
