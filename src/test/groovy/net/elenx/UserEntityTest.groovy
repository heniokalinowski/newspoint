package net.elenx

import spock.lang.Specification

class UserEntityTest extends Specification
{
    def "detects phone"()
    {
        given:
        UserEntity userEntity = new UserEntity("Kowalski", "Jan", 49, "123-456-789")

        when:
        boolean hasPhone = userEntity.hasPhone()

        then:
        hasPhone
    }

    def "detects missing phone"()
    {
        given:
        UserEntity userEntity = new UserEntity("Kowalski", "Jan", 49)

        when:
        boolean hasPhone = userEntity.hasPhone()

        then:
        !hasPhone
    }

    def "phone appears in description"()
    {
        given:
        UserEntity withoutPhone = new UserEntity("Kowalski", "Jan", 49)
        UserEntity withPhone = new UserEntity("Kowalski", "Jan", 49, "123-456-789")

        when:
        String withPhoneDescription = withPhone.toString()
        String withoutPhoneDescription = withoutPhone.toString()

        then:
        withPhoneDescription.length() > withoutPhoneDescription.length()
    }
}
