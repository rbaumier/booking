# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table booking (
  id                        number(19) not null,
  name                      varchar2(255),
  start_date                timestamp,
  constraint pk_booking primary key (id))
;

create sequence booking_seq;




# --- !Downs

drop table booking cascade constraints purge;

drop sequence booking_seq;

