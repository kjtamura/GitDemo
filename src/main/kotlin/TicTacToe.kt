class TicTacToe {
    val data = MutableList(3) { mutableListOf<Char>() }
    val horizontal = MutableList<Int>(3) {0}
    val vertical = MutableList<Int>(3) {0}
    var diag = 0
    var antiDiag = 0
    var notFinished = false

    fun addMoves (input: String) {
        for (i in 0 until input.length) {
            val player = input[i]
            val row = i / 3
            val col = i % 3
            val res = when (player) {
                'X' -> 1
                'O' -> -1
                else ->  {
                    notFinished = true
                    0
                }
            }
            horizontal[row] += res
            vertical[col] += res
            if (row == col) {
                diag += res
            }
            if (row + col == 2) {
                antiDiag += res
            }

            this.data[i/3].add(player)
        }
    }

    fun printRes() {
        val horizontalMax = horizontal.maxOrNull()
        val horizontalMin = horizontal.minOrNull()
        val verticalMax = vertical.maxOrNull()
        val verticalMin = vertical.minOrNull()

        when {
            horizontal.sum() > 1  || horizontal.sum() < -1 || (horizontalMax == 3 && horizontalMin == -3) || (verticalMin == -3 && verticalMax == 3) -> println("Impossible")
            horizontalMax == 3 || verticalMax == 3 || diag == 3 || antiDiag == 3 -> println("X wins")
            horizontalMin == -3 || verticalMin == -3 || diag == -3 || antiDiag == -3 -> println("O wins")
            notFinished == true -> println("Game not finished")
            else -> println("Draw")
        }
    }
    fun print() {
        println("-".repeat(9))
        data.forEach { println("| ${it.joinToString(" ")} |") }
        println("-".repeat(9))
    }
}