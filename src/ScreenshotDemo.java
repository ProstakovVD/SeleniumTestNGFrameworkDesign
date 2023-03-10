
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotDemo {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		//Just copy and paste next lines of code coz something is wrong with way that i saw in lecture 109
		//Links that might help:
		// https://stackoverflow.com/questions/4490454/how-to-take-a-screenshot-in-java
		// https://stackoverflow.com/questions/59144607/java-io-filenotfoundexception-c-screenshot-png-access-is-denied-error-while
		//Calendar and SimpleDateFormat isn't requirement but it helps your screenshot name to look normal
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss");
		Calendar now = Calendar.getInstance();
		
        Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        //Also issue can be in that C file is secured one so change C to D if nothing helps
        ImageIO.write(screenShot, "JPG", new File("C:\\.EclipseScreenshots\\"+formatter.format(now.getTime())+".jpg"));
        
        // !!!UPDATE !!!
        //Ok i have fixed the problem
        // if you want to write code as it was wrote in course you have to add
        //<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
        //<dependency>
        //<groupId>commons-io</groupId>
        //<artifactId>commons-io</artifactId>
        //<version>2.11.0</version>
        //</dependency>
        // in your pom.xml
        // now it have been added to Introduction 5 so everything shoed work
        //You can try to rewrite this code whenever you want
		
	}

}
