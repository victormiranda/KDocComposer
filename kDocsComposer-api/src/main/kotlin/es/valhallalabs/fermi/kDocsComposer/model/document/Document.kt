package es.valhallalabs.fermi.kDocsComposer.model.document

import es.valhallalabs.fermi.kDocsComposer.model.component.Frame
import es.valhallalabs.fermi.kDocsComposer.model.dataset.DocumentDataset
import java.util.UUID

class Document(
    val documentId: UUID,
    val pageFormat: Frame,
    val sections: List<DocumentSection>,
    val datasets: List<DocumentDataset>
)

typealias DocumentId = UUID