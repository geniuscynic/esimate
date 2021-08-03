package com.xjjxmm.esimate.repository

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.extension.kotlin.KtQueryChainWrapper
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.baomidou.mybatisplus.extension.toolkit.ChainWrappers
import org.springframework.beans.factory.annotation.Autowired
import java.io.Serializable


//interface BaseDao<T>  {
//    fun insert(entity: T): Boolean
//
//    fun update(entity: T): Boolean
//
//    fun getById(id : Serializable) : T
//
//    //fun <P: Serializable> getByEstimateId(id:P) : T
//
//    //fun listByMap(columnMap: Map<String, Any>): Collection<T>?
//}


abstract class BaseResponse<T  , M : BaseMapper<T>> : ServiceImpl<M, T>() {

//    @Autowired
//    protected lateinit var baseMapper: M
//
//    //@Autowired
//    //protected lateinit var service: ServiceImpl<T>
//
//
//    override fun insert(entity: T): Boolean {
//        return baseMapper.insert(entity) > 0
//
//    }
//
//    override fun update(entity: T): Boolean {
//        return baseMapper.updateById(entity) > 0
//    }
//
//    override fun getById(id : Serializable) : T {
//        return baseMapper.selectById(id)
//    }


//   @Bean
//   fun getServiceImpl() : IService<T> {
//       return ServiceImpl<M,T>()
//   }

   /* override fun <P: Serializable> getByEstimateId(id: P): T {
        return baseMapper.getByEstimateId(id)
    }*/

   /* override fun listByMap(columnMap: Map<String, Any>): Collection<T>? {
        return baseMapper.listByMap(columnMap)
    }*/

}