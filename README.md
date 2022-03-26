# Redis-Cache
A spring-boot project that demonstrates data caching using Redis

**Setup**
- Install Redis server. Download from https://redis.io/docs/getting-started/installation/
- Ensure you have Maven setup locally
- Use an IDE that supports Kotlin

**SAMPLE PAYLOADS**

1. **Create User**

**Url** = http://localhost:8080/user

**Method** = POST
```
{
    "name": "Sakawa Bob",
    "followers": 4500000
}
```

2. **Edit User**

**Url** = http://localhost:8080/user

**Method** = PUT
```
{
    "id": 4,
    "name": "Sakawa Bobby",
    "followers": 4500000
}
```

3. **Find User**

**Url** = http://localhost:8080/user/4

**Method** = GET

4. **List All Users**

**Url** = http://localhost:8080/user

**Method** = GET

5. **Delete User**

**Url** = http://localhost:8080/user/4

**Method** = DELETE
