# Getting Started

The project includes the following:
* spring sleuth
* zipkin
* liquibase
* spring webflux


#### spring sleuth
```groovy
//refer to build.gradle file: 
    implementation 'org.springframework.cloud:spring-cloud-starter-sleuth'
```

The traceId and spanId are listed in the log statements:
```less
2022-11-12 14:21:17.020  INFO [books-library,56893dda2ddf40e2,56893dda2ddf40e2] 29131 --- [         task-6] reactor.Flux.Take.1                      : request(1)
2022-11-12 14:21:17.119  INFO [books-library,56893dda2ddf40e2,56893dda2ddf40e2] 29131 --- [     parallel-7] reactor.Flux.Take.1                      : onNext(Book(id=7, title=Services, author=Cellect Biotechnology Ltd., published=true))
2022-11-12 14:21:17.121  INFO [books-library,56893dda2ddf40e2,56893dda2ddf40e2] 29131 --- [         task-7] reactor.Flux.Take.1                      : request(1)
2022-11-12 14:21:17.224  INFO [books-library,56893dda2ddf40e2,56893dda2ddf40e2] 29131 --- [     parallel-8] reactor.Flux.Take.1                      : onNext(Book(id=8, title=Sales, author=First Trust Multi-Asset Diversified Income Index Fund, published=true))
2022-11-12 14:21:17.225  INFO [books-library,56893dda2ddf40e2,56893dda2ddf40e2] 29131 --- [         task-8] reactor.Flux.Take.1                      : request(1)
2022-11-12 14:21:17.327  INFO [books-library,56893dda2ddf40e2,56893dda2ddf40e2] 29131 --- [     parallel-9] reactor.Flux.Take.1                      : onNext(Book(id=9, title=Engineering, author=Boston Omaha Corporation, published=true))

```
#### liquibase
```groovy
//refer to build.gradle file:
    implementation 'org.liquibase:liquibase-core:4.13.0'

//The db versions are maintained at resources/db folder    
```

#### zipkin
```groovy
//refer to build.gradle file:
    implementation 'org.springframework.cloud:spring-cloud-starter-zipkin:2.2.8.RELEASE'
```

#### webflux
```groovy
//refer to build.gradle file:
    implementation 'org.springframework.boot:spring-boot-starter-webflux'
```


#### Dependencies in build.gradle file:
```groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-webflux'
    implementation 'org.springframework.boot:spring-boot-starter-web'

    implementation 'org.springframework.boot:spring-boot-starter-actuator'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'

    implementation 'org.springframework.cloud:spring-cloud-starter-sleuth'
    implementation 'org.springframework.cloud:spring-cloud-starter-zipkin:2.2.8.RELEASE'

    implementation 'org.liquibase:liquibase-core:4.13.0'

    implementation 'ch.qos.logback:logback-classic:1.2.11'

    runtimeOnly group: 'com.h2database', name: 'h2', version: '2.0.204'

    compileOnly 'org.projectlombok:lombok'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

```

#### Enable default sampler for sleuth.

```java
    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

```

#### Update application.yaml file to refer to local zipkin.
```properties
  zipkin:
    enabled: true
    baseUrl: http://localhost:9411/

```


#### Database used - H2
```properties
  h2:
    console:
      enabled: true
      # http://localhost:8083/console
      path: /h2
      settings:
        trace: false
        web-allow-others: false

  datasource:
    driverClassName: org.h2.Driver
    url: jdbc:h2:mem:tutorials_db;DB_CLOSE_ON_EXIT=FALSE
    #    url: jdbc:h2:file:~/h2/tutorials_db;DB_CLOSE_ON_EXIT=FALSE
    username: sa
    password: admin123

```

#### local setup
This will start zipkin server locally with port 9411. 
```properties
docker-compose up
```

If you see the below error while starting the springboot application, it is mostly due to unavailability of zipkin server.
Make sure that the `docker-compose up` command has been run successfully.
```java
org.springframework.web.client.ResourceAccessException: I/O error on POST request for "http://localhost:9411/api/v2/spans": Connection refused; nested exception is java.net.ConnectException: Connection refused
	at org.springframework.web.client.RestTemplate.doExecute(RestTemplate.java:785) ~[spring-web-5.3.22.jar:5.3.22]

```

```properties
#this will list the status of dependent applications:
    
docker-compose ps
```

To test the application refer to
* [Library.md](Library.md)
* [Person.md](Person.md)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)