
package google;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.model.GeocodingResult;

import com.google.maps.PlaceDetailsRequest;
import com.google.maps.TextSearchRequest;

public class ejemplo{
    //variables para hacer una busqueda de un lugar
    String ApiKey = "AIzaSyB88REh9fMvRsTARfNYm5ndpf7vEduamI4";
    int radio = 100;
    
    String direccion = "1600 Amphitheatre Parkway Mountain View, CA 94043";
    String query = "restaurants+in+Sydney";

    //location ocupa la latittud y longitud
    
    String urlTexto = "https://maps.googleapis.com/maps/api/place/textsearch/xml?query="+query+"&key="+ApiKey;
   
    GeoApiContext context = new GeoApiContext.Builder().apiKey(ApiKey).build();
    
    //PlacesApi results = PlacesApi.textSearchQuery(context, query).await();
    //Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    GeocodingResult[] results =  GeocodingApi.geocode(context, direccion).await();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    System.out.println(gson.toJson(results[0].addressComponents));
    
    
}