/*
or replace roles_user
*/
CREATE or REPLACE TABLE `roles_user` (
    `user_id` INT NOT NULL,
    `roles_id` INT NOT NULL,
    KEY `user_fk_idx` (`user_id`),
    KEY `roles_fk_idx` (`roles_id`),
    CONSTRAINT `roles_fk` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id_roles`),
    CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `utilisateur` (`id_user`)
);