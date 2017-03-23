package abstractfactory

object ParserFactoryProducer {
  def getFactory(s: String): AbstractParserFactory = {
    if (s.equals("NYCFactory")){return new NYCFactory}
    if (s.equals("LondonFactory")){return new LondonFactory}
    else {return null}
  }

}
