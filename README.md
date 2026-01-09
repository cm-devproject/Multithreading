# Multithreading in Java: Producer-Consumer Problem

This project demonstrates the classic Producer-Consumer problem using Java multithreading. It showcases synchronization between threads using a shared buffer, wait/notify mechanisms, and basic thread communication.

## Project Overview

The Producer-Consumer problem is a synchronization problem where one or more producer threads produce items and place them in a shared buffer, while one or more consumer threads consume items from the same buffer. The challenge is to ensure that producers don't add items to a full buffer and consumers don't remove items from an empty buffer.

In this implementation:
- **Producer**: Generates numbers from 1 to 10 and adds them to the shared buffer.
- **Consumer**: Removes numbers from the shared buffer and "consumes" them.
- **SharedBuffer**: A synchronized buffer that holds up to one item at a time (for simplicity), using `wait()` and `notify()` for thread coordination.

## Project Structure

```
Multithreading/
├── README.md                    # This file
├── .gitignore                   # Ignores build artifacts and IDE files
├── ProducerConsumerProject/
│   ├── pom.xml                  # Maven project configuration
│   ├── Utils.md                 # Build and run commands
│   └── src/main/java/com/mutithreading/producercustomer/
│       ├── Main.java            # Application entry point
│       ├── Producer.java        # Producer thread implementation
│       ├── Consumer.java        # Consumer thread implementation
│       └── SharedBuffer.java    # Shared buffer with synchronization
└── target/                      # Maven build output (ignored by .gitignore)
```

## Files Explanation

### Main.java
The entry point of the application. It:
- Creates a `SharedBuffer` instance.
- Instantiates `Producer` and `Consumer` threads, passing the shared buffer.
- Starts both threads to begin the producer-consumer workflow.

### Producer.java
The producer thread class that extends `Thread`. It:
- Runs a loop to produce items (numbers 1 through 10).
- Calls `buffer.put(item)` to add each item to the shared buffer.
- Simulates production time with a short sleep (100ms).

### Consumer.java
The consumer thread class that extends `Thread`. It:
- Runs a loop to consume 10 items.
- Calls `buffer.take()` to remove and return an item from the shared buffer.
- Simulates consumption time with a short sleep (150ms).

### SharedBuffer.java
The core synchronization component. It:
- Maintains a single integer buffer (can be extended to a queue).
- Uses `synchronized` methods to ensure thread safety.
- Implements `put(int item)`: Waits if buffer is full, adds item, notifies waiting consumers.
- Implements `take()`: Waits if buffer is empty, removes and returns item, notifies waiting producers.
- Uses `wait()` and `notify()` for efficient thread blocking/unblocking.

### pom.xml
Maven configuration file that:
- Defines project metadata (groupId, artifactId, version).
- Sets Java compiler source and target to version 17.
- Allows building the project with `mvn clean package`.

### Utils.md
Contains the exact commands used to build and run the project, along with sample output.

## Workflow

1. **Initialization**: `Main` creates the `SharedBuffer` and thread instances.

2. **Thread Start**: Both `Producer` and `Consumer` threads start executing concurrently.

3. **Production Phase**:
   - Producer generates item 1, calls `buffer.put(1)`.
   - If buffer is empty, item is added and consumer is notified.
   - Producer continues producing items 2-10, sleeping briefly between each.

4. **Consumption Phase**:
   - Consumer calls `buffer.take()`, waits if buffer is empty.
   - When notified by producer, consumes the item and prints it.
   - Continues until all 10 items are consumed.

5. **Synchronization**:
   - If producer tries to put when buffer is full, it waits.
   - If consumer tries to take when buffer is empty, it waits.
   - `notify()` wakes up waiting threads when state changes.

6. **Termination**: Threads complete their loops and exit naturally.

## How to Build and Run

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Build
```bash
cd ProducerConsumerProject
mvn clean package -DskipTests
```

### Run
```bash
java -cp target/classes com.mutithreading.producercustomer.Main
```

## Sample Output

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

The output shows interleaved production and consumption, demonstrating concurrent execution with proper synchronization.

## Key Concepts Demonstrated

- **Multithreading**: Creating and managing multiple threads.
- **Synchronization**: Using `synchronized`, `wait()`, and `notify()`.
- **Thread Safety**: Protecting shared resources from race conditions.
- **Producer-Consumer Pattern**: Classic inter-thread communication.
- **Blocking Queues**: Basic implementation of a blocking buffer.

## Extensions

To make it more realistic:
- Increase buffer size to allow multiple items.
- Add multiple producers/consumers.
- Use `BlockingQueue` from java.util.concurrent for production code.
- Add proper exception handling and thread interruption.

---

Repository: [https://github.com/cm-devproject/Multithreading](https://github.com/cm-devproject/Multithreading)
