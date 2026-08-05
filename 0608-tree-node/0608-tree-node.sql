# Write your MySQL query statement below
select
    id,
    case
        when p_id IS null then 'Root'
        when id IN (select p_id FROM Tree where p_id is not null) then 'Inner'
        else 'Leaf'
    END AS type
from Tree;