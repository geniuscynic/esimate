package com.xjjxmm.estimate.vo

class AddPatientVo {
    lateinit var name: String
    var gender: Int? = null  //1 男 2 女 0 其他
    var age: Int? = null
}

class PatientVo {
    var id : Long = 0
    lateinit var name : String
    var gender: Int? = null  //1 男 2 女 0 其他
    var age: Int? = null
}

