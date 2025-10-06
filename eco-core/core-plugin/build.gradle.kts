group = "com.willfp"
version = rootProject.version

dependencies {
    compileOnly(fileTree("../../lib") {
        include("*.jar")
    }
    )
    compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")
    compileOnly("net.essentialsx:EssentialsX:2.19.7") {
        exclude("*", "*")
    }
    compileOnly("commons-lang:commons-lang:2.6")
}

tasks {
    build {
        dependsOn("publishToMavenLocal")
    }
}
