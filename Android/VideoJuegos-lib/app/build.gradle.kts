plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.volumidev.videogameslib"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.volumidev.videogameslib"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    // Conversor de Gson para Retrofit
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // Opcional: Para manejar llamadas asíncronas de manera más eficiente
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")

    
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}