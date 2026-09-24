# British Spoken Time

A Java application that converts a 24-hour time input into its British spoken form.

## Requirements

* Java 17 or later
* Maven 3.x

## How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA or another Java IDE.
3. Run the `Main` class.

The application accepts time in `H:mm` or `HH:mm` format.

Example:

```text
Enter time (HH:mm): 7:35
twenty-five to eight

Enter time (HH:mm): 9:45
quarter to ten

Enter time (HH:mm): 12:00
noon

Enter time (HH:mm): exit
Goodbye!
```

Type `exit` to stop the application.

## Input Format

Valid input must use:

```text
H:mm
HH:mm
```

Examples:

```text
1:05
01:05
12:30
23:55
```

Invalid examples:

```text
1:5
01:5
24:00
12:60
```

## Supported Spoken Time Rules

| Time  | Spoken form          |
| ----- | -------------------- |
| 00:00 | midnight             |
| 01:00 | one o'clock          |
| 02:05 | five past two        |
| 03:10 | ten past three       |
| 04:15 | quarter past four    |
| 05:20 | twenty past five     |
| 06:25 | twenty-five past six |
| 06:32 | six thirty-two       |
| 07:30 | half past seven      |
| 07:35 | twenty-five to eight |
| 08:40 | twenty to nine       |
| 09:45 | quarter to ten       |
| 10:50 | ten to eleven        |
| 11:55 | five to twelve       |
| 12:00 | noon                 |

## Running Tests

The project uses JUnit 5 for unit testing.

From IntelliJ IDEA, run the test classes under:

```text
src/test/java
```

The tests cover:

* Time input parsing
* Invalid input validation
* Exact hours
* Minutes past the hour
* Quarter past
* Half past
* Numeric minute format
* Minutes to the next hour
* Quarter to
* Midnight
* Noon

## Technologies

* Java 17
* Maven
* JUnit 5
