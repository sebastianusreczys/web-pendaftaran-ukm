create table s_users(
id varchar(36),
nim varchar(9) not null,
nama varchar(255) not null,
email varchar(255) not null,
jenis_kelamain varchar(100) not null,
id_jurusan varchar(36) not null,
id_ukm varchar(36) not null,
PRIMARY KEY(id),
 foreign key (id_jurusan) references s_jurusan(id),
  foreign key (id_ukm) references s_ukm(id) 
) Engine = InnoDB;

create table s_jurusan(
id varchar(36),
jurusan varchar(255) not null,
primary key(id)
) Engine = InnoDB;

create table s_ukm(
id varchar(36),
nama_ukm varchar(255) not null,
primary key(id)
) Engine = InnoDB;


insert into s_jurusan values('J001', 'Informatika');
insert into s_jurusan values('J002', 'Teknik Elektro');
insert into s_jurusan values('J003', 'Matematika');
insert into s_jurusan values('J004', 'Teknik Mesin');


insert into s_ukm values('KM001', 'Futsal');
insert into s_ukm values('KM002', 'Sepak Bola');
insert into s_ukm values('KM003', 'Basket');
insert into s_ukm values('KM004', 'Bulu Tangkis');



select nim, nama, email, jenis_kelamain, jurusan, nama_ukm from s_users
inner join s_jurusan on s_users.id_jurusan = s_jurusan.id
inner join s_ukm on s_users.id_ukm = s_ukm.id;