package com.tai.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
   
@Stateless
public class AngularService extends MockService {

	static List<MockService> mockServiceList = new ArrayList();	
	
	@GET
	@Path("/mock_service/{path}")
	public Response getMockServerResponseGet(@PathParam(value = "path") String path) { 
		for(MockService mockService : mockServiceList) {
			if(mockService.getUrl().equals(path) && 
					"GET".equals(mockService.getHttpMethod())) {
				
				return Response.ok(mockService.getResponse()).build();
			}
			
			if(mockService.getUrl().equals(path) && 
					"POST".equals(mockService.getHttpMethod())) {
				
				return Response.ok(mockService.getResponse()).build();
			}
			
		}
		return Response.ok().build();
	}
	
	@POST
	@Path("/mock_service")
	public Response postClient(MockService mockservice)
	{
		mockServiceList.add(mockservice);
//		ResponseBuilder builder = Response.status(Status.CREATED);
		return Response.ok(mockservice).header("Access-Control-Allow-Origin", "POST").build();
	}
	
	
	
//	@PUT
//	@Path("/{put}")
//	public Response putClient(@PathParam("value") String value)
//	{
//		String message = "Emrah �zt�rk";
//		//return Response.ok(message).build();
//		return Response.ok().header("Access-Control-Allow-Origin", "*").build();
//	}
	
}
