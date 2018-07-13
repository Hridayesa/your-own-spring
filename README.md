# Write your own spring
## Exercise #7 (Implement the way of creating proxies for aspect logic)
Now you should implement the way to enhance the behaviour of beans. 
Do it by creating proxies for beans.
* Create annotation ```@Benchmark``` and use in ```SpeakerImpl```
* Create system code that applies different "proxy" logic after creating and configuring a new bean.  
* Create "business" logic code that implements proxy for ```@Benchmark``` that counts method execution time.

There are several ways to create proxy. This time use dynamic proxy:
```java
import java.lang.reflect.Proxy;
...
Proxy.newProxyInstance(...)
```

To get interfaces use:
```java
type.getInterfaces();
```
## Solution in ```exercise7-solution``` branch