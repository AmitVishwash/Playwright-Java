package pages.home;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utility.PropertyReader;

public class LandingPage {
    Page page;

    public LandingPage(Page page){
       this.page = page;
    }

    String logInButton = "a:text('Log In')";

    public void openApplication(){
        page.navigate(PropertyReader.getPropertyValue("url"));
    }
    public void clickLogInButton(){
        Locator dismissButton = page.locator("#onetrust-accept-btn-handler");
        if (dismissButton.isEnabled()) {
            dismissButton.click();
        }
        page.locator(logInButton).first().click();
    }


}
