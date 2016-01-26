package com.Wonolo_JRI_Parameters;

import com.wonolo.app.Wonolo.PageMethods.WonoloMethods;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class JRIPostJobDataproviderClass {
   @DataProvider(name = "JRIPostJobProvider")
   public static Object[][] getDataFromJRIPostJobDataprovider(Method m) {
      if (m.getName().equalsIgnoreCase("JRICreateTeam")) {
         return new Object[][]{
               {WonoloMethods.random("testTeam")}
         };
      }
      else {
         return new Object[][]{
               {WonoloMethods.random("testJob"),"Some of the many tasks I do!","1","testVenue","131 Chosen Meatball St.","San Ramon","94583","500"},
         };
      }
   }
}

