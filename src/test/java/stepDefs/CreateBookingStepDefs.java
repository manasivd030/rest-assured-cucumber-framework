package stepDefs;

import apis.CreateBookingApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import shareContext.SharedStepContext;
import utility.ApiRequestHelper;
import utility.TestDataHelper;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class CreateBookingStepDefs {

    private final CreateBookingApi createBookingApi;
    private final SharedStepContext sharedStepContext;
    private Map<String, Object> requestPayload;
    private Response createBookingApiResponse;

    public CreateBookingStepDefs(SharedStepContext sharedStepContext) {
        this.createBookingApi = new CreateBookingApi();
        this.sharedStepContext = sharedStepContext;
    }

    @Given("we have a valid request for create booking with following params")
    public void weHaveAValidRequestForCreateBooking(List<Map<String,String>> requestDataList) {

        var requestDataMap = requestDataList.getFirst();
        var dateFormatter = DateTimeFormatter.ISO_DATE;
        var checkInDate = TestDataHelper.getFutureDate(Integer.parseInt(requestDataMap.get("checkInPlusDays")), dateFormatter);
        var checkOutDate = TestDataHelper.getFutureDate(Integer.parseInt(requestDataMap.get("checkOutPlusDays")), dateFormatter);

        this.requestPayload = ApiRequestHelper.getCreateBookingRequest(
                requestDataMap.get("firstName"),
                requestDataMap.get("lastName"),
                Integer.parseInt(requestDataMap.get("totalPrice")),
                Boolean.parseBoolean(requestDataMap.get("depositPaid")),
                requestDataMap.get("additionalNeeds"),
                checkInDate, checkOutDate
        );

    }

    @Given("we have a valid request for create booking with following params as a Map")
    public void weHaveAValidRequestForCreateBookingParamsAsMap(Map<String,String> requestDataMap) {

        var dateFormatter = DateTimeFormatter.ISO_DATE;
        var checkInDate = TestDataHelper.getFutureDate(Integer.parseInt(requestDataMap.get("checkInPlusDays")), dateFormatter);
        var checkOutDate = TestDataHelper.getFutureDate(Integer.parseInt(requestDataMap.get("checkOutPlusDays")), dateFormatter);

        this.requestPayload = ApiRequestHelper.getCreateBookingRequest(
                requestDataMap.get("firstName"),
                requestDataMap.get("lastName"),
                Integer.parseInt(requestDataMap.get("totalPrice")),
                Boolean.parseBoolean(requestDataMap.get("depositPaid")),
                requestDataMap.get("additionalNeeds"),
                checkInDate, checkOutDate
        );

    }

    @Given("we have a valid request for create booking with following params as a Map and total price {int}")
    public void weHaveAValidRequestForCreateBookingParamsAsMap(int totalprice, Map<String,String> requestDataMap) {

        var dateFormatter = DateTimeFormatter.ISO_DATE;
        var checkInDate = TestDataHelper.getFutureDate(Integer.parseInt(requestDataMap.get("checkInPlusDays")), dateFormatter);
        var checkOutDate = TestDataHelper.getFutureDate(Integer.parseInt(requestDataMap.get("checkOutPlusDays")), dateFormatter);

        this.requestPayload = ApiRequestHelper.getCreateBookingRequest(
                requestDataMap.get("firstName"),
                requestDataMap.get("lastName"),
                totalprice,
                Boolean.parseBoolean(requestDataMap.get("depositPaid")),
                requestDataMap.get("additionalNeeds"),
                checkInDate, checkOutDate
        );
            this.sharedStepContext.createBookingApiRequest = requestPayload;
    }


    @When("we send request to create booking API")
    public void weSendRequestToCreateBookingAPI() {

        this.createBookingApiResponse = this.createBookingApi.createNewBooking(this.requestPayload);
        this.sharedStepContext.apiResponse = this.createBookingApiResponse;
    }

    @And("create booking API response has valid booking ID")
    public void createBookingAPIResponseHasValidBookingID() {
        this.createBookingApiResponse.then().body("bookingid", Matchers.is(Matchers.greaterThan(0)));
    }

    @When("booking id has been saved in shared context")
    public void bookingIdHasBeenSavedInSharedContext() {

        this.sharedStepContext.bookingId = this.createBookingApiResponse.jsonPath().getInt("bookingid");
    }
}




