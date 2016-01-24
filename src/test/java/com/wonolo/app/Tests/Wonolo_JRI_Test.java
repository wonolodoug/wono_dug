package com.wonolo.app.Tests;

import com.Wonolo_JRI_Parameters.JRIPostJobDataproviderClass;
import com.wonolo.app.Wonolo.PageMethods.WonoloMethods;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Wonolo_JRI_Test extends WonoloMethods {

   @BeforeMethod(groups={"wonoloJRI"})
   public void setup() throws Exception {
      try {
         driver = driver();
         // Go to the JRI home page and Login
         driver.get(jri_url);
         logIn(driver, "dnbgarner@gmail.com", "password");
         }
      catch (Exception e) {
         logError("JRIOrder", e);
         }
   }

   @AfterMethod(groups={"wonoloJRI"})
   public void teardown() throws Exception {
      //cleanup/delete event after test
   }

   @Test(groups = {"wonoloJRI"}, dataProvider="JRIPostJobProvider", dataProviderClass= JRIPostJobDataproviderClass.class)
   public void JRIPostJob(String jobName) throws Exception {
      try {
         log(jobName);
         driver.findElement(By.cssSelector(signin)).click();
         Thread.sleep(1000);
      } catch (Exception e) {
         logError("JRIOrder", e);
      }
   }

   @Test(groups = {"wonoloJRI"}, dataProvider="JRIPostJobProvider", dataProviderClass= JRIPostJobDataproviderClass.class)
   public void JRICreateTeam(String teamName) throws Exception {
      try {
         log(teamName);
         driver.findElement(By.cssSelector(signin)).click();
         Thread.sleep(1000);
      } catch (Exception e) {
         logError("JRIOrder", e);
      }
   }
}
