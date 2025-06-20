package stepDefs;

import apis.CreateBookingApi;
import apis.UpdateBookingApi;
import io.cucumber.java.en.And;
import io.restassured.response.Response;
import shareContext.SharedStepContext;
import utility.ApiRequestHelper;
import utility.TestDataHelper;

import java.time.format.DateTimeFormatter;
import java.util.Map;

public class UpdateBookingApiStepDefs {

    private final UpdateBookingApi updateBookingApi;
    private final SharedStepContext sharedStepContext;

    private Map<String, Object> requestPayload;


    public UpdateBookingApiStepDefs(SharedStepContext sharedStepContext) {
        this.updateBookingApi = new UpdateBookingApi();
        this.sharedStepContext = sharedStepContext;
    }
    @And("we prepare a request for update booking API")
    public void wePrepareARequestForUpdateBookingAPI(Map<String,String >requestDataMap) {

        var dateFormatter = DateTimeFormatter.ISO_DATE;
        var checkInDate = TestDataHelper.getFutureDate(Integer.parseInt(requestDataMap.get("checkInPlusDays")), dateFormatter);
        var checkOutDate = TestDataHelper.getFutureDate(Integer.parseInt(requestDataMap.get("checkOutPlusDays")), dateFormatter);
        var totalPrice = Integer.parseInt(requestDataMap.get("totalPrice"));

        this.requestPayload = ApiRequestHelper.getCreateBookingRequest(
                requestDataMap.get("firstName"),
                requestDataMap.get("lastName"),
                totalPrice,
                Boolean.parseBoolean(requestDataMap.get("depositPaid")),
                requestDataMap.get("additionalNeeds"),
                checkInDate, checkOutDate

        );

    }

    @And("we send request to update booking API")
    public void weSendRequestToUpdateBookingAPI() {
        var bookingId = this.sharedStepContext.bookingId;
        String username = System.getenv("RESTBOOKER_USERNAME");
        String password = System.getenv("RESTBOOKER_PASSWORD");

        this.sharedStepContext.apiResponse = this.updateBookingApi.updateBooking(this.requestPayload,bookingId,username,password);

    }
}
