fun main() {
    val board = TicTacToe()
    val moves = readln()

    board.addMoves(moves)
    board.print()
    board.printRes()
}