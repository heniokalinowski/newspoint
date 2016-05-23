package net.elenx

import spock.lang.Specification

import java.text.ParseException

class UserAdapterTest extends Specification
{
    def "correctly parses valid data"()
    {
        given:
        UserAdapter userAdapter = new UserAdapter()
        String source = "Jan, Kowalski, 23.09.1968"

        when:
        UserEntity userEntity = userAdapter.adapt source

        then:
        userEntity.name.equals "Kowalski"
    }

    def "raises exception on nonconforming data"()
    {
        given:
        UserAdapter userAdapter = new UserAdapter()
        String source = "Jan, Kowalski, 23-09-1968"

        when:
        userAdapter.adapt source

        then:
        thrown ParseException
    }
}
