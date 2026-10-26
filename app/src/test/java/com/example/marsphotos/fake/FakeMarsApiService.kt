package com.example.marsphotos.fake

import com.example.marsphotos.data.NetworkMarsPhotosRepository
import com.example.marsphotos.model.MarsPhoto
import com.example.marsphotos.network.MarsApiService
import org.junit.Test
import kotlinx.coroutines.test.runTest
import junit.framework.TestCase.assertEquals

class FakeMarsApiService : MarsApiService {
    override suspend fun getPhotos(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }
}
@Test
fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() =
    runTest {
        val repository = NetworkMarsPhotosRepository(
            marsApiService = FakeMarsApiService()
        )
        assertEquals(FakeDataSource.photosList, repository.getMarsPhotos())
    }
