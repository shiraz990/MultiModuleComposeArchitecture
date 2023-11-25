plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    namespace = "com.feature.movie.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    buildFeatures {
        buildConfig = true
    }
    flavorDimensions += listOf("mode")
    productFlavors {
        create("development") {
            dimension = "mode"
            buildConfigField("String", "API_BASE_URL", "\"https://api.themoviedb.org/\"")

        }
        create("production") {
            dimension = "mode"
            buildConfigField("String", "API_BASE_URL", "\"https://api.themoviedb.org/\"")

        }
    }
}

dependencies {

    implementation(project(":feature:movie:domain"))
    implementation(project(":core:network"))
    /*implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)*/
    defaultDependencies()
    hilt()
}