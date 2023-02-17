package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.MyMovie;

@Mapper
public interface MyMovieMapper {

	void saveLike(MyMovie myMovie);
	void upLike(int movieNo);
	void deleteLike(MyMovie myMovie);
	void downLike(int movieNo);
	int getLikeCount(int movieNo);
	List<MyMovie> getMyMovies(int customerNo);
}
