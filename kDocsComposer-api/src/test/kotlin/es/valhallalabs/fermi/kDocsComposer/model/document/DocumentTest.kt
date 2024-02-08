package es.valhallalabs.fermi.kDocsComposer.model.document

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import es.valhallalabs.fermi.kDocsComposer.model.page.*
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test
import java.awt.print.PageFormat
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
                    pageFormat = PageFormat(width = "600", height = "900"), // rest of the data
                    sections = listOf(
                        Section(
                            name = "Document frontpage",
                            pages = listOf(
                                Page(
                                    pageBody = PageBody(
                                        frame = Frame(width = "600", height = "900"),
                                        pageBands = listOf(
                                            PageBand(
                                                layout = Layout(layoutType = "ROW_LAYOUT", elements = listOf())
                                            )
                                        )
                                    ),
                                    pageFooter = PageFooter(
                                        frame = Frame(width = "600", height = "100")
                                    )
                                )
                            )
                        )
                    )
                )
            )
        }
    }
}