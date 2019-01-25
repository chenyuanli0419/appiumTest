import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.LoginPage;
import page.MainPage;
import page.SearchPage;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {
    static MainPage mainPage;
    static SearchPage searchPage;

    @BeforeAll
    static void intialAll(){
        mainPage=MainPage.start();
        searchPage=mainPage.gotoSearch();
    }

    @ParameterizedTest
    @CsvSource({
            "pdd,拼多多",
            "alibaba,阿里巴巴"
    })
    public void getAllTest(String keyword,String expect){
        String content=searchPage.search(keyword).getAll().get(0);
        assertThat(content,equalTo(expect));
    }

    @ParameterizedTest
    @CsvSource({
            "alibaba"
    })
    public void addSelectedTest(String keyword){
        ArrayList<String> array=searchPage.search(keyword).addSelected();
        assertThat(array,hasItems("com.xueqiu.android:id/followed_btn", "com.xueqiu.android:id/follow_btn"));
    }

    @ParameterizedTest
    @CsvSource({
            "pdd,拼多多",
            "alibaba,阿里巴巴"
    })
    public void getByStockTest(String keyword,String expect){
        String content=searchPage.search(keyword).getByStock().get(0);
        assertThat(content,equalTo(expect));
    }
}
