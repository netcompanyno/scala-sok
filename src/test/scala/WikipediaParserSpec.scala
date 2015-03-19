import org.scalatest.{Matchers, FlatSpec}

class WikipediaParserSpec extends FlatSpec with Matchers {

  it should "parse a simple XML file" in {
    val parser: WikipediaParser = new WikipediaParser()

    val documents: Seq[Document] = parser.parse("src/main/resources/det_norske_arbeiderparti.xml")

    documents.size should be (1)
    val document: Document = documents.head
    document.id should be (1)
    document.title should be ("Det norske Arbeiderparti")
    document.text should startWith ("#REDIRECT [[Arbeiderpartiet]]")
  }

  it should "parse the whole shebang" in {
    val parser: WikipediaParser = new WikipediaParser()

    val documents: Seq[Document] = parser.parse("src/main/resources/wikipedia.xml")

    documents.size should be (588)
    val document: Document = documents.head
    document.id should be (1)
    document.title should be ("Det norske Arbeiderparti")

    val lastDocument: Document = documents.last
    lastDocument.id should be (909)
    lastDocument.title should be ("Roger Ruud")

  }
}
