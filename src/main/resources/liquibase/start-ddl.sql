CREATE EXTENSION IF NOT EXISTS hstore;
CREATE EXTENSION IF NOT EXISTS cube;
CREATE EXTENSION IF NOT EXISTS earthdistance;

CREATE TABLE node
(
    "id"        bigint PRIMARY KEY,
    "user"      varchar(100),
    "uid"       bigint,
    "visible"   boolean,
    "version"   bigint,
    "changeset" bigint,
    "timestamp" timestamp,
    "lat"       double precision,
    "lon"       double precision,
    "tags"      hstore
);

CREATE TABLE way
(
    "id"        bigint PRIMARY KEY,
    "user"      varchar(100),
    "uid"       bigint,
    "visible"   boolean,
    "version"   bigint,
    "changeset" bigint,
    "timestamp" timestamp,
    "tags"      hstore,
    "nds"       text
);

CREATE TABLE relation
(
    "id"        bigint PRIMARY KEY,
    "user"      varchar(100),
    "uid"       bigint,
    "visible"   boolean,
    "version"   bigint,
    "changeset" bigint,
    "timestamp" timestamp,
    "tags"      hstore,
    "members"   text
);
