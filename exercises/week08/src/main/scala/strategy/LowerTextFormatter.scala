package strategy

//TODO
case class LowerTextFormatter() extends TextFormatter {
  override def format(text: String): Unit = {
    val textLower = text.toLowerCase
    println(textLower)
  }
}
