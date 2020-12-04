package com.gmail.klepikovmichael174.project1

data class TestDataClass(val name: String, val surname: String, val age: Int)

    var people = listOf(TestDataClass("Mikhail", "Rostov", 25),
    TestDataClass("Alexander", "Vlasov", 24),
    TestDataClass("Vasya", "Pupkin", 27),
    TestDataClass("Oleg", "Zhdanov", 37),
    TestDataClass("Evgeniy", "Kozlov", 32))

    fun sort(property: String) {
    people = when(property) {
        "name" -> people.sortedBy(TestDataClass::name)
        "surname" -> people.sortedBy(TestDataClass::surname)
        "age" -> people.sortedBy(TestDataClass::age)
        else -> throw IllegalArgumentException("Error")
    }
}

