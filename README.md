# Write your own spring
## Exercise #3 (Configure object before use)
Let's do injection of random int in to the int field.
Create annotation ```InjectRandomInt```. Then add configuration code in to the factory. For each new bean you need scan for the fields with annotation ```InjectRandomInt``` and do injection. 

You can use:
```java
import org.reflections.ReflectionUtils;
ReflectionUtils.getAllFields(implClass);
```

In this exercise you need to fix test.
## Solution in __exercise3-solution__ branch