package com.wonolo.app.Wonolo.PageElements;


import com.wonolo.app.Wonolo.WonoloDriver;
import org.openqa.selenium.By;

public class WonoloElements extends WonoloDriver {
    //base url
    public static String jri_url = "https://test.wonolo.com/jobs";

    //job elements
    public static String username = "input[id=user_email]";
    public static String pwd = "input[id=user_password]";
    public static String signin = "input[name=commit]";
    public static String newJob = "a[id=new_request_button]";
    public static String requestName = "input[id=job_request_request_name]";

    public static String desTasks = "textarea[id=job_request_description_tasks]";
    public static String numSlots = "input[id=job_request_slots]";
    public static String venue = "input[id=job_request_venue]";
    public static String address = "input[id=job_request_address]";
    public static String city = "input[id=job_request_city]";
    public static String zip = "input[id=job_request_zip]";
    public static String wage = "input[id=job_request_wage]";

    //team elements
    public static String addTeam = "a[href='/employers/1551/teams']";
    public static String addFirstTeam = "a[class='btn save_button with_ajax_goodness']";
    public static String addTeamName = "input[id=team_name]";
    public static String saveTeam = "input[id=create_team_modal]";
    public static String savedTeamName = "p[class=team_name_string";
    public static String deleteTeam = "(//span[@class='request_action_new_label hide_on_narrow'])[2]";
    public static String confirmTeamDelete = "button[class='btn save_button confirm";

}
