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
    fun printBoard(array: Array<Array<Int>>) {
        println(array.joinToString() { y -> y.joinToString() { x -> while (x) { 0 -> "" } } } })
    }
}