# microwave_2.0_project
Given a GUI, create the API for a full functionality of a microwave. The challenge is to not use control flow; it is made by using state pattern in Scala.

# Credit / Sources
Assignment from Professor Jesse Hartloff
https://cse.buffalo.edu/~hartloff/index.html

Base Code:
https://github.com/jessehartloff/Microwave


# API
The microwave API contains the following methods that were implemented. The “pressed” methods are called when the corresponding button is pressed on the GUI.

currentInstructions(): Instructions
  Called by the GUI after each button press and displays the returned value on the screen
  This method is also called during testing to check if the proper value is displayed without needing the GUI in our unit tests
  The instructions class contains Int variables for the cook time (in seconds) and the power level that the microwave should currently be executing
  
doorOpen(): Boolean
  Called by the GUI and unit tests to display the state of the door
  Returns true if the door is currently open, false if it is closed  
  
openDoor(): Unit

closeDoor(): Unit 

startPressed(): Unit

powerLevelPressed(): Unit

cookTimePressed(): Unit

thirtySecondsPressed(): Unit

popcornPressed(): Unit

clearPressed(): Unit

numberPressed(number: Int): Unit
  The parameter is the number of the button that was pressed

# Functionality

Microwave should have same functionality as a "real world" microwave. 

