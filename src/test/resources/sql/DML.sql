-- PROJECT
INSERT INTO REQLIST.project (id,register_date,description,name,active)
    VALUES (10, '1990-10-12 00:00:00', 'Whatevs', 'Reqlist', 1);
INSERT INTO REQLIST.project (id,register_date,description,name,active)
    VALUES (11, '1990-10-12 00:00:00', 'Whatevs Ipsum', 'Bichorama', 1);
    -- to be deleted
INSERT INTO REQLIST.project (id,register_date,description,name,active)
    VALUES (666, '1990-10-12 00:00:00', 'Whatevs Ipsum dolor', 'Bichorama', 0);

-- SCOPE
INSERT INTO REQLIST.scope (id,title,register_date,active,project_id)
    VALUES (10, 'v1.0', '1990-10-12 00:00:00', 1, 10);
INSERT INTO REQLIST.scope (id,title,register_date,active,project_id)
    VALUES (11, 'v1.IPSUM', '1990-10-12 00:00:00', 1, 10);
    -- to be deleted
INSERT INTO REQLIST.scope (id,title,register_date,active,project_id)
    VALUES (666, 'HellScope', '1990-10-12 00:00:00', 1, 10);
