# Opto

[![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/io.github.goooler.opto/core?&server=https://s01.oss.sonatype.org/)](https://s01.oss.sonatype.org/content/repositories/snapshots/io/github/goooler/opto/)

Opto is a lightweight Preferences DataStore wrapper. Read more about it [here](https://patrykmichalik.com/projects/opto).

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
    implementation "io.github.goooler.opto:domain:$optoVersion"
    implementation "io.github.goooler.opto:core:$optoVersion"
    implementation "io.github.goooler.opto:compose:$optoVersion"
}
```
