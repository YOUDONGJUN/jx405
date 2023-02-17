package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.FaqDto;
import com.example.web.form.FaqCriteria;

@Mapper
public interface FaqMapper {

	int getFaqTotalRows(FaqCriteria criteria);
	List<FaqDto> getAllFaq(FaqCriteria criteria);
}
