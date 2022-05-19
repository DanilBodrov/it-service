create table arrays
(
    id         serial primary key,
    string     text,
    sub_string text,
    results    text,
    type_task  text,
    count      int
);

create table magic_square
(
    id        serial primary key,
    zero_zero int,
    zero_one  int,
    zero_two  int,
    one_zero  int,
    one_one   int,
    one_two   int,
    two_zero  int,
    two_one   int,
    two_two   int
);

create table magic_square_result
(
    id              serial primary key,
    zero_zero       int,
    zero_one        int,
    zero_two        int,
    one_zero        int,
    one_one         int,
    one_two         int,
    two_zero        int,
    two_one         int,
    two_two         int,
    magic_square_id int references magic_square (id)
);