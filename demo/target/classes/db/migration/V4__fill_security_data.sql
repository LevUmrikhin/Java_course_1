INSERT INTO public.users (user_id, username, password, enabled) VALUES
(1, 'user1', 'password1', true),
(2, 'user2', 'password2', true);


INSERT INTO public.authorities (username, authority) VALUES
('user1', 'USER'),
('user2', 'USER'),
('user2', 'ADMIN');
