# JIRA Issue

- [SPR-16514](https://jira.spring.io/browse/SPR-16514)


In our system we use the short live non singleton bean. After upgrade to Spring 5.0.3 our performance tests has performance degradation caused by slowdown the bean creation. Here is a speed comparison between the Spring 4.3.6 and the Spring 5.0.3:

## Spring 4.3.6.RELEASE
```
PerformanceIssue - 1000 bean creations 67 ms
PerformanceIssue - 10000 bean creations 161 ms
PerformanceIssue - 100000 bean creations 222 ms
```

## Spring 5.0.3.RELEASE
```
PerformanceIssue - 1000 bean creations 100 ms
PerformanceIssue - 10000 bean creations 296 ms
PerformanceIssue - 100000 bean creations 1894 ms
```

This problem is caused by Assert.notNull in method AnnotationUtils.synthesizeAnnotation. See the YourKit call tree:

Spring 4.3.6.RELEASE: ![YourKit-Spring4](https://raw.githubusercontent.com/bednar/spring-5-performance-issue/master/src/main/resources/YourKit-Spring4.png "YourKit-Spring4")

Spring 5.0.3.RELEASE: ![YourKit-Spring5](https://raw.githubusercontent.com/bednar/spring-5-performance-issue/master/src/main/resources/YourKit-Spring5.png "YourKit-Spring5")
