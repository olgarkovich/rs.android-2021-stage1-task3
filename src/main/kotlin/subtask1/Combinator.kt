package subtask1

import kotlin.math.sqrt

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        val m = array[0]
        val n = array[1]

        for (i in 1..(m / sqrt(2.0)).toInt()) {
            val current = returnM(i, n)

            if (current.toInt() == m) {
                return i
            }
        }

        return null
    }

    private fun returnM(x: Int, n: Int): Long {
        return factorial(n) / factorial(x) / factorial(n - x)
    }

    private fun factorial(n: Int): Long = if (n < 2) 1 else n * factorial(n - 1)
}
