# lms-msvc-librarian
lms-msvc-librarian

# Database

Currently configured for AWS RDS database support. Support for H2 database included. Requires modification of both pom.xml and application.properties, configs are commented in place. File "data.sql" in resources directory contains schema and data, which is executed AFTER Hibernate intializes. This can lead to SQL errors such as table can't be created because it exists, table can't be dropped because of foreign key constraints, etc. To resolve, change "ddl-auto" setting to "update". As the data.sql script DROPS ALL TABLES, any previously persisted data will be lost, despite the "ddl-auto" setting. Lines can be commented out to maintain data persistence across application restarts.

