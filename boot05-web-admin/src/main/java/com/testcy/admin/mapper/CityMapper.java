package com.testcy.admin.mapper;

import com.testcy.admin.bean.City;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CityMapper {

    @Select("select * from city where id=#{id}")
    public City getCityById(long id);

    @Insert("insert into city(`name`,`state`,`country`) values (#{name},#{state},#{country})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void add(City city);
}
