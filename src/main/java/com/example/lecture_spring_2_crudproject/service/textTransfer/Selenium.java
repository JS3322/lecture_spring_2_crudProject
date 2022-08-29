package com.example.lecture_spring_2_crudproject.service.textTransfer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Selenium {

    public void scraping() {



    WebDriver driver = new ChromeDriver();
    try{
        driver.get("https://www.fragrantica.com/perfume/Maison-Francis-Kurkdjian/Baccarat-Rouge-540-33519.html");
        WebElement element = driver.findElement(By.tagName("div"));

        List<WebElement> elements = element.findElements(By.tagName("p"));
        for (WebElement e : elements) {
            System.out.println(e.getText());
        }
    }catch(Exception e) {
        e.printStackTrace();

    }finally {
        driver.quit();
    }
    }
}
