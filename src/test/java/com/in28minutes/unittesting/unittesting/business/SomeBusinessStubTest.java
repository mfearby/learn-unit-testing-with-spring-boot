package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeDataServiceStub implements SomeDataService {

    private int[] data = new int[] {};

    @Override
    public int[] retrieveAllData() {
        return data;
    }

    @Override
    public void setAllData(int[] data) {
        this.data = data;
    }
}

public class SomeBusinessStubTest {

    @Test
    public void calculateSumUsingDataService_basic() {
        SomeDataService stub = new SomeDataServiceStub();
        stub.setAllData(new int[] { 1, 2, 3 });

        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(stub);

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        SomeDataService stub = new SomeDataServiceStub();
        stub.setAllData(new int[] { 7 });

        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(stub);

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 7;
        assertEquals(expectedResult, actualResult);
    }

}
