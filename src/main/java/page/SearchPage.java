package page;

import org.openqa.selenium.By;

import static page.BasePage.find;

public class SearchPage {
    public SearchPage search(String keyword){
        find(By.className()).click();
        return this;
    }

    public MainPage cancel(){
        find(By.id("action_close")).click();
        return new MainPage();
    }

    public SearchPage getAll(){
        find(By.id("stockName")).click();
        return this;
    }

    public SearchPage getByStock(){

    }
}
