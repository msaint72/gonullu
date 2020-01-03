insert into causes(id,name) values(30001,'İnsan Hakları');
insert into causes(id,name) values(30002,'Dini Kurumlar');
insert into causes(id,name) values(30003,'Sağlık');
insert into causes(id,name) values(30004,'Çevre');
insert into causes(id,name) values(30005,'Hayvanlar');
insert into causes(id,name) values(30006,'Kültür ve Sanat');
insert into addresses(id,address,province,district,zip_code) values (20001,'Kuşcağız Mah. No:10 Tepebaşı','Ankara','Keçiören','06180');

insert into users(id,first_name, last_name, user_id,encrypted_password, profile_image, mobile_phone, email, date_of_birth, tshirt_size, gender, emergency_contact_number, emergency_contact_name, motivation,
    affiliation,school_name, company_name, get_info_mails, invisible) values
        (40001,'Mahmut','Eren','w06cZsKt4X94pGXMu2Uvvch68D5Vd3','$2a$10$A.OSmqsBqIK3MIy4GBOg7OBqbc9Al1vTsmuITNPnW4XkPYQbb35MS',null,'+905332394700','test@test.com','1972-06-29','M','E','+905332394799','Hayati Çalık','abele gübele',true,null,'Gönüllü.Com',true,true);

insert into organizations(id,name,summary,phone,web,address_id,admin_user_id) values(10001,'Çocuk Esirgeme Kurumu','abele gübele','+903122000000','http://cocukesirgeme.gov.tr',20001,40001);
insert into organization_cause(organization_id,cause_id) values(10001,30001);
insert into organization_cause(organization_id,cause_id) values(10001,30003);
insert into organization_cause(organization_id,cause_id) values(10001,30006);
insert into user_cause(user_id,cause_id) values(40001,30002);
insert into user_cause(user_id,cause_id) values(40001,30003);

