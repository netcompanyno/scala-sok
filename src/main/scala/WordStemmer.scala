object WordStemmer {

  val stemmingFunctions: List[Function[String, String]] = List(
    toLower,
    replaceEndings
  )

  def toLower(word: String): String = word.toLowerCase

  def replaceEndings(word: String) = {
    val replaceEndings = List(
      ("mmer", "m"),
      ("mmene", "m"),
      ("er", ""),
      ("ene", ""))

    val ending = replaceEndings.find(t => word.endsWith(t._1))

    ending match {
      case Some((found, replace)) => {
        var i = word.lastIndexOf(found)
        var prefix = word.substring(0, i)

        prefix + replace
      }
      case _ => word
    }
  }


  def stem(word: String): String = {
    val composedStemmerFunction: Function[String, String] = stemmingFunctions reduce (_ andThen _)
    composedStemmerFunction(word)
  }
}
