package com.klef.fsad.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsad.exam.model.Hotel;
import com.klef.fsad.exam.repository.HotelRepository;

@Service
public class HotelService {

    @Autowired
    private HotelRepository repo;

    public Hotel addHotel(Hotel h) {
        return repo.save(h);
    }

    public Hotel updateHotel(int id, Hotel h) {
        Hotel hotel = repo.findById(id).orElse(null);

        if(hotel != null) {
            hotel.setName(h.getName());
            hotel.setDate(h.getDate());
            hotel.setStatus(h.getStatus());
            return repo.save(hotel);
        }

        return null;
    }
}
