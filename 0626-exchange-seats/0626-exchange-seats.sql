# Write your MySQL query statement below
select
    case
        when id % 2 = 1
             and id != (select MAX(id) from Seat)
        then id + 1

        when id % 2 = 0
        then id - 1

        else id
    END AS id,
    student
from Seat
order BY id;