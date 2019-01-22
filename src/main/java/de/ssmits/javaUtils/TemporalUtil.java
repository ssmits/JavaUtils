package de.ssmits.javaUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Utility Class with helper methods for temporal related operations.
 *  
 * @author ssmits
 */
public class TemporalUtil {
    private TemporalUtil() {

    }

    /**
     * Converts the specified UTC {@link LocalDateTime} instance into the specified destination time zone.
     * 
     * @param utcDateTime LocalDateTime instance in UTC
     * @param destinationTimeZone Time zone to convert to
     * 
     * @return LocalDateTime instance of the specified time zone
     * 
     * @see java.time.LocalDateTime
     * @see java.time.ZoneId
     */
    public static final LocalDateTime convertUtcToDestinationTimeZone(LocalDateTime utcDateTime, ZoneId destinationTimeZone) {
        return ZonedDateTime
        	.of(utcDateTime, ZoneId.of("UTC+00:00"))
        	.withZoneSameInstant(destinationTimeZone)
        	.toLocalDateTime();
    }

    /**
     * Maps {@link Date} to {@link LocalDate}
     * 
     * @param date Date instance
     * 
     * @return Converted LocalDate instance
     * 
     * @see java.util.Date
     * @see java.time.LocalDate
     */
    public static final LocalDate map(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DATE));
    }
}
