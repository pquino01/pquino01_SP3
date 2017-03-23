package strategy

// TODO

case class CapTextFormatter() extends TextFormatter {
  override def format(text: String): Unit = {
    val textCap = text.toUpperCase
    println(textCap)
  }
}
