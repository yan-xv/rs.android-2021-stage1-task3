package subtask2

class SquareDecomposer {

    private val resultList : MutableList<Int>? = mutableListOf<Int>()
    fun decomposeNumber(number: Int): Array<Int>? {
        resultList?.add(number - 1)
        decomposeNumber(number - 1, number.toLong().sqr() - (number - 1).toLong().sqr())

         resultList?.let {
             if (it.size > 1) {
                 it.reverse()
                 //it.forEach { print("$it; ") }
                 return it.toTypedArray()
             }
         }
        return null
    }

    private fun decomposeNumber(number: Int, remainder: Long, nLevel: Int = 0): Boolean {
        var curNumber = number
        var curRemainder = remainder.toLong()
        while ( curNumber > 1 ) {
            curNumber--
            val sqrNumber = curNumber.toLong().sqr()
            if ( (curNumber > 1 || curRemainder == curNumber.toLong()) && sqrNumber <= curRemainder ) {
                //println("-".repeat(nLevel) + "$curNumber $curRemainder $sqrNumber")

                if ( decomposeNumber(curNumber, curRemainder - sqrNumber, nLevel + 1) ) {
                    if (nLevel > 0)
                        return true

                    resultList?.add(curNumber)
                    curRemainder -= sqrNumber
                    //println("-".repeat(nLevel) + "true $curNumber $curRemainder")
                }
            }
        }

        if (curNumber == 1 && curRemainder > 1L) {
            //println("-".repeat(nLevel) + "false $curNumber $curRemainder")
            return false
        }
        return true
    }

    private fun Long.sqr(): Long = this * this
}
