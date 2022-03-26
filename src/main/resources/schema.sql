CREATE TABLE IF NOT EXISTS user
(
    id                      integer  not null primary key,
    name                    varchar(255) not null,
    followers               integer not null,
    constraint user_pkey unique (id)
);