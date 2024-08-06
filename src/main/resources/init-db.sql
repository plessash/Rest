CREATE TABLE Student (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         coordinator_id INT REFERENCES Coordinator(id)
);

CREATE TABLE Coordinator (
                             id SERIAL PRIMARY KEY,
                             name VARCHAR(255) NOT NULL
);