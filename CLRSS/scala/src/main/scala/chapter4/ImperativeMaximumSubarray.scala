package chapter4

def findImperativeMaximumSubarray(a: Array[Int]): (Int, Int, Int) = {

    def findMaxCrossingSubarray(a: Array[Int], low: Int, mid: Int, high: Int): (Int, Int, Int) = {
        var leftSum: Int = Int.MinValue
        var sum = 0
        var maxLeft = 0
        var maxRight = 0
        for (i <- mid until low by -1) {
            sum = sum + a(i)
            if (sum > leftSum) {
                leftSum = sum
                maxLeft = i
            }
        }
        var rightSum = Int.MinValue
        sum = 0
        for (j <- mid + 1 until high) {
            sum = sum + a(j)
            if (sum > rightSum) {
                rightSum = sum
                maxRight = j
            }
        }
        (maxLeft, maxRight, leftSum + rightSum)
    }

    def findMaximumSubarray(a: Array[Int], low: Int, high: Int): (Int, Int, Int) = {
        var mid = 0
        if (high == low)
            (low, high, a(low))
        else {
            mid = Math.abs((low + high) / 2)
            val (leftLow, leftHigh, leftSum) = findMaximumSubarray(a, low, mid)
            val (rightLow, rightHigh, rightSum) = findMaximumSubarray(a, mid + 1, high)
            val (crossLow, crossHigh, crossSum) = findMaxCrossingSubarray(a, low, mid, high)
            if (leftSum >= rightSum && leftSum >= crossSum)
                (leftLow, leftHigh, leftSum)
            else if (rightSum >= leftSum && rightSum >= crossSum)
                (rightLow, rightHigh, rightSum)
            else
                (crossLow, crossHigh, crossSum)
        }
    }

    findMaximumSubarray(a, 0, a.length - 1)
}

