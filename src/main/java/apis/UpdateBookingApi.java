package apis;

import http.BaseApi;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.request.CreateBookingRequest;

import java.util.Map;

import static constants.ApiPath.UPDATE_BOOKING;

public class UpdateBookingApi extends BaseApi {

    public UpdateBookingApi() {

        super();
        super.logAllSpecificRequestDetail(LogDetail.BODY).logAllResponseData();
        super.setContentType(ContentType.JSON);
    }

    public Response updateBooking(Map<String, Object> creatBookingPayload, int bookingId,
                                  String username, String password)
    {
        return getCreateBookingApiResponse(creatBookingPayload,bookingId, username, password);
    }

    public Response updateBooking(CreateBookingRequest createBookingRequest, int bookingId, String username, String password)
    {
        return getCreateBookingApiResponse(createBookingRequest,bookingId, username, password);
    }

    private Response getCreateBookingApiResponse(Object createBookingPayload, int bookingId, String username, String password) {
        super.setBasePath(UPDATE_BOOKING.getApiPath());
        super.setRequestBody(createBookingPayload);
        super.setPathParam("bookingId", bookingId);
        super.setBasicAuth(username, password);
        return super.sendRequest(UPDATE_BOOKING.getHttpMethodType());
    }
}
