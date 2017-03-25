package composite

// TODO

case class HtmlElement(s: String) extends HtmlTag(s) {

  var startTag: String = ""
  var endTag: String = ""
  var tagBody: String = ""

  override def setTagBody(tag: String) {tagBody=tag}

  override def setStartTag(tag: String) {startTag=tag}

  override def setEndTag(tag: String) {endTag=tag}

  override def generateHtml {println(startTag+""+ tagBody +""+endTag);}

  override def getTagName: String = {s}
}
