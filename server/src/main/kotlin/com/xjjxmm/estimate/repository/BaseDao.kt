package com.xjjxmm.estimate.repository

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl


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