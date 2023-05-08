package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }


    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities("city").size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities("city").size());
        assertTrue(cityList.getCities("city").contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities("city").get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities("city").get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities("city").get(1)));
    }
    @Test
    public void testDelete(){
        CityList list = new CityList();
        City city1 = new City("khulna","kh");
        City city2 = new City("dhaka","dh");

        list.add(city1);
        list.add(city2);


        list.delete(city1);

        assertEquals(1,list.count());
        assertFalse(list.getCities("city").contains(city1));

    }
    @Test
    public void testDeleteException(){
        CityList list = new CityList();
        City city1 = new City("khulna","kh");
        City city2 = new City("dhaka","dh");

        list.add(city1);
        list.add(city2);

        list.delete(city1);
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(city1);
        });
    }

    @Test
    public void  testCount(){
        CityList list = new CityList();
        City city1 = new City("khulna","kh");
        City city2 = new City("dhaka","dh");

        list.add(city1);
        assertEquals(1,list.count());

        list.add(city2);
        assertEquals(2,list.count());

    }

    @Test
    public void testSort()
    {
        CityList list = new CityList();
        City city1 = new City("Pabna","Aahshahi");
        City city2 = new City("Kushtia","Khulna");
        City city3 = new City("Bogra","Rahshahi");
        City city4 = new City("chuadanga","Khulna");

        list.add(city1);
        list.add(city2);
        list.add(city3);
        list.add(city4);

        assertEquals(0, city3.compareTo(list.getCities("city").get(0)));
        assertEquals(0, city1.compareTo(list.getCities("province").get(0)));


    }
}
