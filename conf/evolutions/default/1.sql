# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table game (
  id                        number(19) not null,
  alley                     number(10),
  name                      varchar2(255),
  start_date                timestamp,
  constraint pk_game primary key (id))
;

create table player (
  id                        number(19) not null,
  team_id                   number(19) not null,
  name                      varchar2(255),
  stats_id                  number(19),
  constraint pk_player primary key (id))
;

create table stats (
  id                        number(19) not null,
  score                     integer default 0,
  strikes                   integer default 0,
  spares                    integer default 0,
  strike_serie              integer default 0,
  pins                      integer default 0,
  constraint pk_stats primary key (id))
;

create table team (
  id                        number(19) not null,
  game_id                   number(19) not null,
  name                      varchar2(255),
  constraint pk_team primary key (id))
;

create sequence game_seq;

create sequence player_seq;

create sequence stats_seq;

create sequence team_seq;

alter table player add constraint fk_player_team_1 foreign key (team_id) references team (id);
create index ix_player_team_1 on player (team_id);
alter table player add constraint fk_player_stats_2 foreign key (stats_id) references stats (id);
create index ix_player_stats_2 on player (stats_id);
alter table team add constraint fk_team_game_3 foreign key (game_id) references game (id);
create index ix_team_game_3 on team (game_id);



# --- !Downs

drop table game cascade constraints purge;

drop table player cascade constraints purge;

drop table stats cascade constraints purge;

drop table team cascade constraints purge;

drop sequence game_seq;

drop sequence player_seq;

drop sequence stats_seq;

drop sequence team_seq;

