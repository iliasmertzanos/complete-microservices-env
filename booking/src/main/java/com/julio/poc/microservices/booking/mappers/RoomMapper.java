package com.julio.poc.microservices.booking.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.julio.poc.microservices.booking.dtos.RoomGetDTO;
import com.julio.poc.microservices.booking.dtos.RoomPostDTO;
import com.julio.poc.microservices.booking.entities.Room;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    Room toEntity(RoomPostDTO dto);

    RoomGetDTO toDTO(Room entity);

    List<RoomGetDTO> toDTO(List<Room> entities);

    default Page<RoomGetDTO> toDTO(Page<Room> page) {
        List<RoomGetDTO> responses = toDTO(page.getContent());
        return new PageImpl<>(responses, page.getPageable(), page.getTotalElements());
    }
}
