object WordStemmer {

  val stemmingFunctions: List[Function[String, String]] = List(
    toLower,
    upperCaseFirstLetter,
    addComma,
    addWorld,
    addExclamationMark
  )

  def upperCaseFirstLetter(word: String): String = {
    val upper: Char = word.charAt(0).toUpper
    upper + word.substring(1, word.length)
  }

  def toLower(word: String): String = word.toLowerCase

  def addComma(word: String): String = {
    word + ", "
  }

  def addExclamationMark(word: String): String = {
    word + "!"
  }

  def addWorld(word: String): String = {
    word + "World"
  }

  def stem(word: String): String = {
    val composedStemmerFunction: Function[String, String] = stemmingFunctions reduce (_ andThen _)
    composedStemmerFunction(word)
  }
}
