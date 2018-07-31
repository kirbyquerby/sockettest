# sockettest
Simple project to locally test
[Google Cloud JDBC Socket Factory](https://github.com/GoogleCloudPlatform/cloud-sql-jdbc-socket-factory).

## Running

1. Build a snapshot version of the Socket Factory
2. Update this project's pom.xml to match the version
3. Run
```
mvn clean install
mvn exec:java
```

