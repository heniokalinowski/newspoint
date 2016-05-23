package net.elenx

import org.apache.commons.lang3.StringUtils
import spock.lang.Specification

class UserMapperTest extends Specification
{
    def "correctly maps valid data"()
    {
        given:
        UserMapper userMapper = new UserMapper()
        String source = "Jan, Kowalski, 23.09.1968\nAdam, Borowy, 12.01.1988, 321-654-987"
        InputStream inputStream = new ByteArrayInputStream(source.getBytes())

        when:
        List<UserEntity> userEntities = userMapper.map inputStream

        then:
        userEntities.size() == 2
    }

    def "correctly handles empty data"()
    {
        given:
        UserMapper userMapper = new UserMapper()
        String source = StringUtils.EMPTY
        InputStream inputStream = new ByteArrayInputStream(source.getBytes())

        when:
        List<UserEntity> userEntities = userMapper.map inputStream

        then:
        userEntities.size() == 0
    }
}
