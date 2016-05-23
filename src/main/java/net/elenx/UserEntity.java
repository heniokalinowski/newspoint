package net.elenx;

import lombok.Data;

import java.util.Optional;

@Data
class UserEntity
{
    private static final String NO_PHONE_NUMBER = null;
    private static final String LONG_PATTERN = "%s, %s, %s, %s\n";
    private static final String SHORT_PATTERN = "%s, %s, %s\n";

    private final String surname;
    private final String name;
    private final int yearOld;
    private final Optional<String> optionalPhoneNumber;

    UserEntity(String surname, String name, int yearOld)
    {
        this(surname, name, yearOld, NO_PHONE_NUMBER);
    }

    UserEntity(String surname, String name, int yearOld, String phoneNumber)
    {
        this.surname = surname;
        this.name = name;
        this.yearOld = yearOld;
        this.optionalPhoneNumber = Optional.ofNullable(phoneNumber);
    }

    boolean hasPhone()
    {
        return optionalPhoneNumber.isPresent();
    }

    String toStringWithoutAge()
    {
        return String.format(SHORT_PATTERN, surname, name, optionalPhoneNumber.get());
    }

    @Override
    public String toString()
    {
        if(optionalPhoneNumber.isPresent())
        {
            return String.format(LONG_PATTERN, name, surname, yearOld, optionalPhoneNumber.get());
        }
        else
        {
            return String.format(SHORT_PATTERN, name, surname, yearOld);
        }
    }
}
