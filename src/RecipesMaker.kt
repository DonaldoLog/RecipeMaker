import javafx.beans.binding.When
import java.lang.NumberFormatException
var receta: MutableList<String> =  mutableListOf<String>()

fun main (args: Array<String>) {
    var ingredientes: List<String> = listOf("Agua", "Leche", "Carne", "Verduras", "Frutas", "Cereal", "HUevos", "Aceite")
    val saludo = ":: Bienvenido a Recipe Maker ::"
    var response: Int? = null
    var ingrediente: Int? = null
    println(saludo)
    while (response != 3) {
        makeRecipe()
        try {
            response = readLine()?.toInt()?:0
            when(response) {
                0 -> println("Ingrese una opcion valida(0 para terminar la receta.)")
                1 -> {
                    ingrediente = null
                    println("Ingredientes disponibles:")
                    for ((index, ingrediente) in ingredientes.withIndex()) {
                        println("${index + 1}. ${ingrediente}")
                    }
                    println("0 para salir.")
                    while (ingrediente != 0) {
                        println("Seleccione un ingrediente:")
                        try {
                            ingrediente = readLine()?.toInt()?: 0
                            when(ingrediente){
                                in 1..10 -> {
                                    if (ingrediente != null) {
                                        receta.add(ingredientes[ingrediente.minus(1)])
                                    }
                                }
                                0 -> println("Receta terminada")
                                else -> {
                                    println("Seleccione un ingrediente valido.")
                                }
                            }
                        } catch (e: Throwable){
                            println("Seleccione un ingrediente valido")
                        }
                    }

                }
                2 -> viewRecipe()
                3 -> println("Adios:)")
                else -> {
                    println("Ingrese una opcion valida")
                }
            }
        } catch (e: Throwable) {
            println("Opcion no valida")
        }


    }



}

fun makeRecipe () {
    val opciones: String = """
        Selecciona la opción deseada
        1. Hacer una receta
        2. Ver mi receta
        3. Salir
    """.trimIndent()
    println(opciones)
}

fun viewRecipe() {
    println(receta)
}