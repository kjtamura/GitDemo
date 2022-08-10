class TicTacToe {
    val data = MutableList(3) { MutableList<Char>(3) {' '} }
    val horizontal = MutableList<Int>(3) {0}
    val vertical = MutableList<Int>(3) {0}
    var diag = 0
    var antiDiag = 0
    var numOfMoves = 0

    fun startGame() {
        print()
        var player = 1
        numOfMoves = this.data.first().size * this.data.size
        while (!isGameOver()) {
            addMove(player)
            player *= -1
            print()
        }
    }

    fun addMove (_player: Int) {
        var validMove = false
        val player = if (_player > 0) 'X' else 'O'

        do {
            try {
                val (row, col) = readln().split(" ").map { it.toInt() - 1 }
                if(row !in 0 .. 2 || col !in 0 .. 2) {
                    println("Coordinates should be from 1 to 3!")
                }
                else if (this.data[row][col] == ' ') {
                    this.data[row][col] = player
                    horizontal[row] += _player
                    vertical[col] += _player
                    diag += _player
                    antiDiag += _player
                    validMove = true
                } else {
                    println("This cell is occupied! Choose another one!")
                }
            } catch (e: Exception) {
                println("You should enter numbers!")
            }
        } while (!validMove)
        numOfMoves--
    }

    fun isGameOver(): Boolean {
        val horizontalMax = horizontal.maxOrNull()
        val horizontalMin = horizontal.minOrNull()
        val verticalMax = vertical.maxOrNull()
        val verticalMin = vertical.minOrNull()

        if (horizontalMax == 3  || verticalMax == 3 || diag == 3 || antiDiag == 3) {
            println("X wins")
            return true
        } else if (horizontalMin == -3  || verticalMin == -3 || diag == -3 || antiDiag == -3) {
            println("O wins")
            return true
        } else if(numOfMoves == 0) {
            println("Draw")
            return true
        }
        return false
    }
    fun print() {
        println("-".repeat(9))
        data.forEach { println("| ${it.joinToString(" ")} |") }
        println("-".repeat(9))
    }
}