package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

class SvatkyTest {


    @Test
    void kdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.vratKdyMaSvatek("Nataša"));
        assertNull(svatky.vratKdyMaSvatek("Eva"));
    }

    @Test
    void jeVSeznamu() {
        //Arrange
        Svatky svatky = new Svatky();
        String jmenoJeVSeznamu = "Klaudie";
        String jmenoNeniVSeznamu = "Max";

        //Act
        boolean resultJmenoJeVSeznamu = svatky.jeVSeznamu(jmenoJeVSeznamu);
        boolean resultJmenoNeniVSeznamu = svatky.jeVSeznamu(jmenoNeniVSeznamu);

        //Assert
        assertTrue(resultJmenoJeVSeznamu, "Očekávám, že Klaudie je v seznamu.");
        assertFalse(resultJmenoNeniVSeznamu, "Očekávám, že Max není v seznamu.");
    }

    @Test
    void getPocetJmen() {
        Svatky svatky = new Svatky();
        int numberOfNamedays = 37;
        int result = svatky.getPocetJmen();

        assertEquals(numberOfNamedays, result, "The Namedays count is not correct.");
    }

    @Test
    void getSeznamJmen() {
        Svatky svatky = new Svatky();
        int nameCount = svatky.getPocetJmen();
        int result = svatky.getSeznamJmen().size();

        assertEquals(nameCount, result);
    }

    @Test
    void pridatSvatekDenMesicInt() {
        Svatky svatky = new Svatky();
        String nameToAdd = "Princess Peach";
        int dayToAdd = 2;
        int monthToAdd = 2;

        svatky.pridejSvatek(nameToAdd, dayToAdd, monthToAdd);

        assertEquals(MonthDay.of(2, 2), svatky.vratKdyMaSvatek("Princess Peach"));
    }

    @Test
    void pridatSvatekDenMesicMonth() {
        Svatky svatky = new Svatky();
        String nameToAdd = "Luigi";
        int dayToAdd = 3;
        Month monthToAdd = Month.MARCH;

        svatky.pridejSvatek(nameToAdd, dayToAdd, monthToAdd);

        assertEquals(MonthDay.of(Month.MARCH, 3), svatky.vratKdyMaSvatek("Luigi"));
    }

    @Test
    void pridatSvatekMonthDay() {
        Svatky svatky = new Svatky();

        String nameToAdd = "Mario";
        MonthDay dayNameToAdd = MonthDay.of(1, 1);

        svatky.pridejSvatek(nameToAdd, dayNameToAdd);

        assertEquals(MonthDay.of(1, 1), svatky.vratKdyMaSvatek("Mario"));

    }

    @Test
    void smazatSvatek() {
        Svatky svatky = new Svatky();

        String deletingName = "Klaudia";

        svatky.smazSvatek(deletingName);

        assertNull(svatky.vratKdyMaSvatek(deletingName));
    }
}
