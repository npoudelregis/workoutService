INSERT INTO workouts(id, name, length, avgrating) VALUES(1, 'Workout 1', 30, 3.5);
INSERT INTO workouts(id, name, length, avgrating) VALUES(2, 'Workout 2', 40, 4.5);
INSERT INTO workouts(id, name, length, avgrating) VALUES(3, 'Workout 3', 50, 2);
INSERT INTO workouts(id, name, length, avgrating) VALUES(4, 'Workout 4', 60, 5);
INSERT INTO workouts(id, name, length, avgrating) VALUES(5, 'Workout 5', 120, 1.5);

INSERT INTO exercises(id, name, description, img_url) VALUES(1, 'Exercises 1', 30, 'blank.jpg');
INSERT INTO exercises(id, name, description, img_url) VALUES(2, 'Exercises 2', 30, 'blank.jpg');
INSERT INTO exercises(id, name, description, img_url) VALUES(3, 'Exercises 3', 30, 'blank.jpg');
INSERT INTO exercises(id, name, description, img_url) VALUES(4, 'Exercises 4', 30, 'blank.jpg');
INSERT INTO exercises(id, name, description, img_url) VALUES(5, 'Exercises 5', 30, 'blank.jpg');

INSERT INTO tags(id, name) VALUES(1, 'tag 1');
INSERT INTO tags(id, name) VALUES(2, 'tag 2');
INSERT INTO tags(id, name) VALUES(3, 'tag 3');
INSERT INTO tags(id, name) VALUES(4, 'muscle');
INSERT INTO tags(id, name) VALUES(5, 'cardio');
INSERT INTO tags(id, name) VALUES(6, 'cardio1');

INSERT INTO workout_tags(id, workout_id, tag_id) VALUES(1, 1, 1);
INSERT INTO workout_tags(id, workout_id, tag_id) VALUES(2, 2, 2);
INSERT INTO workout_tags(id, workout_id, tag_id) VALUES(3, 3, 3);
INSERT INTO workout_tags(id, workout_id, tag_id) VALUES(4, 4, 4);
INSERT INTO workout_tags(id, workout_id, tag_id) VALUES(5, 5, 5);
INSERT INTO workout_tags(id, workout_id, tag_id) VALUES(7, 1, 5);
INSERT INTO workout_tags(id, workout_id, tag_id) VALUES(8, 1, 6);


INSERT INTO exercise_tags(id, exercise_id, tag_id) VALUES(1, 1, 1);
INSERT INTO exercise_tags(id, exercise_id, tag_id) VALUES(2, 1, 2);
INSERT INTO exercise_tags(id, exercise_id, tag_id) VALUES(3, 1, 3);
INSERT INTO exercise_tags(id, exercise_id, tag_id) VALUES(4, 2, 1);

INSERT INTO repetitions(id, exercise_id, workout_id, description) VALUES(1, 1, 1, '30 reps');
INSERT INTO repetitions(id, exercise_id, workout_id, description) VALUES(2, 2, 1, '32 reps');
INSERT INTO repetitions(id, exercise_id, workout_id, description) VALUES(3, 3, 1, '100 reps');

INSERT INTO ratings(id, workout_id, rating) VALUES(1, 1, 3.0);
INSERT INTO ratings(id, workout_id, rating) VALUES(2, 1, 4.0);
INSERT INTO ratings(id, workout_id, rating) VALUES(3, 1, 5.0);