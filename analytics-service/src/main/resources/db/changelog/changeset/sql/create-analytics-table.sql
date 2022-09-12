CREATE TABLE IF NOT EXISTS analytics.analytics.analytics
(
    metric_name varchar(30) primary key,
    value integer NOT NULL DEFAULT 0,
    last_update_time timestamptz
);