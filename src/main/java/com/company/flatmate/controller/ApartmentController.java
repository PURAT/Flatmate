package com.company.flatmate.controller;

import com.company.flatmate.dto.ApartmentDto;
import com.company.flatmate.security.payload.MessageResponse;
import com.company.flatmate.service.ApartmentService;
import com.company.flatmate.util.mapper.ApartmentFeedbackMapper;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/apartment")
@SecurityRequirement(name = "flatmateapi")
@AllArgsConstructor
public class ApartmentController {

    private final ApartmentService service;

    @GetMapping
    public ResponseEntity<?> getActiveApartments() {
        List<ApartmentDto> list = service.findAllByActive(true);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/query")
    public ResponseEntity<?> getApartmentsByPrice(@RequestParam(value = "min") double min,
                                                  @RequestParam(value = "max") double max) {
        List<ApartmentDto> list = service.findAllByPriceBetween(min, max);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/query")
    public ResponseEntity<?> getApartmentsByRooms(@RequestParam(value = "count_room") int count) {
        List<ApartmentDto> list = service.findAllByRoomsCount(count);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/query")
    public ResponseEntity<?> getApartmentsByLodgers(@RequestParam(value = "count_lodger") int count) {
        List<ApartmentDto> list = service.findAllByLodgerCount(count);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<?> addApartment(@RequestBody ApartmentDto apartment) {
        service.save(apartment);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/query")
    public ResponseEntity<?> deleteOutdatedApartments(@RequestParam("date") OffsetDateTime date) {
        service.deleteAllByDateBefore(date);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApartment(@PathVariable String id) {
        try {
            service.deleteById(UUID.fromString(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Apartment ID is entered incorrectly!"));
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteNotActiveApartments() {
        service.deleteAllByActive(false);
        return ResponseEntity.ok().build();
    }
//
//    @GetMapping
//    public String getApartment() {
//        Apartment apartment = new Apartment();
//        apartment.setId(UUID.fromString("400db01e-3999-11ec-8d3d-0242ac130003"));
//        apartment.setLocation(new Point(10.565, 10.987));
////        service.save(apartment);
//        return null;
//    }

}
