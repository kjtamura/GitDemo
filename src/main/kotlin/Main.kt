fun main() {
    val board = TicTacToe()
    repeat (3) {
        board.data[it] = mutableListOf("X", "O", "X")
    }
    board.print()
}