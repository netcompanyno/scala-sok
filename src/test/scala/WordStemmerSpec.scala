import org.scalatest.{Matchers, FlatSpec}

class WordStemmerSpec extends FlatSpec with Matchers {

  "replaceEndings" should "remove Norwegian noun plural endings" in {
    WordStemmer.replaceEndings("katt") should be ("katt")
    WordStemmer.replaceEndings("katter") should be ("katt")
    WordStemmer.replaceEndings("biler") should be ("bil")
    WordStemmer.replaceEndings("bilene") should be ("bil")
    WordStemmer.replaceEndings("programmer") should be ("program")
    WordStemmer.replaceEndings("programmene") should be ("program")
  }

  "stem" should " words" in {
    WordStemmer.stem("HEI på dEg") should be ("hei på deg")
  }
}
