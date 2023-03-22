package microwave.model

class DoorOpened(microwave: Microwave) extends State(microwave){

  //NUMBERS PRESSED IS COOK TIME (DOOR IS OPEN)

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
    microwave.state = new initialMicrowave(microwave)
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
  }

  override def clearPressed(): Unit = {
    this.microwave.initialCookTime = 0
    this.microwave.initialPowerLevel = 100
    this.microwave.pressed30 = 0
    this.microwave.powerLevel = 100
    this.microwave.listNumStrings = this.microwave.listNumStrings.filter(_.length < 1)

  }

  override def numberPressed(number: Int): Unit = {
    val num: String = number.toString
    microwave.listNumStrings :+= num
    microwave.state = new NumberPressedOpenCT(microwave)
  }

}
