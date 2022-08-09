class TicTacToe {
    val data = MutableList(3) { mutableListOf<Char>() }

    fun addMoves (input: String) {
        for (i in 0 until input.length) {
            this.data[i/3].add(input[i])
        }
    }
    fun print() {
        println("-".repeat(9))
        data.forEach { println("| ${it.joinToString(" ")} |") }
        println("-".repeat(9))
    }
}