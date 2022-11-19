create table user (
    id bigint not null auto_increment primary key,
    user_id varchar(255) not null unique,
    password varchar(255) not null,
    salt varchar(255) not null
);

create table hero_class (
    id bigint not null auto_increment primary key,
    name varchar(255) not null,
    mnd int,
    str int,
    dex int,
    vit int
);

create table heroes (
    id bigint not null auto_increment primary key,
    name varchar(255) not null,
    level int not null,
    mnd int,
    str int,
    dex int,
    vit int,
    owner_id bigint not null,
    hero_class_id bigint not null,
    constraint `fk_owner` foreign key (owner_id) references user(id),
    constraint `fk_hero_class` foreign key (hero_class_id) references hero_class(id)
);

create table hero_detail (
    id bigint not null auto_increment primary key
);

create table hero_spell (
    id bigint not null auto_increment primary key
);

create table spell_type (
    id bigint not null auto_increment primary key
);

create table user_hero (
    id bigint not null auto_increment primary key,
    user_id bigint not null,
    hero_id bigint not null,
    constraint `fk_user` foreign key (user_id) references user(id),
    constraint `fk_hero` foreign key (hero_id) references heroes(id)
);

insert into user (user_id, password, salt)
values ('test', '$2a$10$t5E0Y56ITsUGWjHKVIgcFOS0AiLCW6upUkSOp/DtXq4gLHf/X/NAO', '$2a$10$t5E0Y56ITsUGWjHKVIgcFO');

insert into hero_class (name, mnd, str, dex, vit)
values ('Warrior', 5, 10, 5, 5);

insert into hero_class (name, mnd, str, dex, vit)
value ('Mage', 10, 5, 5, 5);

insert into hero_class (name, mnd, str, dex, vit)
values ('Rogue', 5, 5, 10, 5);

insert into hero_class (name, mnd, str, dex, vit)
values ('Paladin', 5, 5, 5, 10);