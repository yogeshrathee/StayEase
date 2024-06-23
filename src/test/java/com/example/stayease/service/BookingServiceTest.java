package com.example.stayease.service;

import com.example.stayease.model.Booking;
import com.example.stayease.model.Hotel;
import com.example.stayease.model.User;
import com.example.stayease.repository.BookingRepository;
import com.example.stayease.repository.HotelRepository;
import com.example.stayease.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingServiceTest {
    @Autowired
    private BookingService bookingService;

    @MockBean
    private BookingRepository bookingRepository;

    @MockBean
    private HotelRepository hotelRepository;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testBookRoom() {
        Hotel hotel = new Hotel();
        hotel.setId(1L);
        hotel.setName("Test Hotel");
        hotel.setAvailableRooms(10);

        User user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");

        Booking booking = new Booking();
        booking.setHotel(hotel);
        booking.setUser(user);

        when(hotelRepository.findById(anyLong())).thenReturn(Optional.of(hotel));
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        Booking bookedRoom = bookingService.bookRoom(1L, 1L);

        assertEquals(hotel.getId(), bookedRoom.getHotel().getId());
        assertEquals(user.getId(), bookedRoom.getUser().getId());
    }
}
