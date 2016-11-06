package edu.calvin.cs262.lab06;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Weather forecast object (POJO), one per day, based on openweathermap's RESTful API.
 * Based on Deitel's WeatherViewer app (chapter 17).
 *
 * @author deitel
 * @author kvlinden
 * @version spring, 2017
 *
 * What does the application do for invalid cities?
 *  For invalid cities, the application toasts the connection_error string:
 *      "Failed to connect to service..."
 *
 * What is the API key? What does it do?
 *  The API key is the string openweather_api_key (8301442678d36413b4e3a04d016deee7)
 *  It accesses the open Application Programming Interface provided by openweather.
 *
 * What does the full JSON response look like?
 *
 *
 *
 * What does the system do with the JSON data?
 * What is the Weather class designed to do?
 *
 *
 */
public class Weather {

    private String day, summary, min, max;

    public Weather(long dt, String summary, String min, String max) {
        this.day = convertTimeStampToDay(dt);
        this.summary = summary;
        this.min = min;
        this.max = max;
    }

    public String getDay() {
        return day;
    }
    public String getSummary() {
        return summary;
    }

    public String getMin() { return min; }
    public String getMax() { return max; }

    private static String convertTimeStampToDay(long dt) {
        // Convert from datetime in milliseconds to calendar.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dt * 1000);

        // Adjust time for device's time zone.
        TimeZone tz = TimeZone.getDefault();
        calendar.add(Calendar.MILLISECOND, tz.getOffset(calendar.getTimeInMillis()));

        // Format/return the day's name.
        return new SimpleDateFormat("EEEE").format(calendar.getTime());
    }
}
