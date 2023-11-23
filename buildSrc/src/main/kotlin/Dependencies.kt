import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Dependencies {

    const val gradlePlugin ="org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.gradlePlugin}"


    const val coreKtx ="androidx.core:core-ktx:${Versions.coreKtx}"
    const val junit ="junit:junit:${Versions.junit}"
    const val lifecycleRuntimeKtx ="androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"
    const val androidTestJunit ="androidx.test.ext:junit:${Versions.androidTestJunit}"
    const val androidTestEspresso ="aandroidx.test.espresso:espresso-core:${Versions.androidTestEspresso}"

    const val composeMaterial = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val composeActivity ="androidx.activity:activity-compose:${Versions.composeActivity}"
    const val composeUiTestJunit ="androidx.compose.ui:ui-test-junit4"
    const val composeUiTestManifest ="androidx.compose.ui:ui-test-manifest"


    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
}


fun DependencyHandler.defaultDependencies() {
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.lifecycleRuntimeKtx)
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.androidTestJunit)
    androidTestImplementation(Dependencies.androidTestEspresso)
}


fun DependencyHandler.room() {
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpLoggingInterceptor)
}

fun DependencyHandler.compose() {
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeRuntime)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composeActivity)
    debugImplementation(Dependencies.composeUiToolingPreview)
    debugImplementation(Dependencies.composeUiTestManifest)
    androidTestImplementation(Dependencies.composeUiTestJunit)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
}

fun DependencyHandler.booksDataSource() {
    implementation(project(":books-datasource"))
}

fun DependencyHandler.booksUi() {
    implementation(project(":books-ui"))
}