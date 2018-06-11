package prueba;
import com.google.maps.GeoApiContext;
import com.google.maps.PhotoRequest;
import com.google.maps.PlaceAutocompleteRequest;
import com.google.maps.PlaceDetailsRequest;
import com.google.maps.QueryAutocompleteRequest;
import com.google.maps.RadarSearchRequest;
import com.google.maps.TextSearchRequest;
import com.google.maps.model.LatLng;

/**
 * Performs a text search for places. The Google Places API enables you to get data from the same
 * database used by Google Maps and Google+ Local. Places features more than 100 million businesses
 * and points of interest that are updated frequently through owner-verified listings and
 * user-moderated contributions.
 *
 * <p>See also: <a href="https://developers.google.com/places/web-service/">Places API Web Service
 * documentation</a>.
 */
public class PlacesApi {

     private PlacesApi() {}

  /**
   * Performs a search for nearby Places.
   *
   * @param context The context on which to make Geo API requests.
   * @param location The latitude/longitude around which to retrieve place information.
   * @return Returns a NearbySearchRequest that can be configured and executed.
   */
    public static NearbySearchRequest nearbySearchQuery(GeoApiContext context, LatLng location) {
        NearbySearchRequest request = new NearbySearchRequest(context);
        request.location(location);
        return request;
    }

  /**
   * Retrieves the next page of Nearby Search results. The nextPageToken, returned in a
   * PlacesSearchResponse when there are more pages of results, encodes all of the original Nearby
   * Search Request parameters, which are thus not required on this call.
   *
   * @param context The context on which to make Geo API requests.
   * @param nextPageToken The nextPageToken returned as part of a PlacesSearchResponse.
   * @return Returns a NearbySearchRequest that can be executed.
   */
    public static NearbySearchRequest nearbySearchNextPage(
        GeoApiContext context, String nextPageToken) {
        NearbySearchRequest request = new NearbySearchRequest(context);
        request.pageToken(nextPageToken);
        return request;
    }

  /**
   * Performs a search for Places using a text query; for example, "pizza in New York" or "shoe
   * stores near Ottawa".
   *
   * @param context The context on which to make Geo API requests.
   * @param query The text string on which to search, for example: "restaurant".
   * @return Returns a TextSearchRequest that can be configured and executed.
   */
  public static TextSearchRequest textSearchQuery(GeoApiContext context, String query) {
    TextSearchRequest request = new TextSearchRequest(context);
    request.query(query);
    return request;
  }

  /**
   * Retrieves the next page of Text Search results. The nextPageToken, returned in a
   * PlacesSearchResponse when there are more pages of results, encodes all of the original Text
   * Search Request parameters, which are thus not required on this call.
   *
   * @param context The context on which to make Geo API requests.
   * @param nextPageToken The nextPageToken returned as part of a PlacesSearchResponse.
   * @return Returns a TextSearchRequest that can be executed.
   */
  public static TextSearchRequest textSearchNextPage(GeoApiContext context, String nextPageToken) {
    TextSearchRequest request = new TextSearchRequest(context);
    request.pageToken(nextPageToken);
    return request;
  }

  /**
   * Performs a radar search for up to 200 places, but with less detail than is returned from Text
   * Search or Nearby Search.
   *
   * @deprecated This functionality is deprecated and will stop working on June 30, 2018.
   * @see <a
   *     href="https://maps-apis.googleblog.com/2017/06/announcing-deprecation-of-place-add.html">Removing
   *     Place Add, Delete &amp; Radar Search features</a>
   * @param context The context on which to make Geo API requests.
   * @param location The location around which to retrieve place information.
   * @param radius The distance in meters within which to return place results.
   * @return Returns a RadarSearchRequest that can be configured and executed.
   */
//  public static RadarSearchRequest radarSearchQuery(
//    GeoApiContext context, LatLng location, int radius) {
//    RadarSearchRequest request = new RadarSearchRequest(context);
//    request.location(location);
//    request.radius(radius);
//    return request;
//  }

  /**
   * Requests the details of a Place.
   *
   * <p>We are only enabling looking up Places by placeId as the older Place identifier, reference,
   * is deprecated. Please see the <a
   * href="https://web.archive.org/web/20170521070241/https://developers.google.com/places/web-service/details#deprecation">
   * deprecation warning</a>.
   *
   * @param context The context on which to make Geo API requests.
   * @param placeId The PlaceID to request details on.
   * @return Returns a PlaceDetailsRequest that you can configure and execute.
   */
    public static PlaceDetailsRequest placeDetails(GeoApiContext context, String placeId) {
        PlaceDetailsRequest request = new PlaceDetailsRequest(context);
        request.placeId(placeId);
        return request;
    }

  /**
   * Requests a Photo from a PhotoReference.
   *
   * <p>Note: If you want to use a Photo in a web browser, please retrieve the photos for a place
   * via our <a
   * href="https://developers.google.com/maps/documentation/javascript/places#places_photos">
   * JavaScript Places Library</a>. Likewise, on Android, Places Photos can be retrieved using the
   * <a href="https://developers.google.com/places/android-api/photos">Google Places API for
   * Android</a>.
   *
   * @param context The context on which to make Geo API requests.
   * @param photoReference The reference to the photo to retrieve.
   * @return Returns a PhotoRequest that you can execute.
   */
    public static PhotoRequest photo(GeoApiContext context, String photoReference) {
        PhotoRequest request = new PhotoRequest(context);
        request.photoReference(photoReference);
        return request;
    }
}
  /**
   * Creates a new Places Autocomplete request for a given input. The Place Autocomplete service can
   * match on full words as well as substrings. Applications can therefore send queries as the user
   * types, to provide on-the-fly place predictions.
   *
   * @param context The context on which to make Geo API requests.
   * @param input input is the text string on which to search.
   * @return Returns a PlaceAutocompleteRequest that you can configure and execute.
   */
//  public static PlaceAutocompleteRequest placeAutocomplete(GeoApiContext context, String input) {
//    PlaceAutocompleteRequest request = new PlaceAutocompleteRequest(context);
//    request.input(input);
//    return request;
//  }

  /**
   * Allows you to add on-the-fly geographic query predictions to your application.
   *
   * @param context The context on which to make Geo API requests.
   * @param input input is the text string on which to search.
   * @return Returns a QueryAutocompleteRequest that you can configure and execute.
   */
//  public static QueryAutocompleteRequest queryAutocomplete(GeoApiContext context, String input) {
//    QueryAutocompleteRequest request = new QueryAutocompleteRequest(context);
//    request.input(input);
//    return request;
//  }
//}