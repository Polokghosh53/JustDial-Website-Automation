# Car Wash Services Identification

 

This project aims to identify car wash services based on specific criteria such as location, rating, and customer votes. The goal is to display the top five car washing services along with their names and phone numbers. The following requirements should be met:

 

1. The **Car Washing services** should be located near the user's location.
2. The services should have a rating higher than 4 stars.
3. The customer votes for each service should be more than 20.

 

## Implementation Details

 

To accomplish the task, the suggested website for reference is [Justdial.com](https://www.justdial.com/), although any legitimate website can be used for this purpose.

 

The automation script should perform the following actions:

 

1. Search for car washing services near the user's location and sort them based on the highest rating.
2. Filter out the services that do not meet the specified criteria (rating > 4, customer votes > 20).
3. Display the names and phone numbers of the top five car washing services that satisfy the criteria.

 

## Error Handling

 

To demonstrate error handling, the automation script should also perform the following tasks:

 

1. Register for **Free Listing** on the website.
2. Fill the registration form with one invalid input, such as an incorrect phone number.
3. Capture the error message displayed due to the invalid input and display it.

 

## Additional Task

 

As an additional task, the automation script should navigate to the **Fitness section** of the website and retrieve all the sub-menu items under the Gym category. The retrieved sub-menu items should be stored in a list and then displayed.

 

## Automation Scope

 

The automation script should cover the following key aspects:

 

1. Handling alerts and search options on the website.
2. Implementing multiple navigation paths to access the desired page.
3. Filling out forms with different objects on the web page.
4. Capturing warning messages and displaying them.
5. Extracting menu items and storing them in collections.
6. Navigating back to the home page after completing the required tasks.

 

Please note that while the suggested website is [Justdial.com](https://www.justdial.com/), any other legitimate website can be used for this project.

# IDE Used
✅ Eclipse IDE for Enterprise Java and Web Developers 2023

# Pre-requisites
1. TestNG (can be installed from Eclipse Marketplace)

# Steps to reproduce
1. In the project directory, a xml file named `testng.xml` is present.
2. Right-click the file and **Run As** -> **TestNG Suite**. The sequence of the test pages will execute accordingly
3. From there, after the execution, you can view the **Extent Report** from **testreport** -> `TESTREPORT1.HTML`, `TESTREPORT2.HTML`, `TESTREPORT3.HTML`
