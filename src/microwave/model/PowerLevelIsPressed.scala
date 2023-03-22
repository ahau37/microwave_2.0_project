package microwave.model

class PowerLevelIsPressed(microwave: Microwave) extends State(microwave){

  override def currentInstructions(): Instructions = {
    new Instructions(this.microwave.initialCookTime, this.microwave.initialPowerLevel)

  }

  override def doorOpen(): Boolean = {
    false
  }


  override def openDoor(): Unit = {
    microwave.state = new PowerLevelOpen(microwave)
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
    //nothing
  }

  override def cookTimePressed(): Unit = {
    this.microwave.listNumStrings = this.microwave.listNumStrings.filter(_.length < 1)
    microwave.state = new initialMicrowave(microwave)
  }

  override def thirtySecondsPressed(): Unit = {
    this.microwave.pressed30 = 30
    microwave.state = new RunningMicrowave(microwave)
  }

  override def popcornPressed(): Unit = {
    this.microwave.initialCookTime = 140
    this.microwave.initialPowerLevel = 100
    microwave.state = new RunningMicrowave(microwave)
  }

  override def clearPressed(): Unit = {
    this.microwave.initialCookTime = 0
    this.microwave.initialPowerLevel = 100
    this.microwave.powerLevel = 100
    this.microwave.pressed30 = 0
    this.microwave.listNumStrings = this.microwave.listNumStrings.filter(_.length < 1)
    microwave.state = new initialMicrowave(microwave)
  }

  override def numberPressed(number: Int): Unit = {
    val num: Int = number * 10
    this.microwave.powerLevel = num
  }

}
