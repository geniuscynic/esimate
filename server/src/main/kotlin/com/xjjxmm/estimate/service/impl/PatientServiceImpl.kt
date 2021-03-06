package com.xjjxmm.estimate.service.impl

import com.xjjxmm.estimate.repository.PatientRepository
import com.xjjxmm.estimate.repository.pojo.PatientEntity
import com.xjjxmm.estimate.service.PatientService
import com.xjjxmm.estimate.vo.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import utity.MappingKit.mapper
import java.time.LocalDateTime

@Service
class PatientServiceImpl : PatientService {

    @Autowired
    lateinit var patientRepository: PatientRepository

    override fun add(patientVo: AddPatientVo): Long {
        val patientEntity = patientVo.mapper<PatientEntity>()
        patientEntity.createTime = LocalDateTime.now()
        patientEntity.createUserId = 0

        patientRepository.save(patientEntity)

        return patientEntity.id?:-1
    }

    override fun save(patientVo: PatientVo): Boolean {
        val patientEntity = patientVo.mapper<PatientEntity>()
        patientEntity.createTime = LocalDateTime.now()
        patientEntity.createUserId = 0

        return patientRepository.save(patientEntity)
    }

    override fun getById(id: Long): PatientVo {
        val patient = patientRepository.getById(id)

        return patient.mapper()
    }

    override fun listPatient(): List<PatientVo> {
        val patients = patientRepository.list()
        return patients.mapper()
    }
}