package com.example.mapper;

import java.util.List;

import com.example.dto.TheaterTransportationDto;

public interface TransportationMapper {

	List<TheaterTransportationDto> getAllTransportationByNo(int no);

}
