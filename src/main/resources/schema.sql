-- Создание таблиц
CREATE TABLE Course (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL
);

CREATE TABLE Coordinator (
                             id SERIAL PRIMARY KEY,
                             name VARCHAR(255) NOT NULL
);

CREATE TABLE Student (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         coordinator_id INT REFERENCES Coordinator(id)
);

CREATE TABLE CourseStudent (
                               course_id INT REFERENCES Course(id),
                               student_id INT REFERENCES Student(id),
                               PRIMARY KEY (course_id, student_id)
);

-- Заполнение таблицы Course
INSERT INTO Course (id, name) VALUES
                                  (1, 'Java'),
                                  (2, 'Economic'),
                                  (3, 'Architect');

-- Заполнение таблицы Coordinator
INSERT INTO Coordinator (id, name) VALUES
    (1, 'Сергей');

-- Заполнение таблицы Student
INSERT INTO Student (id, name, coordinator_id) VALUES
                                                   (1, 'Иван', 1),
                                                   (2, 'Петр', 1),
                                                   (3, 'Дмитрий', 1),
                                                   (4, 'Юрий', 1),
                                                   (5, 'Александр', 1),
                                                   (6, 'Алексей', 1);

-- Заполнение таблицы CourseStudent
INSERT INTO CourseStudent (course_id, student_id) VALUES
                                                      (1, 1), -- Иван записан на Java
                                                      (1, 2), -- Петр записан на Java
                                                      (2, 3), -- Дмитрий записан на Economic
                                                      (3, 4), -- Юрий записан на Architect
                                                      (3, 5), -- Александр записан на Architect
                                                      (2, 6); -- Алексей записан на Economic