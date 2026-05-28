package routes

import com.rashidyusubov.musicserver.module
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class ArtistsRoutesTest {

    @Test
    fun `get artists returns 200`() = testApplication {

        application { module() }

        val response = client.get("/artists")

        assertEquals(HttpStatusCode.Companion.OK, response.status)
    }

    @Test
    fun `artists endpoint returns non empty response`() = testApplication {

        application { module() }

        val response = client.get("/artists")

        assertEquals(true, response.bodyAsText().isNotBlank())
    }
}