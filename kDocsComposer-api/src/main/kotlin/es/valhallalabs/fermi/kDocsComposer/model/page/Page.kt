package es.valhallalabs.fermi.kDocsComposer.model.page

import es.valhallalabs.fermi.kDocsComposer.model.component.Component

interface Page {

    val pageHeader: PageHeader
    val pageBody: PageBody
    val pageFooter: PageFooter
}

interface Band: Component {
    val layout: Layout
}

interface PageHeader : Band

interface PageBody : Band

interface PageFooter : Band