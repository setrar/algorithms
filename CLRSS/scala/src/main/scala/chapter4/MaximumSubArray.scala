package chapter4

def findMaximumSubarray(a: Array[Int]): (Int, Int, Int) = {

    def findMaxCrossingSubarray(a: Array[Int], low: Int, mid: Int, high: Int): (Int, Int, Int) = {

        case class Max(id: Int = Int.MinValue, sum: Int = 0, acc: Int = 0)

        def findMax(r: Range): Max = r.foldLeft(Max()) { (acc, i) =>
            val sum: Int = acc.acc + a(i)
            if (sum > acc.sum)
                acc.copy(id = i, sum = sum, acc = sum)
            else
                acc.copy(acc = sum)
        }

        val l = findMax(mid until low by -1)
        val r = findMax(mid + 1 until high)

        (l.id, r.id, l.sum + r.sum)
    }

    def findMaximumSubarray(a: Array[Int], low: Int, high: Int): (Int, Int, Int) = {
        if (high == low) 
            (low, high, a(low))
        else {
            val mid = Math.abs((low + high) / 2)
            val (leftLow, leftHigh, leftSum) = findMaximumSubarray(a, low, mid)
            val (rightLow, rightHigh, rightSum) = findMaximumSubarray(a, mid + 1, high)
            val (crossLow, crossHigh, crossSum) = findMaxCrossingSubarray(a, low, mid, high)
            if (leftSum >= rightSum && leftSum >= crossSum) 
                (leftLow, leftHigh, leftSum)
            else 
                if (rightSum >= leftSum && rightSum >= crossSum) 
                    (rightLow, rightHigh, rightSum)
                else 
                    (crossLow, crossHigh, crossSum)
        }
    }

    findMaximumSubarray(a, 0, a.length - 1)
}
