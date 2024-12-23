INSERT INTO public.users (user_id, username, password, enabled) VALUES
(1, 'user1', '$2a$10$oZjbOLmW/.STBg4u1k8NCuUCOEkyr2mv3d.GpfHL3TgzU0cPKY.F.', true),
(2, 'user2', '$2a$10$xU8it8s8z2WxXPoqZ0Rr6egtV85dFQ.j8rnpTell0FfsV9gbBQdw.', true);


INSERT INTO public.authorities (username, authority) VALUES
('user1', 'USER'),
('user2', 'USER'),
('user2', 'ADMIN');
