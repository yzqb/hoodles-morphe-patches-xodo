group = "io.github.yzqb"

patches {
    about {
        name = "Xodo Patches"
        description = "Xodo patches maintained by yzqb; based on Hoo-dles Morphe Patches"
        source = "https://github.com/yzqb/hoodles-morphe-patches-xodo"
        author = "Hoo-dles, yzqb"
        contact = "https://github.com/yzqb/hoodles-morphe-patches-xodo/issues"
        website = "https://github.com/yzqb/hoodles-morphe-patches-xodo"
        license = "GPLv3"
    }
}

dependencies {
    implementation(libs.morphe.patches.library)
    implementation(libs.guava)
}

kotlin {
    compilerOptions {
        freeCompilerArgs = listOf("-Xcontext-parameters")
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
    jvmToolchain(17)
}
java {
    targetCompatibility = JavaVersion.VERSION_17
    sourceCompatibility = JavaVersion.VERSION_17
}
