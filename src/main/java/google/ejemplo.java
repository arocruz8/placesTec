
package google;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.model.GeocodingResult;

public class ejemplo{
    String llaveApi = "AIzaSyB88REh9fMvRsTARfNYm5ndpf7vEduamI4";
    GeoApiContext context = new GeoApiContext.Builder().apiKey(llaveApi).build();
    
    String direccion = "1600 Amphitheatre Parkway Mountain View, CA 94043";
    
    GeocodingResult[] results =  GeocodingApi.geocode(context, direccion).await();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    System.out.println(gson.toJson(results[0].addressComponents));

    
    
}