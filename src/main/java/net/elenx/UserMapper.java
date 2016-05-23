package net.elenx;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class UserMapper
{
    private static final String NEW_LINE = "\n";

    List<UserEntity> map(InputStream inputStream)
    {
        List<UserEntity> userEntities = new LinkedList<>();
        UserAdapter userAdapter = new UserAdapter();

        try(Scanner scanner = new Scanner(inputStream))
        {
            scanner.useDelimiter(NEW_LINE);

            while(scanner.hasNext())
            {
                UserEntity userEntity = userAdapter.adapt(scanner.next());
                userEntities.add(userEntity);
            }
        }

        return userEntities;
    }
}
