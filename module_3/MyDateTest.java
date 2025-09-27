
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyDateTest {

    @Test
    void testIsLeapYear() {
        // Typical leap years
        assertTrue(MyDate.isLeapYear(2000));
        assertTrue(MyDate.isLeapYear(2024));

        // Typical non-leap years
        assertFalse(MyDate.isLeapYear(1900));
        assertFalse(MyDate.isLeapYear(2023));

        // Invalid years
        assertThrows(IllegalArgumentException.class, () -> MyDate.isLeapYear(0));
        assertThrows(IllegalArgumentException.class, () -> MyDate.isLeapYear(10000));
    }

    @Test
    void testToJulianNumber() {
        // Example date: January 1, 2000
        int julian = MyDate.convertDateToJulian(1, 1, 2000);
        assertEquals(2451545, julian);

        // Example date: December 31, 1999
        julian = MyDate.convertDateToJulian(31, 12, 1999);
        assertEquals(2451544, julian);
    }

    @Test
    void testFromJulianNumber() {
        // Example Julian number: 2451545 → January 1, 2000
        int[] date = MyDate.fromJulianNumber(2451545);
        assertArrayEquals(new int[]{1, 1, 2000}, date);

        // Example Julian number: 2451544 → December 31, 1999
        date = MyDate.fromJulianNumber(2451544);
        assertArrayEquals(new int[]{31, 12, 1999}, date);
    }
}
