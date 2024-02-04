package es.valhallalabs.fermi.kDocsComposer.model.text

import es.valhallalabs.fermi.kDocsComposer.model.component.Component
import es.valhallalabs.fermi.kDocsComposer.model.component.ComponentType
import es.valhallalabs.fermi.kDocsComposer.model.component.Frame
import es.valhallalabs.fermi.kDocsComposer.model.dataset.DatasetField

class TextComponent(
    val datasetField: DatasetField,
    override val frame: Frame
) : Component {

    override val componentType = ComponentType.TEXT_FIELD
}