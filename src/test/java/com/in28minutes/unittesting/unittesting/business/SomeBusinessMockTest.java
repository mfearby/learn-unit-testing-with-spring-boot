package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessMockTest {

    SomeBusinessImpl business = new SomeBusinessImpl();
    SomeDataService mockDataService = mock(SomeDataService.class);

    @BeforeEach
    public void beforeEach() {
        business.setSomeDataService(mockDataService);
    }

    @Test
    public void calculateSumUsingDataService_basic() {
        when(mockDataService.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
        assertEquals(6, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(mockDataService.retrieveAllData()).thenReturn(new int[] { });
        assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        when(mockDataService.retrieveAllData()).thenReturn(new int[] { 7 });
        assertEquals(7, business.calculateSumUsingDataService());
    }

}
