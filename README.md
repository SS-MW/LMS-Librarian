# lms-msvc-librarian
lms-msvc-librarian

# Database

Utilizes H2 database (file based @ /data/lms-db, change in application.properties). File "data.sql" in resources directory contains schema and data, which is executed AFTER Hibernate intializes. This can lead to SQL errors such as table cant' be created because it exists, table can't be dropped because of foreign key constraints, etc. To resolve, change "ddl-auto" setting to "update". As the data.sql script DROPS ALL TABLES, any previously persisted data will be lost, despited the "ddl-auto" setting. Lines can be commented out to maintain data persistence across application restarts.

