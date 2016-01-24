# Wonolo-JRI automation ##########################################################
# github info
 https://github.com/wonolodoug
 username: wonolodoug
 password: sandman1
 repo:     wono_dug

#Test Plan########################################################################
Project Wonolo JRI

Introduction: create integration tests that test 2 primary paths through the JRI:
              posting a Job
              creating a Team

Resources: myself, Webdriver, TestNG, Intelij, git, github, JAVA

In Scope of the Release: This exercise is limited to functional automated test.
Manual testing, unit testing, and performance testing are out of scope of this exercise.

Functionality to be tested in this Release:

a) Employer Posts a job.
    -go to https://test.wonolo.com/job
    -enter login info
    -click new job button

b) Employer creates a team.
    -go to https://test.wonolo.com/job
    -enter login info

Infrastructure considerations: Tests will be executed against the Wonolo test/sandbox sytem.

Assumptions:
    -Sandbox environment is up and runnning.
    -dnbgarner@gmail.com/password is a valid username/password
    -tests should to the degree possible leave the testing environment the same after a test as before a test
    -tests should produce meaningful output
    -tests should be re-runnable
    -instructions for running tests should be included

#Test Findings ###################################################################
#Minor Bugs /Feature requests


#How To Add/Remove data for tests cases###########################################


#How to run#######################################################################
#From IDE
Highlight the test desired to run, right click, select run