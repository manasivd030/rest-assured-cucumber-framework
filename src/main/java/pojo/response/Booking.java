package pojo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pojo.request.Bookingdates;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking{

	@JsonProperty("firstname")
	private String firstname;

	@JsonProperty("additionalneeds")
	private String additionalneeds;

	@JsonProperty("bookingdates")
	private Bookingdates bookingdates;

	@JsonProperty("totalprice")
	private int totalprice;

	@JsonProperty("depositpaid")
	private boolean depositpaid;

	@JsonProperty("lastname")
	private String lastname;

}