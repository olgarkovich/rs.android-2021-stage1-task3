package subtask2

import kotlin.math.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        return if (number < 5) {
            null
        } else {
            decompose(number.square(), number - 1)?.toTypedArray()
        }
    }

    private fun Int.square(): Int = (this * this)
    private fun Int.diff(b: Int): Int = (this - b.square())

    private fun decompose(number: Int, current: Int): ArrayList<Int>? {
        for (i in current downTo 1) {
            val diff = number.diff(i)
            if (diff == 0) {
                return arrayListOf(i)
            } else if (diff < 0) {
                return null
            } else {
                var sqrtDiff = sqrt(diff.toDouble()).toInt()
                if (sqrtDiff >= i) {
                    sqrtDiff = i - 1
                }
                val result = decompose(diff, sqrtDiff)
                if (result != null) {
                    result.add(i)
                    return result
                }
            }
        }
        return null
    }

}
