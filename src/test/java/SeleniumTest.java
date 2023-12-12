import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {
    
    private WebDriver driver;
    
    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        assertNotNull(driver);
        driver.manage().window().maximize();
        driver.get("https://join.secondlife.com/?lang=pt-BR");
    }
    
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @Test
    public void test01() {
        WebElement queryInput = driver.findElement(By.xpath("//*[@id=\"header-text\"]"));
        assertNotNull(queryInput);
    
        String currentUrl = driver.getCurrentUrl();
        String expected = "https://join.secondlife.com/?lang=pt-BR";
    
        assertEquals(expected, currentUrl);
    }
    
    @Test
    public void teste02() {
        WebElement elemento = driver.findElement(By.xpath("//*[@id=\"create_form\"]/ul/div[4]/li[2]/div/label/a[1]"));
        assertTrue(elemento.isDisplayed());
    }
    
	
	@Test
	public void teste03() {
	    boolean elementoAusente = !driver.findElements(By.id("button bt")).isEmpty();
	    assertFalse(elementoAusente);
	} 

    @Test
    public void teste04() {
    
        WebElement campoUsuario = driver.findElement(By.name("username"));
        WebElement campoSenha = driver.findElement(By.name("password"));
    
        campoUsuario.sendKeys("Larissa Albuquerque");
        campoSenha.sendKeys("123456");
    }

    @Test
    public void teste05() {
    
        WebElement contact = driver.findElement(By.id("button btn"));
        Actions actions = new Actions(driver);
    
        actions.moveToElement(contact).perform();
        contact.click();
    }

    @Test
    public void teste06(){

        WebElement contact = driver.findElement(By.id("id_receive_emails"));
        Actions actions = new Actions(driver);
    
        actions.moveToElement(contact).perform();
        contact.click();

        WebElement cadastrar = driver.findElement(By.xpath("//*[@id=\"id_receive_emails\"]"));
        cadastrar.click();
    }

    @Test
    public void teste07(){
        WebElement contact = driver.findElement(By.id("id_receive_emails"));
        Actions actions = new Actions(driver);
    
        actions.moveToElement(contact).perform();
        contact.click();

        WebElement cadastrar = driver.findElement(By.xpath("//*[@id=\"id_receive_emails\"]"));
        cadastrar.click();

		WebElement newaccount = driver.findElement(By.xpath("//*[@id=\"id_day\"]"));
        Select select = new Select(newaccount);
        int indiceOpcaoDesejada = 3;
        select.selectByIndex(indiceOpcaoDesejada);
    }

    @Test
	public void teste08() {
        WebElement contact = driver.findElement(By.id("id_receive_emails"));
        Actions actions = new Actions(driver);
    
        actions.moveToElement(contact).perform();
        contact.click();

		WebElement campoUsuario = driver.findElement(By.name("username"));
		WebElement campoSenha = driver.findElement(By.name("password"));
		campoUsuario.sendKeys("Gabriel Jose");
		campoSenha.sendKeys("348731");
		campoSenha.submit();
	}

    @Test
    public void teste09(){
        WebElement contact = driver.findElement(By.id("id_receive_emails"));
        Actions actions = new Actions(driver);
    
        actions.moveToElement(contact).perform();
        contact.click();

        WebElement eamil = driver.findElement(By.xpath("//*[@id=\"id_tos\"]"));
        eamil.click();
    }

    @Test
    public void teste10(){
        WebElement contact = driver.findElement(By.id("id_receive_emails"));
        Actions actions = new Actions(driver);
    
        actions.moveToElement(contact).perform();
        contact.click();

        WebElement olho = driver.findElement(By.xpath("//*[@id=\"show-pw\"]"));
        olho.click();

    }
}