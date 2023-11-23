buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Dependencies.hiltAgp)
        classpath(Dependencies.gradlePlugin)
        //classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
    }
}