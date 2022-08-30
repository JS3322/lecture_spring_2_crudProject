package com.example.lecture_spring_2_crudproject.service.textTransfer;

import com.example.lecture_spring_2_crudproject.entity.data.SeleniumDtoExample;
import com.example.lecture_spring_2_crudproject.repository.data.SeleniumDtoExampleRepository;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;
import java.util.Set;

//https://chromedriver.chromium.org/downloads

@Service
public class Selenium {

    @Autowired
    SeleniumDtoExampleRepository seleniumDtoExampleRepository;

    private WebDriver driver;
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
//    public static final String WEB_DRIVER_PATH = "/Users/js/Cleancode/lecture_spring_2_crudProject/src/main/resources/static/tool/chromedriver";
    public static final String WEB_DRIVER_PATH = "C:/Cleancode/lecture_spring_2_crudProject/src/main/resources/static/tool/chromedriver_win.exe";

    private String base_url;

    //Jsoup
    // http request사용하여 정적 데이터 수집
    //selenium
    //jsoup에 속도는 느리나 드라이버를 사용해 동적데이터 수집 가능

    public void scraping() {

        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

//        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        base_url = "https://www.fragrantica.com/perfume/Maison-Francis-Kurkdjian/Baccarat-Rouge-540-33519.html";
//        base_url = "https://giraf.sktelecom.com/web/kostat/";
        driver.get(base_url);
        driver.manage().addCookie(new Cookie("frecently","a%3A1%3A%7Bi%3A33519%3Bi%3A1661833859%3B%7D"));
        driver.manage().addCookie(new Cookie("cto_bundle","6wiwSV9Ia3NFZDhMMHVva3V3RVdiWU1MSE4zVjFIZTVUNm9XQklWUXlZMUZTNXE5QzBsbmxuVzduOHclMkJjdklUVndMYkF6dlpKNVg5REl2VjJtamt1a3J6WUc4RFVseEpsVndMUlp0V2NCZ00lMkJTJTJCMnRUd05TS0JMaXBKJTJCZ0o1QzIwQmpCMVdnQUYwVDFWVXNDbUglMkJMcFAwUnR3JTNEJTNE"));
        driver.manage().addCookie(new Cookie("_gid", "GA1.2.953368079.1661832818"));
        driver.manage().addCookie(new Cookie("_ga", "GA1.2.1327740257.1661832817"));
        driver.manage().addCookie(new Cookie("_ga_LKTF6586LY", "GS1.1.1661832817.1.0.1661832817.0.0.0"));
        driver.manage().addCookie(new Cookie("_gat_gtag_UA_1340700_3","1"));
        driver.manage().addCookie(new Cookie("__gads", "ID=b728ca96e2459dea:T=1661832812:S=ALNI_Maff_wM4txYZ4M_v8JSRP0IveSWuw"));
        driver.manage().addCookie(new Cookie("__gpi", "UID=0000093e6551f8bc:T=1661832812:RT=1661832812:S=ALNI_MbTCDXeg7hTHI9rB70RUFQRzxY0Dw"));
        driver.manage().addCookie(new Cookie("__cf_bm", "UfLdxFbhNlgiwa8F64A.catE6U0YPXsaVuJ4omQT1hA-1661832809-0-AUewa4afhRm9Lo/X4XyaHynwQkGUkslRzLOh41/71/AESczNemKTIYA3FVnUTkpjCce1ICsDDVRNMsgKSykNTcpc0znzo69r44OYryca0zUI5G4bCNTjZfhjYmmXFKFf0Q=="));
        driver.manage().addCookie(new Cookie("__auc", "668c0d63182ecf46ca557c99bf7"));
        driver.manage().addCookie(new Cookie("__asc", "668c0d63182ecf46ca557c99bf7"));
        driver.manage().addCookie(new Cookie("cf_clearance", "TtzAgBel4I2qrV93fSEfRotrpnciljoAslXRwTXYY18-1661832808-0-250"));
        driver.manage().addCookie(new Cookie("cf_chl_prog", "x15"));
        driver.manage().addCookie(new Cookie("cf_chl_2", "d013bafe3467d58"));


//        driver.manage().addCookie(new Cookie("cto_bundle", "frhX-l9Ia3NFZDhMMHVva3V3RVdiWU1MSE54ZDZIbmd3UzlHWnhNUWNFNHZ0cjlPOWNRc0RURjk3S054OG4wWHNTU1N1QkphbVpzY1Z3RkZJeDVGdVNqNDFITFQlMkJKJTJGTHZrclFHc3V3RCUyQlI1UWpQJTJCaXY5RDJJT0J1ZDhYZ2piSklTJTJGWVlTaXBtbDUzRG8yVGVybkNOeGRqeXJ3JTNEJTNE"));
//        driver.manage().addCookie(new Cookie("__gpi", "UID=0000093e6551f8bc:T=1661832812:RT=1661832812:S=ALNI_MbTCDXeg7hTHI9rB70RUFQRzxY0Dw"));
//        driver.manage().addCookie(new Cookie("__gads", "ID=b728ca96e2459dea:T=1661832812:S=ALNI_Maff_wM4txYZ4M_v8JSRP0IveSWuw"));
//        driver.manage().addCookie(new Cookie("_gid", "GA1.2.953368079.1661832818"));
//        driver.manage().addCookie(new Cookie("_ga", "GA1.2.1327740257.1661832817"));
//        driver.manage().addCookie(new Cookie("__auc", "668c0d63182ecf46ca557c99bf7"));
//        driver.manage().addCookie(new Cookie("__asc", "668c0d63182ecf46ca557c99bf7"));
//        driver.manage().addCookie(new Cookie("_ga_LKTF6586LY", "GS1.1.1661832817.1.0.1661832817.0.0.0"));
//        driver.manage().addCookie(new Cookie("__cf_bm", "UfLdxFbhNlgiwa8F64A.catE6U0YPXsaVuJ4omQT1hA-1661832809-0-AUewa4afhRm9Lo/X4XyaHynwQkGUkslRzLOh41/71/AESczNemKTIYA3FVnUTkpjCce1ICsDDVRNMsgKSykNTcpc0znzo69r44OYryca0zUI5G4bCNTjZfhjYmmXFKFf0Q=="));
//        driver.manage().addCookie(new Cookie("frecently", "a%3A1%3A%7Bi%3A33519%3Bi%3A1661832808%3B%7D"));
//        driver.manage().addCookie(new Cookie("cf_clearance", "TtzAgBel4I2qrV93fSEfRotrpnciljoAslXRwTXYY18-1661832808-0-250"));
//        driver.manage().addCookie(new Cookie("cf_chl_prog", "x15"));
//        driver.manage().addCookie(new Cookie("cf_chl_2", "d013bafe3467d58"));
//        driver.manage().addCookie(new Cookie("0", "cf_chl_seq_d013bafe3467d58\tbAcX0ieAbCKPfZ9"));




//
//        driver.manage().addCookie(new Cookie("HSID", "AGsZZUMZ3856C_125"));
//        driver.manage().addCookie(new Cookie("__Secure-3PSIDCC", "AEf-XMTj_IJMMSQqFkJRGQQPiWAbQ9ZomKNo2A1jfappHFcsBv5Ghsf2pJWc8xnQ7Nu6Kg2pC3nN"));
//        driver.manage().addCookie(new Cookie("SAPISID", "oUHbyRgtc9LRQmsp/Aq-OdNJhEGBRJ7wWO"));
//        driver.manage().addCookie(new Cookie("__Secure-1PSIDCC", "AEf-XMROcmwstvA0JF4PrJ4CZ7oAanwsSswIUMir0dmIasadkc8lzzyYO4u_31d5EbMqOEN05Sg"));
//        driver.manage().addCookie(new Cookie("SID", "NAi2lSJCXDFXdR_6brHeaGMhGomFhsDBECuV5rGs90kJWwJ0zt0Kl9n7bP2VWsWcsmqjeg."));
//        driver.manage().addCookie(new Cookie("SIDCC", "AEf-XMQMds043MFJLocidvKz8DTDUkZ4ceXEUdjs8aKf-RGY1AdFXRIwj1Yo7MWV9zNAiG5xd0tV"));
//        driver.manage().addCookie(new Cookie("__Secure-1PSID", "NAi2lSJCXDFXdR_6brHeaGMhGomFhsDBECuV5rGs90kJWwJ0u2fFA3NaXKQIsdSBbQpNLw."));
//



        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies);

        try {
            Thread.sleep(5000);
        }catch (Exception e) {

        }finally {
            driver.quit();
        }

//        try{
//            Thread.sleep(5000);
//            System.out.println(driver.getPageSource());
//
//            WebElement element = driver.findElement(By.tagName("div"));
//
//
//            List<WebElement> elements = element.findElements(By.tagName("p"));
//            int checkNum = 0;
//            for (WebElement e : elements) {
//                System.out.println(checkNum);
//                System.out.println(e.getText());
//                checkNum++;
//
//                SeleniumDtoExample seleniumDtoExample = new SeleniumDtoExample();
//                seleniumDtoExample.setData_name("pTagData");
//                seleniumDtoExample.setData_content(e.getText());
//                insertSeleniumDtoExample(seleniumDtoExample);
//            }
//
//            WebElement element_click = driver.findElement(By.tagName("a"));
//            List<WebElement> elements_click = element_click.findElements(By.tagName("i"));
//            System.out.println("----------check------------"+element_click.getSize());
//            for (WebElement e : elements_click) {
//                System.out.println("----------check in------------");
//                System.out.println(e.getText());
//            }
//
////            WebElement textBox = driver.findElement(By.name("my-text"));
////            WebElement submitButton = driver.findElement(By.cssSelector("button"));
////            driver.get("https://www.fragrantica.com/perfume/Maison-Francis-Kurkdjian/Baccarat-Rouge-540-33519.html");
////            WebElement element = driver.findElement(By.tagName("div"));
////
////            List<WebElement> elements = element.findElements(By.tagName("p"));
////            for (WebElement e : elements) {
////                System.out.println(e.getText());
////            }
//        }catch(Exception e) {
//            e.printStackTrace();
//
//        }finally {
//            driver.quit();
//        }
    }

    public void insertSeleniumDtoExample(SeleniumDtoExample seleniumDtoExample) {
        seleniumDtoExampleRepository.save(seleniumDtoExample);
    }
}
