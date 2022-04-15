package com.userservice.controller;



import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.userservice.exception.ApiRequestException;
import com.userservice.model.Login;
import com.userservice.model.OrderDet;
import com.userservice.model.PaymentDetails;
import com.userservice.model.Signup;

import com.userservice.model.washerRating;
import com.userservice.model.washpackages;
import com.userservice.repo.userRepository;
import com.userservice.service.LoginService;
import com.userservice.service.UserService;

import io.swagger.annotations.ApiOperation;



@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/us")
public class Controller {
	
	
	@Autowired
	private LoginService log;

	@Autowired
	private UserService service;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private userRepository repo;
	
	
	@PostMapping("/Register")
	@ApiOperation(value="Users to Register")
	public Signup saveUser(@RequestBody Signup signup) {
		signup.setId(service.getSequenceNumber(Signup.SEQUENCE_NAME));
		return service.addUser(signup);
	}

	@GetMapping("/allusers")
	@ApiOperation(value="To get List of all users")
	public List<Signup> findAllUsers() {
		return service.getuser();
	}

	
	  @PutMapping("/updateUser")
	  @ApiOperation(value="To update the user")
	  public String updateUser(@RequestBody Signup signup) { 
		  String result = service.Updateuser(signup); return result;
		  }
	 
	  @PostMapping("/login")
	  @ApiOperation(value = "To Add Login Details")
	  public String dopayment(@RequestBody Login login) {
	  return log.userLogin(login);
	  }
	
	
	

	@GetMapping("/allusers/{id}")
	@ApiOperation(value="To get List of all users using id")
	 public Optional<Signup> getuser(@RequestParam int id)
	 		throws ApiRequestException
	 {
		 return Optional.of(repo.findById(id)
				 .orElseThrow( () -> new ApiRequestException("USER NOT FOUND WITH THIS ID ::")));
	 }

	
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value="To delete the user using id")
	 public ResponseEntity<Object> deleteuser(@RequestParam int id)
	 {
		 boolean isUserExist=repo.existsById(id);
		 if(isUserExist) {
			 service.deleteById(id);
			 return new ResponseEntity<Object>("user deleted with id "+id,HttpStatus.OK);
		 }
		 else
		 {
		 	throw new ApiRequestException("CAN NOT DELETE AS USER NOT FOUND WITH THIS ID ::");
		 }
	 }
	
	
	  @GetMapping("/allpacks")
	  @ApiOperation(value="To get List of all packages")
	  public List<washpackages> getwashpacks() { 
		  String baseurl ="http://localhost:8082/admin/allpacks";
		  washpackages[] wp =restTemplate.getForObject(baseurl, washpackages[].class);
	  
	  return Arrays.asList(wp); }
	 
	
	  
	  @PostMapping("/addorder")
	  @ApiOperation(value="To add the order")
	  public String addorder(@RequestBody OrderDet order) {
	  HttpHeaders headers = new HttpHeaders();
	  headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	  HttpEntity<OrderDet> entity = new HttpEntity<OrderDet>(order,headers);
	  return restTemplate.exchange(
	  "http://localhost:8084/od/addorder", HttpMethod.POST, entity, String.class).getBody();
	  }
	  
	  
	  
	  @DeleteMapping("/deleteorder")
	  @ApiOperation(value="To delete the order")
	  public String deleteorder(@RequestParam int id){
	  String baseurl="http://localhost:8084/od/cancelorder";
	  OrderDet order=restTemplate.getForObject(baseurl, OrderDet.class);
	  return "Your Order is successfully Canceled "+order;
	  }
	  
	  
	  @PostMapping("/addratings")
	  @ApiOperation(value="To add ratings")
		public String addrating(@RequestBody washerRating rating) {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<washerRating> entity = new HttpEntity<washerRating>(rating, headers);

			return restTemplate.exchange("http://localhost:8082/admin/addratings", HttpMethod.POST, entity, String.class)
					.getBody();
		}	  

	  
	  
		  
	@PostMapping("/addpayment")
	@ApiOperation(value="To make the payment by user")
	public String payment(@RequestBody PaymentDetails payment) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<PaymentDetails> entity = new HttpEntity<PaymentDetails>(payment, headers);
		return restTemplate.exchange("http://localhost:8085/am/payment", HttpMethod.POST, entity, String.class)
				.getBody();
	}

	

}


