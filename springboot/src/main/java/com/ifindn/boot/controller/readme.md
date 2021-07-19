#SpringBoot核心技术
##1、自动配置原理：
###1.1依赖管理
```xml
<!--依赖管理-->
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.5.0</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```
   开发导入starter场景启动器

   无需关注版本，spring-boot-dependencies中规定了大部分场景的版本
   


