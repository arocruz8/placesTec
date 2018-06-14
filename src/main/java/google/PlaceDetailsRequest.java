package google;

import com.google.gson.FieldNamingPolicy;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiConfig;
import com.google.maps.internal.ApiResponse;
import com.google.maps.model.PlaceDetails;

/**
 * A <a href="https://developers.google.com/places/web-service/details#PlaceDetailsRequests">Place
 * Details</a> request.
 */
public class PlaceDetailsRequest
    extends PendingResultBase<PlaceDetails, PlaceDetailsRequest, PlaceDetailsRequest.Response> {

  static final ApiConfig API_CONFIG =
      new ApiConfig("/maps/api/place/details/json")
          .fieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

  public PlaceDetailsRequest(GeoApiContext context) {
    super(context, API_CONFIG, Response.class);
  }

  /**
   * Specifies the Place ID to get Place Details for. Required.
   *
   * @param placeId The Place ID to retrieve details for.
   * @return Returns this {@code PlaceDetailsRequest} for call chaining.
   */
  public PlaceDetailsRequest placeId(String placeId) {
    return param("placeid", placeId);
  }

  @Override
  protected void validateRequest() {
    if (!params().containsKey("placeid")) {
      throw new IllegalArgumentException("Request must contain 'placeId'.");
    }
  }

  public static class Response implements ApiResponse<PlaceDetails> {
    public String status;
    public PlaceDetails result;
    public String[] htmlAttributions;
    public String errorMessage;

    @Override
    public boolean successful() {
      return "OK".equals(status) || "ZERO_RESULTS".equals(status);
    }

    @Override
    public PlaceDetails getResult() {
      if (result != null) {
        result.htmlAttributions = htmlAttributions;
      }
      return result;
    }

    @Override
    public ApiException getError() {
      if (successful()) {
        return null;
      }
      return ApiException.from(status, errorMessage);
    }
  }
}