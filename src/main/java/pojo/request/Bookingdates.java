package pojo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bookingdates {

	@JsonProperty("checkin")
	private String checkin;

	@JsonProperty("checkout")
	private String checkout;
}