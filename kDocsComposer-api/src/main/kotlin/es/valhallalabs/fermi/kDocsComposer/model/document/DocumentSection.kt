package es.valhallalabs.fermi.kDocsComposer.model.document

import es.valhallalabs.fermi.kDocsComposer.model.page.Page

class DocumentSection(
    val name: String,
    val pages: List<Page>
)