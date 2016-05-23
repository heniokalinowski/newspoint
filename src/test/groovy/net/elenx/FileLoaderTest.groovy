package net.elenx

import spock.lang.Specification

class FileLoaderTest extends Specification
{
    def "should read valid file"()
    {
        given:
        FileLoader fileLoader = new FileLoader()

        when:
        fileLoader.read "data.txt"

        then:
        1 == 1
    }

    def "should not read invalid file"()
    {
        given:
        FileLoader fileLoader = new FileLoader()

        when:
        fileLoader.read "non_existing_file.txt"

        then:
        thrown RuntimeException
    }
}
