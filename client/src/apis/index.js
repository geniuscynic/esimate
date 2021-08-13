import request from '@/apis/request'


export default {
    "getEstimateById": (id) => request.get(`api/estimate/${id}`),
    "GetEsimate": (code) => request.get(`api/estimate/template/${code}`),
    "AddEsimate": (model) => request.post(`api/estimate/add`, model),
    "findByPatientId": (id) => request.get(`api/estimate/patient/${id}`),
    "listEstimate": () => request.get(`api/estimate/list`),


    "AddPatient": (model) => request.post(`api/patient/add`, model),
    "GetPatient": () => request.get(`api/patient/list`),

}