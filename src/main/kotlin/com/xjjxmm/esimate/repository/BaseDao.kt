package com.xjjxmm.esimate.repository

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.extension.service.IService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import java.io.Serializable




/*interface BaseDao<T> : IService<T> {
    fun insert(entity: T): Boolean

    fun update(entity: T): Boolean

    //fun <P: Serializable> getById(id:P) : T

    //fun listByMap(columnMap: Map<String, Any>): Collection<T>?
}*/

abstract class BaseResponse<T, M : BaseMapper<T>> : ServiceImpl<M, T>() {

    /*override fun insert(entity: T): Boolean {
        return this.save(entity)
    }

    override fun update(entity: T): Boolean {
        return this.updateById(entity)
    }*/

   /* override fun <P: Serializable> getById(id: P): T {
        return baseMapper.getById(id)
    }*/

   /* override fun listByMap(columnMap: Map<String, Any>): Collection<T>? {
        return baseMapper.listByMap(columnMap)
    }*/

}