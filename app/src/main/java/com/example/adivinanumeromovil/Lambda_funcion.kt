package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*val mifuncion:(String,Char)->Int=fun(cadena:String,c:Char):Int{
        var num_caracteres=0
        val valor_final=cadena.length
        for(i in 0..valor_final-1)
        {
            if(cadena.get(i)==c) num_caracteres++
        }
        return num_caracteres
    }
    */
    val mifuncion: (String, Char) -> Int
            = { cadena: String, c: Char ->
        var num_caracteres = 0
        val valor_final = cadena.length
        for (i in 0..valor_final - 1) {
            if (cadena.get(i) == c) num_caracteres++
        }
        num_caracteres
    }
    println("Introduce una cadena")
    var cad: String = readln()
    println("Introduce un caracter y te dire cuantas veces aparece ese caracter en la cadena")
    var car: Char = readln().get(0)
    println("Las veces que aparece $car en $cad es: ${mifuncion(cad, car)}")
}