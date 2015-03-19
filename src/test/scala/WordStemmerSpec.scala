import org.scalatest.{Matchers, FlatSpec}

class WordStemmerSpec extends FlatSpec with Matchers {

  "stem" should "stem words" in {
    WordStemmer.stem("helLO") should be ("Hello, World!")
  }
}
