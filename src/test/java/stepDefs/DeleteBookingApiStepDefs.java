package stepDefs;

import apis.DeleteBookingApi;
import io.cucumber.java.en.*;
import shareContext.SharedStepContext;


public class DeleteBookingApiStepDefs {

    private final DeleteBookingApi deleteBookingApi;
    private final SharedStepContext sharedStepContext;


    public DeleteBookingApiStepDefs(SharedStepContext sharedStepContext) {

        this.deleteBookingApi  = new DeleteBookingApi();
        this.sharedStepContext = sharedStepContext;
    }

    @And("we send request to delete booking API")
    public void weSendRequestToDeleteBookingAPI() {
        var bookingId = this.sharedStepContext.bookingId;
        String username = System.getenv("RESTBOOKER_USERNAME");
        String password = System.getenv("RESTBOOKER_PASSWORD");
        this.sharedStepContext.apiResponse = this.deleteBookingApi.deleteBookingById(bookingId,username,password);
    }
}
