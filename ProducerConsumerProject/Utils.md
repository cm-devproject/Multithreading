Commands used to build and run the ProducerConsumerProject

Run these from the repository root (project directory is `ProducerConsumerProject`  cd ProducerConsumerProject):

1. Build (skip tests):

```
mvn clean package -DskipTests
```

2. Run the main class:

```
java -cp target/classes Main
```

Notes:
- I added a minimal `pom.xml` to allow the Maven build to succeed.

Observed output (sample):

```
Produced: 1
Consumed: 1
Produced: 2
Consumed: 2
Produced: 3
Produced: 4
Consumed: 3
Produced: 5
Consumed: 4
Produced: 6
Produced: 7
Consumed: 5
Produced: 8
Consumed: 6
Produced: 9
Produced: 10
Consumed: 7
Consumed: 8
Consumed: 9
Consumed: 10
```
