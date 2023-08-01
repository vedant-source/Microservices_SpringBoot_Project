package com.hotel.service.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.service.dao.HotelService;
import com.hotel.service.dto.Hotel;
import com.hotel.service.exceptions.ResourceNotFoundException;
import com.hotel.service.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository repository;

	@Override
	public Hotel addHotel(Hotel hotel) {
		Hotel h = repository.save(hotel);
		return h;
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Hotel getHotelById(int id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel with given Id doesn't exist ...!!"));
	}

	@Override
	public void deleteHotelById(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public Hotel updateHotelById(Hotel hotel) {
		// TODO Auto-generated method stub
		Hotel h = getHotelById(hotel.getId());
		if (h != null) {
			h.setName(hotel.getName());
			h.setLocation(hotel.getLocation());
			h.setAbout(hotel.getAbout());

			repository.save(h);
		} else {
			throw new ResourceNotFoundException("Hotel with given Id doesn't exist ...!!");
		}
		return null;
	}

}
