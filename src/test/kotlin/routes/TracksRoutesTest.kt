package routes

import com.rashidyusubov.musicserver.module
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class TracksRoutesTest {

    @Test
    fun `get tracks returns 200`() = testApplication {

        application { module() }

        val response = client.get("/tracks")

        assertEquals(HttpStatusCode.OK, response.status
        )
    }

    @Test
    fun `search tracks returns 200`() = testApplication {

        application { module() }

        val response = client.get("/tracks/search?query=believer")

        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun `invalid route returns 404`() = testApplication {

        application { module() }

        val response = client.get("/tracks/999999")

        assertEquals(HttpStatusCode.NotFound, response.status)
    }

    @Test
    fun `empty search query returns success`() = testApplication {

        application { module() }

        val response = client.get("/tracks/search?query=")

        assertEquals(HttpStatusCode.BadRequest, response.status)
    }
}