create table if not exists city (
    id       uuid default uuid_generate_v4() not null primary key,
    name     varchar(64) not null,
    state    varchar(64),
    country  varchar(64),
    ins_time timestamp with time zone default CURRENT_TIMESTAMP  not null
);
