CREATE TABLE IF NOT EXISTS coredata.data.coredata
(
    id    bigserial primary key,
    value integer NOT NULL,
    time  timestamptz
);