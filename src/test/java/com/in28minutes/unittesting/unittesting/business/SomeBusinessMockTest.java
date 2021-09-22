package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessMockTest {

    @Test
    public void calculateSumUsingDataService_basic() {
        SomeDataService mockDataService = mock(SomeDataService.class);
        when(mockDataService.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });

        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(mockDataService);

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        SomeDataService mockDataService = mock(SomeDataService.class);
        when(mockDataService.retrieveAllData()).thenReturn(new int[] { });

        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(mockDataService);

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        SomeDataService mockDataService = mock(SomeDataService.class);
        when(mockDataService.retrieveAllData()).thenReturn(new int[] { 7 });

        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(mockDataService);

        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 7;
        assertEquals(expectedResult, actualResult);
    }

}
