group = "com.willfp"
version = rootProject.version

dependencies {
    compileOnly(fileTree("../../lib") {
        include("*.jar")
    })
    compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")
    compileOnly("net.essentialsx:EssentialsX:2.19.7") {
        exclude("*", "*")
    }
}

tasks {
    build {
        dependsOn(publishToMavenLocal)
    }
}
