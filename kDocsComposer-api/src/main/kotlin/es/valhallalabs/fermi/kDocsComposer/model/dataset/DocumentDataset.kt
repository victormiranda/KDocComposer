package es.valhallalabs.fermi.kDocsComposer.model.dataset

import java.util.*

class DocumentDataset(
    val dataSetId: DataSetId = UUID.randomUUID(),
    val name: String,
    val fields: Set<DatasetField>
)

typealias DataSetId = UUID