package es.valhallalabs.fermi.kDocsComposer.model.document

import es.valhallalabs.fermi.kDocsComposer.model.dataset.DocumentDataset
import es.valhallalabs.fermi.kDocsComposer.model.page.PageFormat
import java.util.UUID

data class Document(
    val documentId: UUID = UUID.randomUUID(),
    val pageFormat: PageFormat,
    val sections: List<DocumentSection>,
    val datasets: List<DocumentDataset>?
)

typealias DocumentId = UUID