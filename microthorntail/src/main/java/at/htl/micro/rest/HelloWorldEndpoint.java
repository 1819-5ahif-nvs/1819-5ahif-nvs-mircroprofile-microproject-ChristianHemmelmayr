package at.htl.micro.rest;


import at.htl.dao.StudentDao;
import at.htl.model.Student;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;


@Path("/hello")
public class HelloWorldEndpoint {

	@GET
	@Produces("text/plain")
	public Response doGet() {
		StudentDao dao = new StudentDao();
		dao.create(new Student());
		int x = dao.listAll(0, 10).size();
		return Response.ok("Hello from Thorntail! 2 :" + x).build();
	}
}
