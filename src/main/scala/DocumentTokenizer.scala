object DocumentTokenizer {
  def tokenize(document: Document): Seq[String] = {
    document.text.split("[^0-9a-zA-ZæøåÆØÅ]+")
  }
}
