-- liquibase formatted sql

-- changeset danchik:1

CREATE INDEX student_name_index ON student (name);

-- changeset danchik:2

CREATE INDEX faculty_nc_index ON faculty (name, color);