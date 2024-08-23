plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

// Calculator that allows me to add any numbers separated by a comma. If there is only one number, we should return that
// if there are none, return 0,

// e.g. input "", "1", "1234", "23,45" ,"1,2,3,4"