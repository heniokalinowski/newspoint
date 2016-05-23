package net.elenx;

import java.io.FileInputStream;
import java.util.List;

class Main
{
    private static final String SOURCE_FILE_NAME = "net/elenx/data.txt";

    public static void main(String[] args)
    {
        FileInputStream fileInputStream = new FileLoader().read(SOURCE_FILE_NAME);
        UserMapper userMapper = new UserMapper();
        List<UserEntity> userEntities = userMapper.map(fileInputStream);

        UserResource userResource = new UserResource(userEntities);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
            .append(userResource.describe())
            .append(userResource.size())
            .append("\n")
            .append(userResource.oldestWithPhone().toStringWithoutAge());

        System.out.println(stringBuilder.toString());
    }
}
