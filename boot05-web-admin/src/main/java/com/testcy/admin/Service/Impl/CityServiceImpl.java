package com.testcy.admin.Service.Impl;

import com.testcy.admin.Service.CityService;
import com.testcy.admin.bean.City;
import com.testcy.admin.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public City queryById(long id) {
        return cityMapper.getCityById(id);
    }

    @Override
    public City saveCity(City city) {
        cityMapper.add(city);
        return city;
    }

}
