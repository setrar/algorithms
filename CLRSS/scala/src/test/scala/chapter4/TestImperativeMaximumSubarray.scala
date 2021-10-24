import org.junit.Test
import org.junit.Assert.*

class TestImperativeMaximumSubarray:
  @Test def ImperativeMaximumSubarraySpec(): Unit = 
    val init = Array(100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97)
    // Converting initial array values to change in stock prices
    // i.e. val a = Array(13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7)
    val changes = (init zip init.tail).map({ case (x, y) => y - x })
    assertEquals(chapter4.findImperativeMaximumSubarray(changes), (7,10,43))
