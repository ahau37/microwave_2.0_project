package microwave.model

class RunningMicrowave(microwave: Microwave) extends State(microwave) {

  override def currentInstructions(): Instructions = {
    new Instructions(this.microwave.initialCookTime, this.microwave.initialPowerLevel)

  }

  override def doorOpen(): Boolean = {
    false
  }


  override def openDoor(): Unit = {
    this.microwave.initialCookTime = 0
    this.microwave.initialPowerLevel = 0
    microwave.state = new DoorOpened(microwave)
  }

  override def closeDoor(): Unit = {
    //nothing
  }

  override def startPressed(): Unit = {
    //nothing
  }

  override def powerLevelPressed(): Unit = {
    //nothing
  }

  override def cookTimePressed(): Unit = {
    //nothing
  }

  override def thirtySecondsPressed(): Unit = {
    this.microwave.initialCookTime += 30
  }

  override def popcornPressed(): Unit = {
    //nothing
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
    //nothing
  }

}
