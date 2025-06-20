package pojo.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookingResponse{

	@JsonProperty("booking")
	private Booking booking;

	@JsonProperty("bookingid")
	private int bookingId;



}