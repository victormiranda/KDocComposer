package es.valhallalabs.fermi.kDocsComposer.model.document

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import es.valhallalabs.fermi.kDocsComposer.model.page.BandBasedPage
import es.valhallalabs.fermi.kDocsComposer.model.page.BandBasedPageBody
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test

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

        // Use SoftAssertions
        SoftAssertions.assertSoftly { softly ->
            softly.assertThat(document.pageFormat.width).isEqualTo("600")
            softly.assertThat(document.pageFormat.height).isEqualTo("900")

            softly.assertThat(document.sections).hasSize(1)
            val section = document.sections[0]
            softly.assertThat(section.name).isEqualTo("Document frontpage")

            softly.assertThat(section.pages).hasSize(1)
            val page = section.pages[0] as BandBasedPage

            softly.assertThat(page.pageBody.frame.width).isEqualTo("600")
            softly.assertThat(page.pageBody.frame.height).isEqualTo("900")
            val bandBasedPageBody = page.pageBody
            softly.assertThat(bandBasedPageBody.pageBands[0].layout.layoutType).isEqualTo("ROW_LAYOUT")
        }
    }
}