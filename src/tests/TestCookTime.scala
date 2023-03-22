package tests

import microwave.model.Microwave
import org.scalatest.FunSuite

class TestCookTime extends FunSuite {

  // Example test case
  test("Enter Time Cook") {
    val microwave: Microwave = new Microwave()

    microwave.numberPressed(3)
    microwave.numberPressed(0)

    assert(microwave.currentInstructions().cookTime == 0)

    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 30)


    val microwave2: Microwave = new Microwave()

    microwave2.numberPressed(8)
    microwave2.numberPressed(2)
    microwave2.numberPressed(3)

    assert(microwave2.currentInstructions().cookTime == 0)

    microwave2.startPressed()

    assert(microwave2.currentInstructions().cookTime == 823)
    assert(microwave2.currentInstructions().powerLevel == 100)

    val microwave3: Microwave = new Microwave()

    microwave3.thirtySecondsPressed()
    assert(microwave3.currentInstructions().cookTime == 30)
    assert(microwave3.currentInstructions().powerLevel == 100)

    val microwave4: Microwave = new Microwave()

    microwave4.numberPressed(4)
    microwave4.numberPressed(1)
    microwave4.thirtySecondsPressed()

    assert(microwave4.currentInstructions().cookTime == 0)

    val microwave5: Microwave = new Microwave()

    microwave5.numberPressed(2)
    microwave5.thirtySecondsPressed()

    assert(microwave5.currentInstructions().cookTime == 0)

    microwave5.startPressed()

    assert(microwave5.currentInstructions().cookTime == 32)
    assert(microwave5.currentInstructions().powerLevel == 100)

    val microwave6: Microwave = new Microwave()

    microwave6.numberPressed(0)
    microwave6.numberPressed(6)
    microwave6.numberPressed(3)
    microwave6.numberPressed(1)
    microwave6.thirtySecondsPressed()

    microwave6.startPressed()

    assert(microwave6.currentInstructions().cookTime == 661)
    assert(microwave6.currentInstructions().powerLevel == 100)

    val microwave7: Microwave = new Microwave()

    microwave7.numberPressed(3)
    microwave7.numberPressed(7)
    microwave7.startPressed()

    assert(microwave7.currentInstructions().cookTime == 37)
    microwave7.thirtySecondsPressed()
    assert(microwave7.currentInstructions().cookTime == 67)

    val microwave8: Microwave = new Microwave()

    microwave8.numberPressed(9)
    microwave8.startPressed()
    microwave8.numberPressed(2)
    microwave8.numberPressed(2)


    assert(microwave8.currentInstructions().cookTime == 9)

    val microwave9: Microwave = new Microwave()

    microwave9.numberPressed(5)
    microwave9.numberPressed(4)

    microwave9.startPressed()
    assert(microwave9.currentInstructions().cookTime == 54)


















  }

}
