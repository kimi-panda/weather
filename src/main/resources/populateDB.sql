
DELETE FROM services;
DELETE FROM cities;
DELETE FROM weather;
ALTER SEQUENCE global_seq RESTART WITH 100000;



INSERT INTO cities (name, code_gismeteo) VALUES
  ('Moscow', '27611'),
  ('Chelyabinsk', '28642');

INSERT INTO services (weatherServiceEnum, url_string) VALUES
  ('GISMETEO', 'http://informer.gismeteo.ru/xml/codeGismeteo-1.xml');

INSERT INTO weather (date_time, city_id, service_id, temperature)
VALUES ('2019-05-30 10:00:00', 100000, 100002, 15);
