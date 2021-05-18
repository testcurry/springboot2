package com.testcy.admin.Service;

import com.testcy.admin.bean.City;
import org.springframework.stereotype.Service;

@Service
public interface CityService {


    public City queryById(long id);

    public City saveCity(City city);

}
