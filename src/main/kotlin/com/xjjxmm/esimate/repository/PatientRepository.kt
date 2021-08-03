package com.xjjxmm.esimate.repository

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.extension.service.IService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.xjjxmm.esimate.repository.mapper.EstimateItemMapper
import com.xjjxmm.esimate.repository.mapper.PatientMapper
import com.xjjxmm.esimate.repository.pojo.EstimateItemEntity
import com.xjjxmm.esimate.repository.pojo.PatientEntity
import com.xjjxmm.esimate.service.EstimateTemplateParseHandler
import com.xjjxmm.esimate.vo.EstimateTemplate
import org.springframework.core.io.DefaultResourceLoader
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.PathVariable
import javax.xml.parsers.SAXParserFactory

@Repository
class PatientRepository : BaseResponse<PatientEntity, PatientMapper>() {
}