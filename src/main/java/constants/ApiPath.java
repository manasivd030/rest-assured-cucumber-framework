package constants;

import io.restassured.http.Method;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static io.restassured.http.Method.*;

@AllArgsConstructor
@Getter
public enum ApiPath {

    GET_BOOKING("/booking/{bookingId}", GET),
    GET_BOOKING_IDS("/booking", GET),
    CREATE_BOOKING("/booking", POST),
    DELETE_BOOKING("/booking/{bookingId}", DELETE),
    UPDATE_BOOKING("/booking/{bookingId}", PUT),;

    private final String apiPath;
    private final Method httpMethodType;//This is declared as private but need to access outside this class so getter is used

}
