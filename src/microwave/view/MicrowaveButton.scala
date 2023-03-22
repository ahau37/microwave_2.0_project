package microwave.view

import javafx.event.{ActionEvent, EventHandler}
import scalafx.scene.control.Button

class MicrowaveButton(display: String, action: EventHandler[ActionEvent], xScale: Double = 1.0, yScale: Double = 1.0, textSize: Double = 25.0) extends Button {
  minWidth = 180 * xScale
  minHeight = 90 * yScale
  onAction = action
  text = display
  style = "-fx-font: " + textSize.toString + " ariel;"
}
