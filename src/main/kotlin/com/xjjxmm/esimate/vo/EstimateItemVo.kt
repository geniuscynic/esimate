package com.xjjxmm.esimate.vo


import org.joda.time.DateTime

class AddEstimateItemVo(
    var patientId: Int?=null,
    var rfId : String?=null,
    var estimatePhase : Int?=null, //1?=null,2?=null,3?=null,4 入院 出院
    var estimateModule : String?=null, //卒中， 血透
    var content: String?=null,
    var createUserId: Long?=null,

    )

class EstimateItemVo(
   
    var id : Long?=null,
    var patientId: Int?=null,
    var rfId : String?=null,
    var estimatePhase : Int?=null, //1?=null,2?=null,3?=null,4 入院 出院
    var content: String?=null,
    var createTime : DateTime?=null,
    var createUserId: Long?=null,
    var updateTime : DateTime?=null,
    var updateUserId: Long?=null,

    ) {

}

/*

CREATE TABLE `estimate`.`estimate_item` (
`id` INT NOT NULL AUTO_INCREMENT,
`patient_Id` INT NOT NULL,
`rf_Id` VARCHAR(45) NOT NULL,
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
