class TicTacToe {
    val data = MutableList(3) { MutableList(3) {""} }

    fun print() {
        data.forEach { println(it.joinToString(" ")) }
    }
}