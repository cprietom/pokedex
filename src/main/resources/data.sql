insert into POKEMON (id, name, favorite) values(1, 'Bilbo', false);
insert into POKEMON (id, name, favorite) values(2, 'Sam', false);
insert into POKEMON (id, name, favorite) values(3, 'Frodo', false);

insert into POKEMON_TYPE (ID, pokemon_id, pokemon_type ) values(1, 1, 'WATER');
insert into POKEMON_TYPE (ID, pokemon_id, pokemon_type ) values(2, 1, 'FIRE');
insert into POKEMON_TYPE (ID, pokemon_id, pokemon_type ) values(3, 2, 'POISON');
insert into POKEMON_TYPE (ID, pokemon_id, pokemon_type ) values(4, 3, 'WATER');

commit;