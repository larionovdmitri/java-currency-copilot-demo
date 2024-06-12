# Demo Currency Converter App

## Install Command
```bash
mvn clean install
```

## Depenedency Command
```bash
mvn dependency:resolve
```

## Build Command
```bash
mvn clean test-compile test
```

## Run Exe
```bash
java -jar target/my-app-1.0-SNAPSHOT.jar
```

## Compile and Watch Tests Command
```bash
mvn com.github.terefang:maven-watcher-plugin:watch
```

## Generated Project with 

[Source](https://stackoverflow.com/questions/6704813/maven-generating-pom-file)

` mvn archetype:generate "-DgroupId=com.mycompany.app" "-DartifactId=my-app" "-DarchetypeArtifactId=maven-archetype-quickstart" "-DarchetypeVersion=1.4" "-DinteractiveMode=false"`