# debug-core库使用手册


* 库名称：`com.abooc.debug:debug-core:1.1.0`
* 当前版本：`v1.1.0`
* 开发语言：`Java`
* 适于开发平台：`Android`

## 概述

**简述**：封装**debug-core**库，提高开发期间的测试效率，提高生产力。

本库主要有以下功能：

- **打印日志**：封装android.util.Log类，方便日志输出
- **定位代码**：输出的日志可以快速定位到具体代码

## 介绍

主要功能类：

- Debug.class
	- 负责debug日志打印。
- Toast.class
	- 显示吐司

## 使用方法

**1. 添加远程仓库**

```
	maven{ url 'http://oss.abooc.com/repository/maven-public/' }
```

**2. 引入项目**

```
    compile 'com.abooc.debug:debug-core:1.1.0'
```

**3. 开启日志**

```java
public class AppApplication extends Application {

    @Override
    public void onCreate() {
        Debug.enable(BuildConfig.DEBUG); // 开启Debug
        super.onCreate();
        ...
```

**4. 用于代码定位（代码锚点）**

```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Debug.anchor(); // 代码定位
        ...
```

此时，日志打印：

```
// PID            包名     级别  TAG     类名         方法    代码超链到行
$ 30586-30586 /com.xxx.xx D/Debug:MainActivity.onCreate(MainActivity.java:19):
```

**输出表示**：

> Debug锚点定位到类`MainActivity.java`的`onCreate`方法，具体在第`19`行。且生成名为`MainActivity.java:19`的超链接，鼠标左击可定位到代码处。

即，`Debug.anchor()`方法的作用：

- 定位到**类名**
- 定位到**方法名**
- 定位到**代码行**
- 超链接到代码

此方法通常用于：对代码的**执行流程**进行锚点，方便检验代码执行顺序是否与期望一致。

**5. 用于打印**

```
@Override
public void onReceiveMessage(String message) {
    Debug.anchor(message); // 打印'message'
}
```

**6. 用于`ERROR`级别打印**

```
@Override
public void onReceiveMessage(String message) {
    Debug.error(message); // 打印'message'
}
```
输出Log为`ERROR`级别。

## 高级使用

**1. 过滤本类的日志打印**

自动将**类名**作为打印日志的`TAG`。
```
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
		Debug.debugClass();
        super.onCreate(savedInstanceState);
        ...
```

**输出**：

```
// PID            包名     级别    TAG       类名            方法    代码超链到行
$ 30586-30586 /com.xxx.xx D/MainActivity:MainActivity.onCreate(MainActivity.java:19):
```


**2. 自定义日志`TAG`**

```
Debug.setTag("test");
```

**3. 修改日志打印级别**

```
Debug.setLevel(Log.VERBOSE);
```

支持级别：

- Log.VERBOSE
- Log.DEBUG
- Log.INFO
- Log.WARN
- Log.ERROR

## 其他使用


手动开启：`Debug.debugOn();`

手动关闭：`Debug.debugOff();`
