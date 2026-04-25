INSERT INTO users VALUES
(1, 'Divya'),
(2, 'Arun'),
(3, 'Priya'),
(4, 'Karthik'),
(5, 'Sneha'),
(6, 'Rahul'),
(7, 'Meena'),
(8, 'Vikram'),
(9, 'Anjali'),
(10, 'Ravi');
INSERT INTO transactions (book_id, user_id, issue_date, due_date, return_date, fine) VALUES
(1, 1, '2024-04-01', '2024-04-10', '2024-04-09', 0),
(2, 2, '2024-04-02', '2024-04-12', '2024-04-15', 50),
(3, 3, '2024-04-03', '2024-04-13', NULL, 0),
(4, 4, '2024-04-04', '2024-04-14', '2024-04-14', 0),
(5, 5, '2024-04-05', '2024-04-15', '2024-04-18', 30),
(6, 6, '2024-04-06', '2024-04-16', NULL, 0),
(7, 7, '2024-04-07', '2024-04-17', '2024-04-16', 0),
(8, 8, '2024-04-08', '2024-04-18', '2024-04-20', 40),
(9, 9, '2024-04-09', '2024-04-19', NULL, 0),
(10, 10, '2024-04-10', '2024-04-20', '2024-04-21', 20);

INSERT INTO books VALUES
(1, 'Java Basics', 'James Gosling'),
(2, 'Data Structures', 'Mark Allen'),
(3, 'DBMS Concepts', 'Navathe'),
(4, 'Operating Systems', 'Galvin'),
(5, 'Computer Networks', 'Tanenbaum'),
(6, 'AI Fundamentals', 'Stuart Russell'),
(7, 'Machine Learning', 'Tom Mitchell'),
(8, 'Web Development', 'Jon Duckett'),
(9, 'Python Programming', 'Guido Rossum'),
(10, 'Software Engineering', 'Ian Sommerville');