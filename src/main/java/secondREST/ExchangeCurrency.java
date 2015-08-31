package secondREST;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/converter")
public class ExchangeCurrency {
	
	
	ExchangeCurrencyService exchangeCurrencyService = new ExchangeCurrencyService();
	
	@GET
	@Produces("application/json")
	@Path("/etd/{E}")
	public Response etd(@PathParam("E") Double E){
		
		return exchangeCurrencyService.convertEuroToDollar(E);
	}
	
	@GET
	@Produces("application/json")
	@Path("/dte/{D}")
	public Response dte(@PathParam("D") Double D){
						
		return exchangeCurrencyService.convertDollarToEuro(D);
	}
}
