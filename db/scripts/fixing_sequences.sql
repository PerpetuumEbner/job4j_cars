SELECT setval('ads_id_seq', (SELECT MAX(id) FROM ads) + 1);

SELECT setval('brands_id_seq', (SELECT MAX(id) FROM brands) + 1);

SELECT setval('cars_id_seq', (SELECT MAX(id) FROM cars) + 1);

SELECT setval('engines_id_seq', (SELECT MAX(id) FROM engines) + 1);

SELECT setval('models_id_seq', (SELECT MAX(id) FROM models) + 1);

SELECT setval('types_id_seq', (SELECT MAX(id) FROM types) + 1);

SELECT setval('users_id_seq', (SELECT MAX(id) FROM cars.public.users) + 1);