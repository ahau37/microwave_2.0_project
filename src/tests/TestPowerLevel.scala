package tests

import org.scalatest.FunSuite
import microwave.model.Microwave

class TestPowerLevel extends FunSuite{

  test("Enter power level and cook time"){

    val microwave6: Microwave = new Microwave()

    microwave6.numberPressed(5)
    microwave6.numberPressed(9)

    assert(microwave6.currentInstructions().cookTime == 0)


    microwave6.powerLevelPressed()
    microwave6.numberPressed(7)
    microwave6.numberPressed(3)

    assert(microwave6.currentInstructions().cookTime == 0)


    microwave6.startPressed()

    assert(microwave6.currentInstructions().cookTime == 59)
    assert(microwave6.currentInstructions().powerLevel == 30)


    val microwave7: Microwave = new Microwave()

    microwave7.numberPressed(5)

    assert(microwave7.currentInstructions().cookTime == 0)


    microwave7.powerLevelPressed()
    microwave7.numberPressed(6)

    assert(microwave7.currentInstructions().cookTime == 0)


    microwave7.cookTimePressed()
    microwave7.numberPressed(1)
    microwave7.numberPressed(0)

    assert(microwave7.currentInstructions().cookTime == 0)


    microwave7.startPressed()

    assert(microwave7.currentInstructions().cookTime == 10)
    assert(microwave7.currentInstructions().powerLevel == 60)

    val microwave8: Microwave = new Microwave()

    microwave8.powerLevelPressed()
    microwave8.numberPressed(3)
    microwave8.numberPressed(8)

    microwave8.cookTimePressed()
    microwave8.numberPressed(4)
    microwave8.numberPressed(2)

    microwave8.startPressed()

    assert(microwave8.currentInstructions().powerLevel == 80)
    assert(microwave8.currentInstructions().cookTime == 42)


  }

}
