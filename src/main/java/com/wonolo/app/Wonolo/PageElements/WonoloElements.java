package com.wonolo.app.Wonolo.PageElements;


import com.wonolo.app.Wonolo.WonoloDriver;
import org.openqa.selenium.By;

public class WonoloElements extends WonoloDriver {
    //base url
    public static String jri_url = "https://test.wonolo.com/jobs";

    //Job elements
    //Sign in
    public static String username = "input[id*=email]";
    public static String pwd = "input[id*=password]";
    public static String signin = "input[name=commit]";

    //Home page
    public static String newJob = "a[id=new_request_button]";

    //Post job
    public static String requestName = "input[id*=request_name]";
    public static String desTasks = "textarea[id*=description_tasks]";
    public static String numSlots = "input[id*=slots]";
    public static String venue = "input[id*=venue]";
    public static String address = "input[id*=address]";
    public static String city = "input[id*=city]";
    public static String zip = "input[id*=zip]";
    public static String wage = "input[id*=wage]";
    public static String postJob = "input[value='Post Job']";

    public static String job_title = "td[class=job_title]";
    public static String deleteJob = "span[class='request_action_new_icon icon icon-close']";

    //Team elements
    public static String addTeam = "a[href='/employers/1551/teams']";
    public static String addFirstTeam = "a[class='btn save_button with_ajax_goodness']";
    public static String addTeamName = "input[id=team_name]";
    public static String saveTeam = "input[id=create_team_modal]";
    public static String savedTeamName = "p[class=team_name_string";
    public static String deleteTeam = "(//span[@class='request_action_new_label hide_on_narrow'])[2]";

    //Popup dialog elements
    public static String confirmDelete = "button[class='btn save_button confirm";

}
