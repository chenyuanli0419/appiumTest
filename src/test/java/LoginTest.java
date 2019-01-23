

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.LoginPage;
import page.ProfilePage;
import page.MainPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class LoginTest {

    static MainPage mainPage;
    static ProfilePage profilePage;

    @BeforeAll
    static void intialAll(){
        mainPage=MainPage.start();
        profilePage=mainPage.gotoProfile();
    }

    @ParameterizedTest
    @CsvSource({
            "15600534760,xxxxxx,用户名或密码错误",
            "1560053476,123456,手机号码填写错误"
    })
    public void accountLogin(String username,String password,String expect){

        LoginPage loginPage=profilePage.gotoLogin();
        loginPage.passwordFail(username,password);
        try {
            assertThat(loginPage.getMessage(),equalTo(expect));
        }catch (Exception e){
            e.printStackTrace();
        }

        profilePage=loginPage.gotoProfile();
    }



    /*@Test
    public void 非手机号(){
        MainPage mainPage=MainPage.start();
        ProfilePage profilePage=mainPage.gotoProfile();
        LoginPage loginPage=profilePage.gotoLogin();
        loginPage.passwordFail("155555","123456");
        assertThat(loginPage.getMessage(),equalTo("手机号码填写错误"));
    }**/

}
