# Write your own spring
## Exercise #2 (Reflection scan for implementations)
Now __implClasses__ in __Configuration__ is empty. You need to scan package for implementations.
You can use __org.reflections.Reflections__ 
```
import org.reflections.Reflections;
scanner = new Reflections(packageName);
...
scanner.getSubTypesOf(key);
```
## Solution in __exercise2-solution__ branch