package tests

import org.scalatest.FunSuite
import microwave.model.Microwave

class TestFullFunctionality extends FunSuite{

  test("tests for all functionality"){

    val microwave8: Microwave = new Microwave()

    microwave8.numberPressed(5)

    microwave8.powerLevelPressed()
    microwave8.numberPressed(3)

    microwave8.openDoor()
    assert(microwave8.doorOpen() == true)
    microwave8.numberPressed(7)
    microwave8.closeDoor()
    assert(microwave8.doorOpen() == false)

    microwave8.startPressed()

    assert(microwave8.currentInstructions().cookTime == 5)
    assert(microwave8.currentInstructions().powerLevel == 70)

    val microwave9: Microwave = new Microwave()

    microwave9.numberPressed(6)
    microwave9.numberPressed(7)

    microwave9.startPressed()
    assert(microwave9.currentInstructions().cookTime == 67)

    microwave9.openDoor()
    assert(microwave9.doorOpen() == true)

    microwave9.clearPressed()
    assert(microwave9.currentInstructions().cookTime == 0)

    microwave9.numberPressed(5)
    microwave9.thirtySecondsPressed()

    microwave9.closeDoor()
    assert(microwave9.doorOpen() == false)
    microwave9.startPressed()

    assert(microwave9.currentInstructions().cookTime == 35)
    assert(microwave9.currentInstructions().powerLevel == 100)

    val microwave10: Microwave = new Microwave()

    microwave10.popcornPressed()

    assert(microwave10.currentInstructions().cookTime == 140)
    assert(microwave10.currentInstructions().powerLevel == 100)

    val microwave11: Microwave = new Microwave()

    microwave11.numberPressed(5)

    microwave11.powerLevelPressed()
    microwave11.numberPressed(3)

    microwave11.openDoor()
    assert(microwave11.doorOpen() == true)

    microwave11.popcornPressed()

    microwave11.closeDoor()
    assert(microwave11.doorOpen() == false)

    microwave11.startPressed()

    assert(microwave11.currentInstructions().cookTime == 140)
    assert(microwave11.currentInstructions().powerLevel == 100)

    val microwave12: Microwave = new Microwave()
    microwave12.powerLevelPressed()
    microwave12.numberPressed(5)

    microwave12.clearPressed()

    microwave12.popcornPressed()
    microwave12.startPressed()
    assert(microwave12.currentInstructions().cookTime == 140)
    assert(microwave12.currentInstructions().powerLevel == 100)

    microwave12.openDoor()

    microwave12.clearPressed()
    assert(microwave12.doorOpen() == true)

    microwave12.numberPressed(3)
    microwave12.numberPressed(3)
    microwave12.numberPressed(7)

    microwave12.startPressed()
    assert(microwave12.currentInstructions().cookTime == 0)

    microwave12.closeDoor()
    microwave12.startPressed()
    assert(microwave12.currentInstructions().cookTime == 337)

    val microwave13: Microwave = new Microwave()

    microwave13.numberPressed(4)
    microwave13.numberPressed(3)

    microwave13.openDoor()
    assert(microwave13.doorOpen() == true)
    microwave13.startPressed()
    assert(microwave13.currentInstructions().cookTime == 0)

    microwave13.closeDoor()
    assert(microwave13.doorOpen() == false)

    microwave13.startPressed()

    microwave13.thirtySecondsPressed()
    assert(microwave13.currentInstructions().cookTime == 73)

    val microwave14: Microwave = new Microwave()

    microwave14.openDoor()
    assert(microwave14.doorOpen() == true)

    microwave14.numberPressed(2)
    microwave14.numberPressed(3)

    microwave14.powerLevelPressed()
    microwave14.numberPressed(5)

    microwave14.startPressed()
    assert(microwave14.currentInstructions().cookTime == 0)

    assert(microwave14.doorOpen() == true)

    microwave14.closeDoor()
    assert(microwave14.doorOpen() == false)

    microwave14.startPressed()
    assert(microwave14.currentInstructions().cookTime == 23)
    assert(microwave14.currentInstructions().powerLevel == 50)

    microwave14.clearPressed()

    microwave14.numberPressed(3)
    microwave14.powerLevelPressed()
    microwave14.numberPressed(2)

    microwave14.startPressed()
    assert(microwave14.currentInstructions().cookTime == 3)
    assert(microwave14.currentInstructions().powerLevel == 20)

    microwave14.openDoor()
    assert(microwave14.doorOpen() == true)

    microwave14.clearPressed()
    assert(microwave14.doorOpen() == true)

    microwave14.numberPressed(5)
    microwave14.powerLevelPressed()
    microwave14.numberPressed(1)

    microwave14.startPressed()
    assert(microwave14.currentInstructions().cookTime == 0)

    microwave14.closeDoor()
    assert(microwave14.doorOpen() == false)


    val microwave15: Microwave = new Microwave()

    microwave15.popcornPressed()
    assert(microwave15.currentInstructions().cookTime == 140)
    assert(microwave15.currentInstructions().powerLevel == 100)

    microwave15.openDoor()
    assert(microwave15.currentInstructions().cookTime == 0)
    assert(microwave15.currentInstructions().powerLevel == 0)
    assert(microwave15.doorOpen() == true)

    microwave15.closeDoor()
    assert(microwave15.doorOpen() == false)

    microwave15.popcornPressed()
    assert(microwave15.currentInstructions().cookTime == 140)
    assert(microwave15.currentInstructions().powerLevel == 100)







  }

}
