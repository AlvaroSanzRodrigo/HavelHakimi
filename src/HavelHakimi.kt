import kotlin.math.abs

class HavelHakimi {

    private fun order(nodes: ArrayList<Int>): ArrayList<Int>{
        nodes.sortDescending()
        return nodes
    }

    private fun checkGreaterOrNegative(nodes: ArrayList<Int>): Boolean{
        var returnable = true
        nodes.forEach {
            if (it < 0 || it > nodes.size)
                returnable = false
        }
        return returnable
    }

    private fun checkOdds(nodes: ArrayList<Int>): Boolean{
        return nodes.filter { it % 2 != 0 }.size % 2 == 0
    }

    private fun subtract(nodes: ArrayList<Int>): ArrayList<Int>{
        if (nodes.size > 1) {

            val longitude = nodes[0] -1
            nodes.removeAt(0)
            if (longitude < nodes.size){
                for (i in 0..longitude) {
                    nodes[i] = nodes[i] - 1
                }
            }

        }
        return  nodes;
    }



    private fun loop(nodes: ArrayList<Int>): Boolean{
        while (order(nodes).sum() > 0 && order(nodes).size != 1){
            subtract(order((nodes)))
        }
        return order(nodes).map { it -> abs(it) }.sum() == 0
    }

    fun checkHavelHakimi(nodes: ArrayList<Int>): Boolean{
        if (!checkGreaterOrNegative(nodes) || !checkOdds(nodes))
            return false
        return loop(nodes)
    }

}

fun main() {

    val havelHakim = HavelHakimi()
    println("Input nodes grades separated with a blank space as in '5 4 3 3 2 2 1 1 1' and press return")
    readLine()?.let { line ->
        if (line.isNotEmpty())
            println( if (havelHakim.checkHavelHakimi(ArrayList(line.split(' ').map { it.toInt() })))  "It's a graph" else "It's not a graph")
        else
            println("Please, input something at least...")
    } ?: println( "Some input error occurred, please rerun again" )

    /*
    println(havelHakim.checkHavelHakim(ArrayList(listOf(5, 4, 3, 3, 2, 2, 1, 1, 1))))           // TRUE
    println(havelHakim.checkHavelHakim(ArrayList(listOf(7, 7, 4, 3, 3, 3, 2, 1))))              // FALSE
    println(havelHakim.checkHavelHakim(ArrayList(listOf(5, 4, 3, 2, 2))))                       // FALSE
    println(havelHakim.checkHavelHakim(ArrayList(listOf(5, 4, 3, 2, 2, 1))))                    // FALSE
    println(havelHakim.checkHavelHakim(ArrayList(listOf(5, 5, 5, 5, 5, 5))))                    // TRUE
    println(havelHakim.checkHavelHakim(ArrayList(listOf(3, 3, 3, 3, 3))))                       // FALSE
    println(havelHakim.checkHavelHakim(ArrayList(listOf(5, 3, 3, 3, 3, 2, 2, 2, 1))))           // TRUE
    println(havelHakim.checkHavelHakim(ArrayList(listOf(6, 3, 3, 3, 3, 2, 2, 2, 2, 1, 1))))     // TRUE
    println(havelHakim.checkHavelHakim(ArrayList(listOf(6, 5, 5, 4, 3, 2, 1))))                 // FALSE
    println(havelHakim.checkHavelHakim(ArrayList(listOf(7, 6, 5, 4, 4, 3, 2, 1))))              // TRUE
    */
}