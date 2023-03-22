package microwave.model

class Instructions(var cookTime: Int, var powerLevel: Int) {

  override def toString: String = {
    "Cooking for " + cookTime + " seconds at power level " + powerLevel
  }

}
