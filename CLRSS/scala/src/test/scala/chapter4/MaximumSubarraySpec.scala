package chapter4

import org.scalatest._

class MaximumSubarraySpec extends FlatSpec with Matchers {
  "The MaximumSubarraySpec" should "not fail" in {
    val init = Array(100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97)
    // Converting initial array values to change in stock prices
    // i.e. val a = Array(13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7)
    val changes = (init zip init.tail).map({ case (x, y) => y - x })
    MaximumSubarray.findMaximumSubarray(changes) shouldEqual (7,10,43)

    // https://www.geeksforgeeks.org/maximum-subarray-sum-using-divide-and-conquer-algorithm/
    val i2 = Array(-2, -5, 6, -2, -3, 1, 5, -6)
    MaximumSubarray.findMaximumSubarray(i2) shouldEqual (2,6,7)

    // https://en.wikipedia.org/wiki/Maximum_subarray_problem
    val i3 = Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    MaximumSubarray.findMaximumSubarray(i3) shouldEqual (3,6,6)
  }
}
