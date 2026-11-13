# SkillSwap – Selenium Java Automation Testing

## Project Overview

SkillSwap is a web-based skill-sharing application that allows users to explore skills, connect with other learners, send requests, schedule sessions, and communicate through chat.

This project focuses on automating the application's major user workflows using Selenium WebDriver with Java and TestNG.

## Application URL

https://skillswap-six-psi.vercel.app

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Microsoft Edge WebDriver
- Maven

## Automation Scope

The project covers the following 10 test methods:

1. Login
2. Dashboard
3. Profile
4. Explore
5. View Partner Profile
6. Requests
7. Sessions
8. Chat
9. Send Chat Message
10. Logout

## Test Automation Flow

1. Launch the application in Microsoft Edge.
2. Log in using valid credentials.
3. Verify the Dashboard page and its details.
4. Navigate to the Profile page and verify profile information.
5. Navigate to Explore and verify search and city filter fields.
6. Send a skill request to another user.
7. View the partner's profile and verify the displayed information.
8. Return to the Explore page.
9. Navigate to Requests and verify received and sent requests.
10. Navigate to Sessions and verify upcoming and completed sessions.
11. Open Chat, select a user, and send a message.
12. Log out and verify redirection to the Login page.

## Project Structure

```text
SkillSwap-Automation/
│
├── src/
│   └── test/
│       └── java/
│           └── testpkg/
│               └── SkillSwapTest.java
│
├── test-output/
│
├── pom.xml
│
└── README.md
```

## Test Execution

1. Clone or download the project from GitHub.
2. Open the project in Eclipse or IntelliJ IDEA.
3. Configure Java, Selenium WebDriver, and TestNG dependencies.
4. Update the login credentials in `SkillSwapTest.java`.
5. Run `SkillSwapTest.java` as a TestNG test.
6. Verify the execution results.

## Key Automation Features

- Automated end-to-end user workflows.
- Browser automation using Selenium WebDriver.
- Test execution using TestNG.
- Element identification using XPath and CSS selectors.
- Explicit waits for synchronization.
- Assertions to validate page navigation and application elements.
- Automated login, request, chat, and logout workflows.

## Execution Result

- **Test Methods:** 10
- **Automation Tool:** Selenium WebDriver
- **Test Framework:** TestNG
- **Browser:** Microsoft Edge
- **Execution Status:** Passed

## Skills Demonstrated

- Java Programming
- Selenium WebDriver
- TestNG
- Web UI Automation
- XPath and CSS Locators
- Explicit Waits
- Assertions
- End-to-End Testing
- Functional Testing

## Author

**Thirisha G**

Manual Testing | Selenium Java Automation Testing
