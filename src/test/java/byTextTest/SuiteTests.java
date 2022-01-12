package byTextTest;

import byTextTest.testMethod.CheckElementComputersAndNetworksSectionsTests;
import byTextTest.testMethod.СheckElementCatalogSectionByTextTests;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;

import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectClasses({CheckElementComputersAndNetworksSectionsTests.class, СheckElementCatalogSectionByTextTests.class})

public class SuiteTests {
}
