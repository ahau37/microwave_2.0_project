package microwave.model

class NumberPressedOpenCT(microwave: Microwave) extends State(microwave) {

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
    microwave.state = new NumberPressedCT(microwave)
  }

  override def startPressed(): Unit = {
    //nothing
  }

  override def powerLevelPressed(): Unit = {
    microwave.state = new PowerLevelOpen(microwave)
  }

  override def cookTimePressed(): Unit = {
    //nothing
  }

  override def thirtySecondsPressed(): Unit = {
    this.microwave.pressed30 = 30
  }

  override def popcornPressed(): Unit = {
    this.microwave.initialCookTime = 140
    this.microwave.initialPowerLevel = 100
    microwave.state = new PopcornPressed(microwave)


  }

  override def clearPressed(): Unit = {
    this.microwave.initialPowerLevel = 100
    this.microwave.initialCookTime = 0
    this.microwave.pressed30 = 0
    this.microwave.powerLevel = 100
    this.microwave.listNumStrings = this.microwave.listNumStrings.filter(_.length < 1)
    microwave.state = new DoorOpened(microwave)
  }

  override def numberPressed(number: Int): Unit = {
    val num: String = number.toString
    this.microwave.listNumStrings :+= num
  }

}
