package es.valhallalabs.fermi.kDocsComposer.model.container

import es.valhallalabs.fermi.kDocsComposer.model.component.Component
import es.valhallalabs.fermi.kDocsComposer.model.component.ComponentType
import es.valhallalabs.fermi.kDocsComposer.model.component.Frame

class Container(
    override val frame: Frame
) : Component {

    override val componentType = ComponentType.CONTAINER
}