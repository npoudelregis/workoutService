DROP TABLE IF EXISTS workouts CASCADE;
DROP TABLE IF EXISTS exercises CASCADE;
DROP TABLE IF EXISTS workout_exercises CASCADE;
DROP TABLE IF EXISTS tags CASCADE;
DROP TABLE IF EXISTS workout_tags CASCADE;




CREATE TABLE workouts (
    id SERIAL PRIMARY KEY,
    length bigint,
    name character varying(255)
);


CREATE TABLE exercises (
    id SERIAL PRIMARY KEY,
    description character varying(255),
    img_url character varying(255),
    name character varying(255)
);


CREATE TABLE workout_exercises(
    id SERIAL PRIMARY KEY,
    exercise_id bigint REFERENCES exercises (id),
    workout_id  bigint REFERENCES workouts (id)
);

CREATE TABLE tags(
    id SERIAL PRIMARY KEY,
    name character varying(255)
);

CREATE TABLE workout_tags(
    id SERIAL PRIMARY KEY,
    workout_id bigint REFERENCES workouts (id),
    tag_id bigint REFERENCES tags (id)
);