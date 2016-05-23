package net.elenx;

import java.util.List;

class UserResource
{
    private final List<UserEntity> userEntities;

    UserResource(List<UserEntity> userEntities)
    {
        userEntities.sort
        (
            (user1, user2) -> Integer.compare(user2.getYearOld(), user1.getYearOld())
        );

        this.userEntities = userEntities;
    }

    String describe()
    {
        StringBuilder stringBuilder = new StringBuilder();

        userEntities.forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

    int size()
    {
        return userEntities.size();
    }

    UserEntity oldestWithPhone()
    {
        return userEntities
            .stream()
            .filter(UserEntity::hasPhone)
            .findFirst()
            .get();
    }
}
