package google;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiResponse;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

public class GeocodingApi {

    public GeocodingApi() {}

  /**
   * Creates a new Geocoding API request.
   *
   * @param context The {@link GeoApiContext} to make requests through.
   * @return Returns the request, ready to run.
   */
    public static GeocodingApiRequest newRequest(GeoApiContext context) {
        return new GeocodingApiRequest(context);
    }

  /**
   * Requests the latitude and longitude of an {@code address}.
   *
   * @param context The {@link GeoApiContext} to make requests through.
   * @param address The address to geocode.
   * @return Returns the request, ready to run.
   */
    public static GeocodingApiRequest geocode(GeoApiContext context, String address) {
        GeocodingApiRequest request = new GeocodingApiRequest(context);
        request.address(address);
        return request;
    }

  /**
   * Requests the street address of a {@code location}.
   *
   * @param context The {@link GeoApiContext} to make requests through.
   * @param location The location to reverse geocode.
   * @return Returns the request, ready to run.
   */
    public static GeocodingApiRequest reverseGeocode(GeoApiContext context, LatLng location) {
        GeocodingApiRequest request = new GeocodingApiRequest(context);
        request.latlng(location);
        return request;
    }

    static class Response implements ApiResponse<GeocodingResult[]> {
        public String status;
        public String errorMessage;
        public GeocodingResult[] results;

        @Override
        public boolean successful() {
          return "OK".equals(status) || "ZERO_RESULTS".equals(status);
        }

        @Override
        public GeocodingResult[] getResult() {
          return results;
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