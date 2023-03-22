package microwave.controller

import microwave.model.Microwave
import javafx.event.{ActionEvent, EventHandler}

/**
  * EventHandlers for each of the button on the microwave. NumberAction takes
  * an Int representing the which number button was pressed. You may assume
  * that each of these classes has a reference to the same Microwave object.
  */


class OpenDoorAction(microwave: Microwave) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = microwave.openDoor()
}

class CloseDoorAction(microwave: Microwave) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = microwave.closeDoor()
}

class StartAction(microwave: Microwave) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = microwave.startPressed()
}

class PowerLevelAction(microwave: Microwave) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = microwave.powerLevelPressed()
}

class CookTimeAction(microwave: Microwave) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = microwave.cookTimePressed()
}

class ThirtySecondsAction(microwave: Microwave) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = microwave.thirtySecondsPressed()
}

class PopcornAction(microwave: Microwave) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = microwave.popcornPressed()
}

class ClearAction(microwave: Microwave) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = microwave.clearPressed()
}

class NumberAction(microwave: Microwave, number: Int) extends EventHandler[ActionEvent] {
  override def handle(event: ActionEvent): Unit = microwave.numberPressed(number)
}