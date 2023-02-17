package com.example.mapper;

import java.util.List;

import com.example.dto.TheaterFacilityDto;

public interface FacilityMapper {

	List<TheaterFacilityDto> getAllFacilityByNo(int no);

}
