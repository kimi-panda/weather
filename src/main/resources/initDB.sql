
DROP TABLE IF EXISTS cities CASCADE;
DROP TABLE IF EXISTS services CASCADE;
DROP TABLE IF EXISTS weather;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;



CREATE TABLE cities
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL,
  code_gismeteo    VARCHAR
);

CREATE TABLE services
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  weatherServiceEnum  VARCHAR                 NOT NULL,
  url_string       VARCHAR                 NOT NULL
);

CREATE TABLE weather (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  date_time   TIMESTAMP NOT NULL,
  city_id     INTEGER NOT NULL,
  service_id INTEGER NOT NULL,
  temperature   INT       NOT NULL,
  FOREIGN KEY (city_id) REFERENCES cities (id) ON DELETE CASCADE,
  FOREIGN KEY (service_id) REFERENCES services (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX weather_unique_city_service_datetime_idx
  ON weather (city_id, service_id, date_time);