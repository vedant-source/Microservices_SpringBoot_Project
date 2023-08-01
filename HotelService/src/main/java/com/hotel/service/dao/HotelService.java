package com.hotel.service.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hotel.service.dto.Hotel;

public interface HotelService {

	// create
	Hotel addHotel(Hotel hotel);

	// getAll
	List<Hotel> getAllHotels();

	// getSingle
	Hotel getHotelById(int id);

	// delete hotel by id
	void deleteHotelById(int id);

	// Update user by id
	Hotel updateHotelById(Hotel hotel);

}
