package microwave.model

abstract class State(microwave: Microwave) {

  def currentInstructions(): Instructions = {
    currentInstructions()
  }

  def doorOpen(): Boolean = {
    doorOpen()
  }


  def openDoor(): Unit = {

  }

  def closeDoor(): Unit = {

  }

  def startPressed(): Unit = {

  }

  def powerLevelPressed(): Unit = {

  }

  def cookTimePressed(): Unit = {

  }

  def thirtySecondsPressed(): Unit = {

  }

  def popcornPressed(): Unit = {

  }

  def clearPressed(): Unit = {

  }

  def numberPressed(number: Int): Unit = {

  }

}
