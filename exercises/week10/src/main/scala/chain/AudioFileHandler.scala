package chain

case class AudioFileHandler(s: String) extends Handler {

  var nextHandler: Handler = null

  override def setHandler(handler: Handler): Unit = {nextHandler=handler}

  override def process(file: File): Unit = {
    if (file.fileType.equals("audio")){
      println("Process and saving " + file.fileType +" file... by " + this.getHandlerName())
    }else{
      println(this.getHandlerName() + " forwards request to " + nextHandler.getHandlerName())
      nextHandler.process(file)
    }
  }

  override def getHandlerName(): String = s
}
