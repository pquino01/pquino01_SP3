package composite

import java.util.List

import scala.collection.mutable.ArrayBuffer

abstract class HtmlTag(tagName: String) {
  def getTagName: String

  def setStartTag(tag: String)

  def setEndTag(tag: String)

  def setTagBody(tag: String) {
    throw new UnsupportedOperationException
  }

  def addChildTag(htmlTag: HtmlTag) {
    throw new UnsupportedOperationException
  }

  def removeChildTag(htmlTag: HtmlTag) {
    throw new UnsupportedOperationException
  }

  def getChildren: ArrayBuffer[HtmlTag] = {
    throw new UnsupportedOperationException
  }

  def generateHtml
}