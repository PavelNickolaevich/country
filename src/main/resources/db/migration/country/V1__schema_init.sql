create extension if not exists "uuid-ossp";

create table if not exists "country"
(
    id           UUID unique        not null default uuid_generate_v1() primary key,
    country_name varchar(50) unique not null,
    country_code varchar(3)         not null
);

alter table "country"
    owner to postgres;

delete
from "country";

INSERT INTO country
(country_name, country_code)
VALUES('Fiji', 'FJ');
INSERT INTO country
(country_name, country_code)
VALUES('Tanzania', 'TZ');
INSERT INTO country
(country_name, country_code)
VALUES('Western Sahara', 'EH');
INSERT INTO country
(country_name, country_code)
VALUES('Canada', 'CA');
INSERT INTO country
(country_name, country_code)
VALUES('United States', 'US');
INSERT INTO country
(country_name, country_code)
VALUES('Kazakhstan', 'KZ');
INSERT INTO country
(country_name, country_code)
VALUES('Uzbekistan', 'UZ');
INSERT INTO country
(country_name, country_code)
VALUES('Papua New Guinea', 'PG');
INSERT INTO country
(country_name, country_code)
VALUES('Indonesia', 'ID');
INSERT INTO country
(country_name, country_code)
VALUES('Argentina', 'AR');
INSERT INTO country
(country_name, country_code)
VALUES('Chile', 'CL');
INSERT INTO country
(country_name, country_code)
VALUES('Democratic Republic of the Congo', 'CD');
INSERT INTO country
(country_name, country_code)
VALUES('Somalia', 'SO');
INSERT INTO country
(country_name, country_code)
VALUES('Kenya', 'KE');
INSERT INTO country
(country_name, country_code)
VALUES('Sudan', 'SD');
INSERT INTO country
(country_name, country_code)
VALUES('Chad', 'TD');
INSERT INTO country
(country_name, country_code)
VALUES('Haiti', 'HT');
INSERT INTO country
(country_name, country_code)
VALUES('Dominican Republic', 'DO');
INSERT INTO country
(country_name, country_code)
VALUES('Russia', 'RU');
INSERT INTO country
(country_name, country_code)
VALUES('Bahamas', 'BS');
INSERT INTO country
(country_name, country_code)
VALUES('Falkland Islands', 'FK');
INSERT INTO country
(country_name, country_code)
VALUES('Norway', 'NO');
INSERT INTO country
(country_name, country_code)
VALUES('Greenland', 'GL');
INSERT INTO country
(country_name, country_code)
VALUES('Timor-Leste', 'TL');
INSERT INTO country
(country_name, country_code)
VALUES('South Africa', 'ZA');
INSERT INTO country
(country_name, country_code)
VALUES('Lesotho', 'LS');
INSERT INTO country
(country_name, country_code)
VALUES('Mexico', 'MX');
INSERT INTO country
(country_name, country_code)
VALUES('Uruguay', 'UY');
INSERT INTO country
(country_name, country_code)
VALUES('Brazil', 'BR');
INSERT INTO country
(country_name, country_code)
VALUES('Bolivia', 'BO');
