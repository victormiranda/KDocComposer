package es.valhallalabs.fermi.kDocsComposer.model.document

import es.valhallalabs.fermi.kDocsComposer.model.dataset.DocumentDataset
import java.util.UUID

class Document(
    val documentId: UUID,
    val sections: List<DocumentSection>,
    val datasets: List<DocumentDataset>
)

typealias DocumentId = UUID