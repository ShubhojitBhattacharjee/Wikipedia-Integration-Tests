# Wikipedia-Integration-Tests
Wikipedia Search Feature Automation Tests

Quality Engineering Challenge
-
- [ ] Search for “Apollo 11”
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
- Test data file name can be changed from the Java config file `config.properties`
- Test generates HTML reports after execution with name `Wikipedia Test Automation Report.html`
- Upon Test Failure, screenshot is captured in folder `test-output/Screenshots`


Test Execution Steps
-
- Repository path: `https://github.com/ShubhojitBhattacharjee/Wikipedia-Integration-Tests.git`
- Install all the maven dependencies by running maven build in Java IDE or by running the command `mvn clean` in the project's root folder
- Tests can be run in either of the two ways:
  - `testng.xml` file: Right-click on the file in Java IDE and click `Run testng.xml` or 
  - From console with maven command-line arguments: `mvn clean test`
- Maven is configured to accept two custom optional parameters: `<browser: Chrome(CH), Firefox(FF) or Safari(SF)>` and `headless`
- Default browser is Chrome and default mode is non-headless
- To pass browser name and/or headless mode, pass two custom optional parameters to the maven command-line
  - `mvn clean test -Dheadless=true -Dbrowser=FF`
- After execution the HTML Test Report is generated in folder `target/surefire-reports` with name `Wikipedia Test Automation Report.html`
- The HTML report logs each test step of the test case
- Also, the test logs the detailed steps to the console. This log is also printed in CI Pipeline log
- When test fails, the screenshot is captured at the step that caused the test to fail and stored in folder `test-output/Screenshots`
- One sample HTML Report `Wikipedia Test Automation Report.html` is checked-in to `target/surefire-reports` folder

###CircleCI

- The test is deployed in [Wikipedia-Integration-Tests Pipeline](https://app.circleci.com/pipelines/github/ShubhojitBhattacharjee/Wikipedia-Integration-Tests)
- In CI, the test runs on Chrome browser in headless mode logging the detailed steps in the pipeline log
- In similar way, Firefox browser capability can be added to CircleCI config file: `.circleci/config.yml`
- After the build run, the HTML Report is stored in Artifacts Tab under the build information

