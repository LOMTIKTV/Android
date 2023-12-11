fun printChessboard(king: Pair<Int, Int>, rook: Pair<Int, Int>, bishop: Pair<Int, Int>) {
    val chessboard = Array(8) { CharArray(8) { '0' } }
    chessboard[king.first][king.second] = 'K'
    chessboard[rook.first][rook.second] = 'T'
    chessboard[bishop.first][bishop.second] = 'C'
    for (row in chessboard) {
        for (square in row) {
            print("$square ")
        }
        println()
    }
}

fun threatToKing(king: Pair<Int, Int>, rook: Pair<Int, Int>, bishop: Pair<Int, Int>): Int {

    if (king.first == rook.first || king.second == rook.second) {
        return 1 // Threat from rook
    }


    if (Math.abs(king.first - bishop.first) == Math.abs(king.second - bishop.second)) {
        return 2
    }

    return 0
}

fun main() {
    val king = Pair(3, 4)
    val rook = Pair(3, 7)
    val bishop = Pair(0, 1)

    printChessboard(king, rook, bishop)

    val threat = threatToKing(king, rook, bishop)

    when (threat) {
        0 -> println("No threat to the king.")
        1 -> println("Threat from rook to the king.")
        2 -> println("Threat from bishop to the king.")
    }
}