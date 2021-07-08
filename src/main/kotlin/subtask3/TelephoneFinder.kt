package subtask3

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        var  arr = mutableListOf<String>()
        number.forEach { c ->
            val near = getNear(c) ?: return null
            near.forEach { arr?.add(number.replace(c, it)) }
        }
        return arr.toTypedArray()
    }

    private fun getNear(number: Char): String? {
       return when(number) {
            '0' -> "8"
            '1' -> "24"
            '2' -> "135"
            '3' -> "26"
            '4' -> "157"
            '5' -> "2468"
            '6' -> "359"
            '7' -> "48"
            '8' -> "5790"
            '9' -> "68"
            else -> null
        }
    }
}

