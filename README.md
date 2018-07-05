# Write your own spring
## Exercise #5 (Create your own @Autowire)
Now you should create @Autowire implementation on top of ```BeanPostProcessor```
* Remove the static code from ```ApplicationContext```
* Create IRobot from context
* Create ```MyAutowireBeanPostProcessor```
* If you need ```ApplicationContext``` inside your ```BeanPostProcessor``` you need to "inject" it (inversion of control)
You can use:
```java
public interface ApplicationContextAware {
    void setApplicationContext(ApplicationContext applicationContext);
}
```

## Solution in ```exercise5-solution``` branch
