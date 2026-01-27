package com.garage.Vehicle_Service.repo;

import com.garage.Vehicle_Service.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle,Long> {

}
