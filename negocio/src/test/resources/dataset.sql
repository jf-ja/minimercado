/* Administrador : cedula, correo, nombre, password */
insert into administrador values ("1111", "admin1@gmail.com", "Lau" , "123");
insert into administrador values ("2222", "admin1@gmail.com", "Juan" , "000");
insert into administrador values ("3333", "admin1@gmail.com", "Sara" , "345");
insert into administrador values ("4444", "admin1@gmail.com", "Andres" , "678");

/* Administrador_telefonos : cedula, telefonos*/
insert into administrador_telefonos values ("4444", "3124567900");
insert into administrador_telefonos values ("1111", "3125000905");
insert into administrador_telefonos values ("3333", "323567900");
insert into administrador_telefonos values ("2222", "3185000905");

/* Provedor: cedula, correo, nombre*/
insert into provedor values ("1111", "provedor1@gmail.com", "Alirio");
insert into provedor values ("2222", "provedor2@gmail.com", "Jesus");
insert into provedor values ("3333", "provedor3@gmail.com", "Eduardo");
insert into provedor values ("4444", "provedor4@gmail.com", "Sandra");

/* Provedor_telefonos : cedula, telefonos*/
insert into provedor_telefonos values ("1111", "3147569100");
insert into provedor_telefonos values ("2222", "3134590990");
insert into provedor_telefonos values ("3333", "3124933011");
insert into provedor_telefonos values ("4444", "3155289287");

/* Cliente : cedula, correo, nombre */
insert into cliente values ("1111", "cliente1@gmail.com", "Carmen");
insert into cliente values ("2222", "cliente2@gmail.com", "Maria");
insert into cliente values ("3333", "cliente3@gmail.com", "Sofia");
insert into cliente values ("4444", "cliente4@gmail.com", "David");

/* Cliente_telefonos : cedula, telefonos*/
insert into cliente_telefonos values ("1111", "3111111100");
insert into cliente_telefonos values ("1111", "3134567990");
insert into cliente_telefonos values ("2222", "3124965011");
insert into cliente_telefonos values ("3333", "3155222287");

/* Empleado : cedula, correo, nombre */
insert into cliente values ("1111", "empleado1@gmail.com", "Andres");
insert into cliente values ("2222", "empleado2@gmail.com", "Karla");
insert into cliente values ("3333", "empleado3@gmail.com", "Noah");
insert into cliente values ("4444", "empleado4@gmail.com", "Diana");

/* Empleado_telefonos : cedula, telefonos*/
insert into cliente_telefonos values ("1111", "3123456100");
insert into cliente_telefonos values ("1111", "3136767990");
insert into cliente_telefonos values ("2222", "3128965011");
insert into cliente_telefonos values ("3333", "3156622287");

/* Categoria : codigo, nombre*/
insert into categoria values (1, "Aseo");
insert into categoria values (2, "Granos");
insert into categoria values (3, "Lacteos");
insert into categoria values (4, "Pasabocas");

/* descuento : codigo, porcentaje*/
insert into descuento values (1,30);
insert into descuento values (2,10);
insert into descuento values (3,15);
insert into descuento values (4,5);

/* Fecha: codigo, año, dia, mes*/
insert into fecha values(1,"2021","1","Enero");
insert into fecha values(2,"2021","2","Febrero");
insert into fecha values(3,"2021","3","Marzo");
insert into fecha values(4,"2021","4","Abril");

/* Factura: codigo, total, cliente_cedula, empleado_cedula, fecha_codigo*/
insert into factura values(1,3600,"1111","2222",1);
insert into factura values(1,78000,"2222","1111",2);
insert into factura values(1,3600,"1111","44444",3);
insert into factura values(1,78000,"3333","1111",4);

/* Pedido: codigo, cantidad, total, administrador_cedula, fecha_codigo, provedor_cedula*/
insert into pedido values(1,10,100,"1111","1","4444");
insert into pedido values(2,20,200,"2222","1","3333");
insert into pedido values(3,30,300,"3333","1","2222");
insert into pedido values(4,40,400,"4444","1","1111");

/* Producto: codigo, nombre, precio, unidades, categoria_codigo, descuento_codigo, fecha_codigo*/
insert into producto values(1, "Palomitas",1500, 20, 4, 2, 3);
insert into producto values(1, "Jabon", 5000, 50, 1, 2, 3);
insert into producto values(1, "Frijoles", 7300, 70, 2, 2, 3);
insert into producto values(1, "Leche", 4800, 40, 3, 2, 3);

/* Factura_Producto: codigo,factura_codigo, producto_codigo */
insert into factura_producto values(1,4,3);
insert into factura_producto values(2,3,4);
insert into factura_producto values(3,2,1);
insert into factura_producto values(4,1,2);

/* Pedido_Producto: codigo, pedido_codigo, producto_codigo*/
insert into pedido_producto values(1,1,4);
insert into pedido_producto values(2,3,3);
insert into pedido_producto values(3,2,2);
insert into pedido_producto values(4,4,1);


