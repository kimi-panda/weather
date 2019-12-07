DELETE FROM weather_resources;
DELETE FROM cities;
DELETE FROM weather;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO cities (name, code_gismeteo) VALUES
  ('Yakutsk', '24959'),
  ('Chelyabinsk', '28642');

INSERT INTO weather_resources (name, url_string) VALUES
  ('GISMETEO', 'http://informer.gismeteo.ru/xml/codeGismeteo-1.xml');

INSERT INTO weather (date_time, city_id, weather_resource_id, temperature)
VALUES ('2019-05-30 10:00:00', 100000, 100002, 15);
