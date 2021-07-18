此包的作用是定义注解

需要在自定义注解上加 @Retention(RetentionPolicy.RUNTIME)，声明该注解可以保留到运行时，再通过反射时才可以正确获取

https://note.youdao.com/s/AfF8c1Et