package es.valhallalabs.fermi.kDocsComposer.model.dataset

import java.util.*

data class DatasetField(
    val datasetFieldId: DatasetFieldId = UUID.randomUUID(),
    val dataSetFieldType: DataSetFieldType
)

typealias DatasetFieldId = UUID