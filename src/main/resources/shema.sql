CREATE TABLE IF NOT EXISTS place (
    id bigint AUTO_INCREMENT primary key,
    name varchar(250) not null,
    slug varchar(250) not null,
    state varchar(250) not null,
    created_at timestamp not null,
    updated_at timestamp not null
);