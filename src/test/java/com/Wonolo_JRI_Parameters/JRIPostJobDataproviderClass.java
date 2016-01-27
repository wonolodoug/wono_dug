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
       if (m.getName().equalsIgnoreCase("JRICreateTeamNoName")) {
           return new Object[][]{
                   {""}
           };
       }
       if (m.getName().equalsIgnoreCase("JRIPostJobWages")) {
           return new Object[][]{
                   {WonoloMethods.random("testJob"),"Some of the many tasks I do!","1","testVenue","61 Taylor St.","San Francisco","94045","500.95"},
                   {WonoloMethods.random("testJob"),"Some of the many tasks I do!","1","testVenue","61 Taylor St.","San Francisco","94045",".95"},
                   {WonoloMethods.random("testJob"),"Some of the many tasks I do!","1","testVenue","61 Taylor St.","San Francisco","94045",".5"},
                   {WonoloMethods.random("testJob"),"Some of the many tasks I do!","1","testVenue","61 Taylor St.","San Francisco","94045","5000000"}
                   //{WonoloMethods.random("testJob"),"Some of the many tasks I do!","1","testVenue","61 Taylor St.","San Francisco","94045","0"},
                   //{WonoloMethods.random("testJob"),"Some of the many tasks I do!","1","testVenue","61 Taylor St.","San Francisco","94045",""}
           };
       }
       if (m.getName().equalsIgnoreCase("JRIPostJobMissingRequiredField")) {
           return new Object[][]{
                   {""}
           };
       }
      else {
         return new Object[][]{
                 {WonoloMethods.random("testJob"),"Some of the many tasks I do!","1","testVenue","131 Chosen Meatball St.","San Ramon","94583","500"},
                 {WonoloMethods.random("testJob"),"Some of the many tasks I do!","1","testVenue","61 Taylor St.","San Francisco","94045","500"},
                 {"","Some of the many tasks I do!","1","testVenue","61 Taylor St.","San Francisco","94045","0"}
         };
      }
   }
}

