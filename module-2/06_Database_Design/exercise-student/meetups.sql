--Member Table
CREATE TABLE member (
member_id serial NOT NULL,
last_name varchar(45) NOT NULL,
first_name varchar(45) NOT NULL,
email varchar(45) NOT NULL,
phone_number varchar(13),
dob date,
wants_reminders boolean NOT NULL default true,
CONSTRAINT pk_member_member_id PRIMARY KEY (member_id)
);
--Events Table
CREATE TABLE events (
event_id serial NOT NULL,
event_name varchar(100) NOT NULL,
description varchar (200) NOT NULL,
event_date_time TIMESTAMP NOT NULL,
duration_in_minutes integer NOT NULL,
group_id integer NOT NULL,
CONSTRAINT pk_events_event_id PRIMARY KEY (event_id),
CONSTRAINT ck_events_duration_in_minutes CHECK (duration_in_minutes >= 30)
);
-- Interest Group Table
CREATE TABLE interest_group (
group_id serial NOT NULL, 
interest_group_name varchar(45) UNIQUE NOT NULL,
CONSTRAINT pk_interest_group_group_id PRIMARY KEY (group_id)
);
-- Member Group
CREATE TABLE member_group (
group_id integer NOT NULL,
member_id integer NOT NULL,
CONSTRAINT pk_member_group_group_id_member_id PRIMARY KEY (group_id, member_id)
);
-- Member Event
CREATE TABLE member_event (
member_id integer NOT NULL,
event_id integer NOT NULL,
CONSTRAINT pk_member_event_member_id_event_id PRIMARY KEY (member_id, event_id)
);

--Membergroup alters
ALTER TABLE member_group
ADD FOREIGN KEY (group_id)
REFERENCES interest_group (group_id);

--Membegroup alters
ALTER TABLE member_group
ADD FOREIGN KEY (member_id)
REFERENCES member (member_id);

--Member event alters
ALTER TABLE member_event
ADD FOREIGN KEY (member_id)
REFERENCES member (member_id);

 --MEMber event alters
 ALTER TABLE member_event
ADD FOREIGN KEY (event_id)
REFERENCES events (event_id);

--Altering events
ALTER TABLE events
ADD FOREIGN KEY  (group_id)
REFERENCES interest_group (group_id);
 
 INSERT INTO member (last_name, first_name, email, wants_reminders)
VALUES ('Sofia', 'Chaos_evil', 'badSofia@bad2thebone.com', false);
INSERT INTO member (last_name, first_name, email, wants_reminders)
VALUES ('Sofia', 'Chaos_neutral', 'badNeutralSofia@bad2thebone.com', false);
INSERT INTO member (last_name, first_name, email, wants_reminders)
VALUES ('Sofia', 'Chaos_good', 'goodSofia@4387fgvndli.com', false);
INSERT INTO member (last_name, first_name, email, dob, wants_reminders)
VALUES ('Sofia', 'neutral_evil', 'evilNeutralSofia@bad2thebone.com', '06/09/1969', false);
INSERT INTO member (last_name, first_name, email, phone_number, wants_reminders)
VALUES ('Sofia', 'Good_neutral', 'goodNeutralSofia@goodie2shoes.com', '555-555-5555', true);
INSERT INTO member (last_name, first_name, email, dob, phone_number, wants_reminders)
VALUES ('Sofia', 'Lawful_good', 'upstandingcitizenSofia@goodie2shoes.com', '01/01/1900', '777-777-7777', true);
INSERT INTO member (last_name, first_name, email, phone_number, wants_reminders)
VALUES ('Sofia', 'Lawful_neutral', 'finecitizenSofia@goodie2shoes.com', '777-777-7778', true);
INSERT INTO member (last_name, first_name, email, phone_number, wants_reminders)
VALUES ('Sofia', 'True_neutral', 'neutralSofia@boring.com', '777-777-7788', false);
INSERT INTO member (last_name, first_name, email, dob, phone_number, wants_reminders)
VALUES ('Sofia', 'lawful_evil', 'badSofia@bad2thebone.com', '06/26/1966', '666-666-6666', true);

--Inserting new groups
INSERT INTO interest_group (interest_group_name)
VALUES ('Dead Poets Society');
INSERT INTO interest_group (interest_group_name)
VALUES ('Dungeons and Dragons Meetup');
INSERT INTO interest_group (interest_group_name)
VALUES ('Copypastafarians');
 
--Creating new events
INSERT INTO events (event_name, description, event_date_time, duration_in_minutes, group_id) 
VALUES ('Copy Pasta All You Can Eat', 'Copy and pasta all the macaroni, angel hair, and fetuccini your heart desires', '06-14-2021 6:30', 60,(SELECT group_id FROM interest_group WHERE interest_group_name = 'Copypastafarians'));
INSERT INTO events (event_name, description, event_date_time, duration_in_minutes, group_id) 
VALUES ('Doubles & Dragons', 'Each roll is a double', '06-24-2021 22:30', 120, (SELECT group_id FROM interest_group WHERE interest_group_name = 'Dungeons and Dragons Meetup'));
INSERT INTO events (event_name, description, event_date_time, duration_in_minutes, group_id) 
VALUES ('Show up if you feel like it', 'Live life to the fullest. SEIZE THE DAY!', '12-24-2021 5:30', 600, (SELECT group_id FROM interest_group WHERE interest_group_name = 'Dead Poets Society'));
INSERT INTO events (event_name, description, event_date_time, duration_in_minutes, group_id) 
VALUES ('Bad Sofia Festival', 'You can only attend this if you identify as a member of the Symphony of Sofia', '04-08-2021 16:30', 120, (SELECT group_id FROM interest_group WHERE interest_group_name = 'Dungeons and Dragons Meetup'));


--Members into groups
INSERT INTO member_group(group_id, member_id)
VALUES ((SELECT group_id FROM interest_group WHERE interest_group_name = 'Dead Poets Society'),
       (SELECT member_id FROM member WHERE email = 'neutralSofia@boring.com' ));

INSERT INTO member_group(group_id, member_id)
VALUES ((SELECT group_id FROM interest_group WHERE interest_group_name = 'Dead Poets Society'),
       (SELECT member_id FROM member WHERE email = 'goodSofia@4387fgvndli.com' ));

INSERT INTO member_group(group_id, member_id)
VALUES ((SELECT group_id FROM interest_group WHERE interest_group_name = 'Dungeons and Dragons Meetup'),
       (SELECT member_id FROM member WHERE email = 'goodSofia@4387fgvndli.com' ));
INSERT INTO member_group(group_id, member_id)
VALUES ((SELECT group_id FROM interest_group WHERE interest_group_name = 'Dungeons and Dragons Meetup'),
       (SELECT member_id FROM member WHERE email = 'neutralSofia@boring.com' ));     
         
 INSERT INTO member_group(group_id, member_id)
VALUES ((SELECT group_id FROM interest_group WHERE interest_group_name = 'Copypastafarians'),
       (SELECT member_id FROM member WHERE email = 'goodSofia@4387fgvndli.com' ));
INSERT INTO member_group(group_id, member_id)
VALUES ((SELECT group_id FROM interest_group WHERE interest_group_name = 'Copypastafarians'),
       (SELECT member_id FROM member WHERE email = 'neutralSofia@boring.com' ));     
               
--Members to events
INSERT INTO member_event (event_id, member_id)
VALUES ((SELECT event_id FROM events WHERE event_name = 'Copy Pasta All You Can Eat'),
       (SELECT member_id FROM member WHERE email = 'goodSofia@4387fgvndli.com' ));

INSERT INTO member_event (event_id, member_id)
VALUES ((SELECT event_id FROM events WHERE event_name = 'Doubles & Dragons'),
       (SELECT member_id FROM member WHERE email = 'goodSofia@4387fgvndli.com' ));

INSERT INTO member_event (event_id, member_id)
VALUES ((SELECT event_id FROM events WHERE event_name = 'Show up if you feel like it'),
       (SELECT member_id FROM member WHERE email = 'goodSofia@4387fgvndli.com' ));

INSERT INTO member_event (event_id, member_id)
VALUES ((SELECT event_id FROM events WHERE event_name = 'Bad Sofia Festival'),
       (SELECT member_id FROM member WHERE email = 'goodSofia@4387fgvndli.com' ));       
       
              
       















