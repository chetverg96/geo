package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class LocalizationServiceImplTest {

    @Test
    public void testLocaleReturnsRussianGreetingForRussia() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String result = localizationService.locale(Country.RUSSIA);
        assertEquals("Добро пожаловать", result);
    }

    @Test
    public void testLocaleReturnsEnglishGreetingForNonRussianCountry() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String result = localizationService.locale(Country.USA);
        assertEquals("Welcome", result);
    }
}
