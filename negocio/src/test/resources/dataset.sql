/* Administrador : cedula, correo, nombre, password */
insert into administrador values ("111", "admin1@gmail.com", "Lau" , "123");
insert into administrador values ("222", "admin2@gmail.com", "Juan" , "000");
insert into administrador values ("333", "admin3@gmail.com", "Sara" , "345");
insert into administrador values ("444", "admin4@gmail.com", "Andres" , "678");

/* Administrador_telefonos : cedula, telefonos*/
insert into administrador_telefonos values ("444", "3124567900");
insert into administrador_telefonos values ("111", "3125000905");
insert into administrador_telefonos values ("333", "323567900");
insert into administrador_telefonos values ("222", "3185000905");

/* Provedor: cedula, correo, nombre*/
insert into provedor values ("11", "provedor1@gmail.com", "Alirio");
insert into provedor values ("22", "provedor2@gmail.com", "Jesus");
insert into provedor values ("33", "provedor3@gmail.com", "Eduardo");
insert into provedor values ("44", "provedor4@gmail.com", "Sandra");

/* Provedor_telefonos : cedula, telefonos*/
insert into provedor_telefonos values ("11", "3147569100");
insert into provedor_telefonos values ("22", "3134590990");
insert into provedor_telefonos values ("33", "3124933011");
insert into provedor_telefonos values ("44", "3155289287");

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


/* Empleado : cedula, correo, nombre ,password*/
insert into empleado values ("0111", "empleado1@gmail.com", "Andres" ,"010");
insert into empleado values ("0222", "empleado2@gmail.com", "Karla","020");
insert into empleado values ("0333", "empleado3@gmail.com", "Noah","030");
insert into empleado values ("0444", "empleado4@gmail.com", "Diana","040");


/* Empleado_telefonos : cedula, telefonos*/
insert into empleado_telefonos values ("0111", "3123456100");
insert into empleado_telefonos values ("0111", "3136767990");
insert into empleado_telefonos values ("0222", "3128965011");
insert into empleado_telefonos values ("0333", "3156622287");

/* Categoria : codigo, nombre*/
insert into categoria values (1, "Aseo");
insert into categoria values (2, "Granos");
insert into categoria values (3, "Lacteos");
insert into categoria values (4, "Pasabocas");
insert into categoria values (5, "Bebidas");
insert into categoria values (6, "Helados");

/* descuento : codigo, porcentaje*/
insert into descuento values (1,30);
insert into descuento values (2,10);
insert into descuento values (3,15);
insert into descuento values (4,5);

/* Factura: codigo, fecha, total, cliente_cedula, empleado_cedula*/
insert into factura values(1,"2022-10-01",3600,"1111","0222");
insert into factura values(2,"2022-11-05",78000,"2222","0111");
insert into factura values(3,"2022-10-08",15400,"2222","0444");
insert into factura values(4,"2022-12-09",140000,"3333","0111");


/* Pedido: codigo, cantidad, fecha, total, administrador_cedula,provedor_cedula*/
insert into pedido values(1,16,"2022-05-01",100000,"111","44");
insert into pedido values(2,8,"2022-10-06",50000,"111","33");
insert into pedido values(3,12,"2022-07-02",300000,"111","22");
insert into pedido values(4,15,"2022-09-09",450000,"111","11");

/* Producto: codigo, descuento, nombre, precio, unidades, categoria_codigo */
insert into producto values(1,  0.30, "2022-10-01",  "Palomitas",1500, 20, 2);
insert into producto values(2,  null, "2023-04-05",  "Jabon", 5000, 50, 1);
insert into producto values(3,  0.10, "2024-10-01",  "Frijoles", 7300, 70, 2);
insert into producto values(4,  0.20, "2022-10-08",  "papas", 6800, 45, 4);
insert into producto values(5,  0.50, "2023-12-20",  "Limpido", 1400, 42, 1);
insert into producto values(6,  null, "2025-10-19",  "esponja", 7800, 13, 1);




