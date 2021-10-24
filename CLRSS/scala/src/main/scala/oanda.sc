import scala.util.matching.Regex

// returns sequence consisting of first letters of each of the input strings
def firstLetters(strs: Seq[String]): Seq[String] = strs.map( _.take(1))

firstLetters(List("Hello", "world", "") )

// returns string consisting of first letters of each input string; None if no input strings
def firstLettersWord(strs: String*): Option[String] = strs.map(_.take(1)).mkString("") match {
  case "" => None
  case x => Some(x)
}


firstLettersWord("Hello", "world") // = Some("Hw")

firstLettersWord()

// returns the price for the optional quote
case class Quote(symbol: String, price: Option[BigDecimal])
def price(quote: Option[Quote]): Option[BigDecimal] = quote.flatMap(_.price)

price(Some(Quote("USD/CAD", None))) // == None

price(Some(Quote("EUR/CAD", Some(BigDecimal("1.5"))))) // == Some(BigDecimal("1.5"))

price(None) // == None

// returns all (base, quote) symbols for strings matching the given regex
val CurrencyPair: Regex = "([A-Z]{3})/([A-Z]{3})".r
def currencyPairs(strs: Seq[String]): Seq[(String, String)] = strs.flatMap(
  {
    case CurrencyPair(base,quote) => List((base,quote))
    case _ => Nil
  }
)


currencyPairs(List("USD/CAD", "EURCAD"))// == Seq(("USD", "CAD"))
