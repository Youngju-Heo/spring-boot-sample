insert into city(id, name, state, country) values ('3013b1de-2bb7-429f-bc7e-dcc6605efb30', '송파구', '서울특별시', '대한민국') on conflict (id) do nothing;
insert into city(id, name, state, country) values ('7cddd91b-2345-4d67-bb85-6d94e9b47365', '거제시', '경상남도', '대한민국') on conflict (id) do nothing;
