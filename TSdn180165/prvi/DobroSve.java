
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.chrome.ChromeDriver;;

public class DobroSve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\korisnik\\Desktop\\New folder\\New folder\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			WebDriver w = new ChromeDriver(options);
			w.get("http://localhost/projekat5/IP_projekat/index.php");
			w.manage().window().maximize();
			WebElement prijavi = w.findElement(By.linkText("Prijavi se"));
			prijavi.click();
			
			WebElement username = w.findElement(By.name("k_ime"));
			username.sendKeys("ana");
			WebElement sifra = w.findElement(By.name("lozinka"));
			sifra.sendKeys("Sifra1234$");
			Thread.sleep(2000);
			WebElement dugme = w.findElement(By.name("dugme_log"));
			dugme.click();
			WebElement ostavi = w.findElement(By.linkText("Ostavi biografiju"));
			System.out.println("Prosao test");
			Thread.sleep(2000);
			w.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}