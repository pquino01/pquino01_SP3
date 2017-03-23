package observer

import scala.collection.mutable.ListBuffer

class CommentaryObject(var subscribers: ListBuffer[Observer], val title: String) extends Subject with Commentary {

  var newCommentary = ""

  def subscribeObserver(observer: Observer) = {
    subscribers+= observer
  }

  def unSubscribeObserver(observer: Observer) = {
    subscribers.remove(subscribers.indexOf(observer))
  }

  def notifyObservers() = {
    for (obs <- subscribers){
      obs.update(subjectDetails)
    }
  }

  def subjectDetails: String = {
    title+ "\n" + newCommentary
  }

  override def setDesc(desc: String): Unit = {
    newCommentary= desc
    notifyObservers()
  }
}
