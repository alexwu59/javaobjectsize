使用者如果可以定义自己的类，然后在SizeOfObjectTest中执行
```
System.out.println("sizeOf(new A())=" + sizeOf(new A()));
```
便可以打印出当前A的字节大小

使用maven完成程序打包之后，在该项目的根目录下启动命令行执行
```$xslt
java -javaagent:target/test.jar -XX:+UseCompressedOops  com.ws.jvm.SizeOfObjectTest
```
注意：-XX:+UseCompressedOops表示开启指针压缩 默认开启
     -XX:-UseCompressedOops表示关闭指针压缩
