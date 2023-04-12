/*
 create roles table
*/
CREATE TABLE roles (
id_roles INT NOT NULL AUTO_INCREMENT,
code_role VARCHAR(30) NOT NULL,
nom_role VARCHAR(100) NOT NULL,
PRIMARY KEY (id_roles)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

/*
-----table utilisateur
*/
CREATE TABLE utilisateur(
id_user INT NOT NULL AUTO_INCREMENT,
login VARCHAR(100) NOT NULL,
`password` VARCHAR(200) NOT NULL,

PRIMARY KEY(id_user)
);

/*
---many TO many roles et USER 
*/
CREATE TABLE `roles_user` (
	id INT NOT NULL AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `roles_id` INT NOT NULL,
    PRIMARY KEY (id),
        FOREIGN KEY (`user_id`) REFERENCES `utilisateur` (`id_user`)
        ON DELETE CASCADE ON UPDATE CASCADE,
        FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id_roles`)
        ON DELETE CASCADE ON UPDATE CASCADE
);


/*
-----table employe
*/
CREATE TABLE employe(
id_employe INT NOT NULL AUTO_INCREMENT,
nom VARCHAR(100) NOT NULL,
prenom VARCHAR(100) NOT NULL,
`adresse` VARCHAR(200) NOT NULL,
nationalite VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL,
`phone` VARCHAR(200) NOT NULL,
date_embauche DATETIME NOT NULL,
specialite VARCHAR(100) NOT NULL,
`description` VARCHAR(200) NOT NULL,
photo VARCHAR(150) NOT NULL,
cv VARCHAR(150) NOT NULL,

PRIMARY KEY (id_employe)
);


/*
-----table clients
*/
CREATE TABLE `client`(
id_client INT NOT NULL AUTO_INCREMENT,
nom_client VARCHAR(100) NOT NULL,
`adresse` VARCHAR(200) NOT NULL,
siteweb VARCHAR(200) NOT NULL,
email VARCHAR(100) NOT NULL,
`description` VARCHAR(200) NOT NULL,

PRIMARY KEY (id_client)
);

/*
-----table projet
*/
CREATE TABLE projet(
id_projet INT NOT NULL AUTO_INCREMENT,
code_projet VARCHAR(50) NOT NULL,
nom_projet VARCHAR (250),
 `description` TEXT,
 id_client INT,
PRIMARY KEY (id_projet),
 FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`)
 );
 
 /*
 -----table affecation
*/
 CREATE TABLE affectation(
 id_affectation INT NOT NULL AUTO_INCREMENT, 
 id_employe INT, 
 id_projet INT,
 date_debut DATETIME, 
 date_fin DATETIME,
PRIMARY KEY(id_affectation),
FOREIGN KEY (`id_employe`) REFERENCES `employe` (`id_employe`),
FOREIGN KEY (`id_projet`) REFERENCES `projet` (`id_projet`)
 )

