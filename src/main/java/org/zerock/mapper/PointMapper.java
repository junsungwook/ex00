package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;

public interface PointMapper {

	public void updatePoint(@Param("point") int point, @Param("userid") String userid);
}
