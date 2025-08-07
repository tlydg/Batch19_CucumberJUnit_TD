# 🥒 Cucumber + Java + Selenium Test Otomasyon Projesi

Bu proje, Java ile geliştirilmiş ve **Cucumber**, **Selenium WebDriver** ile test otomasyonunu gerçekleştiren, **Maven** üzerinden çalıştırılabilen bir yapıdır. Gherkin diliyle yazılmış senaryolar üzerinden davranış odaklı testler yapılır. Proje, kendi içinde modüler olarak yapılandırılmıştır.

## 🔧 Kullanılan Teknolojiler

- Java
- Maven
- Cucumber
- Selenium WebDriver
- Gherkin
- JUnit
- Raporlama (Extent Reports veya Allure)

## 📁 Proje Yapısı

```
src
└── test
    ├── java
    │   ├── runners
    │   │   └── CukesRunner.java       --> Testleri başlatan ana sınıf
    │   ├── stepdefinitions
    │   │   ├── LoginSteps.java        --> Sayfa bazlı adım tanımlamaları
    │   │   └── SearchSteps.java
    │   └── utilities
    │       └── Driver.java            --> Selenium WebDriver yönetimi
    └── resources
        └── features
            ├── login.feature          --> Gherkin senaryoları
            └── search.feature
```

## 🚀 Projeyi Çalıştırma

### IntelliJ IDEA ile:

1. Maven bağımlılıklarını indir:  
   `mvn clean install`

2. `CukesRunner.java` dosyasını çalıştır:  
   Sağ tık > Run ‘CukesRunner’

### Maven üzerinden terminal ile:

```bash
mvn test
```

## 📝 Gherkin ile Senaryo Yazımı

Tüm senaryolar `src/test/resources/features` klasöründe yazılır. Örnek:

```gherkin
Feature: Kullanıcı girişi

  Scenario: Geçerli bilgilerle giriş
    Given kullanıcı login sayfasındadır
    When kullanıcı geçerli "kullaniciAdi" ve "sifre" bilgilerini girer
    Then kullanıcı ana sayfaya yönlendirilmelidir
```

## 🔍 Step Definitions

Her `.feature` dosyasındaki adımların karşılığı `stepdefinitions` paketindeki Java sınıflarında yazılır. Bu sınıflar, sayfa bazlı veya modül bazlı olarak ayrılmıştır.

```java
@Given("kullanıcı login sayfasındadır")
public void kullanici_login_sayfasindadir() {
    Driver.get().get("https://example.com/login");
}
```

## 🖥️ Driver Yönetimi

Selenium WebDriver işlemleri `utilities/Driver.java` sınıfı üzerinden kontrol edilir. Singleton yapıdadır ve tarayıcıyı tek noktadan yönetir.

```java
public class Driver {
    private static WebDriver driver;

    public static WebDriver get() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
```

## 📊 Raporlama

Testler çalıştırıldığında otomatik olarak rapor üretilir. Rapor klasörü genellikle aşağıdaki yoldadır:

```
/target/cucumber-reports/
```

Kullanılan raporlama sistemine göre HTML çıktısı, ekran görüntüsü veya detaylı hata mesajları içerebilir.

## 🧪 Test Koşum Sınıfı: CukesRunner.java

```java
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepdefinitions")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class CukesRunner {}
```

> Gerekli importlar:

```java
import org.junit.platform.suite.api.*;
import static io.cucumber.junit.platform.engine.Constants.*;
```

## 🔄 Hooks (Opsiyonel)

Senaryo öncesi/sonrası işlemler için `Hooks.java` kullanılabilir:

```java
@Before
public void setUp() {
    Driver.get();
}

@After
public void tearDown() {
    Driver.closeDriver();
}
```

## 📌 Notlar

- Kodlar, proje modülerliğini koruyacak şekilde yapılandırılmıştır.
- `features`, `stepdefinitions` ve `runner` yapısı ayrıdır.
- Senaryolar Türkçe Gherkin sözdizimiyle yazılmıştır.
- Raporlar test sonrası otomatik olarak oluşturulur.
- Maven üzerinden kolayca build ve test edilebilir.

## 👤 Hazırlayan

Bu framework, tamamen kişisel ihtiyaçlara özel olarak yapılandırılmıştır ve Java + Cucumber + Selenium üçlüsünü verimli bir şekilde entegre eder.


