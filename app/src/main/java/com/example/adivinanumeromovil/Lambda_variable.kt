package org.example

fun main(){
    val mifuncion:(String,Char)->Int={cadena:String,car:Char->

        var num_caracteres=0
        val valor_final=cadena.length
        for(i in 0..valor_final-1)
        {
            if(cadena.get(i)==car) num_caracteres++
        }
       num_caracteres
    }

    println(mifuncion("Hola esto es kotlin",'o'))
}