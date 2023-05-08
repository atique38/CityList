package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * this method sorts cities according to city or province name
     * @param name
     * sort by city if name="city", otherwise sort by province
     * @return
     * sorted cityList
     */
    public List<City> getCities(String name) {
        List<City> cityList = cities;
        if(name.equals("city"))
        {
            Collections.sort(cityList);
        }
        else if(name.equals("province"))
        {
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City city, City t1) {
                    return city.getProvinceName().compareTo(t1.getProvinceName());
                }
            });
        }

        return cityList;
    }

    /**
     * this method delete city if exists otherwise throws exception
     * @param city
     * city to be deleted
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * this method count the number of cities in cityList
     * @return
     * total number of cities
     */
    public int count(){
        return cities.size();
    }
}
