package net.elenx;

import lombok.SneakyThrows;

import java.io.FileInputStream;

class FileLoader
{
    @SneakyThrows
    FileInputStream read(String fileName)
    {
        String file = getClass().getClassLoader().getResource(fileName).getFile();

        return new FileInputStream(file);
    }
}
