package stepDefs;

import io.cucumber.java.en.*;

import shareContext.SharedStepContext;

public class ResponseValidationStepDefs {

        private final SharedStepContext sharedStepContext;

        public ResponseValidationStepDefs(SharedStepContext sharedStepContext)
        {
                this.sharedStepContext = sharedStepContext;
        }

        @Then("API Response should have HTTP Status code {int}")
        public void apiResponseShouldHaveHTTPStatusCode(int statusCode) {
                sharedStepContext.apiResponse.then().assertThat().statusCode(statusCode);
        }
}
