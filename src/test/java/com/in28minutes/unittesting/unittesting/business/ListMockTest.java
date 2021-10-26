package com.in28minutes.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

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

    @Test
    public void size_returnWithGenericParameters() {
        when(listMock.get(anyInt())).thenReturn("in28minutes");
        assertEquals("in28minutes", listMock.get(0));
        assertEquals("in28minutes", listMock.get(1));
    }

    @Test
    public void argumentCapturing() {
        listMock.add("Some String");

        // Verify
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(listMock).add(captor.capture());

        assertEquals("Some String", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        listMock.add("Some String 1");
        listMock.add("Some String 2");

        // Verify
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(listMock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();
        assertEquals("Some String 1", allValues.get(0));
        assertEquals("Some String 2", allValues.get(1));
    }

}
