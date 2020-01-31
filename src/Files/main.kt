package Files

import java.io.Serializable

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
        return Array(size) {y -> Array(size) {x -> if (y % 2 == 0) {if (x % 2 == 0) {if (y < 3) {2} else if (y > 4) {3} else {0}} else {1}} else {if (x % 2 == 0) {1} else {if (y < 3) {2} else if (y > 4) {3} else {0}}} } }
    }

    fun printBoard(array: Array<Array<Int>>) {
        println(array.joinToString(separator="\n") { y -> y.joinToString(separator="") { x -> when (x) { 1 -> "██"; 2 -> " ▓ "; 3 -> " ░ "; else -> "   " } } } + "\n")
    }

    fun movePiece(board: Array<Array<Int>>, fromx: Int, fromy: Int, tox: Int, toy: Int, color: Int): Array<Serializable> {
        if (board[fromy][fromx] in arrayOf(color, color+2)) {
            if (board[toy][tox] == 0) {
                board[toy][tox] = board[fromy][fromx]
                board[fromy][fromx] = 0
            } else {
                return arrayOf(board, "There's a piece in the way, or that place isn't a black tile")
            }
        } else {
            return arrayOf(board, "That piece isn't the right color, or there isn't a piece there")
        }
        // if to-from == 0, impossible move
        // if to-from == 1, moving up
        // if to-from == -1, moving down
        // those ones aren't quite true but yknow

        return arrayOf(board, "Success")
    }
}

// just for testing
fun main() {
    val chk = Checkers()
    chk.printBoard(Array(8) {y -> Array(8) {x -> if (y % 2 == 0) {if (x % 2 == 0) {-1} else {0}} else {if (x % 2 == 0) {0} else {-1}} } })
}