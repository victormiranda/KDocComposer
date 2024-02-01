package es.valhallalabs.fermi.kDocsComposer.model.page

import es.valhallalabs.fermi.kDocsComposer.model.component.ComponentType
import es.valhallalabs.fermi.kDocsComposer.model.component.Frame

class BandBasedPageBody(
    override val frame: Frame,
    val pageBands: List<Band>
) : PageBody {

    override val componentType = ComponentType.PAGE_BODY
    override val layout: Layout = RowLayout(frame = frame, elements = pageBands)
}