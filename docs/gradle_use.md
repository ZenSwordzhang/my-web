# 创建Gradle工程
* 目录结构
```` src
└── src
    ├── main
    │   └── java
    └── test
        └── java
````
* 在src同级目录中添加一个build.gradle文件，文件内容：
````
apply plugin: 'java'
````
* 执行命令
````
gradle build
````
# 使用Gradle Wrapper(推荐使用)
## 好处
* 不用安装gradle也能运行gradle
* 有人使用相同的gradle版本
## 操作
* 在build.gradle中添加内容
````
wrapper {
    gradleVersion = '6.2.2'
}
````
* 执行命令后生成gradlew文件、gradlew.bat文件和gradle目录
````
gradle wrapper
````
# 添加Spring Boot依赖
````
// 注意buildscript必须在顶部
buildscript {
    repositories {
		maven { url 'https://maven.aliyun.com/repository/public' }
		mavenCentral()
        jcenter()
    }
    dependencies {
		// 让spring-boot支持gradle
        classpath('org.springframework.boot:spring-boot-gradle-plugin:2.2.5.RELEASE')
    }
}

repositories {
	maven { url 'https://maven.aliyun.com/repository/public' }
	maven { url 'http://mvnrepository.com/' }
	maven { url 'https://repo1.maven.org/maven2/' }
	mavenCentral()
    jcenter()
}

apply plugin: 'java'
apply plugin: 'idea'
// 使用spring boot
apply plugin: 'org.springframework.boot'
// 使用spring boot的自动依赖管理
apply plugin: 'io.spring.dependency-management'

group 'com.zsx'
version '1.0-SNAPSHOT'

sourceCompatibility = 13
targetCompatibility = 13


wrapper {
    gradleVersion = '6.2.2'
}

// 依赖列表
dependencies {
    compile('org.springframework.boot:spring-boot-starter-web')
    testCompile('org.springframework.boot:spring-boot-starter-test')
	testCompile group: 'org.junit.platform', name: 'junit-platform-launcher', version: '1.6.1'
    testCompile group: 'org.junit.jupiter', name: 'junit-jupiter-engine', version: '5.6.1'
}
````





            