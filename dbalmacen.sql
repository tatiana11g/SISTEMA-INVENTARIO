-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-11-2022 a las 20:06:26
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbalmacen`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_recibos` (IN `id` INT)   BEGIN
select * from tblRecibos where IdRecibos = id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_disminuir_stock` (IN `idprod` VARCHAR(45), IN `st` INT)   begin
update tblAlmacen set Stock = Stock - st where IdAlmacen = idprod;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_editar_lineas` (IN `id` INT, IN `linea` VARCHAR(45))   BEGIN
UPDATE tblLineas SET Nombre=linea WHERE IdLineas = id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_editar_proveedores` (IN `id` INT, IN `nom` VARCHAR(45), IN `dom` VARCHAR(45), IN `tel` VARCHAR(45))   BEGIN
UPDATE tblProveedores SET NombreRS=nom, Domicilio=dom, Telefono=tel WHERE IdProveedores = id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_editar_usuarios` (IN `id` INT, IN `nom` VARCHAR(45), IN `us` VARCHAR(45), IN `pass` VARCHAR(45), IN `perf` VARCHAR(45))   BEGIN
UPDATE tblUsuarios SET Nombre=nom, Usuario=us, Clave=pass, Perfil=perf WHERE IdUsuarios = id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_lineas` (IN `id` INT)   BEGIN
DELETE FROM tblLineas WHERE IdLineas = id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_proveedores` (IN `id` INT)   BEGIN
DELETE FROM tblProveedores WHERE IdProveedores = id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_usuarios` (IN `id` INT)   BEGIN
DELETE FROM tblUsuarios WHERE IdUsuarios = id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_datellerecib` (IN `recibid` INT, IN `prodid` VARCHAR(45), IN `idlin` INT, IN `cant` INT, IN `tot` DECIMAL(18,2))   BEGIN
insert into tblDetRecibos (RecibosId,ProductosId,LineasId,Cantidad,Total) values (recibid,prodid,idlin,cant,tot);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_detallefacturas` (IN `idfact` INT, IN `idprod` VARCHAR(45), IN `cant` INT, IN `tot` DECIMAL(10,2))   BEGIN
insert into tblDetalleFactura (FacturasId,ProductosId,Cantidad,Total) values (idfact,idprod,cant,tot);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_facturas` (IN `idlin` INT, IN `idprov` INT, IN `fechen` DATE, OUT `idfac` INT)   BEGIN
insert into tblFacturas (LineasId, ProveedoresId, FechaEntrada) values (idlin, idprov, fechen);
set idfac = @@identity;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_lineas` (IN `linea` VARCHAR(45))   BEGIN
INSERT INTO tblLineas (Nombre) VALUES (linea);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_productos` (IN `idprod` VARCHAR(45), IN `idlin` INT, IN `descrip` VARCHAR(45), IN `st` INT, IN `punit` DECIMAL(10,2), IN `umed` VARCHAR(45))   begin
  IF EXISTS (select * from tblAlmacen where IdAlmacen = idprod) THEN
    update tblAlmacen set Stock = Stock + st where IdAlmacen = idprod;
  ELSE 
    INSERT INTO tblAlmacen (IdAlmacen, LineasId, Descripcion, PUnitario, Stock, UMedida) VALUES (idprod, idlin, descrip, punit, st, umed);
  END IF;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_proveedores` (IN `nom` VARCHAR(45), IN `dom` VARCHAR(45), IN `tel` VARCHAR(45))   BEGIN
INSERT INTO tblProveedores (NombreRS, Domicilio, Telefono) VALUES (nom, dom, tel);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_recibos` (IN `fechs` DATE, IN `personae` VARCHAR(45), IN `personar` VARCHAR(45), OUT `idrec` INT)   BEGIN
insert into tblRecibos (FechaS, PersonaEntrega, PersonaRecibe) values (fechs, personae, personar);
set idrec = @@identity;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_usuarios` (IN `nom` VARCHAR(45), IN `us` VARCHAR(45), IN `pass` VARCHAR(45), IN `perf` VARCHAR(45))   BEGIN
INSERT INTO tblUsuarios (Nombre, Usuario, Clave, Perfil) VALUES (nom, us, pass, perf);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrarbuscar_lineas` (IN `linea` VARCHAR(45))   BEGIN
SELECT * FROM tblLineas WHERE Nombre LIKE CONCAT('%',linea,'%');
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrarbuscar_productos` (IN `prod` VARCHAR(45))   BEGIN
select * from tblAlmacen where IdAlmacen LIKE concat('%',prod,'%');
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrarbuscar_proveedores` (IN `nom` VARCHAR(45))   BEGIN
SELECT * FROM tblProveedores WHERE NombreRS LIKE CONCAT('%',nom,'%');
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrarbuscar_usuarios` (IN `us` VARCHAR(45))   BEGIN
SELECT * FROM tblUsuarios WHERE Usuario LIKE CONCAT('%',us,'%');
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrardetalleFacturas` (IN `id` INT)   BEGIN
SELECT d.ProductosId, p.Descripcion, d.Cantidad, p.UMedida,p.PUnitario,d.Total FROM tblDetalleFactura d INNER JOIN tblAlmacen p ON p.IdAlmacen = d.ProductosId WHERE FacturasId = id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrardetalleRecibos` (IN `id` INT)   BEGIN
SELECT d.ProductosId, p.Descripcion, d.Cantidad, p.UMedida,p.PUnitario,l.Nombre, d.Total FROM tblDetRecibos d INNER JOIN tblAlmacen p ON p.IdAlmacen = d.ProductosId INNER JOIN tblLineas l ON l.IdLineas = d.LineasId WHERE RecibosId = id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrar_facturas` ()   BEGIN
SELECT f.IdFacturas, p.NombreRS, l.Nombre, f.FechaEntrada FROM tblFacturas f INNER JOIN tblProveedores p ON f.ProveedoresId = p.IdProveedores INNER JOIN tblLineas l ON f.LineasId = l.IdLineas;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrar_inventario` (IN `id` VARCHAR(45))   BEGIN
select a.IdAlmacen, a.Descripcion, a.Stock, a.UMedida, a.PUnitario, (a.Stock*a.PUnitario) AS Total, l.Nombre from tblAlmacen a INNER JOIN tblLineas l on a.LineasId = l.IdLineas where a.IdAlmacen LIKE concat('%',id,'%');
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrar_productosrecibos` (IN `idprod` VARCHAR(45))   BEGIN
select a.IdAlmacen, a.Descripcion, a.UMedida, a.PUnitario, l.Nombre, l.IdLineas from tblAlmacen a INNER JOIN tblLineas l on a.LineasId = l.IdLineas where a.IdAlmacen LIKE concat('%',idprod,'%');
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrar_recibos` ()   BEGIN
select * from tblRecibos;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_validarusuario` (IN `us` VARCHAR(45), IN `pass` VARCHAR(45))   BEGIN
SELECT * FROM tblusuarios WHERE Usuario = us AND Clave = pass;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblalmacen`
--

CREATE TABLE `tblalmacen` (
  `IdAlmacen` varchar(45) NOT NULL,
  `LineasId` int(11) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `Stock` int(11) NOT NULL,
  `UMedida` varchar(45) DEFAULT NULL,
  `PUnitario` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tblalmacen`
--

INSERT INTO `tblalmacen` (`IdAlmacen`, `LineasId`, `Descripcion`, `Stock`, `UMedida`, `PUnitario`) VALUES
('1', 2, 'Pala', 24, 'Pieza', '50.00'),
('2', 2, 'martillo', 16, 'pieza', '15.00'),
('3', 1, 'escoba', 1, 'pieza', '15.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbldetallefactura`
--

CREATE TABLE `tbldetallefactura` (
  `IdDetalleFacturas` int(11) NOT NULL,
  `FacturasId` int(11) NOT NULL,
  `ProductosId` varchar(45) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Total` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbldetallefactura`
--

INSERT INTO `tbldetallefactura` (`IdDetalleFacturas`, `FacturasId`, `ProductosId`, `Cantidad`, `Total`) VALUES
(1, 10, '2', 1, '15.00'),
(2, 11, '2', 1, '15.00'),
(3, 11, '1', 2, '100.00'),
(4, 12, '2', 4, '60.00'),
(5, 12, '1', 2, '100.00'),
(6, 13, '2', 2, '30.00'),
(7, 13, '1', 2, '100.00'),
(8, 14, '1', 3, '150.00'),
(9, 15, '2', 1, '15.00'),
(10, 15, '1', 2, '100.00'),
(11, 16, '2', 1, '15.00'),
(12, 16, '1', 2, '100.00'),
(13, 17, '2', 1, '15.00'),
(14, 17, '1', 1, '50.00'),
(15, 18, '2', 1, '15.00'),
(16, 18, '1', 1, '50.00'),
(17, 19, '2', 1, '15.00'),
(18, 19, '1', 1, '50.00'),
(19, 20, '2', 1, '15.00'),
(20, 20, '1', 1, '50.00'),
(21, 21, '1', 1, '50.00'),
(22, 21, '2', 2, '30.00'),
(23, 22, '1', 1, '50.00'),
(24, 23, '2', 1, '15.00'),
(25, 23, '1', 1, '50.00'),
(26, 24, '2', 1, '15.00'),
(27, 24, '1', 1, '50.00'),
(28, 25, '2', 1, '15.00'),
(29, 25, '1', 1, '50.00'),
(30, 26, '2', 1, '15.00'),
(31, 26, '1', 2, '100.00'),
(32, 27, '2', 1, '15.00'),
(33, 27, '1', 2, '100.00'),
(34, 28, '2', 1, '15.00'),
(35, 28, '1', 1, '50.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbldetrecibos`
--

CREATE TABLE `tbldetrecibos` (
  `IdDetalleRecib` int(11) NOT NULL,
  `RecibosId` int(11) NOT NULL,
  `ProductosId` varchar(45) DEFAULT NULL,
  `LineasId` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Total` decimal(18,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbldetrecibos`
--

INSERT INTO `tbldetrecibos` (`IdDetalleRecib`, `RecibosId`, `ProductosId`, `LineasId`, `Cantidad`, `Total`) VALUES
(1, 2, '3', 1, 1, '15.00'),
(2, 2, '2', 2, 1, '15.00'),
(3, 2, '1', 2, 2, '100.00'),
(4, 3, '2', 2, 4, '60.00'),
(5, 3, '1', 2, 3, '150.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblfacturas`
--

CREATE TABLE `tblfacturas` (
  `IdFacturas` int(11) NOT NULL,
  `LineasId` int(11) NOT NULL,
  `ProveedoresId` int(11) NOT NULL,
  `FechaEntrada` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tblfacturas`
--

INSERT INTO `tblfacturas` (`IdFacturas`, `LineasId`, `ProveedoresId`, `FechaEntrada`) VALUES
(1, 1, 1, '2020-01-24'),
(2, 2, 1, '2020-01-09'),
(3, 2, 1, '2020-01-10'),
(4, 1, 1, '2020-01-18'),
(5, 1, 1, '2020-01-03'),
(6, 2, 1, '2020-01-09'),
(7, 2, 1, '2020-01-31'),
(8, 2, 1, '2020-01-09'),
(9, 2, 1, '2020-01-02'),
(10, 2, 1, '2020-01-26'),
(11, 2, 1, '2020-01-26'),
(12, 2, 1, '2020-01-28'),
(13, 1, 1, '2020-01-25'),
(14, 2, 1, '2020-01-30'),
(15, 2, 1, '2020-01-27'),
(16, 2, 1, '2020-01-30'),
(17, 2, 1, '2020-01-27'),
(18, 2, 1, '2020-01-28'),
(19, 2, 1, '2020-01-22'),
(20, 2, 1, '2020-01-30'),
(21, 2, 1, '2020-01-30'),
(22, 2, 1, '2020-01-31'),
(23, 2, 1, '2020-01-29'),
(24, 2, 1, '2020-01-30'),
(25, 2, 1, '2020-01-31'),
(26, 2, 1, '2020-01-31'),
(27, 2, 1, '2020-01-31'),
(28, 2, 1, '2020-01-30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbllineas`
--

CREATE TABLE `tbllineas` (
  `IdLineas` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbllineas`
--

INSERT INTO `tbllineas` (`IdLineas`, `Nombre`) VALUES
(1, 'Limpieza'),
(2, 'Ferreteria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblproveedores`
--

CREATE TABLE `tblproveedores` (
  `IdProveedores` int(11) NOT NULL,
  `NombreRS` varchar(45) NOT NULL,
  `Telefono` varchar(45) NOT NULL,
  `Domicilio` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tblproveedores`
--

INSERT INTO `tblproveedores` (`IdProveedores`, `NombreRS`, `Telefono`, `Domicilio`) VALUES
(1, 'don jose', '123456789', 'Puebla');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblrecibos`
--

CREATE TABLE `tblrecibos` (
  `IdRecibos` int(11) NOT NULL,
  `FechaS` date NOT NULL,
  `PersonaEntrega` varchar(45) NOT NULL,
  `PersonaRecibe` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tblrecibos`
--

INSERT INTO `tblrecibos` (`IdRecibos`, `FechaS`, `PersonaEntrega`, `PersonaRecibe`) VALUES
(1, '2020-04-10', 'Admin', 'Enrique'),
(2, '2020-04-18', 'Admin', 'Enrique'),
(3, '2020-04-18', 'Admin', 'dvfsbvgfb');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblusuarios`
--

CREATE TABLE `tblusuarios` (
  `IdUsuarios` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Usuario` varchar(45) NOT NULL,
  `Clave` varchar(45) NOT NULL,
  `Perfil` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tblusuarios`
--

INSERT INTO `tblusuarios` (`IdUsuarios`, `Nombre`, `Usuario`, `Clave`, `Perfil`) VALUES
(1, 'Enrique', 'kike', '123', 'Personal');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tblalmacen`
--
ALTER TABLE `tblalmacen`
  ADD PRIMARY KEY (`IdAlmacen`),
  ADD KEY `LineasId` (`LineasId`);

--
-- Indices de la tabla `tbldetallefactura`
--
ALTER TABLE `tbldetallefactura`
  ADD PRIMARY KEY (`IdDetalleFacturas`),
  ADD KEY `FacturasId` (`FacturasId`);

--
-- Indices de la tabla `tbldetrecibos`
--
ALTER TABLE `tbldetrecibos`
  ADD PRIMARY KEY (`IdDetalleRecib`),
  ADD KEY `RecibosId` (`RecibosId`),
  ADD KEY `LineasId` (`LineasId`);

--
-- Indices de la tabla `tblfacturas`
--
ALTER TABLE `tblfacturas`
  ADD PRIMARY KEY (`IdFacturas`),
  ADD KEY `LineasId` (`LineasId`),
  ADD KEY `ProveedoresId` (`ProveedoresId`);

--
-- Indices de la tabla `tbllineas`
--
ALTER TABLE `tbllineas`
  ADD PRIMARY KEY (`IdLineas`);

--
-- Indices de la tabla `tblproveedores`
--
ALTER TABLE `tblproveedores`
  ADD PRIMARY KEY (`IdProveedores`);

--
-- Indices de la tabla `tblrecibos`
--
ALTER TABLE `tblrecibos`
  ADD PRIMARY KEY (`IdRecibos`);

--
-- Indices de la tabla `tblusuarios`
--
ALTER TABLE `tblusuarios`
  ADD PRIMARY KEY (`IdUsuarios`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbldetallefactura`
--
ALTER TABLE `tbldetallefactura`
  MODIFY `IdDetalleFacturas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de la tabla `tbldetrecibos`
--
ALTER TABLE `tbldetrecibos`
  MODIFY `IdDetalleRecib` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tblfacturas`
--
ALTER TABLE `tblfacturas`
  MODIFY `IdFacturas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `tbllineas`
--
ALTER TABLE `tbllineas`
  MODIFY `IdLineas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tblproveedores`
--
ALTER TABLE `tblproveedores`
  MODIFY `IdProveedores` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tblrecibos`
--
ALTER TABLE `tblrecibos`
  MODIFY `IdRecibos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tblusuarios`
--
ALTER TABLE `tblusuarios`
  MODIFY `IdUsuarios` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tblalmacen`
--
ALTER TABLE `tblalmacen`
  ADD CONSTRAINT `tblalmacen_ibfk_1` FOREIGN KEY (`LineasId`) REFERENCES `tbllineas` (`IdLineas`);

--
-- Filtros para la tabla `tbldetallefactura`
--
ALTER TABLE `tbldetallefactura`
  ADD CONSTRAINT `tbldetallefactura_ibfk_1` FOREIGN KEY (`FacturasId`) REFERENCES `tblfacturas` (`IdFacturas`);

--
-- Filtros para la tabla `tbldetrecibos`
--
ALTER TABLE `tbldetrecibos`
  ADD CONSTRAINT `tbldetrecibos_ibfk_1` FOREIGN KEY (`RecibosId`) REFERENCES `tblrecibos` (`IdRecibos`),
  ADD CONSTRAINT `tbldetrecibos_ibfk_2` FOREIGN KEY (`LineasId`) REFERENCES `tbllineas` (`IdLineas`);

--
-- Filtros para la tabla `tblfacturas`
--
ALTER TABLE `tblfacturas`
  ADD CONSTRAINT `tblfacturas_ibfk_1` FOREIGN KEY (`LineasId`) REFERENCES `tbllineas` (`IdLineas`),
  ADD CONSTRAINT `tblfacturas_ibfk_2` FOREIGN KEY (`ProveedoresId`) REFERENCES `tblproveedores` (`IdProveedores`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
