insert into user_role (id, name) values (1,'ROLE_USER');
insert into user_role (id, name) values (2,'ROLE_ADMIN');
insert into user_role (id, name) values (3,'ROLE_SUPER_ADMIN');
insert into user_role (id, name) values (4,'ROLE_DEVELOPER');

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

insert into event_conversation_participant (name) values ('HERO');
insert into event_conversation_participant (name) values ('NPC');
insert into event_conversation_participant (name) values ('NARRATOR');

insert into resistance_type (id, name) values (1, 'ALL');
insert into resistance_type (id, name) values (2, 'MAGIC');
insert into resistance_type (id, name) values (3, 'PHYSICAL');
insert into resistance_type (id, name) values (4, 'IGNORE');

insert into spell_type (name, resistance_type_id) values ('PHYSICAL', 3);
insert into spell_type (name, resistance_type_id) values ('FIRE', 2);
insert into spell_type (name, resistance_type_id) values ('ICE', 2);
insert into spell_type (name, resistance_type_id) values ('LIGHTNING', 2);
insert into spell_type (name, resistance_type_id) values ('POISON', 2);
insert into spell_type (name, resistance_type_id) values ('DARK', 2);
insert into spell_type (name, resistance_type_id) values ('HEAL', 4);
insert into spell_type (name, resistance_type_id) values ('BUFF', 4);
insert into spell_type (name, resistance_type_id) values ('DEBUFF', 4);

