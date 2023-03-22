package microwave.view

import javafx.scene.input.MouseEvent
import microwave.controller._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.TextField
import scalafx.scene.layout.GridPane

object Microwave extends JFXApp {

  val microwaveModel = new microwave.model.Microwave()

  var textField: TextField = new TextField {
    editable = false
    style = "-fx-font: 26 ariel;"
    this.text.value = doorString(microwaveModel.doorOpen()) + " - " + microwaveModel.currentInstructions()
  }

  var pressPowerLevel: MicrowaveButton = new MicrowaveButton("Power Level", new PowerLevelAction(microwaveModel),1,1)
  var pressCookTime :MicrowaveButton = new MicrowaveButton("Cook Time", new CookTimeAction(microwaveModel),1,1)
  var press30Seconds :MicrowaveButton = new MicrowaveButton("+30 Seconds", new ThirtySecondsAction(microwaveModel),1,1)
  var pressPopcorn :MicrowaveButton = new MicrowaveButton("Popcorn", new PopcornAction(microwaveModel),1,1)

  var pressZero :MicrowaveButton = new MicrowaveButton("0", new NumberAction(microwaveModel, 0),1,1,30)
  var pressClear :MicrowaveButton = new MicrowaveButton("Clear", new ClearAction(microwaveModel),1,1)
  var pressStart :MicrowaveButton = new MicrowaveButton("Start", new StartAction(microwaveModel),1,1)

  var pressOne :MicrowaveButton =  new MicrowaveButton("1", new NumberAction(microwaveModel, 1),1,1, 30)
  var pressTwo :MicrowaveButton =  new MicrowaveButton("2", new NumberAction(microwaveModel, 2),1,1,30)
  var pressThree :MicrowaveButton =  new MicrowaveButton("3", new NumberAction(microwaveModel, 3),1,1,30)

  var pressFour :MicrowaveButton = new MicrowaveButton("4", new NumberAction(microwaveModel, 4),1,1, 30)
  var pressFive :MicrowaveButton = new MicrowaveButton("5", new NumberAction(microwaveModel, 5),1,1,30)
  var pressSix :MicrowaveButton = new MicrowaveButton("6", new NumberAction(microwaveModel, 6),1,1,30)

  var pressSeven :MicrowaveButton = new MicrowaveButton("7", new NumberAction(microwaveModel, 7),1,1,30)
  var pressEight :MicrowaveButton = new MicrowaveButton("8", new NumberAction(microwaveModel, 8),1,1,30)
  var pressNine :MicrowaveButton = new MicrowaveButton("9", new NumberAction(microwaveModel, 9),1,1,30)

  var pressClose = new MicrowaveButton("Close Door", new CloseDoorAction(microwaveModel),2)
  var pressOpen = new MicrowaveButton("Open Door", new OpenDoorAction(microwaveModel),2)


  stage = new PrimaryStage {
    title = "Microwave"
    scene = new Scene() {
      content = List(
        new GridPane {
          hgap = 0.0
          vgap = 0.0

          add(textField, 0, 0, 4, 1)

          add(pressPowerLevel, 0, 1,1,1)
          add(pressCookTime, 1, 1,1,1)
          add(press30Seconds, 3, 1, 1, 1)
          add(pressPopcorn, 2, 1, 1, 1)

          add(pressZero, 3, 2, 1, 1)
          add(pressClear, 3, 3,1,1)
          add(pressStart, 3, 4,1,1)

          add(pressSeven, 0, 2)
          add(pressEight, 1, 2)
          add(pressNine, 2, 2)
          add(pressFour, 0, 3)
          add(pressFive, 1, 3)
          add(pressSix, 2, 3)
          add(pressOne, 0, 4)
          add(pressTwo, 1, 4)
          add(pressThree, 2, 4)

          add(pressClose, 0, 6,2,1)
          add(pressOpen, 2, 6,2,1)
        }
      )
    }

    addEventFilter(MouseEvent.MOUSE_CLICKED, (_: MouseEvent) => {
      textField.text.value = doorString(microwaveModel.doorOpen()) + " - " + microwaveModel.currentInstructions()
    })

  }




  def doorString(doorOpen: Boolean): String = {
    "door open: " + doorOpen
  }


}
