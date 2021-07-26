package rozetkaTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.LaptopsPage;
import util.PropertiesReader;
import util.RozetkaFilter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class BaseTest {

    PropertiesReader preader = new PropertiesReader();
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeTest
    public void setUp() {
        System.setProperty(preader.getDriverName(), preader.getDriverLocation());
    }

    @BeforeMethod
    public void setUpTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(preader.getURL());
    }

    @AfterMethod
    public void close() {
        driver.close();
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public LaptopsPage getLaptopPage() {
        return new LaptopsPage(getDriver());
    }

    public RozetkaFilter useFilterData() throws JAXBException {
        File file = new File("src\\main\\resources\\rozetkaFilterData.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(RozetkaFilter.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        RozetkaFilter rozetkaFilter = (RozetkaFilter) unmarshaller.unmarshal(file);
        return rozetkaFilter;
    }

}
