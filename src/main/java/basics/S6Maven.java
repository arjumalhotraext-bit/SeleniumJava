package basics;

public class S6Maven {
    public static void main(String[] args) {
        /*
       Maven –
       Apache Maven is a software project management and build
       management tool for Java frameworks.

       --------------------------------------------------------
       1. Why Maven?
       --------------------------------------------------------
       • Central repository to get dependencies
       • Maintaining common structure across the organization
       • Flexibility in integrating with CI tools
       • Plugins for test framework execution

       --------------------------------------------------------
       2. Install Maven
       --------------------------------------------------------
       • Download & install Maven
       • Set System variables to recognize Maven (M2_HOME, PATH)

       --------------------------------------------------------
       3. Maven Terminologies
       --------------------------------------------------------
       • Artifact:
           An artifact is a file, usually a JAR, that gets deployed to a Maven repository.
       • GroupId:
           groupId uniquely identifies your project across all projects.
       • Archetype:
           mvn archetype:generate → Generates a new project from an archetype.

       --------------------------------------------------------
       4. Creating a Maven Project
       --------------------------------------------------------
       Command:
       mvn archetype:generate
           -DgroupId=com.mycompany.app
           -DartifactId=my-app
           -DarchetypeArtifactId=maven-archetype-quickstart
           -DinteractiveMode=false

       --------------------------------------------------------
       5. Integrate Maven with Eclipse
       --------------------------------------------------------
       • Install Maven plugin in Eclipse (or use built-in support).
       • Import Maven project into Eclipse.

       --------------------------------------------------------
       6. Maven Phases for Test Automation
       --------------------------------------------------------
       • clean   – Removes target directory with compiled files
       • compile – Compiles source code
       • test    – Runs unit tests

       --------------------------------------------------------
       7. Understanding POM.xml file
       --------------------------------------------------------
       • Contains dependencies, plugins, build configurations, profiles, etc.

       --------------------------------------------------------
       8. How to find dependencies of software?
       --------------------------------------------------------
       • Use https://mvnrepository.com
       • Add dependency snippet in POM.xml

       --------------------------------------------------------
       9. Importance of Maven Surefire Plugin
       --------------------------------------------------------
       • Executes unit & TestNG tests during build.
       • Generates test reports.

       --------------------------------------------------------
       10. Running Tests with Surefire Plugin
       --------------------------------------------------------
       mvn test

       --------------------------------------------------------
       11. Integrating TestNG into Maven
       --------------------------------------------------------
       • Add TestNG dependency in POM.xml
       • Configure surefire plugin to pick up testng.xml

       --------------------------------------------------------
       12. TestNG XML configuration in POM
       --------------------------------------------------------
       Example inside surefire plugin:
           <suiteXmlFiles>
               <suiteXmlFile>testng.xml</suiteXmlFile>
           </suiteXmlFiles>

       --------------------------------------------------------
       13. Setting up Profiles in POM.xml
       --------------------------------------------------------
       • Define multiple environments (dev, qa, prod)
       • Activate with:
           mvn test -Pqa

       --------------------------------------------------------
       14. Running Selected Tests with Maven
       --------------------------------------------------------
       • mvn -Dtest=ClassName test
       • mvn -Dtest=ClassName#methodName test

       --------------------------------------------------------
       15. Maven Surefire Reports
       --------------------------------------------------------
       • Located in target/surefire-reports/
       • Provides XML & HTML execution reports
    */
    /*
       Maven Command Structure
       ------------------------
       • All Maven commands start with: mvn
       • Examples: mvn clean, mvn compile, mvn test

       Three Most Important Commands
       -----------------------------
       • mvn clean   → Deletes previous build files, clears target folder
       • mvn compile → Compiles code & checks for syntax errors (no tests executed)
       • mvn test    → Runs test cases (automatically does clean + compile first)

       Execution Path
       --------------
       • Always run Maven commands from the project folder where pom.xml is located
       • Commands read pom.xml to know dependencies, build config, etc.

       Dependency Resolution
       ---------------------
       • Maven checks local repository first: ~/.m2/repository
       • If dependency not found → fetches from central Maven repository
       • JARs are cached locally → avoids repeated downloads

       Naming Convention for Test Classes
       ----------------------------------
       • Maven Surefire Plugin runs test classes ending with "Test"
       • Example: AppiumTest.java, RESTAPITest.java, SeleniumTest.java
       • If "Test" suffix is missing → Maven will NOT execute that class

       First Execution vs Later Runs
       ------------------------------
       • First run: Maven downloads dependencies (takes more time)
       • Later runs: Uses local .m2 cache, executes faster

       No Eclipse Dependency
       ---------------------
       • You don’t need Eclipse/IDE to run tests
       • Run tests directly via CLI → mvn test
       • Generates reports automatically

       Reports
       -------
       • Summary: total tests run, passed, failed, skipped
       • Detailed reports stored in: target/surefire-reports/
    */
    }
}
