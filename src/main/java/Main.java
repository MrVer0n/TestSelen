import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int max = 6;
        System.setProperty("webdriver.edge.driver", "C:\\Program Files\\edgedriver_win64\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.get("https://yandex.ru/");

        WebElement input = driver.findElement(By.xpath("//*[@id=\"text\"]"));
        input.sendKeys("шариковая ручка \"parker\"" + Keys.ENTER);

    for(int j=1; j<max;j++) {
        System.out.print("Страница " + j + "\n");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ArrayList<WebElement> results = (ArrayList<WebElement>) driver.findElements(By.xpath("//*[@id=\"search-result\"]/li"));
        int i = 1;
        for (WebElement en : results) {
            String text = en.getAttribute("innerText");
            if (text.contains("PARKER") || text.contains("Parker")|| text.contains("parker")) {
                System.out.print("   Номер элемента списка:" + i + "\n");
                //System.out.print("      Контекст:" + text + "\n");
            }
            i++;
        }
        if(j<max-1) {
            driver.findElement(By.xpath("//a[@class=\"link link_theme_none link_target_serp pager__item pager__item_kind_next i-bem\"]")).click();
        }
    }
        //WebElement en = driver.findElement(By.xpath("//*[@id=\"search-result\"]/li[" + i + "]//span[@role='text']"));
        //*[@id=\"search-result\"]/li["+i+"]/div/div/div/span
        //driver.findElement(By.cssSelector("ul[class='serp-list serp-list_left_yes'] li[data-cid='" + i + "']"))
    }
}
