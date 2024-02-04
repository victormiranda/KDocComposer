package es.valhallalabs.fermi.kDocsComposer.model.dataset

import java.util.*

open class DatasetField(
    open val datasetFieldId: DatasetFieldId = UUID.randomUUID(),
    open val value: Any
)

typealias DatasetFieldId = UUID