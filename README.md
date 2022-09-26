# Wikipedia-Integration-Tests
Wikipedia Search Feature Automation Tests

Quality Engineering Challenge
-
- [ ] Search for “Apollo 11” using the language of your choosing
- [ ] Select one of the search results
- [ ] Open the article page
- [ ] Verify article is correct


Framework Features
-
This is a Java Maven Project that has all its dependencies like Selenium, TestNG, Extent Reports, etc, defined in `pom.xml`
- Framework is based on **Page Object Model** design pattern
- Framework supports **cross-browser execution** for Chrome, Firefox and Safari browsers
- Tests are data driven, test data path: `src/main/resources/testdata.xlsx`
- Test data file name is mentioned in Java config path: `src/main/resources/config.properties`
- Test data file name can be changed in the `config.properties`
- Test generates HTML report after execution with name `Wikipedia Test Automation Report.html`
- Upon Test Failure, screenshot is captured in folder `test-output/Screenshots`


Test Execution Steps
-
- Repository path: `https://github.com/ShubhojitBhattacharjee/Wikipedia-Integration-Tests.git`
- Install all the maven dependencies by running the command `mvn clean` in the project's root folder
- Tests can be run either from either of the two ways:
  - `testng.xml` file: Right-click on the file in Java IDE and click `Run testng.xml` or 
  - From console with maven command-line arguments: `mvn clean test`
- Maven is configured to accept two custom optional parameters: `<browser Name: Chrome(CH), Firefox(FF) or Safari(SF)>` and `headless`
- The browser is Chrome and browser mode is not headless by default
- To pass browser name and/or headless mode, pass two custom parameters to maven command line
  - `mvn clean test -Dheadless=true -Dbrowser=FF`
- After execution the HTML Test Report is generated in folder `target/surefire-reports` with name `Wikipedia Test Automation Report.html`
- This HTML report logs each test step of the test cases
- Also, the test logs the detailed steps to the console. This log is also printed in CI Pipeline log for further debugging
- When test fails, the screenshot is captured at the step that caused the test to fail and stored in folder `test-output/Screenshots`
- One sample HTML Report `Wikipedia Test Automation Report.html` is checked-in to `target/surefire-reports` folder

###CircleCi

- The test is deployed in [Wikipedia-Integration-Tests Pipeline](https://app.circleci.com/pipelines/github/ShubhojitBhattacharjee/Wikipedia-Integration-Tests)
- Test runs on Chrome browser in headless mode logging the detailed steps in the pipeline log
- The HTML Report is stored in Artifacts Tab under the build information
