package es.valhallalabs.fermi.kDocsComposer.model.dataset

import java.util.*

class TestDataField(
    override val datasetFieldId: DatasetFieldId = UUID.randomUUID(),
    override val value: String
) : DatasetField(datasetFieldId = datasetFieldId, value = value)