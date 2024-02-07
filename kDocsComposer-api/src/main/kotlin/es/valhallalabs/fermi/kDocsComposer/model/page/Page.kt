package es.valhallalabs.fermi.kDocsComposer.model.page

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo
import es.valhallalabs.fermi.kDocsComposer.model.component.Component
import es.valhallalabs.fermi.kDocsComposer.model.component.ComponentType
import es.valhallalabs.fermi.kDocsComposer.model.component.Frame

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes(
    Type(value = BandBasedPage::class)
)
interface Page: Component {

    val pageType: PageType
}

enum class PageType { FreePage,
    BandBasedPage
}

interface Band : Component {

    val layout: Layout
}

interface PageHeader : Band

interface PageBody : Band

interface PageFooter : Band


class BandBasedPage(
    val pageHeader: BandBasedPageHeader?,
    val pageBody: BandBasedPageBody,
    val pageFooter: BandBasedPageFooter?
) : Page {

    override val componentType: ComponentType = ComponentType.PAGE_BODY
    override val frame: Frame
        get() = TODO("Not yet implemented")
    override val pageType = PageType.BandBasedPage
}

class BandBasedPageHeader(
    override val frame: Frame,
    val headerComponents: List<Component> = emptyList()
) : PageHeader, Band {

    override val layout = RowLayout(frame = frame, elements = headerComponents)
    override val componentType = ComponentType.PAGE_HEADER
}


class FreeLayout(
    override val frame: Frame,
    override val elements: List<Component>,
) : RelativeLayout {

    override val componentType: ComponentType = ComponentType.LAYOUT
    override val layoutType: LayoutType = LayoutType.RELATIVE_LAYOUT
}

open class FreeLayoutPage(
    override val frame: Frame,
    val elements: List<Component>
) : Page {

    override val pageType = PageType.FreePage

    override val componentType = ComponentType.PAGE_BODY
}

class BandBasedPageBody(
    override val frame: Frame,
    val pageBands: List<Band>
) : PageBody {

    override val componentType = ComponentType.PAGE_BODY
    override val layout: Layout = RowLayout(frame = frame, elements = pageBands)
}

class BandBasedPageFooter(
    override val frame: Frame,
    val footerComponents: List<Component>
) : PageFooter, Band {

    override val layout = RowLayout(frame = frame, elements = footerComponents)
    override val componentType = ComponentType.PAGE_HEADER
}