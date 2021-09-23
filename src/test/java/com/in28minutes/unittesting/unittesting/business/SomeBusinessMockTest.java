package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {

    @InjectMocks
    SomeBusinessImpl business;

    @Mock
    SomeDataService mockDataService = mock(SomeDataService.class);

//    If you are using JUnit 5, in the next lecture use
//    @ExtendWith(MockitoExtension.class)
//    instead of @RunWith(MockitoJUnitRunner.class)

    // No longer needed with @InjectMocks and @Mock
//    @BeforeEach
//    public void beforeEach() {
//        business.setSomeDataService(mockDataService);
//    }

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
