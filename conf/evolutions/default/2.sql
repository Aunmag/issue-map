# --- !Ups

insert into issue (title, description, lat, lon, status, created) values
('Светофор', 'Неделю не работает светофор', 55.437724, 65.328618, 3, '2019-01-01'),
('Разрыли яму', 'Перекрыта дорога, ремонтируют дорогу', 55.438868, 65.331064, 4, '2019-01-01'),
('Порыв трубы', 'Сильный фонтан горячей воды', 55.460166, 65.372485, 1, '2019-01-01'),
('Ремонт дороги', 'Ремонтируют канализацию', 55.442269, 65.365050, 4, '2019-01-01'),
('Ремонт дороги', 'Ремонтируют дорогу', 55.462502, 65.366854, 5, '2019-01-01'),
('Нет люка канализации', 'Украли люк канализации на проезжей части', 55.418283, 65.245371, 3, '2019-01-01'),
('Перевернута остановка', 'Ветром перевернуло остановку', 55.418456, 65.375036, 2, '2019-01-01'),
('Мешки с мусором', 'Кто то выкинул мусор на обочину', 55.458890, 65.410063, 1, '2019-01-01'),
('Светофор', 'Неделю не работает светофор', 55.459157, 65.335093, 3, '2019-01-01');

insert into authority (name) values
('Тест 1'),
('Тест 2'),
('Тест 3');

insert into issue_category (name, icon, color) values
('Тест 1', 'plus', '#ff0000'),
('Тест 2', 'plus', '#ff0000'),
('Тест 3', 'plus', '#ff0000');

insert into issue_issue_category (issue_id, issue_category_id) values
(1, 1),
(1, 2),
(2, 1);

insert into issue_authority (issue_id, authority_id) values
(1, 1),
(1, 2),
(2, 1);

# --- !Downs

delete from issue_authority;
delete from issue_issue_category;
delete from issue;
delete from issue_category;
delete from authority;

alter table issue alter column id restart with 1;
alter table issue_category alter column id restart with 1;
alter table authority alter column id restart with 1;
