package pojo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookingRequest{

	@JsonProperty("firstname")
	private String firstName;

	@JsonProperty("additionalneeds")
	private String additionalNeeds;

	@JsonProperty("bookingdates")
	private Bookingdates bookingDates;

	@JsonProperty("totalprice")
	private int totalPrice;

	@JsonProperty("depositpaid")
	private boolean depositPaid;

	@JsonProperty("lastname")
	private String lastName;
}