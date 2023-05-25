create table course
(
    id bigint not null,
    name varchar(255) not null,
    author varchar(255) not null,
    primary key (id)

);
create table todo
(
    id bigint not null,
    username varchar(255) not null,
    description varchar(255) not null,
    targetDate date not null,
    done boolean,
    primary key (id)
)