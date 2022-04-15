package com.washerservice.Controller;

import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.washerservice.Model.OrderDet;
import com.washerservice.Model.Washerdetails;
import com.washerservice.Model.washerRating;
import com.washerservice.Repository.WasherRepo;
import com.washerservice.exception.ApiRequestException;
import com.washerservice.service.WashService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/wash")
@CrossOrigin(origins = "http://localhost:3000")
public class WashController {

	@Autowired
	private WashService service;
	
   @Autowired
	private RestTemplate restTemplate;
   
   
   @Autowired
   private WasherRepo repo;
	
	@PostMapping(value = "/addwasher")
	@ApiOperation(value="To add the washer")
	public Washerdetails saveWasher(@RequestBody Washerdetails washer) {
		washer.setId(service.getSequenceNumber(washer.SEQUENCE_NAME));
		return service.addWasher(washer);
	}
	
	@GetMapping("/allwashers")
	@ApiOperation(value="To get List of all washers")
	public List<Washerdetails> findAllwashers() {
		return service. getwashers();
	}

	@GetMapping("/allwashers/{location}")
	@ApiOperation(value="To get List of all washers using location")
	public List<Washerdetails> findwasherByAddress(@PathVariable String location) {
		return service.getwasherbylocation(location);
	}

	@DeleteMapping(value="/delete")
	@ApiOperation(value="To delete the user")
	public Washerdetails removeUser(@RequestBody Washerdetails washer) {
		service.deletewasher(washer);
		return washer;
	}
	
	
	
	
	@GetMapping("/allratings")
	public List<washerRating> getallratings(){
	String baseurl="http://localhost:8082/admin/rating/allratings";
	washerRating[] allratings=restTemplate.getForObject(baseurl,washerRating[].class);

	return Arrays.asList(allratings);

	}
	
	@GetMapping("/allorders")
	public List<OrderDet> getallorders(){
	String baseurl="http://localhost:8084/od/allorders";
	OrderDet[] allorders=restTemplate.getForObject(baseurl, OrderDet[].class);

	return Arrays.asList(allorders);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deletewasher(@RequestParam int id)
	{
		boolean isUserExist=repo.existsById(id);
		if(isUserExist) {
			repo.deleteById(id);
			return new ResponseEntity<Object>("user deleted with id "+id,HttpStatus.OK);
		}
		else
		{
			throw new ApiRequestException("CAN NOT DELETE AS WASHER NOT FOUND WITH THIS ID ::");
		}
	}
	
	
	
	
	
	
	
	
	
}
