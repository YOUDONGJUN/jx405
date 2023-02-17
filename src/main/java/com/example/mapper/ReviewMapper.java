package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.dto.ReviewDto;
import com.example.vo.Review;
import com.example.vo.ReviewPoint;
import com.example.vo.ReviewPointType;
import com.example.web.form.Criteria;

@Mapper
public interface ReviewMapper {

	Review getReviewByNo(long reviewNo);
	void insertReview(Review review);
	void insertReviewPoint(ReviewPoint reviewPoint);
	int getTotalReviewsByMovieNo(int movieNo);
	List<ReviewPointType> getAllPointTypes();
	List<ReviewDto> getAllReviewsByMovieNo(Criteria criteria);
	List<ReviewPointType> getPointNamesByReviewNo(long reviewNo);
	Review getMyReviewByMovieNo(@Param("customerNo") int customerNo, 
            					@Param("movieNo") int movieNo);
	List<ReviewPoint> getReviewPointsByReviewNo(long reviewNo);
	void updateReview(Review review);
	void deleteReviewPoints(long reviewNo);
	void deleteReview(long reviewNo);
	int getReviewPointCount(@Param("movieNo") int movieNo, 
							@Param("pointNo") int pointNo);
	int getReviewScore(int movieNo);
	String getPointNameByPointNo(int pointNo);
	List<String> getQualification(@Param("customerNo") int customerNo, 
							      @Param("movieNo") int movieNo);
}
