INSERT INTO public.brands (id, name)
VALUES (1, 'Audi');

INSERT INTO public.brands (id, name)
VALUES (2, 'BMW');

INSERT INTO public.brands (id, name)
VALUES (3, 'Mercedes-Benz');

INSERT INTO public.brands (id, name)
VALUES (4, 'Škoda ');

INSERT INTO public.brands (id, name)
VALUES (5, 'Volkswagen');



INSERT INTO public.engines (id, name)
VALUES (1, 'Бензин');

INSERT INTO public.engines (id, name)
VALUES (2, 'Дизель');



INSERT INTO public.types (id, name)
VALUES (1, 'Седан');

INSERT INTO public.types (id, name)
VALUES (2, 'Хэтчбек');

INSERT INTO public.types (id, name)
VALUES (3, 'Внедорожник');

INSERT INTO public.types (id, name)
VALUES (4, 'Лифтбек');

INSERT INTO public.types (id, name)
VALUES (5, 'Универсал');

INSERT INTO public.types (id, name)
VALUES (6, 'Купе');



INSERT INTO public.models (id, name, brand_id)
VALUES (1, 'A1', 1);

INSERT INTO public.models (id, name, brand_id)
VALUES (2, 'A3', 1);

INSERT INTO public.models (id, name, brand_id)
VALUES (3, 'A4', 1);

INSERT INTO public.models (id, name, brand_id)
VALUES (4, 'A5', 1);

INSERT INTO public.models (id, name, brand_id)
VALUES (5, 'A7', 1);

INSERT INTO public.models (id, name, brand_id)
VALUES (6, 'Q5', 1);

INSERT INTO public.models (id, name, brand_id)
VALUES (7, 'Q7', 1);

INSERT INTO public.models (id, name, brand_id)
VALUES (8, 'RS 5', 1);

INSERT INTO public.models (id, name, brand_id)
VALUES (9, '1 серии', 2);

INSERT INTO public.models (id, name, brand_id)
VALUES (10, '2 серии', 2);

INSERT INTO public.models (id, name, brand_id)
VALUES (11, '3 серии', 2);

INSERT INTO public.models (id, name, brand_id)
VALUES (12, '5 серии', 2);

INSERT INTO public.models (id, name, brand_id)
VALUES (13, 'X3', 2);

INSERT INTO public.models (id, name, brand_id)
VALUES (14, 'X5', 2);

INSERT INTO public.models (id, name, brand_id)
VALUES (15, 'X6', 2);

INSERT INTO public.models (id, name, brand_id)
VALUES (16, 'M3', 2);

INSERT INTO public.models (id, name, brand_id)
VALUES (17, 'M4', 2);

INSERT INTO public.models (id, name, brand_id)
VALUES (18, 'M5', 2);

INSERT INTO public.models (id, name, brand_id)
VALUES (19, 'A-класс', 3);

INSERT INTO public.models (id, name, brand_id)
VALUES (20, 'B-класс', 3);

INSERT INTO public.models (id, name, brand_id)
VALUES (21, 'C-класс', 3);

INSERT INTO public.models (id, name, brand_id)
VALUES (22, 'E-класс', 3);

INSERT INTO public.models (id, name, brand_id)
VALUES (23, 'G-класс', 3);

INSERT INTO public.models (id, name, brand_id)
VALUES (24, 'GL-класс', 3);

INSERT INTO public.models (id, name, brand_id)
VALUES (25, 'Rapid', 4);

INSERT INTO public.models (id, name, brand_id)
VALUES (26, 'Octavia', 4);

INSERT INTO public.models (id, name, brand_id)
VALUES (27, 'Kodiaq', 4);

INSERT INTO public.models (id, name, brand_id)
VALUES (28, 'Superb', 4);

INSERT INTO public.models (id, name, brand_id)
VALUES (29, 'Golf', 5);

INSERT INTO public.models (id, name, brand_id)
VALUES (30, 'Passat', 5);

INSERT INTO public.models (id, name, brand_id)
VALUES (31, 'Polo', 5);

INSERT INTO public.models (id, name, brand_id)
VALUES (32, 'Tiguan', 5);

INSERT INTO public.models (id, name, brand_id)
VALUES (33, 'Touareg', 5);



INSERT INTO public.cars (id, yearofissue, type_id, model_id, engine_id)
VALUES (1, 2008, 1, 3, 1);

INSERT INTO public.cars (id, yearofissue, type_id, model_id, engine_id)
VALUES (2, 2021, 3, 15, 2);

INSERT INTO public.cars (id, yearofissue, type_id, model_id, engine_id)
VALUES (3, 2013, 2, 20, 1);

INSERT INTO public.cars (id, yearofissue, type_id, model_id, engine_id)
VALUES (4, 2018, 3, 27, 2);

INSERT INTO public.cars (id, yearofissue, type_id, model_id, engine_id)
VALUES (5, 2019, 1, 18, 1);

INSERT INTO public.cars (id, yearofissue, type_id, model_id, engine_id)
VALUES (6, 2015, 1, 22, 1);

INSERT INTO public.cars (id, yearofissue, type_id, model_id, engine_id)
VALUES (7, 2017, 3, 32, 1);

INSERT INTO public.cars (id, yearofissue, type_id, model_id, engine_id)
VALUES (8, 2017, 4, 26, 1);

INSERT INTO public.cars (id, yearofissue, type_id, model_id, engine_id)
VALUES (9, 2011, 6, 8, 1);

INSERT INTO public.cars (id, yearofissue, type_id, model_id, engine_id)
VALUES (10, 2018, 4, 28, 1);

INSERT INTO public.cars (id, yearofissue, type_id, model_id, engine_id)
VALUES (11, 2013, 5, 3, 2);

INSERT INTO public.cars (id, yearofissue, type_id, model_id, engine_id)
VALUES (13, 2008, 4, 8, 1);

INSERT INTO public.cars (id, yearofissue, type_id, model_id, engine_id)
VALUES (16, 2017, 1, 13, 1);

INSERT INTO public.cars (id, yearofissue, type_id, model_id, engine_id)
VALUES (18, 2017, 1, 12, 1);

INSERT INTO public.cars (id, yearofissue, type_id, model_id, engine_id)
VALUES (19, 2013, 3, 10, 2);

INSERT INTO public.cars (id, yearofissue, type_id, model_id, engine_id)
VALUES (20, 2008, 4, 20, 2);

INSERT INTO public.cars (id, yearofissue, type_id, model_id, engine_id)
VALUES (21, 2018, 1, 26, 1);

INSERT INTO public.cars (id, yearofissue, type_id, model_id, engine_id)
VALUES (15, 2018, 4, 28, 2);



INSERT INTO public.users (id, name, password, email)
VALUES (1, 'admin', 'admin', 'admin@cars.ru');