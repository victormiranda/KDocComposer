package es.valhallalabs.fermi.kDocsComposer.model.page

import es.valhallalabs.fermi.kDocsComposer.model.component.Component
import es.valhallalabs.fermi.kDocsComposer.model.component.ComponentType
import es.valhallalabs.fermi.kDocsComposer.model.component.Frame

class ColumnLayout(
    override val elements: List<Component>,
    override val frame: Frame
): StackedLayout {
    override val componentType  = ComponentType.COLUMN_LAYOUT
    override val layoutType = LayoutType.COLUMN_LAYOUT
}