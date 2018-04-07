## For windows users, change console code page
```bash
chcp 1251
Active code page: 1251
```
## For not windows users, remove from log4j.properties
log4j.appender.A1.encoding=Cp1251

## Build project
test-branch
```bash
mvn clean install
```
## Run app
```bash
java -jar target/search-1.0-SNAPSHOT.jar
   ```