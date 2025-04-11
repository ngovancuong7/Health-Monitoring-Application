plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.healthtrack"
    compileSdk = 35 // Sử dụng compileSdk 35
    //compileSdk = 33 // Đã comment dòng này

    defaultConfig {
        applicationId = "com.example.healthtrack"
        minSdk = 26
        targetSdk = 33 // Sử dụng targetSdk 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // AndroidX Components
    implementation("androidx.appcompat:appcompat:1.7.0-alpha03") // Cập nhật AppCompat
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.annotation:annotation:1.7.1")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.work:work-runtime-ktx:2.9.0") // Cập nhật WorkManager

    // Lifecycle Components
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")

    // Material Design
    implementation("com.google.android.material:material:1.11.0-alpha03") // Cập nhật Material Design

    // Network
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // UI Libraries
    implementation("de.hdodenhof:circleimageview:3.1.0")
    implementation("com.github.PhilJay:MPAndroidChart:3.1.0")
    implementation("com.github.ybq:Android-SpinKit:1.4.0")
    implementation("com.squareup:android-times-square:1.6.5@aar")
    implementation("io.github.ShawnLin013:number-picker:2.4.13")
    implementation("com.github.cachapa:ExpandableLayout:2.9.2")
    implementation("com.github.prolificinteractive:material-calendarview:2.0.0")
    implementation("com.github.dmytrodanylyk:circular-progress-button:1.4")
    implementation("com.github.cjhandroid:WaveProgressBar:v1.0.0")

    // Image Loading
    implementation("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")

    // ZXing (QR Code)
    implementation("com.journeyapps:zxing-android-embedded:4.1.0")
    implementation("com.google.zxing:core:3.3.3")

    // Time
    implementation("com.jakewharton.threetenabp:threetenabp:1.2.0")

    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:32.8.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-storage")
    implementation("com.google.firebase:firebase-auth:22.3.1")
    implementation("com.google.android.gms:play-services-auth:21.0.0")

    // JSON
    implementation("com.google.code.gson:gson:2.10.1")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
}