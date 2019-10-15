package resources;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name = "tabs")
    public Object[][] dataProviderMethodForTabs() {
        return new Object[][] { { "JOBS" }, { "TEFL" }, { "TEACHER CERTIFICATION" }, { "COURSES" }, { "HIRE TEACHERS" } };
    }

}
