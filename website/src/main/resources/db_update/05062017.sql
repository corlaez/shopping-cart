
alter table product add column stock int;

INSERT INTO public.product_type (id, name, active) VALUES (1, 'Abrigos', true);
INSERT INTO public.product_type (id, name, active) VALUES (2, 'Gorros', true);
INSERT INTO public.product_type (id, name, active) VALUES (3, 'Mantas', true);
INSERT INTO public.product_type (id, name, active) VALUES (4, 'Otros', true);

INSERT INTO public.product (id, name, description, price, active, product_type_id) VALUES (1, 'Chompa de Alpaca', 'Bella chompa de alpaca, modelo 2017', 80, true, 1);
