CREATE TABLE IF NOT EXISTS coredata.data.coredata
(
    id    bigserial primary key,
    value smallint NOT NULL,
    time  timestamptz
);