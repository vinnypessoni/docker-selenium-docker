import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumDockerPOC {

    WebDriver driver;

    static final String site = "https://viniciuspessoni.com/";
    static final String HOST_URL = "http://localhost:4444/wd/hub";


    @Test
    public void assertTitle() throws MalformedURLException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserVersion", "114.0");
        chromeOptions.setCapability("platformName", "linux");
        // Showing a test name instead of the session id in the Grid UI
        chromeOptions.setCapability("se:name", "Exemplo Tester Global");

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4445"), chromeOptions);

        String tituloEsperado = "TESTER GLOBAL";

        String tituloEncontrado = "";

        driver.get(site);
        tituloEncontrado = driver.findElement(By.cssSelector(".et_pb_text_inner")).getText();

        System.out.println(tituloEncontrado);

    }

    @AfterEach
    public void tearDown(){
        if(driver != null) {
            driver.quit();
        }
    }
}
