package com.example.stayease.service;

import com.example.stayease.model.Hotel;
import com.example.stayease.repository.HotelRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelServiceTest {
    @Autowired
    private HotelService hotelService;

    @MockBean
    private HotelRepository hotelRepository;

    @Test
    public void testCreateHotel() {
        Hotel hotel = new Hotel();
        hotel.setName("Test Hotel");
        hotel.setLocation("Test Location");
        hotel.setDescription("Test Description");
        hotel.setAvailableRooms(10);

        when(hotelRepository.save(any(Hotel.class))).thenReturn(hotel);

        Hotel createdHotel = hotelService.createHotel(hotel);

        assertEquals(hotel.getName(), createdHotel.getName());
    }
}
