package es.valhallalabs.fermi.kDocsComposer.model.page

import com.fasterxml.jackson.annotation.JsonTypeInfo
import es.valhallalabs.fermi.kDocsComposer.model.component.Component


interface Layout: Component {
    val elements: List<Component>
    val layoutType: LayoutType
}

interface RelativeLayout: Layout {}

interface StackedLayout: Layout {}

