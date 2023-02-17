package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.TheaterMapper;
import com.example.vo.Region;
import com.example.vo.Theater;


@Service
public class TheaterService {

	@Autowired
	private TheaterMapper theaterMapper;
	
	public Theater getTheaterDetail(int no){
		
		return theaterMapper.getTheaterByNo(no);
	}
	
	public Map<String, List<Theater>> getAllTheaters() {
		Map<String, List<Theater>> result = new HashMap<>();
		result.put("seoul", theaterMapper.getTheatersByRegion(10));
		result.put("kyungki", theaterMapper.getTheatersByRegion(11));
		result.put("incheon", theaterMapper.getTheatersByRegion(12));
		result.put("daejeon", theaterMapper.getTheatersByRegion(13));
		result.put("busan", theaterMapper.getTheatersByRegion(14));
		result.put("kwangju", theaterMapper.getTheatersByRegion(15));
		result.put("kangwon", theaterMapper.getTheatersByRegion(16));
		
		
		return result;
	}
	
	public List<Region> getAllRegion(){
		List<Region> regions = theaterMapper.getAllRegion();
		return regions;
	}
	
}
