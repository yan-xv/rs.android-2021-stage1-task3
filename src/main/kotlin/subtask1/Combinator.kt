package subtask1

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        val posters = array[0].toLong()
        val colors  = array[1].toLong()
        var k = 0L
        var calcPosters = 0L

        while (calcPosters < posters) {
            if ( ++k == colors )
                return null
            calcPosters = colors.fact() / (k.fact() * ((colors - k).fact()))
        }
        return k.toInt()
    }
}

fun Long.fact(): Long = (1..this).reduce(Long::times)