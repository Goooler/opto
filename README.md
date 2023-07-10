# Opto

[![Maven Central](https://img.shields.io/maven-central/v/com.patrykmichalik.opto/core)](https://central.sonatype.com/artifact/com.patrykmichalik.opto/core)

Opto is a lightweight Preferences DataStore wrapper. Read more about it [here](https://patrykmichalik.com/projects/opto). This repo is a fork of [patrykandpatrick/opto](https://github.com/patrykandpatrick/opto).

## Getting started

Opto is available on Maven Central. Ensure this repository is declared in your project-level `build.gradle` file.

```groovy
allprojects {
    repositories {
        mavenCentral()
    }
}
```

Then, add the dependencies you need via the module-level `build.gradle` file.

```groovy
dependencies {
    def optoVersion = "1.0.15"

    implementation "com.patrykmichalik.opto:domain:$optoVersion"
    implementation "com.patrykmichalik.opto:core:$optoVersion"
    implementation "com.patrykmichalik.opto:compose:$optoVersion"
}
```
