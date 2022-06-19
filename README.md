# work-with-secrets

## Motivation
 > Docker secrets do not set environment variables directly. 
 > This was a conscious decision, because environment variables can 
 > unintentionally be leaked between containers.

_from_: https://docs.docker.com/engine/swarm/secrets/#build-support-for-docker-secrets-into-your-images


### SmallRye FileSystem Config Source
https://smallrye.io/docs/smallrye-config/main/config-sources/config-sources.html#filesystem-config-source

### Quarkus PR
https://github.com/quarkusio/quarkus/pull/21478

Using in `build.gradle`:
```groovy
implementation 'io.smallrye.config:smallrye-config-source-file-system'
```

Using in `pom.xml`:
```xml
<dependency>
  <groupId>io.smallrye.config</groupId>
  <artifactId>smallrye-config-source-file-system</artifactId>
</dependency>
```