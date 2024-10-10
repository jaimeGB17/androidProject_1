package org.example

import kotlin.math.pow

fun main() {

    val funcion_buscar: String.(String, Int) -> Boolean = { cad, pos: Int ->
        var encontrado = false
        var ind = pos
        var ind2 = pos
        do {
            ind2 = 0
            do {
                encontrado = (this.get(ind++) == cad.get(ind2++))
            } while ((ind2 < cad.length) && (encontrado))
        } while ((ind < this.length) && !encontrado)
        encontrado
    }
    //Ejercicio

    //   cadena padre  cadena a buscar
    val funcion_buscar2: (String, String, Int) -> Boolean = { cadena, cadenaBuscar, pos: Int ->
        var encontrado = false
        var ind = pos
        var ind2 = pos
        do {
            ind2 = 0
            do {
                encontrado = (cadena.get(ind++) == cadenaBuscar.get(ind2++))
            } while ((ind2 < cadenaBuscar.length) && (encontrado))
        } while ((ind < cadena.length) && !encontrado)
        encontrado
    }

    //Ejercicio 2

    val buscar: String.(c: Char) -> Int = { caracter: Char ->
        var cont: Int = 0
        for (i in 0..(this.length - 1)) {
            if (caracter == this.get(i)) cont++
        }
        cont
    }
    //Ejercicio.- Representa la misma función pero con 3 parametros
    //Ejercicio2.- Diseña una función que extienda de Stringa, como expresión lambda
    // que devuelva el número de veces que aparece un caracter en la cadena pasada
    //como parametro

    println("Hola mundo".funcion_buscar("do", 2))
    println(funcion_buscar2("viva Franco", "viva", 0))
    println("Hola mundo".buscar('d'))
    println("----------------------------------------------------------------------")

    // comprobar que el numero dado es primo
    val compruebaPrimo: (Int) -> Boolean = { num ->
        var contDivisores = 0;
        for (i in 1..num) {
            if (num % i == 0) contDivisores++
        }
        contDivisores <= 2
    }
    var num = 4
    println("¿El número " + num + " es primo? " + compruebaPrimo(num))

    // comprobar si el numero dado es magico
    val compruebaMagico: (Int) -> Boolean = { num: Int ->
        var cubo = Math.pow(num.toDouble(), 3.0).toInt()
        var numToText = cubo.toString()
        var magicNum: Int = 0;
        for (i in 0..(numToText.length - 1)) {
            magicNum += numToText.get(i).toString().toInt()
        }
        magicNum == num
    }
    var num2 = 17
    println("¿El número " + num2 + " es magico? " + compruebaMagico(num2))

    // comprueba si el numero dado es capicua
    val compruebaCapicua: (Int) -> Boolean = { num: Int ->
        var numToText = num.toString()
        var reverse = numToText.reversed()
        numToText == reverse
    }
    var num3 = 123
    println("¿El número " + num3 + " es capicua? " + compruebaCapicua(num3))


}