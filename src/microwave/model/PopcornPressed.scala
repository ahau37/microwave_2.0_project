package microwave.model

class PopcornPressed(microwave: Microwave) extends State(microwave) {
  override def currentInstructions(): Instructions = {
    new Instructions(this.microwave.initialCookTime, this.microwave.initialPowerLevel)

  }

  override def doorOpen(): Boolean = {
    true
  }

  override def openDoor(): Unit = {
    //nothing
  }

  override def closeDoor(): Unit = {
    microwave.state = new PopcornPressedClosed(microwave)
  }

  override def startPressed(): Unit = {
    //nothing
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
    microwave.state = new DoorOpened(microwave)
  }

  override def numberPressed(number: Int): Unit = {

  }

}
