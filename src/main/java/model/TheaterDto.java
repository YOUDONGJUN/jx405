package model;

import lombok.Data;
import vo.Theater;

import java.util.List;
import java.util.Map;

@Data
public class TheaterDto {
	private Map<String, List<Theater>> theaterList;
	private Theater theater;
	private List<TheaterTransportationDto> transportationList;

	private List<TheaterFacilityDto> facilityList;

	private List<ShowScheduleDto> showScheduleList;
	public void setTheaterList(String string, List<Theater> theatersByRegion) {
		// TODO Auto-generated method stub

	}
}
