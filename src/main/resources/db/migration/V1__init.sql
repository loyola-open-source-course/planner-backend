create table user
(
    id        bigint auto_increment primary key,
    full_name varchar(255) not null,
    password  varchar(255) not null,
    username  varchar(255) not null
) engine = InnoDB;

create table task
(
    id          bigint auto_increment primary key,
    created_at  datetime     not null,
    description varchar(255) not null,
    task_status varchar(255) not null,
    author_id   bigint       not null
) engine = InnoDB;

create index fk_task_author_id on task (author_id);

create table tasks_column
(
    id       bigint auto_increment primary key,
    task_ids varchar(255) null,
    title    varchar(255) not null
) engine = InnoDB;


-- insert default values

insert into tasks_column (title)
values ('To Do'),
       ('In progress'),
       ('Done');
