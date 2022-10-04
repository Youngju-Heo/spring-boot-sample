import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.3"
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    war
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
}

group = "com.example"
version = if (System.getenv("VERSION").isNullOrBlank()) "0.0.1-SNAPSHOT" else System.getenv("VERSION")
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
    all {
        exclude("org.apache.logging.log4j", "log4j-to-slf4j")
        exclude ("ch.qos.logback", "logback-classic")
        exclude ("org.springframework.boot", "spring-boot-starter-logging")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-log4j2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    //=============================================================================
    // jdbc jpa config
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")
    runtimeOnly("org.postgresql:postgresql")
    //-----------------------------------------------------------------------------

    //=============================================================================
    // zuul gateway proxy 사용하기위한 설정추가
    implementation ("org.springframework.cloud:spring-cloud-starter-bootstrap:3.1.4")
    // spring-cloud-starter-bootstrap 의 fix vulnerability 해결용
    runtimeOnly ("org.bouncycastle:bcprov-jdk15on:1.70")
    // zuul gateway package
    implementation ("org.springframework.cloud:spring-cloud-starter-netflix-zuul:2.2.10.RELEASE")
    // spring-cloud-starter-netflix-zuul 의 fix vulnerability 해결용
    runtimeOnly ("com.google.guava:guava:31.1-jre")
    //-----------------------------------------------------------------------------

    //=============================================================================
    // for jsp parsing
    implementation ("org.apache.tomcat.embed:tomcat-embed-jasper")
    implementation ("javax.servlet:jstl:1.2")
    //-----------------------------------------------------------------------------

    //=============================================================================
    // for log4jdbc
    implementation ("org.bgee.log4jdbc-log4j2:log4jdbc-log4j2-jdbc4:1.16")
    //-----------------------------------------------------------------------------

    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.named("bootWar") {
    println("app version: $version")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
