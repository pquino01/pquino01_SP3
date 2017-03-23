package abstractfactory

/**
  * Created by pablo on 23/03/2017.
  */
class NYCFactory extends AbstractParserFactory {
  override def getParserInstance(parserType: String): XMLParser = {
    if (parserType.equals("NYCORDER")){return new NYCOrder}
    if (parserType.equals("NYCFEEDBACK")){return new NYCFeedback}
    if (parserType.equals("NYCERROR")){return new NYCError}
    if (parserType.equals("NYCRESPONSE")){return new NYCResponse}
    else {return null}
  }
}
