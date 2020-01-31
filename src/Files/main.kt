package Files

class Stuff {
    fun hi() {
        println("HEllo WOrld")
    }

    fun print(string: String) {
        println(string)
    }
}

class Checkers {
    fun initBoard(size: Int): Array<Array<Int>> {
        return Array(size) {y -> Array(size) {x -> if (y % 2 == 0) {if (x % 2 == 0) {0} else {1}} else {if (x % 2 == 0) {1} else {0}} } }
    }

    fun printBoard(array: Array<Array<Int>>) {
        println(array.joinToString(separator="\n") { y -> y.joinToString(separator="") { x -> when (x) { 0 -> "██"; 1 -> "▙"; 2 -> "██"; else -> "   " } } })
    }

    fun movePiece(board: Array<Array<Int>>, from: Array<Int>, to: Array<Int>): Array<Array<Int>> {
        board[to[1]][to[0]] = board[from[1]][from[0]]
        board[from[1]][from[0]] = 0
        return board
    }
}

// just for testing
fun main() {
    val chk = Checkers()
    chk.printBoard(Array(8) {y -> Array(8) {x -> if (y % 2 == 0) {if (x % 2 == 0) {-1} else {0}} else {if (x % 2 == 0) {0} else {-1}} } })
}