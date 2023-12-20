CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company (id, name)
values (1, 'VCR'), (2, 'CRP'), (3, 'BPB'), (4, 'PPL'), (5, 'BRP'), (6, 'BP');

insert into person (id, name, company_id)
values (1, 'Oly', 1), (2, 'Vasy', 1), (3, 'Zoya', 1),
(4, 'Roma', 2), (5, 'Goscha', 2), (6, 'Sveta', 2), (7, 'Irina', 3), (8, 'Oleg', 3), (9, 'Wera', 3), (10, 'Mark', 3),
(11, 'Tema', 4), (12, 'Lena', 4), (13, 'Rik', 4), (14, 'Semen', 4), (15, 'Dascha', 5),
(16, 'Klim', 5), (17, 'Lilya',5 ), (18, 'Nik', 6), (19, 'Dima', 6), (20, 'Oleg', 6),
(21, 'Oly', 6);

select p.name person,  c.name company
from person p
join company on company.id = person.company_id
where person.company_id != 5;

select company.name company, count(person.company_id) as counter
from company
join person
on person.company_id = company.id
group by company.name
having count(person.company_id) =
(select max(mcount)
 from (select count(person.company_id) as mcount
	  from person
	  group by company_id) as maximum);