package com.xjjxmm.esimate.vo

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDate
import java.time.LocalDateTime

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

