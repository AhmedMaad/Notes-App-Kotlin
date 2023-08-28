plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id ("kotlin-parcelize")
}

android {
    namespace = "com.example.android.notesappkotlin"
    compileSdk = 33

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.example.android.notesappkotlin"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Room + Coroutines support for Room
    implementation ("androidx.room:room-ktx:2.5.2")
    //The Room annotation processor generates the code that actually implements the database,
    //so it is essential for using Room.
    kapt("androidx.room:room-compiler:2.5.2")

    //Coroutines support for view model
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
}