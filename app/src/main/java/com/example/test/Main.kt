package com.example.test

fun main(){
    var Current_score: Int = 0
    print("1.The main part of the computer : ")
    val q1: String = readln().lowercase()
    print("2.My mobile name : ")
    val q2: String = readln().lowercase()
    print("3.My Ups name : ")
    val q3: String = readln().lowercase()

    val status: Boolean = (q1.isEmpty() || q2.isEmpty() || q3.isEmpty())
    if(status) print("fill all fields and try again")
    if(status == false) {
        if (q1.equals("cpu")) {
            Current_score++
        }
        if (q2.equals("poco")) {
            Current_score++
        }
        if (q3.equals("zebronics")) {
            Current_score++
        }
        when(Current_score) {
            1 -> print("Low score")
            2 -> print("Good score")
            3 -> print("Excellent")
        }

    }

}