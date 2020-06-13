import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Guo Yan
 * @date 2020/5/26-22:05
    自动打开chrome浏览器，打开有道网站，搜索
 */

public class TestChromeSearch {

     public static void main(String[] args) throws InterruptedException {


         /** 第二个参数为 Chromedriver 镜像下载目录地址 */
         System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");

         //新建一个webdriver对象，当用非火狐浏览器时，必须在上面设置浏览器驱动，否则默认为火狐浏览器
         WebDriver driver = new ChromeDriver();




         //打开指定的网址
         driver.get("https://www.baidu.com");

         //找到id为kw的元素,搜索框，不同的浏览器，定义不一样
         WebElement inputBox = driver.findElement(By.id("kw"));

         //输入csdn
         inputBox.sendKeys("CSDN");

         //点击按钮
         driver.findElement(By.id("su")).click();

         Thread.sleep(3000);

         driver.close();
     }

}
