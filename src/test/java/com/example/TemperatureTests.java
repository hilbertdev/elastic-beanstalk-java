package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.example.services.StringUtils;
import com.example.services.TemperatureConverter;

public class TemperatureTests {
    
    @Test 
    void ConvertsRoomTempToFahrenheit()
    {
       //arrange
       var roomTemp = 25;
       var expectedRoomtTempInFahrenHeit = 74.3;
       var sut = new TemperatureConverter();

       //act
       var result = sut.ConvertToFahrenHeit(roomTemp);

       //assert
       assertEquals(expectedRoomtTempInFahrenHeit, result);
    }

    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
    void palindromes(String candidate) {
        assertTrue(StringUtils.isPalindrome(candidate));
    }
}
