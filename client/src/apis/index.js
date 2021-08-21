import request from '@/apis/request'


export default {
    "getEstimateById":  async (id) => await request.get(`api/estimate/${id}`),
    "GetEsimate": async (code) => await request.get(`api/estimate/template/${code}`),
    "AddEsimate": async (model) => await request.post(`api/estimate/add`, model),
    "findByPatientId": async (id) => await request.get(`api/estimate/patient/${id}`),
    "listEstimate": async () => await request.get(`api/estimate/list`),


    "AddPatient": async (model) => await request.post(`api/patient/add`, model),
    "GetPatient": async () => await request.get(`api/patient/list`),

}