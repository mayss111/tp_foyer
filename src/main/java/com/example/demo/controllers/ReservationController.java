package com.example.demo.controllers;

import com.example.demo.Entitiy.Reservation;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.service.ReservationServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/reservations")
@Tag(name = "Reservation Management", description = "CRUD operations for reservations")

public class ReservationController {
    private final ReservationServiceImpl reservationService ;
    public ReservationController(ReservationServiceImpl reservationService) {
        this.reservationService = reservationService;
    }
    @Operation(summary = "Add a new reservation", description = "Creates a new reservation in the system")
@PostMapping
public String addReservation(@RequestBody Reservation reservation) {
    return reservationService.addReservation(reservationService );}
    @Operation(summary = "Update an existing reservation", description = "Updates the details of a reservation")
@PutMapping
public String updateReservation(@RequestBody Reservation reservation) {
    return reservationService.updateReservation(reservationService);}
    @Operation(summary = "Delete a reservation by ID", description = "Deletes the reservation with the given ID")
@DeleteMapping("/{id}")
public void deleteReservation(@PathVariable long id) {
    return reservationService.updateReservation(reservationService);}

    @Operation(summary = "Get all reservations", description = "Returns the list of all reservations")
@GetMapping
public List<Reservation> getAllReservations(){
    return reservationService.getAllReservation();
}

    @Operation(summary = "Get a reservation by ID", description = "Returns a specific reservation by its ID")
@GetMapping
public Reservation getAllReservationById(@PathVariable Long id){
    return reservationService.getReservationById(id);
}
}