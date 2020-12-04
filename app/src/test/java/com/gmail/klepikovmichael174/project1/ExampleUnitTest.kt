package com.gmail.klepikovmichael174.project1

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun start() {
        sort("name")
        println("First sorting by name")
        println(people)
        sort("surname")
        println("Second sorting by surname")
        println(people)
        sort("age")
        println("Third sorting by age")
        println(people)
    }

}