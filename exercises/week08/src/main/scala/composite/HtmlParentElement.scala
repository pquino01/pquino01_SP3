package composite

import java.util.List

import scala.collection.mutable.ArrayBuffer

// TODO
case class HtmlParentElement(s: String) extends HtmlTag(s) {

  var startTag: String = ""
  var endTag: String = ""
  var childrenTag: ArrayBuffer[HtmlTag] = new ArrayBuffer[HtmlTag]()

  override def setStartTag(tag: String) {startTag=tag}

  override def setEndTag(tag: String) {endTag=tag}

  override def addChildTag(htmlTag: HtmlTag) {
    childrenTag+=htmlTag
  }

  override def removeChildTag(htmlTag: HtmlTag) {
    childrenTag-=htmlTag
  }

  override def getChildren: ArrayBuffer[HtmlTag] = {
    childrenTag
  }

  override def generateHtml {
    println(startTag)
    for (tag <- childrenTag){
      tag.generateHtml
    }
    println(endTag)
  }

  override def getTagName: String = {s}
}
