# EasyBeanUtil
A collection of classes that easily implement Bean operations.

# Usage
It's Simple Usage.  
Call `copyProperty` in `EasyBeanUtil` class, first arg is source object, second arg is destination object.  
The same field name will be copied.  
This copy is shallow copy.
```
EasyBeanUtil.copyProperty(src, dest);
```
## @CopyField
You can customize the copy operation by adding the `@CopyField` annotation.  
By default, the following operations are supported. (Currently being supported)

### Datetime copy
By Adding `@CopyField("Datetime")`, when copy process, convert String <-> Long(2020-12-31 00:00:00 <-> 1609340400000) of the Datetime.  
The specification method is as follows in the copy source Bean class.
```
@CopyField("Datetime")
private String datetime;
```

destnation Bean class is as follows.
```
private Long datetime;
```
