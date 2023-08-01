package com.hotel.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.service.dao.HotelService;
import com.hotel.service.dto.Hotel;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	HotelService service;

	@PostMapping("/addHotel")
	private ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		System.out.println("hitted addHotel...");
		Hotel addedHotel = service.addHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedHotel);
	}

	@GetMapping("/getHotel/{hotelId}")
	private ResponseEntity<Hotel> getHotelById(@PathVariable int hotelId) {
		Hotel hotelById = service.getHotelById(hotelId);
		return ResponseEntity.ok(hotelById);
	}

	@GetMapping("/getAllHotels")
	private ResponseEntity<List<Hotel>> getAllHotels() {
		List<Hotel> allHotels = service.getAllHotels();
		return ResponseEntity.ok(allHotels);
	}

	@DeleteMapping("/deleteHotelById/{hotelId}")
	public ResponseEntity<String> deleteHotelById(@PathVariable int hotelId) {
		service.deleteHotelById(hotelId);
		return ResponseEntity.ok("Hotel deleted successfully");
	}

	@PostMapping("/updateHotel")
	private String updateUser(@RequestBody Hotel hotel) {
		System.out.println("update hotel hitted....");
		service.updateHotelById(hotel);
		String ok = "Hotel Updated Successfully";
		return ok;
	}
}
