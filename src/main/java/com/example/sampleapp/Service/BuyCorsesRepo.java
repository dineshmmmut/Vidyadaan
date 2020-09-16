package com.example.sampleapp.Service;

import com.example.sampleapp.model.BuyCourses;
import com.example.sampleapp.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BuyCorsesRepo extends JpaRepository<BuyCourses,Integer>
{
//public BuyCourses findBuyCoursesByPro_id(String pro_id);

//    @Query("SELECT new pl.edu.wat.dto.FlightTicketDto(f.flight_id, f.departureDate, f.destinationDate, t.name, t.surname) "
//            + "FROM Flight f INNER JOIN f.tickets t")

//   BuyCourses findBuyCoursesByDuration(String duration);


//    @Query("select pro_id from buy_courses WHERE proId = :proId")
//    BuyCourses getCourse(String proId);
   BuyCourses findBuyCoursesByProId(String ProId);
}
