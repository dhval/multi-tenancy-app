## Micronaut 3.9.0-SNAPSHOT

- [User Guide](https://docs.micronaut.io/3.8.1/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.8.1/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.8.1/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Micronaut Multi Tenancy 

Demo the error 

#### Works fine

```
GET http://mini.local:8080/hello/1
co: default
```

#### Throws  No current transaction present. Consider declaring @Transactional on the surrounding method

```
GET http://mini.local:8080/hello/1
co: secondary
```

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)


## Feature sql-jdbi documentation

- [Micronaut Jdbi documentation](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#jdbi)


