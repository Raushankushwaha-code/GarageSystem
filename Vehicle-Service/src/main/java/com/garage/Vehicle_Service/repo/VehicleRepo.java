package com.garage.Vehicle_Service.repo;

import com.garage.Vehicle_Service.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle,Long> {

    /*//Find vehicleId (if exist return true or not exist return false)
    @Override
    boolean existsById(Long vId);*/

    //Find list of vehicles by customers ( in case multiples have same customerID)
    List<Vehicle> findByCustomerId(Long id);
}
