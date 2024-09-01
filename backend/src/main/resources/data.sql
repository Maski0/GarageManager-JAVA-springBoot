insert into employee(employee_id,employee_name, address, e_mail, ph_no, date_of_joining)
values (1,'Jatin','Uppal,Hyderabad','something@gmail.com', 9721346857, current_date());

insert into employee(employee_id,employee_name, address, e_mail, ph_no, date_of_joining)
values (2,'max','Raman,Hyderabad','something2@gmail.com', 7786759882, current_date());

insert into employee(employee_id,employee_name, address, e_mail, ph_no, date_of_joining)
values (3,'David','Sec,Hyderabad','something3@gmail.com', 7447474796, current_date());

insert into customer(customer_id,customer_name,address,e_mail, phone_number)
values (1, 'BSDK', 'sec,Hyderabad','something1@gmail.com',7447474796);

insert into customer(customer_id,customer_name,address,e_mail, phone_number)
values (2, 'max','Raman,Hyderabad','something2@gmail.com', 7786759882);

insert into customer(customer_id,customer_name,address,e_mail, phone_number)
values (3,'Jatin','Uppal,Hyderabad','something@gmail.com', 9721346857);

insert into service(service_id,service_name, service_description ,service_duration)
values (1,'PPF','Saasd  a ajghfz xa ghsfa gfajhx tghs ss', 3);

insert into service(service_id,service_name, service_description ,service_duration)
values (2,'Coating','Dsff', 4);

insert into vehicle (vehicle_id ,vehicle_plate_number,customer_id,make,model)
values (1,'adzpm123Hf231',1,'thar','Roxx');

insert into vehicle (vehicle_id ,vehicle_plate_number,customer_id,make,model)
values (2,'zxdff234Fshxc',2,'Swift','Desire');

insert into vehicle (vehicle_id ,vehicle_plate_number,customer_id,make,model)
values (3,'opaszxc132Sda',3,'nano','tata');


insert into booking (booking_id, service_id, vehicle_id, start_date, delivery_date, booking_status, service_price, total_amount_due)
values (1, 1, 1, current_date() , current_date(), 'undone', 5000, 5000);

insert into booking (booking_id, service_id, vehicle_id, start_date, delivery_date, booking_status, service_price, total_amount_due)
values (2, 1, 2, current_date() , current_date(), 'undone', 5000, 5000);

insert into booking (booking_id, service_id, vehicle_id, start_date, delivery_date, booking_status, service_price, total_amount_due)
values (3, 2, 3, current_date() , current_date(), 'undone', 5000, 5000);

insert into booking_employee (booking_id, employee_id)
values (1,1);

insert into booking_employee (booking_id, employee_id)
values (2,3);

insert into booking_employee (booking_id, employee_id)
values (3,2);


