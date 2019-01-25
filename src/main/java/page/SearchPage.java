package page;

import driver.Driver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;


public class SearchPage extends BasePage {
    public SearchPage search(String keyword){
        find(By.className("android.widget.EditText")).sendKeys(keyword);
        return this;
    }

    public MainPage cancel(){
        find(By.id("action_close")).click();
        return new MainPage();
    }

    public ArrayList<String> getAll(){
        ArrayList<String> array=new ArrayList<String>();
        for(WebElement e: Driver.getCurrentDriver().findElements(By.id("stockName"))){
            array.add(e.getText());
        }
        return array;
    }

    public ArrayList<String> getByStock(){
        ArrayList<String> array=new ArrayList<String>();
        find(By.xpath("//*[contains(@text,'股票')]")).click();
        for (WebElement e: Driver.getCurrentDriver().findElements(By.id("stockName"))){
            array.add(e.getText());
        }
        return array;

    }

    public ArrayList<String> addSelected(){
        ArrayList<String> array=new ArrayList<String>();
        AndroidElement select=(AndroidElement) find(By.xpath("//*[contains(@resource-id,'follow')]"));
        //System.out.println(select.getAttribute("resourceId"));
        array.add(select.getAttribute("resourceId"));
        //name(返回 content-desc 或 text)\className(返回class,API=>18才能支持)\resourceId(返回resource-id,只有 API=>18 才能支持)
        select.click();
        AndroidElement choosed=(AndroidElement) find(By.xpath("//*[contains(@resource-id,'follow')]"));
        //System.out.println(choosed.getAttribute("resourceId"));
        array.add(choosed.getAttribute("resourceId"));
        return array;

    }

    public SearchPage removeSelected(){
        return this;
    }
}
