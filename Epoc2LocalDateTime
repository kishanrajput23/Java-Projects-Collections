package org.java.sample.dateNtime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Epoch time is the number of seconds that have elapsed since 0:00:00 UTC on 1 January 1970
 * This code converts epoc time to Local Date, Local DateTime and also demonstrates
 * converting it to a zoned time
 * @author rajeshp
 * @Date 10/18/22
 */
public class Epoc2LocalDateTime {
    public static void main(String[] args) {

        long epoch = Instant.now().toEpochMilli();
        System.out.println("Epoch: " +epoch);

        LocalDate ld = Instant.ofEpochMilli(epoch)
                .atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("Local Date: "+ ld);

        LocalDateTime ldt = Instant.ofEpochMilli(epoch)
                .atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("Local Date & Time "+ ldt);

        LocalDateTime zldt = Instant.ofEpochMilli(epoch)
                .atZone(ZoneId.of("Asia/Kolkata")).toLocalDateTime();
        System.out.println("Asia/Kolkata Zone Local Date: "+ zldt);
    }
}
