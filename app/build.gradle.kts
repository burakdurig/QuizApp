plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.mastercoding.thequizapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mastercoding.thequizapp"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    //LifeCycle Dependencies
    val lifecycle_version = "2.8.7"
    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version")
    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata:$lifecycle_version")

    //Retrofit Depend
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")


    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}