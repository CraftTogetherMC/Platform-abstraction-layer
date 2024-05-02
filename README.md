# Platform abstraction layer

Platform abstraction layer is a library for abstracting away some server platform specific implementations.

Compared to the [the previous abstraction library](https://github.com/AuroraLS3/Abstract-Plugin-Framework), this library
is more modular and main goal was to use composition rather than inheritance to gain access to the platform
implementations. This allows users of this API to use other libraries without worrying about compatibility issues.

### Supported Minecraft server-platforms

- [Spigot](https://www.spigotmc.org/)
- [BungeeCord](https://www.spigotmc.org/wiki/bungeecord/)
- [Velocity](https://www.velocitypowered.com/)
  
### Repository

```xml
    <repository>
        <id>plan</id>
        <url>https://maven.craft-together-mc.de/</url>
    </repository>
```
### Usage

```xml
    <dependency>
        <groupId>de.crafttogether</groupId>
        <artifactId>platform-abstraction-layer-api</artifactId>
        <version>5.0.0</version>
        <scope>provided</scope>
    </dependency>

    <!-- Pick your platform(s) -->
    <dependency>
        <groupId>de.crafttogether</groupId>
        <artifactId>platform-abstraction-layer-bukkit</artifactId>
        <version>5.0.0</version>
        <scope>provided</scope>
    </dependency>

    <dependency>
        <groupId>de.crafttogether</groupId>
        <artifactId>platform-abstraction-layer-bungeecord</artifactId>
        <version>5.0.0</version>
        <scope>provided</scope>
    </dependency>

    <dependency>
        <groupId>de.crafttogether</groupId>
        <artifactId>platform-abstraction-layer-velocity</artifactId>
        <version>5.0.0</version>
        <scope>provided</scope>
    </dependency>
```
Include this library in your project and shade/shadow the library classes into the final artifact.  
Relocate `de.crafttogether.common.plugin` to a different location to avoid conflicts.

Access the API:

```java
PlatformAbstractionLayer layer;

// org.bukkit.plugin.java.JavaPlugin
layer = new BukkitPlatformLayer(javaPlugin); 
// net.md_5.bungee.api.plugin.Plugin
layer = new BungeePlatformLayer(plugin);
// Object (has @Plugin annotation), ProxyServer, org.slf4j.Logger, Path
layer = new VelocityPlatformLayer(plugin, proxy, logger, dataFolderPath);     
```

See the javadoc for further details on each feature `PlatformAbstractionLayer` provides.

### Features

- Console logging
- Access to plugin meta-data, jar-resources and configuration folder
- Access to platform task scheduling
- Managing listeners of specific platform
