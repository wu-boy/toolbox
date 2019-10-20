# Java工具箱
## 说明
本项目旨在收集并维护Java开发中常用的工具类，打造一个类似于Apache Commons或Guava类型的工具箱。

## 开发注意事项

* 通用性

尽量维护基本的工具类，不涉及具体的领域和业务。
不同领域和业务放在不同的模块中，按需引入。


* 不要引入大型依赖

例如，不要引入spring-boot-starter，shiro-spring-boot-web-starter，Swagger等系列的依赖，尽量保证该包的小巧性。

* 命名方式

工具类统一命名为XxxUtils，可以参考Apache Commons中的命名方式。

工具类中各方法建议按方法名升序排列。

* 抛出异常

工具类不处理异常，需要将异常抛出，由调用者负责处理异常。

## Maven配置文件settings.xml
请检查自己电脑Maven的配置文件settings.xml，需要修改如下内容。
### servers
```
<servers>
    <server>
      <id>nexus-releases</id>
      <username>用户名</username>
      <password>密码</password>
    </server>
    <server>
      <id>nexus-snapshots</id>
      <username>用户名</username>
      <password>密码</password>
   </server>
</servers>
```

### mirrors
```
<mirrors>   
    <mirror>   
      <id>nexus</id>   
      <mirrorOf>*</mirrorOf>   
      <url>http://IP:port/repository/maven-public</url>   
    </mirror>  
</mirrors>
```

### profiles
```
<profiles>  
   <profile>  
      <id>nexus</id>  
      <repositories>  
        <repository>  
          <id>central</id>  
          <url>http://central</url>  
          <releases><enabled>true</enabled></releases>  
          <snapshots><enabled>true</enabled></snapshots>  
        </repository>  
      </repositories>  
      <pluginRepositories>  
        <pluginRepository>  
		   <id>central</id>  
		   <url>http://central</url>  
		   <releases><enabled>true</enabled></releases>  
		   <snapshots><enabled>true</enabled></snapshots>  
	    </pluginRepository>
      </pluginRepositories>  
   </profile>  
</profiles>
```

### activeProfiles
```
<activeProfiles>
  <activeProfile>nexus</activeProfile> 
</activeProfiles>
```

## 发布到Nexus
修改版本号，运行mvn deploy命令即可。

## 使用方式
```
<dependency>
  <groupId>org.wu.toolbox</groupId>
  <artifactId>toolbox-lang</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```
每个项目引入该包即可，可在Nexus中查询最新发布的版本，替换版本号即可。

发布版本查询：http://IP:port/#browse/browse:maven-releases

快照版本查询：http://IP:port/#browse/browse:maven-snapshots
