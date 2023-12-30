use learn_jpa;
ALTER TABLE products
    MODIFY COLUMN name VARCHAR(255);
INSERT INTO products (name, description, price, qteStock)
VALUES ('Tapis Royal', 'Tapis royal en soie avec motifs complexes', 850.00, 25),
       ('Ensemble de Vaisselle Cuivrée', 'Ensemble de vaisselle en cuivre martelé', 750.50, 18),
       ('Manteau en Velours', 'Manteau en velours traditionnel marocain', 920.00, 12),
       ('Table en Noyer', 'Table en bois de noyer avec incrustations', 880.99, 15),
       ('Lanterne Mauresque Géante', 'Lanterne mauresque géante en fer forgé', 720.00, 8),
       ('Canapé Marocain', 'Canapé marocain en bois sculpté et tissu', 980.50, 10),
       ('Robe de Soirée Caftan', 'Robe de soirée caftan en soie brodée', 850.99, 7),
       ('Service à Thé en Argent', 'Service à thé en argent massif gravé', 720.00, 20),
       ('Tapisserie Murale', 'Tapisserie murale avec scènes traditionnelles', 950.00, 5),
       ('Sac à Dos en Cuir', 'Sac à dos en cuir de qualité supérieure', 810.00, 15),
       ('Miroir en Mosaïque', 'Miroir mural en mosaïque avec couleurs vives', 680.50, 30),
       ('Chaise en Bois Sculpté', 'Chaise en bois sculpté avec coussin brodé', 890.99, 12),
       ('Bijoux en Or', 'Bijoux artisanaux en or avec pierres précieuses', 720.00, 25),
       ('Statuette en Bronze', 'Statuette en bronze représentant une danseuse', 950.99, 9),
       ('Service à Café Marocain', 'Service à café marocain en porcelaine fine', 780.50, 14);

INSERT INTO costumers (name, email, phone, adress)
VALUES ('Omar Benjelloun', 'omar.benjelloun@example.com', '+212600112233', '123 Avenue Mohammed V, Casablanca'),
       ('Laila El Khoury', 'laila.elkhoury@example.com', '+212600445566', '456 Rue Mohammed VI, Rabat'),
       ('Khalid El Mansouri', 'khalid.elmansouri@example.com', '+212600778899', '789 Boulevard Hassan II, Marrakech'),
       ('Yasmine Chakir', 'yasmine.chakir@example.com', '+212600334455', '234 Rue Mohammed V, Fès'),
       ('Mohammed Amiri', 'mohammed.amiri@example.com', '+212600667788', '567 Avenue Moulay Hassan, Agadir'),
       ('Nawal Bensouda', 'nawal.bensouda@example.com', '+212600112233', '890 Boulevard Mohammed VI, Tanger'),
       ('Hicham El Alaoui', 'hicham.alaoui@example.com', '+212600445566', '123 Rue Mohammed VI, Essaouira'),
       ('Samira El Fassi', 'samira.elfassi@example.com', '+212600778899', '456 Avenue Hassan II, Meknès'),
       ('Adil Zouhair', 'adil.zouhair@example.com', '+212600334455', '789 Boulevard Mohammed V, Oujda'),
       ('Saida Hamid', 'saida.hamid@example.com', '+212600667788', '234 Avenue Mohammed VI, Tetouan');

INSERT INTO costumers (name, email, phone, adress)
VALUES ('Marie Martin', 'marie.martin@example.com', '+212600445566', '456 Avenue Hassan II, Rabat'),
       ('Ahmed Amrani', 'ahmed.amrani@example.com', '+212600778899', '789 Boulevard Moulay Rachid, Marrakech'),
       ('Fatima Zouhair', 'fatima.zouhair@example.com', '+212600334455', '234 Rue Mohammed VI, Fès'),
       ('Hassan El Khattab', 'hassan.elkhattab@example.com', '+212600667788', '567 Avenue Mohammed V, Agadir'),
       ('Nadia Bensalem', 'nadia.bensalem@example.com', '+212600112233', '890 Boulevard Mohammed VI, Tanger'),
       ('Ali Hamid', 'ali.hamid@example.com', '+212600445566', '123 Rue Moulay Hassan, Essaouira'),
       ('Sara Benjelloun', 'sara.benjelloun@example.com', '+212600778899', '456 Avenue Mohammed VI, Meknès'),
       ('Karim El Mansouri', 'karim.elmansouri@example.com', '+212600334455', '789 Boulevard Mohammed V, Oujda'),
       ('Amina Chakir', 'amina.chakir@example.com', '+212600667788', '234 Avenue Hassan II, Tetouan');
-- Commandes pour le client avec l'ID 1
INSERT INTO orders (dateCreated, lastUpdated, status,custumer_id_fk) VALUES
                                                                                      ('2023-01-01 10:00:00', '2023-01-01 10:30:00', 'COMPLETED', 1),
                                                                                      ('2023-02-05 14:30:00', '2023-02-05 15:00:00', 'PREPARATION',1);