package utility;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestDataHelper {

    private final static Faker FAKER = Faker.instance();

    public static String getFutureDate(int plusDays, DateTimeFormatter dateTimeFormatter)
    {
        return LocalDate.now()
                .plusDays(plusDays)
                .format(dateTimeFormatter);
    }

    public static Faker getFaker()
    {
        return FAKER;
    }

    public static int getRandomInt(int numberofDigits)
    {
        return Math.toIntExact(FAKER.number().randomNumber(numberofDigits,true));
    }
}
