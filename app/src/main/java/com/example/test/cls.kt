package com.example.test

data class db(var name:String, var age:Int, var rollnumber: Int)

class Student() {
    var students = mutableListOf<db>()
    fun add_details(name:String, age:Int, rollnumber: Int){
        val details = db(name,age,rollnumber)
        students.add(details)
        println("Student added")
    }

    fun remove_student(roll_number: Int){
        for(getinfo in students){
            if(getinfo.rollnumber == roll_number){
                students.remove(getinfo)
                println("Student removed")
            }
        }
    }

    fun findStudent(name: String): String {
        for (student in students) {
            if (student.name.contains(name, ignoreCase = true)) {
                return """
                Student name      : ${student.name}
                Student age       : ${student.age}
                Student roll no  : ${student.rollnumber}
            """.trimIndent()
            }
        }
        return "❌ Student not found."
    }
}

fun main(){
    val c = Student()
    c.add_details("Mohamed",18,12345)
    c.add_details("Mohamed azim",18,12245)
    c.add_details("mohamed hasan",18,20009)
    val getstudent: String = c.findStudent("Mohamed hasan")
    println(getstudent)
}