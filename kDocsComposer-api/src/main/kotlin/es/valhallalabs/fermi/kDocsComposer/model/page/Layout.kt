package es.valhallalabs.fermi.kDocsComposer.model.page

import es.valhallalabs.fermi.kDocsComposer.model.component.Component

interface Layout: Component {
    val elements: List<Component>
}

interface RelativeLayout: Layout {}

interface StackedLayout: Layout {}

