import scala.xml._

class WikipediaParser() {
  def parse(sourceFileName: String): Seq[Document] = {
    val pageNodes: NodeSeq = XML.loadFile(sourceFileName) \ "page"

    pageNodes.map((page) => {
      new Document(
        (page \ "id").text.toInt,
        (page \ "title").text,
        (page \ "revision" \ "text").text
      )
    })
  }
}
