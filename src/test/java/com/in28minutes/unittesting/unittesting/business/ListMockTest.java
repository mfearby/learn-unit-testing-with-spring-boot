package com.in28minutes.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListMockTest {

    List listMock = mock(List.class);

    @Test
    public void size_basic() {
        when(listMock.size()).thenReturn(5);
        assertEquals(5, listMock.size());
    }

    @Test
    public void size_returnDifferentValues() {
        when(listMock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, listMock.size());
        assertEquals(10, listMock.size());
    }

    @Test
    public void size_returnWithParameters() {
        when(listMock.get(0)).thenReturn("in28minutes");
        assertEquals("in28minutes", listMock.get(0));
        assertNull(listMock.get(1));
    }
}
