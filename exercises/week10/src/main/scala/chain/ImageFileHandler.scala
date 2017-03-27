package chain

case class ImageFileHandler(s: String) extends Handler {

  var nextHandler: Handler = null

  override def setHandler(handler: Handler): Unit = {nextHandler=handler}

  override def process(file: File): Unit = {
    if (file.fileType.equals("image")){
      println("Process and saving " + file.fileType +" file... by " + this.getHandlerName())
    }else{
      print("File not supported")
    }
  }

  override def getHandlerName(): String = s
}