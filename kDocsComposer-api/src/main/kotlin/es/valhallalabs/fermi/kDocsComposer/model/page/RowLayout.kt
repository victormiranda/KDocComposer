package es.valhallalabs.fermi.kDocsComposer.model.page

import es.valhallalabs.fermi.kDocsComposer.model.component.Component
import es.valhallalabs.fermi.kDocsComposer.model.component.ComponentType
import es.valhallalabs.fermi.kDocsComposer.model.component.Frame

class RowLayout(
    override val frame: Frame,
    override val elements: List<Component>
) : StackedLayout {

    override val componentType = ComponentType.ROW_LAYOUT
}