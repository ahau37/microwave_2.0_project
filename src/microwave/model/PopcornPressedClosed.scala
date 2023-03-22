package microwave.model

class PopcornPressedClosed(microwave: Microwave) extends State(microwave) {
  override def currentInstructions(): Instructions = {
    new Instructions(this.microwave.initialCookTime, this.microwave.initialPowerLevel)

  }

  override def doorOpen(): Boolean = {
    false
  }

  override def openDoor(): Unit = {
    microwave.state = new PopcornPressed(microwave)
  }

  override def closeDoor(): Unit = {
    //nothing
  }

  override def startPressed(): Unit = {
    microwave.state = new RunningMicrowave(microwave)
  }

  override def powerLevelPressed(): Unit = {
    //nothing
  }

  override def cookTimePressed(): Unit = {

  }

  override def thirtySecondsPressed(): Unit = {

  }

  override def popcornPressed(): Unit = {

  }

  override def clearPressed(): Unit = {
    this.microwave.initialCookTime = 0
    this.microwave.initialPowerLevel = 100
    this.microwave.pressed30 = 0
    this.microwave.powerLevel = 100
    this.microwave.listNumStrings = this.microwave.listNumStrings.filter(_.length < 1)
    microwave.state = new initialMicrowave(microwave)
  }

  override def numberPressed(number: Int): Unit = {

  }

}
