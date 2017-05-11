------------------------------------------------------------
--        Script Postgre 
------------------------------------------------------------

------------------------------------------------------------
-- Table: LinkSkill
------------------------------------------------------------
CREATE TABLE dokkan.linkskill(
	id SERIAL NOT NULL,
	name VARCHAR (100),
	description  VARCHAR (100),
	CONSTRAINT prk_constraint_linkskill PRIMARY KEY (id)
)WITHOUT OIDS;

------------------------------------------------------------
-- Table: Card
------------------------------------------------------------
CREATE TABLE dokkan.card(
	id SERIAL NOT NULL ,
	name VARCHAR (500)  ,
	shortName VARCHAR (100)  ,
	url VARCHAR (500)  ,
	maxLevel INT,
	rarity VARCHAR (100)  ,
	type VARCHAR (100)  ,
	costMax INT,
	costBase INT,
	leaderSkill VARCHAR (500)  ,
	superATK VARCHAR (500)  ,
	passiveSkill VARCHAR (500)  ,
	hpMax INT,
	hpBase INT,
	atkMax INT,
	atkBase INT,
	owned BOOLEAN,
	versionMax BOOLEAN,
	additionnalInfo VARCHAR (500)  ,
	CONSTRAINT prk_constraint_livre PRIMARY KEY (id)
)WITHOUT OIDS;

------------------------------------------------------------
-- Table: Team
------------------------------------------------------------
CREATE TABLE dokkan.team(
	id   SERIAL NOT NULL ,
	name VARCHAR (25)  ,
	description VARCHAR (500)  ,
	CONSTRAINT prk_constraint_team PRIMARY KEY (id)
)WITHOUT OIDS;

------------------------------------------------------------
-- Table: Event
------------------------------------------------------------
CREATE TABLE dokkan.event(
	id   SERIAL NOT NULL ,
	name VARCHAR (25)  ,
	description VARCHAR (500)  ,
	CONSTRAINT prk_constraint_event PRIMARY KEY (id)
)WITHOUT OIDS;

------------------------------------------------------------
-- Table: Medal
------------------------------------------------------------
CREATE TABLE dokkan.medal(
	id   SERIAL NOT NULL ,
	name VARCHAR (25)  ,
	CONSTRAINT prk_constraint_medal PRIMARY KEY (id)
)WITHOUT OIDS;

------------------------------------------------------------
-- Table: Capacity
------------------------------------------------------------
CREATE TABLE dokkan.capacity(
	id   SERIAL NOT NULL ,
	name VARCHAR (25)  ,
	CONSTRAINT prk_constraint_capacity PRIMARY KEY (id)
)WITHOUT OIDS;

------------------------------------------------------------
-- Table: PossederLiens
------------------------------------------------------------
CREATE TABLE dokkan.links(
	id_card           INT  NOT NULL ,
	id_linkskill INT  NOT NULL ,
	CONSTRAINT prk_constraint_links PRIMARY KEY (id_card,id_linkskill)
)WITHOUT OIDS;

ALTER TABLE dokkan.links ADD CONSTRAINT fk_links_id_card FOREIGN KEY (id_card) REFERENCES dokkan.card(id);
ALTER TABLE dokkan.links ADD CONSTRAINT fk_links_id_linkskill FOREIGN KEY (id_linkskill) REFERENCES dokkan.linkskill(id);

------------------------------------------------------------
-- Table: Se Composer
------------------------------------------------------------
CREATE TABLE dokkan.composedof(
	id_card      INT  NOT NULL ,
	id_team INT  NOT NULL ,
	CONSTRAINT prk_constraint_composedof PRIMARY KEY (id_card,id_team)
)WITHOUT OIDS;

ALTER TABLE dokkan.composedof ADD CONSTRAINT fk_composedof_id_card FOREIGN KEY (id_card) REFERENCES dokkan.card(id);
ALTER TABLE dokkan.composedof ADD CONSTRAINT fk_composedof_id_team FOREIGN KEY (id_team) REFERENCES dokkan.team(id);

------------------------------------------------------------
-- Table: Avoir Capacite
------------------------------------------------------------
CREATE TABLE dokkan.capacities(
	id_card      INT  NOT NULL ,
	id_capacity INT  NOT NULL ,
	CONSTRAINT prk_constraint_capacities PRIMARY KEY (id_card,id_capacity)
)WITHOUT OIDS;

ALTER TABLE dokkan.capacities ADD CONSTRAINT fk_capacities_id_card FOREIGN KEY (id_card) REFERENCES dokkan.card(id);
ALTER TABLE dokkan.capacities ADD CONSTRAINT fk_capacities_id_capacity FOREIGN KEY (id_capacity) REFERENCES dokkan.capacity(id);

------------------------------------------------------------
-- Table: Awake
------------------------------------------------------------
CREATE TABLE dokkan.awake(
	id_card      INT  NOT NULL ,
	id_medal INT  NOT NULL ,
	CONSTRAINT prk_constraint_awake PRIMARY KEY (id_card,id_medal)
)WITHOUT OIDS;

ALTER TABLE dokkan.awake ADD CONSTRAINT fk_awake_id_card FOREIGN KEY (id_card) REFERENCES dokkan.card(id);
ALTER TABLE dokkan.awake ADD CONSTRAINT fk_awake_id_medal FOREIGN KEY (id_medal) REFERENCES dokkan.medal(id);

------------------------------------------------------------
-- Table: How to Obtain
------------------------------------------------------------
CREATE TABLE dokkan.obtain(
	id_card      INT  NOT NULL ,
	id_event INT  NOT NULL ,
	CONSTRAINT prk_constraint_obtain PRIMARY KEY (id_card,id_event)
)WITHOUT OIDS;

ALTER TABLE dokkan.obtain ADD CONSTRAINT fk_obtain_id_card FOREIGN KEY (id_card) REFERENCES dokkan.card(id);
ALTER TABLE dokkan.obtain ADD CONSTRAINT fk_obtain_id_event FOREIGN KEY (id_event) REFERENCES dokkan.event(id);

------------------------------------------------------------
-- Table: Boss
------------------------------------------------------------
CREATE TABLE dokkan.boss(
	id_card      INT  NOT NULL ,
	id_event INT  NOT NULL ,
	CONSTRAINT prk_constraint_boss PRIMARY KEY (id_card,id_event)
)WITHOUT OIDS;

ALTER TABLE dokkan.boss ADD CONSTRAINT fk_boss_id_card FOREIGN KEY (id_card) REFERENCES dokkan.card(id);
ALTER TABLE dokkan.boss ADD CONSTRAINT fk_boss_id_event FOREIGN KEY (id_event) REFERENCES dokkan.event(id);

------------------------------------------------------------
-- Table: Team for Event
------------------------------------------------------------
CREATE TABLE dokkan.teamevent(
	id_team      INT  NOT NULL ,
	id_event INT  NOT NULL ,
	CONSTRAINT prk_constraint_teamevent PRIMARY KEY (id_team,id_event)
)WITHOUT OIDS;

ALTER TABLE dokkan.teamevent ADD CONSTRAINT fk_teamevent_id_team FOREIGN KEY (id_team) REFERENCES dokkan.team(id);
ALTER TABLE dokkan.teamevent ADD CONSTRAINT fk_teamevent_id_event FOREIGN KEY (id_event) REFERENCES dokkan.event(id);

------------------------------------------------------------
-- Table: Boss
------------------------------------------------------------
CREATE TABLE dokkan.eventlink(
	id_link      INT  NOT NULL ,
	id_event INT  NOT NULL ,
	CONSTRAINT prk_constraint_eventlink PRIMARY KEY (id_link,id_event)
)WITHOUT OIDS;

ALTER TABLE dokkan.eventlink ADD CONSTRAINT fk_eventlink_id_link FOREIGN KEY (id_link) REFERENCES dokkan.linkskill(id);
ALTER TABLE dokkan.eventlink ADD CONSTRAINT fk_eventlink_id_event FOREIGN KEY (id_event) REFERENCES dokkan.event(id);
