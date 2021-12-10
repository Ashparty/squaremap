<div align="center">

# squaremap

[![License](https://img.shields.io/github/license/jpenilla/squaremap?color=blue)](LICENSE)
[![GitHub Workflow Status](https://img.shields.io/github/workflow/status/jpenilla/squaremap/Build)](https://github.com/jpenilla/squaremap/actions)

squaremap (formerly known as Pl3xMap) is a minimalistic and lightweight live world map viewer for Paper servers.

</div>

## What is squaremap

If, like me, you have no real need for 3D views, the novelty of Dynmap and Bluemap have worn off, and you're ready for something actually usable for navigation without all the heavy bulk or slow renders then this is the plugin for you.

## Version Support
Currently supports 1.18

## Features

* Ultra fast render times. Get your map viewable today, not next week!
* Simple vanilla-like top down 2D view, designed for navigation.
* Player markers showing yaw rotation, health, and armor
* [Easy configuration](https://github.com/jpenilla/squaremap/wiki/Default-config.yml). Even a caveman can do it.
* Up to date Leaflet front-end.
* [Addons and integrations](ADDONS_INTEGRATIONS.md) for many popular plugins.

## Downloads
Downloads can be obtained from the [releases](https://github.com/jpenilla/squaremap/releases) section.

## Servers Using squaremap

[Click here](SERVERS.md) to view a list of servers using squaremap.

## License
[![MIT License](https://img.shields.io/github/license/jpenilla/squaremap?&logo=github)](LICENSE)

This project is licensed under the [MIT license](https://github.com/jpenilla/squaremap/blob/master/LICENSE)

Leaflet (the web ui frontend) is licensed under [2-clause BSD License](https://github.com/Leaflet/Leaflet/blob/master/LICENSE)

## bStats

[![bStats Graph Data](https://bstats.org/signatures/bukkit/Pl3xMap.svg)](https://bstats.org/plugin/bukkit/Pl3xMap/10133)

## API

Addons written for the Pl3xMap api are generally also compatible with squaremap.

### Dependency Information
Maven
```xml
<repository>
    <id>squaremap-snapshots</id>
    <url>https://repo.jpenilla.xyz/snapshots/</url>
</repository>
```
```xml
<dependency>
    <groupId>xyz.jpenilla</groupId>
    <artifactId>squaremap-api</artifactId>
    <version>1.1.0-SNAPSHOT</version>
    <scope>provided</scope>
</dependency>
```

Gradle
```kotlin
repositories {
    maven("https://repo.jpenilla.xyz/snapshots/")
}
```
```kotlin
dependencies {
    compileOnly("xyz.jpenilla", "squaremap-api", "1.1.0-SNAPSHOT")
}
```

## Building from source

Build squaremap by invoking the `build` task with Gradle.

```
./gradlew build
```
