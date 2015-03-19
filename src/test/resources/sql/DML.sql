-- USER
INSERT INTO REQLIST.user (id,name,email,password,register_date,confirmed)
    VALUES (10,'Vinicius','wh@tevs.com','123456','1990-10-12 00:00:00',1);

-- PROJECT
INSERT INTO REQLIST.project (id,register_date,description,name,active)
    VALUES (10,'1990-10-12 00:00:00','Whatevs','Reqlist',1);
INSERT INTO REQLIST.project (id,register_date,description,name,active)
    VALUES (11,'1990-10-12 00:00:00','Whatevs Ipsum','Bichorama',1);
    -- to be deleted
INSERT INTO REQLIST.project (id,register_date,description,name,active)
    VALUES (666,'1990-10-12 00:00:00','Whatevs Ipsum dolor','Bichorama',0);

-- SCOPE
INSERT INTO REQLIST.scope (id,title,register_date,active,project_id)
    VALUES (10,'v1.0','1990-10-12 00:00:00',1,10);
INSERT INTO REQLIST.scope (id,title,register_date,active,project_id)
    VALUES (11,'v1.IPSUM','1990-10-12 00:00:00',1,10);
    -- to be deleted
INSERT INTO REQLIST.scope (id,title,register_date,active,project_id)
    VALUES (666,'HellScope','1990-10-12 00:00:00',1,10);

-- OBJECTIVE
INSERT INTO REQLIST.objective (id,title,description,register_date,user_id,project_id)
    VALUES (10,'Dominate the world','And a planet at choice','1990-10-12 00:00:00',10,10);
INSERT INTO REQLIST.objective (id,title,description,register_date,user_id,project_id)
    VALUES (11,'Dominate the heart of your beloved one','<3','1990-10-12 00:00:00',10,10);
    -- to be deleted
INSERT INTO REQLIST.objective (id,title,description,register_date,user_id,project_id)
    VALUES (666,'Dominate humanity','And stabilish chaos','1990-10-12 00:00:00',10,10);

-- REQUIREMENT
INSERT INTO REQLIST.requirement (id,title,description,register_date,type,active,user_id,project_id)
    VALUES (10,'Must be awesome','In a awesome way','1990-10-12 00:00:00','FUNCTIONAL',1,10,10);
INSERT INTO REQLIST.requirement (id,title,description,register_date,type,active,user_id,project_id)
    VALUES (11,'Must be bold','Not italic.','1990-10-12 00:00:00','USABILITY',1,10,10);
    -- NxN
INSERT INTO REQLIST.scope_x_requirement(scope_id, requirement_id)
    VALUES (10, 10), (11, 10);
    -- to be deleted
INSERT INTO REQLIST.requirement (id,title,description,register_date,type,active,user_id,project_id)
    VALUES (666,'Tsum eb emosewa','Ni a emosewa yaw','1990-10-12 00:00:00','USABILITY',1,10,10);

-- TASK
INSERT INTO REQLIST.task (id,title,description,register_date,done,delivery_id,requirement_id,user_id)
    VALUES (10,'Must be awesome','In a awesome way','1990-10-12 00:00:00',0,null,10,null);
INSERT INTO REQLIST.task (id,title,description,register_date,done,delivery_id,requirement_id,user_id)
    VALUES (11,'Must be bold','Not italic.','1990-10-12 00:00:00',1,null,10,10);
    -- to be deleted
INSERT INTO REQLIST.task (id,title,description,register_date,done,delivery_id,requirement_id,user_id)
    VALUES (666,'Must be bold','Not italic.','1990-10-12 00:00:00',1,null,10,10);