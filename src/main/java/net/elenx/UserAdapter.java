package net.elenx;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Calendar;

class UserAdapter
{
    private static final String DELIMITER = ", ";
    private static final String DATE_PATTERN = "dd.MM.YYYY";

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
    private final int activeYear = Calendar.getInstance().get(Calendar.YEAR);

    UserEntity adapt(String line)
    {
        String[] split = line.split(DELIMITER);

        switch(split.length)
        {
            case 3: return new UserEntity(split[0], split[1], years(split[2]));
            case 4: return new UserEntity(split[0], split[1], years(split[2]), split[3]);
            default: throw new RuntimeException(String.valueOf(split.length));
        }
    }

    @SneakyThrows
    private int years(String birthday)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(simpleDateFormat.parse(birthday));

        return activeYear - calendar.get(Calendar.YEAR);
    }
}