package org.example;

import org.example.entities.*;
import org.example.repositories.*;
import org.example.services.ClienteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("org.example.repositories")
@EntityScan("org.example.entities")
public class Main {

    public static void main(String[] args) { SpringApplication.run(Main.class, args); }

    @Bean
    public CommandLineRunner mappingDemo (
        //ClienteService clienteService
        ClienteRepository clienteRepository,
        UsuarioRepository usuarioRepository,
        AuthorityRepository authorityRepository,
        SolicitudProductoRepository solicitudProductoRepository,
        DetallePedidoRepository detallePedidoRepository,
        EstadoSolicitudRepository estadoSolicitudRepository,
        TipoDePagoRepository tipoDePagoRepository,
        DeliveryRepository deliveryRepository,
        ProveedorRepository proveedorRepository,
        EstacionRepository estacionRepository,
        UbigeoRepository ubigeoRepository,
        StockProductoRepository stockProductoRepository,
        ProductoRepository productoRepository,
        TipoProductoRepository tipoProductoRepository
    ) {
        return args -> {
            // **DATOS DE CLIENTES**
            Cliente cliente1 = new Cliente(0L, "C001", "mariaGomez@gmail.com", "Maria Alejandra Gomez Torres", "987654321", "12345678", "Av. La Marina 123, Lima", null, null);
            Cliente cliente2 = new Cliente(0L, "C002", "joseFernandez@gmail.com", "Jose Manuel Fernandez Castro", "923456789", "87654321", "Jr. Los Olivos 456, Arequipa", null, null);
            Cliente cliente3 = new Cliente(0L, "C003", "sofiaMorales@gmail.com", "Sofia Isabel Morales Ruiz", "912345678", "98765432", "Calle Real 789, Trujillo", null, null);
            Cliente cliente4 = new Cliente(0L, "C004", "carlosMartinez@gmail.com", "Carlos Enrique Martinez Rojas", "934567890", "87654322", "Av. Universitaria 456, Cusco", null, null);
            Cliente cliente5 = new Cliente(0L, "C005", "anaVera@gmail.com", "Ana Maria Vera Flores", "945678123", "76543210", "Jr. Independencia 234, Iquitos", null, null);
            clienteRepository.saveAll(List.of(cliente1, cliente2, cliente3, cliente4, cliente5));

            /*cliente1 = clienteRepository.save(cliente1); System.out.println(cliente1);
            cliente2 = clienteRepository.save(cliente2); System.out.println(cliente2);
            cliente3 = clienteRepository.save(cliente3); System.out.println(cliente3);
            cliente4 = clienteRepository.save(cliente4); System.out.println(cliente4);
            cliente5 = clienteRepository.save(cliente5); System.out.println(cliente5);*/

            // **DATOS DE AUTHORITIES**
            Authority authority1 = new Authority(0L, "ROLE_ADMIN", null);
            Authority authority2 = new Authority(0L, "ROLE_USER", null);
            authorityRepository.saveAll(List.of(authority1, authority2));

            /*authority1 = authorityRepository.save(authority1);
            authority2 = authorityRepository.save(authority2);*/

            // **DATOS DE USUARIOS**
            /*Usuario usuario1 = new Usuario(0L, "Mgomez", "password123", true, clienteRepository.findById(1L).get(), authorityRepository.findById(1L).get(), null);
            Usuario usuario2 = new Usuario(0L, "Jfernandez", "password456", true, clienteRepository.findById(2L).get(), authorityRepository.findById(2L).get(), null);
            Usuario usuario3 = new Usuario(0L, "Smorales", "password789", true, clienteRepository.findById(3L).get(), authorityRepository.findById(1L).get(), null);
            Usuario usuario4 = new Usuario(0L, "Cmartinez", "password321", true, clienteRepository.findById(4L).get(), authorityRepository.findById(2L).get(), null);
            Usuario usuario5 = new Usuario(0L, "Avera", "password654", true, clienteRepository.findById(5L).get(), authorityRepository.findById(2L).get(), null);*/
            Usuario usuario1 = new Usuario(0L, "Mgomez", "password123", true, clienteRepository.findById(1L).get(), null);
            Usuario usuario2 = new Usuario(0L, "Jfernandez", "password456", true, clienteRepository.findById(2L).get(), null);
            Usuario usuario3 = new Usuario(0L, "Smorales", "password789", true, clienteRepository.findById(3L).get(), null);
            Usuario usuario4 = new Usuario(0L, "Cmartinez", "password321", true, clienteRepository.findById(4L).get(), null);
            Usuario usuario5 = new Usuario(0L, "Avera", "password654", true, clienteRepository.findById(5L).get(), null);
            usuarioRepository.saveAll(List.of(usuario1, usuario2, usuario3, usuario4, usuario5));

            /*usuario1 = usuarioRepository.save(usuario1); System.out.println(usuario1);
            usuario2 = usuarioRepository.save(usuario2); System.out.println(usuario2);
            usuario3 = usuarioRepository.save(usuario3); System.out.println(usuario3);
            usuario4 = usuarioRepository.save(usuario4); System.out.println(usuario4);
            usuario5 = usuarioRepository.save(usuario5); System.out.println(usuario5);*/

            // **DATOS DE SOLICITUDES DE PRODUCTO**
            SolicitudProducto solicitud1 = new SolicitudProducto(0L, LocalDate.of(2023, 8, 1), LocalTime.of(14, 30), 350.00, "Tarjeta", LocalDate.of(2023, 8, 2), 10, clienteRepository.findById(1L).get(), null, null, null, null);
            SolicitudProducto solicitud2 = new SolicitudProducto(0L, LocalDate.of(2023, 9, 10), LocalTime.of(10, 45), 150.00, "Contra Entrega", LocalDate.of(2023, 9, 11), 5, clienteRepository.findById(2L).get(), null, null, null, null);
            SolicitudProducto solicitud3 = new SolicitudProducto(0L, LocalDate.of(2023, 7, 15), LocalTime.of(8, 15), 500.00, "Tarjeta", LocalDate.of(2023, 7, 16), 20, clienteRepository.findById(3L).get(), null, null, null, null);
            SolicitudProducto solicitud4 = new SolicitudProducto(0L, LocalDate.of(2023, 6, 20), LocalTime.of(12, 0), 400.00, "Contra Entrega", LocalDate.of(2023, 6, 21), 15, clienteRepository.findById(4L).get(), null, null, null, null);
            SolicitudProducto solicitud5 = new SolicitudProducto(0L, LocalDate.of(2023, 8, 5), LocalTime.of(16, 45), 600.00, "Tarjeta", LocalDate.of(2023, 8, 6), 25, clienteRepository.findById(5L).get(), null, null, null, null);
            solicitudProductoRepository.saveAll(List.of(solicitud1, solicitud2, solicitud3, solicitud4, solicitud5));

            /*solicitud1 = solicitudProductoRepository.save(solicitud1);
            solicitud2 = solicitudProductoRepository.save(solicitud2);
            solicitud3 = solicitudProductoRepository.save(solicitud3);
            solicitud4 = solicitudProductoRepository.save(solicitud4);
            solicitud5 = solicitudProductoRepository.save(solicitud5);*/

            // **DATOS DE DETALLES DE PEDIDO**
            DetallePedido detalle1 = new DetallePedido(0L, 5, 50.00, solicitudProductoRepository.findById(1L).get(), null);
            DetallePedido detalle2 = new DetallePedido(0L, 10, 30.00, solicitudProductoRepository.findById(2L).get(), null);
            DetallePedido detalle3 = new DetallePedido(0L, 15, 40.00, solicitudProductoRepository.findById(3L).get(), null);
            DetallePedido detalle4 = new DetallePedido(0L, 8, 60.00, solicitudProductoRepository.findById(4L).get(), null);
            DetallePedido detalle5 = new DetallePedido(0L, 12, 45.00, solicitudProductoRepository.findById(5L).get(), null);
            detallePedidoRepository.saveAll(List.of(detalle1, detalle2, detalle3, detalle4, detalle5));

            /*detalle1 = detallePedidoRepository.save(detalle1);
            detalle2 = detallePedidoRepository.save(detalle2);
            detalle3 = detallePedidoRepository.save(detalle3);
            detalle4 = detallePedidoRepository.save(detalle4);
            detalle5 = detallePedidoRepository.save(detalle5);*/

            // **DATOS DE ESTADO SOLICITUD**
            EstadoSolicitud estado1 = new EstadoSolicitud(0L, "En Proceso", null);
            EstadoSolicitud estado2 = new EstadoSolicitud(0L, "Completado", null);
            EstadoSolicitud estado3 = new EstadoSolicitud(0L, "Cancelado", null);
            EstadoSolicitud estado4 = new EstadoSolicitud(0L, "Enviando", null);
            EstadoSolicitud estado5 = new EstadoSolicitud(0L, "Entregado", null);
            estadoSolicitudRepository.saveAll(List.of(estado1, estado2, estado3, estado4, estado5));

            /*estado1 = estadoSolicitudRepository.save(estado1);
            estado2 = estadoSolicitudRepository.save(estado2);
            estado3 = estadoSolicitudRepository.save(estado3);
            estado4 = estadoSolicitudRepository.save(estado4);
            estado5 = estadoSolicitudRepository.save(estado5);*/

            // **DATOS DE TIPOS DE PAGO**
            TipoDePago tipoPago1 = new TipoDePago(0L, true, false, null); // Pago contra entrega
            TipoDePago tipoPago2 = new TipoDePago(0L, false, true, null); // Pago con tarjeta
            TipoDePago tipoPago3 = new TipoDePago(0L, true, true, null);  // Ambos métodos
            TipoDePago tipoPago4 = new TipoDePago(0L, true, false, null); // Solo contra entrega
            TipoDePago tipoPago5 = new TipoDePago(0L, false, true, null); // Solo tarjeta
            tipoDePagoRepository.saveAll(List.of(tipoPago1, tipoPago2, tipoPago3, tipoPago4, tipoPago5));

            /*tipoPago1 = tipoDePagoRepository.save(tipoPago1);
            tipoPago2 = tipoDePagoRepository.save(tipoPago2);
            tipoPago3 = tipoDePagoRepository.save(tipoPago3);
            tipoPago4 = tipoDePagoRepository.save(tipoPago4);
            tipoPago5 = tipoDePagoRepository.save(tipoPago5);*/

            // **DATOS DE DELIVERIES**
            Delivery delivery1 = new Delivery(0L, "Express", "Av. La Marina 123, Lima", LocalDate.of(2023, 8, 2), LocalTime.of(15, 30), 20.00, null, null);
            Delivery delivery2 = new Delivery(0L, "Normal", "Jr. Los Olivos 456, Arequipa", LocalDate.of(2023, 9, 11), LocalTime.of(12, 0), 10.00, null, null);
            Delivery delivery3 = new Delivery(0L, "Urgente", "Calle Real 789, Trujillo", LocalDate.of(2023, 7, 16), LocalTime.of(9, 0), 15.00, null, null);
            Delivery delivery4 = new Delivery(0L, "Express", "Av. Universitaria 456, Cusco", LocalDate.of(2023, 6, 21), LocalTime.of(14, 0), 18.00, null, null);
            Delivery delivery5 = new Delivery(0L, "Normal", "Jr. Independencia 234, Iquitos", LocalDate.of(2023, 8, 6), LocalTime.of(17, 0), 12.00, null, null);
            deliveryRepository.saveAll(List.of(delivery1, delivery2, delivery3, delivery4, delivery5));

            /*delivery1 = deliveryRepository.save(delivery1);
            delivery2 = deliveryRepository.save(delivery2);
            delivery3 = deliveryRepository.save(delivery3);
            delivery4 = deliveryRepository.save(delivery4);
            delivery5 = deliveryRepository.save(delivery5);*/

            // **DATOS DE PROVEEDORES**
            Proveedor proveedor1 = new Proveedor(0L, "Proveedor 1", "923456789", "proveedor1@gmail.com", "Av. Proveedores 123, Lima", null);
            Proveedor proveedor2 = new Proveedor(0L, "Proveedor 2", "987654321", "proveedor2@gmail.com", "Av. Industriales 456, Arequipa", null);
            Proveedor proveedor3 = new Proveedor(0L, "Proveedor 3", "912345678", "proveedor3@gmail.com", "Av. Comercio 789, Trujillo", null);
            Proveedor proveedor4 = new Proveedor(0L, "Proveedor 4", "934567890", "proveedor4@gmail.com", "Jr. Mercaderes 123, Cusco", null);
            Proveedor proveedor5 = new Proveedor(0L, "Proveedor 5", "945678123", "proveedor5@gmail.com", "Jr. Negocios 456, Iquitos", null);
            proveedorRepository.saveAll(List.of(proveedor1, proveedor2, proveedor3, proveedor4, proveedor5));

            /*proveedor1 = proveedorRepository.save(proveedor1);
            proveedor2 = proveedorRepository.save(proveedor2);
            proveedor3 = proveedorRepository.save(proveedor3);
            proveedor4 = proveedorRepository.save(proveedor4);
            proveedor5 = proveedorRepository.save(proveedor5);*/

            // **DATOS DE ESTACIONES**
            Estacion estacion1 = new Estacion(0L, "Estación 1", "Av. La Marina 123, Lima", "987654321", proveedorRepository.findById(1L).get(), null, null, null);
            Estacion estacion2 = new Estacion(0L, "Estación 2", "Jr. Los Olivos 456, Arequipa", "923456789", proveedorRepository.findById(2L).get(), null, null, null);
            Estacion estacion3 = new Estacion(0L, "Estación 3", "Calle Real 789, Trujillo", "912345678", proveedorRepository.findById(3L).get(), null, null, null);
            Estacion estacion4 = new Estacion(0L, "Estación 4", "Av. Universitaria 456, Cusco", "934567890", proveedorRepository.findById(4L).get(), null, null, null);
            Estacion estacion5 = new Estacion(0L, "Estación 5", "Jr. Independencia 234, Iquitos", "945678123", proveedorRepository.findById(5L).get(), null, null, null);
            estacionRepository.saveAll(List.of(estacion1, estacion2, estacion3, estacion4, estacion5));

            /*estacion1 = estacionRepository.save(estacion1);
            estacion2 = estacionRepository.save(estacion2);
            estacion3 = estacionRepository.save(estacion3);
            estacion4 = estacionRepository.save(estacion4);
            estacion5 = estacionRepository.save(estacion5);*/

            // **DATOS DE UBIGEOS**
            Ubigeo ubigeo1 = new Ubigeo(0L, "Lima", "Lima");
            Ubigeo ubigeo2 = new Ubigeo(0L, "Arequipa", "Cercado");
            Ubigeo ubigeo3 = new Ubigeo(0L, "Trujillo", "Víctor Larco");
            Ubigeo ubigeo4 = new Ubigeo(0L, "Cusco", "Wanchaq");
            Ubigeo ubigeo5 = new Ubigeo(0L, "Iquitos", "San Juan Bautista");
            ubigeoRepository.saveAll(List.of(ubigeo1, ubigeo2, ubigeo3, ubigeo4, ubigeo5));

            /*ubigeo1 = ubigeoRepository.save(ubigeo1);
            ubigeo2 = ubigeoRepository.save(ubigeo2);
            ubigeo3 = ubigeoRepository.save(ubigeo3);
            ubigeo4 = ubigeoRepository.save(ubigeo4);
            ubigeo5 = ubigeoRepository.save(ubigeo5);*/

            // **DATOS DE TIPOS DE PRODUCTO**
            TipoProducto tipoProducto1 = new TipoProducto(0L, "Combustible", "Gasolina, Diesel, etc", null);
            TipoProducto tipoProducto2 = new TipoProducto(0L, "Lubricante", "Aceite, aditivos", null);
            TipoProducto tipoProducto3 = new TipoProducto(0L, "Accesorios", "Llantas, luces", null);
            TipoProducto tipoProducto4 = new TipoProducto(0L, "Repuestos", "Filtros, bujias", null);
            TipoProducto tipoProducto5 = new TipoProducto(0L, "Herramientas", "Llaves, gatos", null);
            tipoProductoRepository.saveAll(List.of(tipoProducto1, tipoProducto2, tipoProducto3, tipoProducto4, tipoProducto5));

            /*tipoProducto1 = tipoProductoRepository.save(tipoProducto1);
            tipoProducto2 = tipoProductoRepository.save(tipoProducto2);
            tipoProducto3 = tipoProductoRepository.save(tipoProducto3);
            tipoProducto4 = tipoProductoRepository.save(tipoProducto4);
            tipoProducto5 = tipoProductoRepository.save(tipoProducto5);*/

            // **DATOS DE PRODUCTOS**
            Producto producto1 = new Producto(0L, 100.00, tipoProductoRepository.findById(1).get(), null);
            Producto producto2 = new Producto(0L, 200.00, tipoProductoRepository.findById(2).get(), null);
            Producto producto3 = new Producto(0L, 150.00, tipoProductoRepository.findById(3).get(), null);
            Producto producto4 = new Producto(0L, 120.00, tipoProductoRepository.findById(4).get(), null);
            Producto producto5 = new Producto(0L, 180.00, tipoProductoRepository.findById(5).get(), null);
            productoRepository.saveAll(List.of(producto1, producto2, producto3, producto4, producto5));

            /*producto1 = productoRepository.save(producto1);
            producto2 = productoRepository.save(producto2);
            producto3 = productoRepository.save(producto3);
            producto4 = productoRepository.save(producto4);
            producto5 = productoRepository.save(producto5);*/

            // **DATOS DE STOCK PRODUCTO**
            StockProducto stockProducto1 = new StockProducto(0L, 50, 100.00, productoRepository.findById(1L).get(), estacionRepository.findById(1L).get());
            StockProducto stockProducto2 = new StockProducto(0L, 70, 200.00, productoRepository.findById(2L).get(), estacionRepository.findById(2L).get());
            StockProducto stockProducto3 = new StockProducto(0L, 60, 150.00, productoRepository.findById(3L).get(), estacionRepository.findById(3L).get());
            StockProducto stockProducto4 = new StockProducto(0L, 80, 120.00, productoRepository.findById(4L).get(), estacionRepository.findById(4L).get());
            StockProducto stockProducto5 = new StockProducto(0L, 90, 180.00, productoRepository.findById(5L).get(), estacionRepository.findById(5L).get());
            stockProductoRepository.saveAll(List.of(stockProducto1, stockProducto2, stockProducto3, stockProducto4, stockProducto5));

            /*stockProducto1 = stockProductoRepository.save(stockProducto1);
            stockProducto2 = stockProductoRepository.save(stockProducto2);
            stockProducto3 = stockProductoRepository.save(stockProducto3);
            stockProducto4 = stockProductoRepository.save(stockProducto4);
            stockProducto5 = stockProductoRepository.save(stockProducto5);*/
        };
    }
}