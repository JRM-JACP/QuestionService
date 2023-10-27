INSERT INTO question_tags (question_id, tags)
VALUES (1, 'STRING');

INSERT INTO question (id, problem, difficulty, tags, description, body, test)
VALUES (1, 'Grasshopper', 'EASY', 'STRING', 'Description', 'Body', 'Test');

INSERT INTO question_imports(id, imports)
VALUES (1, 'import lombok.AllArgsConstructor;');