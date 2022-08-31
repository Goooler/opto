# Opto

![](https://img.shields.io/maven-central/v/com.patrykmichalik.opto/core)

Opto is a lightweight Preferences DataStore wrapper. Read more about it [here](https://patrykmichalik.com/projects/opto).

## Getting started

Opto is available on Maven Central. Ensure this repository is declared in your project-level `build.gradle` file.

```groovy
buildscript {
    repositories {
        mavenCentral()
        ...
    }
    ...
}
```

Then, add the dependencies you need via the module-level `build.gradle` file.

```groovy
def optoVersion = 1.0.15

dependencies {
    implementation "com.patrykmichalik.opto:domain:$optoVersion"
    implementation "com.patrykmichalik.opto:core:$optoVersion"
    implementation "com.patrykmichalik.opto:compose:$optoVersion"
    ...
}
```
