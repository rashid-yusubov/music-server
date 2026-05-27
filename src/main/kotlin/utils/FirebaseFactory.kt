package com.rashidyusubov.musicserver.utils

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import java.io.FileInputStream

object FirebaseFactory {

    fun init() {

        val serviceAccount = FileInputStream(
            "firebase/firebase-adminsdk.json"
        )

        val options = FirebaseOptions.builder()
            .setCredentials(
                GoogleCredentials.fromStream(serviceAccount)
            )
            .build()

        if (FirebaseApp.getApps().isEmpty()) {

            FirebaseApp.initializeApp(options)
        }
    }
}