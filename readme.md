Config file:
	src/main/resources/application.properties

Mysql:
	user: root
	password: a.......3
	jdbc:mysql://localhost:3306/dgaspc_app_db

Apache tomcat: 
	http://localhost:8080/
	
Site login:
	andreea.nicoara : a.......3
	sau update cu hash generat aici: https://bcrypt-generator.com/

Deploy:
	install java JRE 17, se verifica cu java -version
	build: <folderul proiectului, ex. dgaspc> mvn clean install
	Setup XAMPP: folder xampp > setup_xampp.bat
	run: java -jar dgaspcapp.jar

BACKUP:
mysqldump.exe -u root --hex-blob --max_allowed_packet=512M dgaspc_app_db > dgaspc_app_db_3.sql

RESTORE:
mysql.exe -u root -p --max_allowed_packet=512M dgaspc_app_db < dgaspc_app_db_3.sql