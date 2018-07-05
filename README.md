# Write your own spring
## Exercise #4 (Configure object before use. Part2)
Now you should create customizable way to add a different "bean configurators".
We introduce an interface ```MyBeanPostProcessor```
You need to scan for all ```MyBeanPostProcessor``` implementations and then apply it to all new beans.
You can use:
```java
import org.reflections.Reflections;
scanner = new Reflections(packageName);
scanner.getSubTypesOf(key);
```

## Solution in ```exercise4-solution``` branch
