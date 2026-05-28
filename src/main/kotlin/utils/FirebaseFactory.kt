package com.rashidyusubov.musicserver.utils

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import java.io.ByteArrayInputStream
import java.io.FileInputStream
import java.io.InputStream

object FirebaseFactory {

    fun init() {

        val firebaseConfig =
            System.getenv("FIREBASE_CONFIG")

        val credentialsStream: InputStream =

            if (firebaseConfig != null) {

                ByteArrayInputStream(
                    firebaseConfig.toByteArray()
                )

            } else {

                FileInputStream(
                    "firebase/firebase-adminsdk.json"
                )
            }

        val options = FirebaseOptions.builder()
            .setCredentials(
                GoogleCredentials.fromStream(credentialsStream)
            )
            .build()

        if (FirebaseApp.getApps().isEmpty()) {

            FirebaseApp.initializeApp(options)
        }
    }
}