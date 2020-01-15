create table if not exists SPEAKER (id int, name varchar(20), twitter varchar(20));
create table if not exists ATTENDEE (id int, name varchar(20));
create table if not exists TALK (id int, title varchar(20), description varchar(20));
create table if not exists SPEAKER_TALK (id int, speaker_id varchar(20), talk_id varchar(20));
create table if not exists ATTENDEE_TALK (id int, attendee_id varchar(20), talk_id varchar(20));

insert into SPEAKER values(1,'speaker 1','@speaker1');
insert into SPEAKER values(2,'speaker 2','@speaker2');
insert into SPEAKER values(3,'speaker 3','@speaker3');
insert into SPEAKER values(4,'speaker 4','@speaker4');


insert into ATTENDEE values(1,'attendee 1');
insert into ATTENDEE values(2,'attendee 2');
insert into ATTENDEE values(3,'attendee 3');
insert into ATTENDEE values(4,'attendee 4');
insert into ATTENDEE values(5,'attendee 5');
insert into ATTENDEE values(6,'attendee 6');
insert into ATTENDEE values(7,'attendee 7');
insert into ATTENDEE values(8,'attendee 8');
insert into ATTENDEE values(9,'attendee 9');
insert into ATTENDEE values(10,'attendee 10');
insert into ATTENDEE values(11,'attendee 11');
insert into ATTENDEE values(12,'attendee 12');

insert into TALK values (1,'talk 1','this is desc for talk 1');
insert into TALK values (2,'talk 2','this is desc for talk 2');
insert into TALK values (3,'talk 3','this is desc for talk 3');


insert into SPEAKER_TALK values (1,1,1);
insert into SPEAKER_TALK values (2,2,1);
insert into SPEAKER_TALK values (3,3,2);
insert into SPEAKER_TALK values (4,4,3);

insert into ATTENDEE_TALK values (1,1,1);
insert into ATTENDEE_TALK values (2,2,1);
insert into ATTENDEE_TALK values (3,3,1);
insert into ATTENDEE_TALK values (4,4,1);
insert into ATTENDEE_TALK values (5,5,1);
insert into ATTENDEE_TALK values (6,6,2);
insert into ATTENDEE_TALK values (7,7,2);
insert into ATTENDEE_TALK values (8,8,2);
insert into ATTENDEE_TALK values (9,9,2);
insert into ATTENDEE_TALK values (10,10,2);
insert into ATTENDEE_TALK values (11,11,3);
insert into ATTENDEE_TALK values (12,12,3);
insert into ATTENDEE_TALK values (13,1,3);
insert into ATTENDEE_TALK values (14,2,3);
insert into ATTENDEE_TALK values (15,3,3);