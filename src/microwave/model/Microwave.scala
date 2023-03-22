package microwave.model

class Microwave() {

  var state: State = new initialMicrowave(this)
  var initialPowerLevel: Int = 100
  var initialCookTime: Int = 0
  var listNumStrings: List[String] = List()
  var powerLevel: Int = 100
  var pressed30: Int = 0



  def currentInstructions(): Instructions = {
    this.state.currentInstructions()
  }

  def doorOpen(): Boolean = {
    this.state.doorOpen()
  }

  def openDoor(): Unit = {
    this.state.openDoor()
  }

  def closeDoor(): Unit = {
    this.state.closeDoor()
  }

  def startPressed(): Unit = {
    this.state.startPressed()
  }

  def powerLevelPressed(): Unit = {
    this.state.powerLevelPressed()
  }

  def cookTimePressed(): Unit = {
    this.state.cookTimePressed()
  }

  def thirtySecondsPressed(): Unit = {
    this.state.thirtySecondsPressed()
  }

  def popcornPressed(): Unit = {
    this.state.popcornPressed()
  }

  def clearPressed(): Unit = {
    this.state.clearPressed()
  }

  def numberPressed(number: Int): Unit = {
    this.state.numberPressed(number)
  }

}
