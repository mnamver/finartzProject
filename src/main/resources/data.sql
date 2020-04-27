INSERT INTO AIRPORT (id, name, phone, city, address) VALUES (1, 'IGA', '+90 212 6789056', 'İstanbul', 'Yeşilköy Mahallesi, Havaalanı Cad. No:3/1 34149 Bakırköy, İstanbul/Türkiye');
INSERT INTO AIRPORT (id, name, phone, city, address) VALUES (2, 'Sabiha Gökçen', '+90 216 5678966', 'İstanbul', 'Kurtköy, Osmanlı Blv. Aeropark 11/A, 34912 Pendik/İstanbul');

INSERT INTO AIR_CARRIER (id, name, number_of_aircraft, number_of_destination, phone) VALUES(1, 'Türk Hava Yolları', 215, 1200, '+90 212 9988765' );
INSERT INTO AIR_CARRIER (id, name, number_of_aircraft, number_of_destination, phone) VALUES(2, 'Pegasus', 130, 700, '+90 212 9807658');

INSERT INTO FLIGHTS (id, available_seat, flight_code, price, route_code, total_seat) VALUES(1, 185, 'TK1001', 120, 'ROTA100', 200);
INSERT INTO FLIGHTS (id, available_seat, flight_code, price, route_code, total_seat) VALUES(2, 160, 'TK1002', 80, 'ROTA102', 200);

INSERT INTO ROUTE (id, arrival_date, departure, departure_date, destination, distance, route_code) VALUES(1, '2020-04-28 14:03:01.146' , 'IGA', '2020-04-28 22:03:01.146', 'New York JFK' ,1200, 'ROTA100');
INSERT INTO ROUTE (id, arrival_date, departure, departure_date, destination, distance, route_code) VALUES(2, '2020-04-28 14:03:01.146' , 'IGA', '2020-04-28 22:03:01.146', 'Paris Airport' ,1200, 'ROTA102');


