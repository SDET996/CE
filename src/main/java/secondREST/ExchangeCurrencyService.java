package secondREST;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ExchangeCurrencyService {
	
	
	public Double getRate() {
		
		Client client = Client.create();

	    WebResource webResource = client.resource("http://api.fixer.io/latest?symbols=USD");
	    
	    ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

	    if (response.getStatus() != 200) { 
	    	throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
	    }

	    JSONObject obj = new JSONObject(response.getEntity(String.class));
	   
	    JSONObject objRate = new JSONObject(obj.get("rates").toString());
	    
	    return (Double) objRate.get("USD");
	}
	
	public Response convertEuroToDollar(Double euro){
		
		Double dollar = euro / getRate();
		
		JSONObject obj = new JSONObject();
		
		obj.put("Dollar", dollar);
		
		return Response.status(200).entity(obj.toString()).build();
	}
	
	public Response convertDollarToEuro(Double dollar){
		
		Double euro = dollar * getRate();
		
		JSONObject obj = new JSONObject();
		
		obj.put("Euro", euro);
		
		return Response.status(200).entity(obj.toString()).build();
	}
	

}
