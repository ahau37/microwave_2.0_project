package microwave.model

class initialMicrowave(microwave: Microwave) extends State(microwave) {

  override def currentInstructions(): Instructions = {
    new Instructions(this.microwave.initialCookTime, this.microwave.initialPowerLevel)
  }

  override def doorOpen(): Boolean = {
    false
    //DOOR CLOSED!
  }

  override def openDoor(): Unit = {
    microwave.state = new DoorOpened(microwave)
  }

  override def closeDoor(): Unit = {
    //nothing
  }

  override def startPressed(): Unit = {
    val nums: Int = this.microwave.listNumStrings.mkString.toInt
    this.microwave.initialCookTime = nums
    this.microwave.initialPowerLevel = this.microwave.powerLevel
    microwave.state = new RunningMicrowave(microwave)
  }

  override def powerLevelPressed(): Unit = {
    microwave.state = new PowerLevelIsPressed(microwave)
  }

  override def cookTimePressed(): Unit = {
    //nothing
  }

  override def thirtySecondsPressed(): Unit = {
    this.microwave.initialCookTime += 30
    microwave.state = new RunningMicrowave(microwave)
  }

  override def popcornPressed(): Unit = {

    this.microwave.initialPowerLevel = 100
    this.microwave.initialCookTime = 140
    microwave.state = new RunningMicrowave(microwave)

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
    this.microwave.listNumStrings :+= num
    microwave.state = new NumberPressedCT(microwave)
  }

}
