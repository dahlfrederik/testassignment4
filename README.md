# Assignment 4 

## 1. Mockito powerups  
*Answer the following questions about Mockito*


**How do you verify that a mock was called?** 

Utilizing the Mockito method verify. 

See code example below

```java
Mockito.verify(yourMock).someMethod();
```

**How do you verify that a mock was NOT called?** 

Utilizing the Mockito method verify and adding the parameter **never()**.

See code example below

```java
Mockito.verify(yourMock, never()).someMethod();
```

**How do you specify how many times a mock should have been called?** 

Utilizing the Mockito method verify and using the **Mockito.times("amount of times")**. 

See code example below

```java
Mockito.verify(yourMock, Mockito.times(1)).add("1");
```

**How do you verify that a mock was called with specific arguments?** 

Utilizing the Mockito method verify and this time in the method **adding the specified parameter** we want to verify. 

See code example below

```java
Mockito.verify(yourMock).someMethod("specific arguments");
```

**How do you use a predicate to verify the properties of the arguments given to a call to the mock?**

Utilizing the Mockito method verify and a lambda arrow functions. This is a possible since Mockito 2.1.0 has the ArgumentMatcher interface which can be used to compare method calls. 

See code example below

```java
Mockito.verify(yourMock).doThing(argThat((Bar aBar) -> aBar.getI() == 5));
```


## 2. At least one 

**A:** Snake game 

First run the command `mvn clean install`

To run the snake game open your terminal and run the command: `mvn clean javafx:run`

To run the test run the command `mvn clean test`

**Code coverage**
![Jacoco test coverage](/Users/frederikdahl/Soft dev/2 semester/Test/Handins/test_handin4/jacoco.png)
