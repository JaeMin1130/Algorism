select count(*)
    from (select distinct name from animal_ins where name is not null);
    