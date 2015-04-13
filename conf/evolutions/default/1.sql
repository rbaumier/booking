# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table booking (
  id                        number(19) not null,
  alley                     number(10),
  name                      varchar2(255),
  start_date                timestamp,
  constraint pk_booking primary key (id))
;

create table player (
  id                        number(19) not null,
  team_id                   number(19) not null,
  name                      varchar2(255),
  score                     integer default 0,
  constraint pk_player primary key (id))
;

create table team (
  id                        number(19) not null,
  booking_id                number(19) not null,
  name                      varchar2(255),
  constraint pk_team primary key (id))
;

create sequence booking_seq;

create sequence player_seq;

create sequence team_seq;

alter table player add constraint fk_player_team_1 foreign key (team_id) references team (id);
create index ix_player_team_1 on player (team_id);
alter table team add constraint fk_team_booking_2 foreign key (booking_id) references booking (id);
create index ix_team_booking_2 on team (booking_id);



# --- !Downs

drop table booking cascade constraints purge;

drop table player cascade constraints purge;

drop table team cascade constraints purge;

drop sequence booking_seq;

drop sequence player_seq;

drop sequence team_seq;

