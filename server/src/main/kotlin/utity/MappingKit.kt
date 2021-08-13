package utity

import org.springframework.beans.BeanUtils

object MappingKit {

/*    fun <T> Any.mapper(factory: () -> T) : T {
        val target = factory()
        BeanUtils.copyProperties(this, target!!)

        return target
    }

    fun <T, R> List<T>.mapper(factory: () -> R) : List<R> {
        val result = mutableListOf<R>()

        this.forEach {
            it?.mapper(factory)?.let { it1 ->
                result.add(it1)
            }
        }

        return result
    }*/

    inline fun <reified T> Any.mapper(): T {

        val target: T = T::class.java.newInstance()

        target?.let {
            BeanUtils.copyProperties(this, it)
        }

        return target
    }

    inline fun <T, reified R> List<T>.mapper(): List<R> {
        val results = mutableListOf<R>()

        this.forEach {
            it?.mapper<R>()?.let {it1->
                results.add(it1)
            }
        }

        return results
    }

}