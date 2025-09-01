package basics;

public class S7SeleniumGrid {
    public static void main(String[] args) {
        // https://www.selenium.dev/documentation/grid/

    /*
   Selenium Grid Setup Instructions
   ---------------------------------

   • Download the Selenium Server.
   • Download Browser drivers and place them in the same path
     where the Selenium server is located.

   • Start the Hub - which eventually starts:
       - Router
       - Distributor
       - Session Map
       - New Session Queue
       - Event Bus

     Command:
       java -jar <SeleniumJarname> hub

   • Start the Node in the same machine where Hub is running:
       java -jar <SeleniumJarname> node --detect-drivers true

   • Start the Node in a different physical machine:
       java -jar <SeleniumJarname> node --detect-drivers true
            --publish-events tcp://<ipaddressofhub>
            --subscribe-events tcp://<ipaddressofhub>

   • Check the status of Grid at:
       http://localhost:4444/

   • Create multiple Selenium TestNG tests with parallel run capability.

   • Run the tests and observe the distribution of tests across multiple Node machines.

   ---------------------------------
   What is Selenium Grid?
   ---------------------------------
   Selenium Grid is a smart proxy server that makes it easy to run
   tests in parallel on multiple machines.

   Example: Running 10 tests in parallel across nodes.
    */
    }
}
