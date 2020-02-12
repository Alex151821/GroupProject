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
    public var board = Array(8) { y ->
        Array(8) { x ->
            if (y % 2 == 0) {
                if (x % 2 == 0) {
                    if (y < 3) {
                        2
                    } else if (y > 4) {
                        3
                    } else {
                        0
                    }
                } else {
                    1
                }
            } else {
                if (x % 2 == 0) {
                    1
                } else {
                    if (y < 3) {
                        2
                    } else if (y > 4) {
                        3
                    } else {
                        0
                    }
                }
            }
        }
    }

    fun printBoard() {
        println(board.joinToString(separator = "\n") { y ->
            y.joinToString(separator = "") { x ->
                when (x) {
                    0 -> "   "
                    1 -> "███"
                    2 -> " ■ "
                    3 -> " □ "
                    4 -> " ▲ "
                    5 -> " ▼ "
                    else -> "   "
                }
            }
        } + "\n")
    }

    fun movePiece(fromx: Int, fromy: Int, tox: Int, toy: Int, color: Int): Array<Serializable> {
        var oppColor = if (color == 2) {
            3
        } else {
            2
        }
        if (board[fromy][fromx] in arrayOf(color, color + 2)) {
            try {
                var up = toy - fromy < 0
                var left = tox - fromx < 0
                var piece = if (board[fromy][fromx] > 3) {"king"} else {"normal"}

                if (board[toy][tox] == 0) {
                    if (piece == "normal" && ((color in arrayOf(2, 4) && up) || (color in arrayOf(3, 5) && !up))) {
                        return arrayOf(board, "That piece isn't a king, and cannot be moved backwards!")
                    }
                    board[toy][tox] = board[fromy][fromx]
                    board[fromy][fromx] = 0
                } else {
                    if (board[toy][tox] in arrayOf(color, color + 2)) {
                        return arrayOf(board, "One of your own pieces is in the way!")
                    } else if (board[toy][tox] in arrayOf(oppColor, oppColor + 2)) {
                        try {
                            if (up && left) {
                                if (board[toy - 1][tox - 1] in arrayOf(oppColor, oppColor + 2)) {
                                    return arrayOf(board, "An enemy piece is in the way!")
                                } else {
                                    board[toy - 1][tox - 1] = board[fromy][fromx]
                                    board[toy][tox] = 0
                                    board[fromy][fromx] = 0
                                }
                            } else if (up && !left) {
                                if (board[toy - 1][tox + 1] in arrayOf(oppColor, oppColor + 2)) {
                                    return arrayOf(board, "An enemy piece is in the way!")
                                } else {
                                    board[toy - 1][tox + 1] = board[fromy][fromx]
                                    board[toy][tox] = 0
                                    board[fromy][fromx] = 0
                                }
                            } else if (!up && left) {
                                if (board[toy + 1][tox - 1] in arrayOf(oppColor, oppColor + 2)) {
                                    return arrayOf(board, "An enemy piece is in the way!")
                                } else {
                                    board[toy + 1][tox - 1] = board[fromy][fromx]
                                    board[toy][tox] = 0
                                    board[fromy][fromx] = 0
                                }
                            } else if (!up && !left) {
                                if (board[toy + 1][tox + 1] in arrayOf(oppColor, oppColor + 2)) {
                                    return arrayOf(board, "An enemy piece is in the way!")
                                } else {
                                    board[toy + 1][tox + 1] = board[fromy][fromx]
                                    board[toy][tox] = 0
                                    board[fromy][fromx] = 0
                                }
                            }
                        } catch (err: ArrayIndexOutOfBoundsException) {
                            return arrayOf(board, "An enemy piece is in the way!")
                        }
                    }
                }
            } catch (err: ArrayIndexOutOfBoundsException) {
                return arrayOf(board, "You can't move the piece off the board!")
            }
        } else {
            if (board[fromy][fromx] in arrayOf(oppColor, oppColor + 2)) {
                return arrayOf(board, "That piece isn't the right color!")
            }
            return arrayOf(board, "There isn't a piece there!")
        }

        return arrayOf(board, "Success")
    }

    fun kingCheck(): Array<Array<Int>> {
        for (i in 0..board[0].size) {
            if (board[0][i] == 3) {
                board[0][i] == 5
            }
        }
        for ( i in 0..board[7].size) {
            if (board[7][i] == 2) {
                board[7][i] == 4
            }
        }
    }
}