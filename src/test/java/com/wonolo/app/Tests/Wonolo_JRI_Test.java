package com.wonolo.app.Tests;

import com.Wonolo_JRI_Parameters.JRIPostJobDataproviderClass;
import com.wonolo.app.Wonolo.PageMethods.WonoloMethods;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.wonolo.app.Wonolo.Assertions.wonolo_assertTrue;
import java.util.Objects;


public class Wonolo_JRI_Test extends WonoloMethods {

   //add any step here that is necessary to all test prior to executing test steps
   @BeforeMethod(groups={"wonoloJRI"})
   public void setup() throws Exception {
      try {
         driver = driver();
         // Go to the JRI home page and Login
         driver.get(jri_url);
         logIn(driver, "dnbgarner@gmail.com", "password");
         }
      catch (Exception e) {
         logError("JRIOrder_setup", e);
         }
   }

   //teardown is used to clean up things common to all tests
   @AfterMethod(groups={"wonoloJRI"})
   public void teardown() throws Exception {
      //cleanup/delete event after test
      driver.close();
   }

    //Post a new Job
   @Test(groups = {"wonoloJRI"}, dataProvider="JRIPostJobProvider", dataProviderClass= JRIPostJobDataproviderClass.class)
   public void JRIPostJob(String jobName, String tasks, String slots, String workvenue, String workaddress, String workcity, String workzip, String workwage) throws Exception {
      try {
          driver.findElement(By.cssSelector(newJob)).click();
          //wait for job form to load, complete form data, post job
          createJob(jobName, tasks, slots, workvenue, workaddress, workcity, workzip, workwage);
          driver.findElement(By.cssSelector(postJob)).click();
          Thread.sleep(2000);
          wonolo_assertTrue(Objects.equals(driver.findElement(By.cssSelector(job_title)).getText(),
                 jobName), jobName + ":  Not found in posted jobs.");
      } catch (Exception e) {
         logError("JRIPostJob", e);
      }
      //Finally - used to clean up test data specific to a test
      finally {
         deleteJob();
         }
      }

   //Create a New Team and Verify it Successfully is saved.
   @Test(groups = {"wonoloJRI"}, dataProvider="JRIPostJobProvider", dataProviderClass= JRIPostJobDataproviderClass.class)
   public void JRICreateTeam(String teamName) throws Exception {
      try {
          createTeam(teamName);
          wonolo_assertTrue(Objects.equals(driver.findElement(By.cssSelector(savedTeamName)).getText(),
                  "Team: " + teamName), "Team name actual does not match expected.");
      } catch (Exception e) {
         logError("JRICreateTeam", e);
      }
      //Finally - used to clean up test data specific to a test
      finally {
          deleteTeam();
      }
   }
}
