-- select count(*) as "count"
--     from (select distinct name 
--             from animal_ins 
--             where name is not null
--          );

select count(distinct(name)) as "count"
    from animal_ins
    where name is not null;