import org.scalatest.{Matchers, FlatSpec}

class DocumentTokenizerSpec extends FlatSpec with Matchers {

  it should "convert a document to a sequence of words" in {
    val document: Document = new Document(1, "this is the title", "Vår værhane er i uføre med 24 røde BILER")

    val words: Seq[String] = DocumentTokenizer.tokenize(document)

    words should be (Seq("Vår", "værhane", "er", "i", "uføre", "med", "24", "røde", "BILER"))
  }
}
