import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;



import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SeleniumDockerPOC {

    WebDriver driver;

    //Esse é o endereço do grid do selenium dentro do container docker
    static final String HOST_URL = "http://localhost:4444/wd/hub";

    //Esse é o site que vc quer testar
    static final String site = "https://viniciuspessoni.com/";
    ChromeOptions chromeOptions;

    @BeforeAll
    public void setUp(){
        chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserVersion", "114.0");
        chromeOptions.setCapability("platformName", "linux");
        // Showing a test name instead of the session id in the Grid UI
        chromeOptions.setCapability("se:name", "Exemplo Tester Global");
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4445"), chromeOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }


    @Test
    public void verificaTitulo(){

        String tituloEsperado = "TESTER GLOBAL\n" +
                "   por Vinicius Pessoni*\n" +
                " ";

        String tituloEncontrado = "";

        driver.get(site);

        tituloEncontrado = driver.findElement(By.cssSelector(".et_pb_text_inner")).getText();
        System.out.println(tituloEncontrado);
        assertEquals(tituloEsperado, tituloEncontrado);

    }

    @AfterEach
    public void tearDown(){
        if(driver != null) {
            driver.quit();
        }
    }
}
