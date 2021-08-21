import Vue from 'vue'
import Vuex from 'vuex'
import api from "@/apis";

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    patientId: "",
  },
  mutations: {
    setPatientId(state, id) {
      state.patientId = id
    },
   
  },
  actions: {
    async GetPatient({commit} ) { 
      let res = await api.GetPatient()
      
      commit("getPatient", res.data);
  }
  },
  modules: {
  }
})
