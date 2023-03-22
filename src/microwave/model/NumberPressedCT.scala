package microwave.model

class NumberPressedCT(microwave: Microwave) extends State(microwave){

  //DOOR IS CLOSED!

  override def currentInstructions(): Instructions = {
    new Instructions(this.microwave.initialCookTime, this.microwave.initialPowerLevel)

  }

  override def doorOpen(): Boolean = {
    false
  }


  override def openDoor(): Unit = {
    microwave.state = new NumberPressedOpenCT(microwave)
  }

  override def closeDoor(): Unit = {
    //nothing
  }

  override def startPressed(): Unit = {
    val nums: Int = this.microwave.listNumStrings.mkString.toInt
    this.microwave.initialCookTime = nums + this.microwave.pressed30
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
    this.microwave.pressed30 = 30
  }

  override def popcornPressed(): Unit = {
    this.microwave.initialCookTime = 100
    this.microwave.initialPowerLevel = 100
    microwave.state = new RunningMicrowave(microwave)

  }

  override def clearPressed(): Unit = {
    this.microwave.initialPowerLevel = 100
    this.microwave.initialCookTime = 0
    this.microwave.pressed30 = 0
    this.microwave.powerLevel = 100
    this.microwave.listNumStrings = this.microwave.listNumStrings.filter(_.length < 1)
    microwave.state = new initialMicrowave(microwave)
  }

  override def numberPressed(number: Int): Unit = {
    val num: String = number.toString
    this.microwave.listNumStrings :+= num
  }

}
