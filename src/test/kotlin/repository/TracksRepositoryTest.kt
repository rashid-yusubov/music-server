package repository

import com.rashidyusubov.musicserver.data.database.DatabaseFactory
import com.rashidyusubov.musicserver.data.repository.TracksRepositoryImpl
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class TracksRepositoryTest {

    private val repository = TracksRepositoryImpl()

    @BeforeTest
    fun setup() {

        DatabaseFactory.init()
    }

    @Test
    fun `get all tracks returns tracks`() {

        runBlocking {

            val result = repository.getAllTracks()

            assertTrue(result.isNotEmpty())
        }
    }

    @Test
    fun `search tracks returns matching result`() {

        runBlocking {

            val result = repository.searchTracks("Believer")

            assertTrue(result.isNotEmpty())
        }
    }

    @Test
    fun `get track by id returns track`() {

        runBlocking {

            val result = repository.getTrackById(1)

            assertNotNull(result)
        }
    }
}