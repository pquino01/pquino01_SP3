package abstractfactory

/**
  * Created by pablo on 23/03/2017.
  */
class LondonFactory extends AbstractParserFactory {
  override def getParserInstance(parserType: String): XMLParser = {
    if (parserType.equals("LondonORDER")){return new LondonOrder}
    if (parserType.equals("LondonFEEDBACK")){return new LondonFeedback}
    if (parserType.equals("LondonERROR")){return new LondonError}
    if (parserType.equals("LondonRESPONSE")){return new LondonResponse}
    else {return null}
  }
}
