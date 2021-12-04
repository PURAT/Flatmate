package com.company.flatmate.controller;

import com.company.flatmate.dto.ApartmentPhotoDto;
import com.company.flatmate.entity.ApartmentPhoto;
import com.company.flatmate.service.ApartmentPhotoService;
import com.company.flatmate.util.mapper.ApartmentPhotoMapper;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.UUID;

@RestController
@RequestMapping("/apartment/photo")
@SecurityRequirement(name = "flatmateapi")
@AllArgsConstructor
public class ApartmentPhotoController {

    private final ApartmentPhotoMapper apartmentPhotoMapper;
    private final ApartmentPhotoService service;

    @PostMapping
    public HttpStatus addApartmentPhoto(@RequestBody ApartmentPhoto photo) {
        service.save(photo);
        return HttpStatus.OK;
    }

    @GetMapping
    public String getApartmentPhoto() {

        ApartmentPhotoDto dto = new ApartmentPhotoDto();
        dto.setApartmentId(UUID.fromString("400db01e-3999-11ec-8d3d-0242ac130003"));
        dto.setId(UUID.randomUUID());
        dto.setPhoto(new byte[]{3, 5, 6, 50, 127, 0});

        ApartmentPhoto photo = apartmentPhotoMapper.dtoToPhoto(dto);
        System.out.println(Arrays.toString(photo.getPhoto()));
        service.save(photo);


        return photo.toString();
    }

}
