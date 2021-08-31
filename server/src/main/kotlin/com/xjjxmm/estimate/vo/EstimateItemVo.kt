package com.xjjxmm.estimate.vo

import com.xjjxmm.estimate.model.EstimateTemplate


class SelectedEstimateItem {
    lateinit var code: String
    lateinit var value: String
}

class AddEstimateItemVo {
    var patientId: Long = 0
    lateinit var estimateCode: String
    //lateinit var rfId: String
    var estimatePhase: Int = 0 //1?=null,2?=null,3?=null,4 入院 出院
    lateinit var estimateModule: String //卒中， 血透
    lateinit var data: List<SelectedEstimateItem>
    //var createUserId: Long = 0
}

class EditEstimateItemVo {
    var id : Long = 0
    lateinit var data: List<SelectedEstimateItem>
    //var createUserId: Long = 0
}

class EstimateItemVo {
    var id : Long=0
    var patientId: Long=0
    //var rfId : String?=null,
    var estimatePhase : Int=0 //1?=null,2?=null,3?=null,4 入院 出院
    //lateinit var code: String
    lateinit var detail: EstimateTemplate
    //var content: String?=null,
}

class PatientEstimateItemListVo {
    var id : Long=0
    var patientId: Long=0
    //var rfId : String?=null,
    var estimatePhase : Int=0 //1?=null,2?=null,3?=null,4 入院 出院
    //lateinit var code: String
    lateinit var estimateTitle: String

    lateinit var estimateCode: String

    var estimateScore: Int = 0
    //var content: String?=null,
}


class EstimateItemListVo {

    lateinit var code: String

    lateinit var title: String
}

/*

CREATE TABLE `estimate`.`estimate_item` (
`id` INT NOT NULL AUTO_INCREMENT,
`patient_Id` INT NOT NULL,
`rf_Id` VARCHAR(45) NOT NULL, //暂时注释掉
`estimate_Num` INT NOT NULL,
`estimate_Phase` INT NOT NULL,
`estimate_Module` VARCHAR(45) NOT NULL,
`estimate_Type` VARCHAR(45) NOT NULL,
`content` INT LONGTEXT NOT NULL,
`create_Time` DATE NOT NULL,
`create_User_Id` INT NOT NULL,
`update_Time` DATE NULL,
`update_User_Id` INT NULL,

PRIMARY KEY (`id`));
*/
