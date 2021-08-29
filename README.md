# Adidas Luis Castillo Asessment

This project was created in order to  continue hiring process at adidas by automating threee flows on the page https://www.adidas.co/.

SerenityBDD was used as base framework using Screenplay as parrtern,maven as build tool, Java 8, Cucumber and Lombok.
## Get the code

Git:

    git clone https://github.com/TitanRogha/adidas-luis-assesment.git
    cd adidas-luis-assesment


Or simply [download a zip](hhttps://github.com/TitanRogha/adidas-luis-assesment/archive/master.zip) file.


### The project directory structure
The project has build scripts for  Maven , and follows the standard directory structure used in most Serenity projects:
```Gherkin
src
  + main
  + test
    + java                          Test runners and supporting code
    + resources
      + features                    Feature files
        + search                    Feature file subdirectories 
          search_by_keyword.feature  
      + webdriver                   Bundled webdriver binaries
        + linux
        + mac
        + windows
          chromedriver.exe          OS-specific Webdriver binaries
          geckodriver.exe

```

## Executing the tests
To run the  project, you can either just run the `CucumberTestSuite` test runner class, or run either `mvn verify` or `gradle test` from the command line.

By default, the tests will run using Chrome. You can run them in Firefox by overriding the `driver` system property, e.g.
```json
$ mvn clean verify -Dwebdriver.driver=firefox
```
Or 
```json
$ gradle clean test -Pwebdriver.driver=firefox
```

The test results will be recorded in the `target/site/serenity` directory.

### Environment-specific configurations
We can also configure environment-specific properties and options, so that the tests can be run in different environments. Here, we configure three environments, __dev__, _staging_ and _prod_, with different starting URLs for each:
```json
environments {
  default {
    webdriver.base.url = "https://www.adidas.co/"
  }
  dev {
    webdriver.base.url = "https://www.adidas.co//dev"
  }
  staging {
    webdriver.base.url = "https://www.adidas.co//staging"
  }
  prod {
    webdriver.base.url = "https://www.adidas.co//prod"
  }
}
```
  
You use the `environment` system property to determine which environment to run against. For example to run the tests in the staging environment, you could run:
```json
$ mvn clean verify -Denvironment=staging
```

See [**this article**](https://johnfergusonsmart.com/environment-specific-configuration-in-serenity-bdd/) for more details about this feature.
