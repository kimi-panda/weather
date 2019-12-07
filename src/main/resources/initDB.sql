
DROP TABLE IF EXISTS cities CASCADE;
DROP TABLE IF EXISTS weather_resources CASCADE;
DROP TABLE IF EXISTS weather;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;



CREATE TABLE cities
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL,
  code_gismeteo    VARCHAR
);

CREATE TABLE weather_resources
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL,
  url_string       VARCHAR                 NOT NULL
);

CREATE TABLE weather (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  date_time   TIMESTAMP NOT NULL,
  city_id     INTEGER NOT NULL,
  weather_resource_id INTEGER NOT NULL,
  temperature   INT       NOT NULL,
  FOREIGN KEY (city_id) REFERENCES cities (id) ON DELETE CASCADE,
  FOREIGN KEY (weather_resource_id) REFERENCES weather_resources (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX weather_unique_city_weather_resource_datetime_idx
  ON weather (city_id, weather_resource_id, date_time);