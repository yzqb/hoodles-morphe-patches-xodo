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
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
    jvmToolchain(17)
}
java {
    targetCompatibility = JavaVersion.VERSION_17
    sourceCompatibility = JavaVersion.VERSION_17
}

val verification = sourceSets.create("verification") {
    compileClasspath += configurations["compileClasspath"]
}

tasks.processResources {
    from(rootProject.file("LICENSE"))
    from(rootProject.file("NOTICE"))
}

tasks.named("build") {
    dependsOn("buildAndroid")
}

tasks.register<JavaExec>("verifyBundle") {
    description = "Loads the Android bundle and verifies Xodo-only patches and version metadata."
    group = "verification"
    dependsOn("buildAndroid", verification.classesTaskName)
    classpath = verification.output + configurations["runtimeClasspath"]
    mainClass.set("VerifyBundle")
    args(layout.buildDirectory.file("libs/patches-${project.version}.mpp").get().asFile.absolutePath)
}
