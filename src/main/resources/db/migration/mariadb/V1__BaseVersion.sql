create table user_role(
    id bigint primary key not null auto_increment,
    name varchar(255) not null
);

insert into user_role (id, name) values (1,'ROLE_USER');
insert into user_role (id, name) values (2,'ROLE_ADMIN');
insert into user_role (id, name) values (3,'ROLE_SUPER_ADMIN');
insert into user_role (id, name) values (4,'ROLE_DEVELOPER');

create table user (
    id bigint not null auto_increment primary key,
    user_id varchar(255) not null unique,
    password varchar(255) not null,
    salt varchar(255) not null,
    user_role_id bigint not null,
    foreign key (user_role_id) references user_role(id)
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
    exp int not null,
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

create table spell_type (
    id bigint not null auto_increment primary key,
    name varchar(255) not null
);

create table hero_spell (
    id bigint not null auto_increment primary key,
    name varchar(255) not null,
    spell_type_id bigint not null,
    constraint `fk_spell_type` foreign key (spell_type_id) references spell_type(id)
);



create table user_hero (
    id bigint not null auto_increment primary key,
    user_id bigint not null,
    hero_id bigint not null,
    constraint `fk_user` foreign key (user_id) references user(id),
    constraint `fk_hero` foreign key (hero_id) references heroes(id)
);

create table hero_purse (
    id bigint not null auto_increment primary key,
    hero_id bigint not null unique,
    gold int not null,
    crystal int not null,
    heaven_coin int not null,
    constraint `fk_user_purse` foreign key (hero_id) references user(id)
);

create table event_base (
    id bigint not null auto_increment primary key,
    name varchar(255) not null,
    description varchar(255) not null,
    required_level int not null
);

create table event_conversation_participant(
    id bigint not null auto_increment primary key,
    name varchar(255) not null
);

insert into event_conversation_participant (name) values ('HERO');
insert into event_conversation_participant (name) values ('NPC');
insert into event_conversation_participant (name) values ('NARRATOR');

create table event_conversation (
  id bigint not null auto_increment primary key,
  event_base_id bigint not null,
  hero_id bigint not null,
  text varchar(255) not null,
  sayer_id bigint not null,
  partner_name varchar(255) not null,
constraint `fk_event_base` foreign key (event_base_id) references event_base(id),
constraint `fk_hero_evc` foreign key (hero_id) references heroes(id),
constraint `fk_sayer` foreign key (sayer_id) references event_conversation_participant(id)
);

create table event_fight (
    id bigint not null auto_increment primary key,
    event_base_id bigint not null,
    constraint `fk_event_base_f` foreign key (event_base_id) references event_base(id)
);

create table enemy_base (
    id bigint not null auto_increment primary key,
    name varchar(255) not null,
    attack int not null,
    defense int not null,
    health int not null
);

create table event_fight_enemies (
    id bigint not null auto_increment primary key,
    event_fight_id bigint not null,
    enemy_base_id bigint not null,
    constraint `fk_event_fight_e` foreign key (event_fight_id) references event_fight(id),
    constraint `fk_enemy_base_e` foreign key (enemy_base_id) references enemy_base(id)
);

insert into user (user_id, password, salt, user_role_id)
values ('test', '$2a$10$t5E0Y56ITsUGWjHKVIgcFOS0AiLCW6upUkSOp/DtXq4gLHf/X/NAO', '$2a$10$t5E0Y56ITsUGWjHKVIgcFO', 3);

insert into hero_class (name, mnd, str, dex, vit)
values ('Warrior', 5, 10, 5, 5);

insert into hero_class (name, mnd, str, dex, vit)
value ('Mage', 10, 5, 5, 5);

insert into hero_class (name, mnd, str, dex, vit)
values ('Rogue', 5, 5, 10, 5);

insert into hero_class (name, mnd, str, dex, vit)
values ('Paladin', 5, 5, 5, 10);