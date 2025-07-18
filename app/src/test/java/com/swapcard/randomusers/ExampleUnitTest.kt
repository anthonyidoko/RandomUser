package com.swapcard.randomusers

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val map = LinkedHashSet<Int>()
        map.add(1)
        map.add(2)
        map.add(3)
        map.add(1)
        println(map)
        assertEquals(4, 2 + 2)
    }
}