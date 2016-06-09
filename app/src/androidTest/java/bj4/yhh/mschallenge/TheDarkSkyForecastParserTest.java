package bj4.yhh.mschallenge;

import android.test.AndroidTestCase;

import bj4.yhh.mschallenge.weather.TheDarkSkyForecastParser;

/**
 * Created by yenhsunhuang on 2016/6/9.
 */
public class TheDarkSkyForecastParserTest extends AndroidTestCase {
    private static final String WEB_RETURN_RAW_DATA = "{\"latitude\":25.027015,\"longitude\":121.479315,\"timezone\":\"Asia/Taipei\",\"offset\":8,\"currently\":{\"time\":1465228800,\"summary\":\"Clear\",\"icon\":\"clear-night\",\"precipIntensity\":0.007,\"precipProbability\":0.32,\"precipType\":\"rain\",\"temperature\":78,\"apparentTemperature\":78,\"dewPoint\":72.02,\"humidity\":0.82,\"windSpeed\":0.68,\"windBearing\":137,\"visibility\":6.21,\"cloudCover\":0.21,\"pressure\":1009.78,\"ozone\":290.43},\"hourly\":{\"summary\":\"Light rain overnight and in the afternoon.\",\"icon\":\"rain\",\"data\":[{\"time\":1465228800,\"summary\":\"Drizzle\",\"icon\":\"rain\",\"precipIntensity\":0.007,\"precipProbability\":0.32,\"precipType\":\"rain\",\"temperature\":78,\"apparentTemperature\":78,\"dewPoint\":72.02,\"humidity\":0.82,\"windSpeed\":0.68,\"windBearing\":137,\"visibility\":6.21,\"cloudCover\":0.21,\"pressure\":1009.78,\"ozone\":290.43},{\"time\":1465232400,\"summary\":\"Drizzle\",\"icon\":\"rain\",\"precipIntensity\":0.0062,\"precipProbability\":0.27,\"precipType\":\"rain\",\"temperature\":77.7,\"apparentTemperature\":77.7,\"dewPoint\":71.79,\"humidity\":0.82,\"windSpeed\":0.57,\"windBearing\":127,\"visibility\":4.97,\"cloudCover\":0.21,\"pressure\":1009.59,\"ozone\":290.97},{\"time\":1465236000,\"summary\":\"Drizzle\",\"icon\":\"rain\",\"precipIntensity\":0.0054,\"precipProbability\":0.22,\"precipType\":\"rain\",\"temperature\":77.4,\"apparentTemperature\":77.4,\"dewPoint\":71.56,\"humidity\":0.82,\"windSpeed\":0.48,\"windBearing\":112,\"visibility\":4.35,\"cloudCover\":0.21,\"pressure\":1009.39,\"ozone\":291.5},{\"time\":1465239600,\"summary\":\"Clear\",\"icon\":\"clear-night\",\"precipIntensity\":0.0047,\"precipProbability\":0.18,\"precipType\":\"rain\",\"temperature\":77.28,\"apparentTemperature\":77.28,\"dewPoint\":71.65,\"humidity\":0.83,\"windSpeed\":0.17,\"windBearing\":277,\"visibility\":4.97,\"cloudCover\":0.21,\"pressure\":1009.22,\"ozone\":291.21},{\"time\":1465243200,\"summary\":\"Partly Cloudy\",\"icon\":\"partly-cloudy-night\",\"precipIntensity\":0.004,\"precipProbability\":0.14,\"precipType\":\"rain\",\"temperature\":77.28,\"apparentTemperature\":77.28,\"dewPoint\":71.87,\"humidity\":0.83,\"windSpeed\":1.04,\"windBearing\":283,\"visibility\":4.97,\"cloudCover\":0.26,\"pressure\":1009.07,\"ozone\":290.57},{\"time\":1465246800,\"summary\":\"Partly Cloudy\",\"icon\":\"partly-cloudy-night\",\"precipIntensity\":0.0033,\"precipProbability\":0.11,\"precipType\":\"rain\",\"temperature\":77.66,\"apparentTemperature\":77.66,\"dewPoint\":72.01,\"humidity\":0.83,\"windSpeed\":1.78,\"windBearing\":285,\"visibility\":6.21,\"cloudCover\":0.27,\"pressure\":1009.11,\"ozone\":289.9},{\"time\":1465250400,\"summary\":\"Partly Cloudy\",\"icon\":\"partly-cloudy-day\",\"precipIntensity\":0.0027,\"precipProbability\":0.08,\"precipType\":\"rain\",\"temperature\":78.57,\"apparentTemperature\":78.57,\"dewPoint\":71.89,\"humidity\":0.8,\"windSpeed\":2.21,\"windBearing\":286,\"visibility\":3.11,\"cloudCover\":0.27,\"pressure\":1009.42,\"ozone\":289.19},{\"time\":1465254000,\"summary\":\"Clear\",\"icon\":\"clear-day\",\"precipIntensity\":0.0021,\"precipProbability\":0.05,\"precipType\":\"rain\",\"temperature\":79.84,\"apparentTemperature\":79.84,\"dewPoint\":71.61,\"humidity\":0.76,\"windSpeed\":2.49,\"windBearing\":287,\"visibility\":6.21,\"cloudCover\":0.24,\"pressure\":1009.84,\"ozone\":288.46},{\"time\":1465257600,\"summary\":\"Drizzle\",\"icon\":\"rain\",\"precipIntensity\":0.0069,\"precipProbability\":0.31,\"precipType\":\"rain\",\"temperature\":81.14,\"apparentTemperature\":85.3,\"dewPoint\":71.39,\"humidity\":0.72,\"windSpeed\":2.77,\"windBearing\":294,\"visibility\":6.21,\"cloudCover\":0.19,\"pressure\":1010.1,\"ozone\":288.06},{\"time\":1465261200,\"summary\":\"Clear\",\"icon\":\"clear-day\",\"precipIntensity\":0.0017,\"precipProbability\":0.04,\"precipType\":\"rain\",\"temperature\":82.58,\"apparentTemperature\":87.34,\"dewPoint\":71.42,\"humidity\":0.69,\"windSpeed\":3.3,\"windBearing\":306,\"visibility\":6.21,\"cloudCover\":0.23,\"pressure\":1010.02,\"ozone\":288.09},{\"time\":1465264800,\"summary\":\"Clear\",\"icon\":\"clear-day\",\"precipIntensity\":0.0017,\"precipProbability\":0.04,\"precipType\":\"rain\",\"temperature\":84.08,\"apparentTemperature\":89.42,\"dewPoint\":71.52,\"humidity\":0.66,\"windSpeed\":4.06,\"windBearing\":318,\"visibility\":6.21,\"cloudCover\":0.23,\"pressure\":1009.77,\"ozone\":288.45},{\"time\":1465268400,\"summary\":\"Clear\",\"icon\":\"clear-day\",\"precipIntensity\":0.0019,\"precipProbability\":0.05,\"precipType\":\"rain\",\"temperature\":85.15,\"apparentTemperature\":90.86,\"dewPoint\":71.58,\"humidity\":0.64,\"windSpeed\":4.63,\"windBearing\":327,\"visibility\":6.21,\"cloudCover\":0.23,\"pressure\":1009.45,\"ozone\":289.21},{\"time\":1465272000,\"summary\":\"Clear\",\"icon\":\"clear-day\",\"precipIntensity\":0.0033,\"precipProbability\":0.11,\"precipType\":\"rain\",\"temperature\":85.53,\"apparentTemperature\":91.38,\"dewPoint\":71.62,\"humidity\":0.63,\"windSpeed\":4.86,\"windBearing\":336,\"visibility\":6.21,\"cloudCover\":0.22,\"pressure\":1009.09,\"ozone\":290.72},{\"time\":1465275600,\"summary\":\"Clear\",\"icon\":\"clear-day\",\"precipIntensity\":0.0048,\"precipProbability\":0.19,\"precipType\":\"rain\",\"temperature\":85.47,\"apparentTemperature\":91.39,\"dewPoint\":71.73,\"humidity\":0.64,\"windSpeed\":4.92,\"windBearing\":347,\"visibility\":6.21,\"cloudCover\":0.22,\"pressure\":1008.73,\"ozone\":292.64},{\"time\":1465279200,\"summary\":\"Drizzle\",\"icon\":\"rain\",\"precipIntensity\":0.0063,\"precipProbability\":0.27,\"precipType\":\"rain\",\"temperature\":85.3,\"apparentTemperature\":91.31,\"dewPoint\":71.92,\"humidity\":0.64,\"windSpeed\":4.75,\"windBearing\":358,\"visibility\":6.21,\"cloudCover\":0.21,\"pressure\":1008.42,\"ozone\":293.93},{\"time\":1465282800,\"summary\":\"Drizzle\",\"icon\":\"rain\",\"precipIntensity\":0.0077,\"precipProbability\":0.36,\"precipType\":\"rain\",\"temperature\":85.17,\"apparentTemperature\":91.41,\"dewPoint\":72.26,\"humidity\":0.65,\"windSpeed\":4.29,\"windBearing\":15,\"visibility\":6.21,\"cloudCover\":0.2,\"pressure\":1008.14,\"ozone\":293.99},{\"time\":1465286400,\"summary\":\"Drizzle\",\"icon\":\"rain\",\"precipIntensity\":0.0091,\"precipProbability\":0.45,\"precipType\":\"rain\",\"temperature\":84.94,\"apparentTemperature\":91.4,\"dewPoint\":72.65,\"humidity\":0.67,\"windSpeed\":4.06,\"windBearing\":39,\"visibility\":6.21,\"cloudCover\":0.2,\"pressure\":1007.9,\"ozone\":293.44},{\"time\":1465290000,\"summary\":\"Light Rain\",\"icon\":\"rain\",\"precipIntensity\":0.01,\"precipProbability\":0.46,\"precipType\":\"rain\",\"temperature\":84.43,\"apparentTemperature\":90.92,\"dewPoint\":72.92,\"humidity\":0.69,\"windSpeed\":4.17,\"windBearing\":58,\"visibility\":6.21,\"cloudCover\":0.19,\"pressure\":1007.84,\"ozone\":293},{\"time\":1465293600,\"summary\":\"Light Rain\",\"icon\":\"rain\",\"precipIntensity\":0.0102,\"precipProbability\":0.47,\"precipType\":\"rain\",\"temperature\":83.42,\"apparentTemperature\":89.45,\"dewPoint\":72.88,\"humidity\":0.71,\"windSpeed\":3.96,\"windBearing\":66,\"visibility\":6.21,\"cloudCover\":0.19,\"pressure\":1008.06,\"ozone\":292.97},{\"time\":1465297200,\"summary\":\"Light Rain\",\"icon\":\"rain\",\"precipIntensity\":0.0097,\"precipProbability\":0.46,\"precipType\":\"rain\",\"temperature\":82.16,\"apparentTemperature\":87.45,\"dewPoint\":72.65,\"humidity\":0.73,\"windSpeed\":3.39,\"windBearing\":71,\"visibility\":6.21,\"cloudCover\":0.19,\"pressure\":1008.46,\"ozone\":293.06},{\"time\":1465300800,\"summary\":\"Light Rain\",\"icon\":\"rain\",\"precipIntensity\":0.0092,\"precipProbability\":0.45,\"precipType\":\"rain\",\"temperature\":81.25,\"apparentTemperature\":85.98,\"dewPoint\":72.5,\"humidity\":0.75,\"windSpeed\":2.9,\"windBearing\":79,\"visibility\":6.21,\"cloudCover\":0.19,\"pressure\":1008.76,\"ozone\":293.14},{\"time\":1465304400,\"summary\":\"Drizzle\",\"icon\":\"rain\",\"precipIntensity\":0.0088,\"precipProbability\":0.43,\"precipType\":\"rain\",\"temperature\":81.02,\"apparentTemperature\":85.67,\"dewPoint\":72.61,\"humidity\":0.76,\"windSpeed\":2.75,\"windBearing\":93,\"visibility\":6.21,\"cloudCover\":0.18,\"pressure\":1008.85,\"ozone\":293.12},{\"time\":1465308000,\"summary\":\"Drizzle\",\"icon\":\"rain\",\"precipIntensity\":0.0086,\"precipProbability\":0.42,\"precipType\":\"rain\",\"temperature\":81.12,\"apparentTemperature\":85.95,\"dewPoint\":72.85,\"humidity\":0.76,\"windSpeed\":2.89,\"windBearing\":108,\"visibility\":6.21,\"cloudCover\":0.18,\"pressure\":1008.84,\"ozone\":293.08},{\"time\":1465311600,\"summary\":\"Drizzle\",\"icon\":\"rain\",\"precipIntensity\":0.0081,\"precipProbability\":0.38,\"precipType\":\"rain\",\"temperature\":81.15,\"apparentTemperature\":86.06,\"dewPoint\":73,\"humidity\":0.76,\"windSpeed\":3.01,\"windBearing\":118,\"visibility\":6.21,\"cloudCover\":0.18,\"pressure\":1008.72,\"ozone\":293.11}]},\"daily\":{\"data\":[{\"time\":1465228800,\"summary\":\"Light rain starting in the afternoon.\",\"icon\":\"rain\",\"sunriseTime\":1465247107,\"sunsetTime\":1465296218,\"moonPhase\":0.08,\"precipIntensity\":0.006,\"precipIntensityMax\":0.0102,\"precipIntensityMaxTime\":1465293600,\"precipProbability\":0.47,\"precipType\":\"rain\",\"temperatureMin\":77.28,\"temperatureMinTime\":1465239600,\"temperatureMax\":85.53,\"temperatureMaxTime\":1465272000,\"apparentTemperatureMin\":77.28,\"apparentTemperatureMinTime\":1465239600,\"apparentTemperatureMax\":91.38,\"apparentTemperatureMaxTime\":1465272000,\"dewPoint\":72.08,\"humidity\":0.73,\"windSpeed\":1.49,\"windBearing\":9,\"visibility\":5.85,\"cloudCover\":0.21,\"pressure\":1009.02,\"ozone\":291.34}]},\"flags\":{\"sources\":[\"gfs\",\"cmc\",\"fnmoc\",\"isd\",\"madis\"],\"isd-stations\":[\"466860-99999\",\"466960-99999\",\"589680-99999\",\"589740-99999\",\"591580-99999\"],\"madis-stations\":[\"RCSS\",\"RCTP\"],\"units\":\"us\"}}";

    public void testParser() {
        TheDarkSkyForecastParser parser = new TheDarkSkyForecastParser(WEB_RETURN_RAW_DATA);

        assertEquals("25.027015", parser.getLatitude());
        assertEquals("121.479315", parser.getLongitude());
        assertEquals("Asia/Taipei", parser.getTimeZone());
        assertEquals("8", parser.getOffset());

        // test currently data
        assertEquals("Clear", parser.getCurrentlyData().getSummary());
        assertEquals("clear-night", parser.getCurrentlyData().getIcon());
        assertEquals(1465228800, parser.getCurrentlyData().getTime());

        // test daily data
        assertEquals("rain", parser.getDailyData().getWeatherData().getIcon());
        assertEquals("Light rain starting in the afternoon.", parser.getDailyData().getWeatherData().getSummary());
        assertEquals(1465228800, parser.getDailyData().getWeatherData().getTime());

        // test hourly data
        assertEquals(24, parser.getHourlyData().getData().size());

        // test 7:00, 12:00, 19:00 respectively
        assertEquals(1465254000, parser.getHourlyData().getData().get(7).getTime());
        assertEquals("Clear", parser.getHourlyData().getData().get(7).getSummary());
        assertEquals("clear-day", parser.getHourlyData().getData().get(7).getIcon());

        assertEquals(1465272000, parser.getHourlyData().getData().get(12).getTime());
        assertEquals("Clear", parser.getHourlyData().getData().get(12).getSummary());
        assertEquals("clear-day", parser.getHourlyData().getData().get(12).getIcon());

        assertEquals(1465297200, parser.getHourlyData().getData().get(19).getTime());
        assertEquals("Light Rain", parser.getHourlyData().getData().get(19).getSummary());
        assertEquals("rain", parser.getHourlyData().getData().get(19).getIcon());
    }
}
