package es.valhallalabs.fermi.kDocsComposer.model.document

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import es.valhallalabs.fermi.kDocsComposer.model.component.ComponentType
import es.valhallalabs.fermi.kDocsComposer.model.component.Frame
import es.valhallalabs.fermi.kDocsComposer.model.page.*
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test
import es.valhallalabs.fermi.kDocsComposer.model.page.PageFormat
import java.util.*

class DocumentTest {

    @Test fun `test simple document definition`() {

        val documentJson = """
            {
                "documentId": "",
                "pageFormat": {
                    "width": "600",
                    "height": "900"
                },
                "sections": [
                    {
                        "name": "Document frontpage",
                        "pages": [
                            {
                                "pageBody": {
                                    "frame": {
                                        "width": "600",
                                        "height": "900"
                                    },
                                    "pageBands": [
                                        {
                                            "layout": {
                                                "layoutType": "ROW_LAYOUT",
                                                "elements": []
                                            }
                                        }
                                    ]
                                },
                                "pageFooter": {
                                    "frame": {
                                        "width": "600",
                                        "height": "100"
                                    }
                                }
                            }
                        ]
                    }
                ]
            }
        """.trimIndent()

        val mapper = jacksonObjectMapper()
        val document: Document = mapper.readValue(documentJson)

        SoftAssertions.assertSoftly { softly ->
            softly.assertThat(document).usingRecursiveComparison().isEqualTo(
                Document(
                    pageFormat = PageFormat(width = 600f, height = 900f), // rest of the data
                    sections = listOf(
                        DocumentSection(
                            name = "Document frontpage",
                            pages = listOf(
                                BandBasedPage(
                                    pageHeader = null,
                                    pageBody = BandBasedPageBody(
                                        frame = Frame(width = 600f, height = 900f),
                                        pageBands = listOf(
                                            BaseBand(
                                                layout = RowLayout(
                                                    frame = Frame(width = 600f, height = 900f),
                                                    elements = listOf()
                                                ),
                                                componentType = ComponentType.BAND,
                                                frame = Frame(width = 600f, height = 900f),
                                                )
                                        )
                                    ),
                                    pageFooter = null
                                )
                            )
                        )
                    ),
                    datasets = null
                )
            )
        }
    }
}