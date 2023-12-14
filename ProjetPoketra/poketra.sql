create database poketra ; 

\c poketra ;



create table type(
    id serial PRIMARY KEY,
    type varchar(50)
);

create table look(
    id serial PRIMARY KEY,
    look varchar(50)
);

create table matiere(
    id serial PRIMARY KEY,
    matiere  varchar(50)
);


create table Matiere_produit(
    id serial PRIMARY KEY,
    look INT REFERENCES look(id),
    matiere INT REFERENCES matiere(id),
    taille varchar(50),
    quantite decimal
);


INSERT INTO type (type)
VALUES
  ('sac a dos'),
  ('portf'),
  ('sac a main');

INSERT INTO matiere (matiere)
VALUES
     ('cuivre'),
     ('soga'),
     ('rofia');

INSERT INTO look (look)
VALUES 
    ('luxe'),
    ('normal'),
    ('debrayer');


INSERT INTO Matiere_produit (look,matiere,taille,quantite)
VALUES
  (1,1,'grand',3),
  (1,1,'medium',2),
  (1,1,'petit',1),
  (2,2,'medium',2),
  (2,2,'petit',1),
  (3,3,'medium',1);

create view v_mp as
  select distinct( l.look,m.matiere)
from Matiere_produit mp
LEFT join look l  on mp.look = l.id
LEFT join matiere m  on mp.matiere = m.id;


drop view v_mp;
select  distinct (look) from v_mp;