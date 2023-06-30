package ru.netology.geo;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GeoServiceImplTest {
    @Test
    public void testByIpReturnsLocationForLocalhostIp() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location result = geoService.byIp("127.0.0.1");
        assertNull(result.getCountry());
        assertNull(result.getCity());
        assertNull(result.getStreet());
    }

    @Test
    public void testByIpReturnsLocationForMoscowIp() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location result = geoService.byIp("172.0.32.11");
        assertEquals("Moscow", result.getCity());
        assertEquals(Country.RUSSIA, result.getCountry());
        assertEquals("Lenina", result.getStreet());
    }

    @Test
    public void testByIpReturnsLocationForNewYorkIp() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location result = geoService.byIp("96.44.183.149");
        assertEquals("New York", result.getCity());
        assertEquals(Country.USA, result.getCountry());
        assertEquals(" 10th Avenue", result.getStreet());
    }

    @Test
    public void testByIpReturnsLocationForMoscowIpAddress() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location result = geoService.byIp("172.1.1.1");
        assertEquals("Moscow", result.getCity());
        assertEquals(Country.RUSSIA, result.getCountry());
        assertNull(result.getStreet());
    }

    @Test
    public void testByIpReturnsLocationForNewYorkIpAddress() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location result = geoService.byIp("96.1.1.1");
        assertEquals("New York", result.getCity());
        assertEquals(Country.USA, result.getCountry());
        assertNull(result.getStreet());
    }

    @Test
    public void testByIpReturnsNullForUnknownIpAddress() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location result = geoService.byIp("1.2.3.4");
        assertNull(result);
    }
}
