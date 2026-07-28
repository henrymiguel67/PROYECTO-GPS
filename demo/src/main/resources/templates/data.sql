-- =========================
-- CLIENTES
-- =========================

INSERT INTO cliente 
(nombre_empresa, nit, representante, telefono, correo, direccion, activo)
VALUES
('Seguridad Andina SAS', '900123456-1', 'Carlos Perez', '3001112233', 'contacto@seguridadandina.com', 'Bucaramanga', true),

('Transportes Santander', '900987654-2', 'Laura Gomez', '3015556677', 'info@transportessantander.com', 'Floridablanca', true);


-- =========================
-- USUARIOS
-- =========================

INSERT INTO usuarios
(nombre, correo, contraseña, rol)
VALUES
('Administrador Sistema', 'admin@gpstrack.com', 'admin123', 'ADMINISTRADOR'),

('Juan Rodriguez', 'supervisor@gpstrack.com', 'super123', 'SUPERVISOR'),

('Pedro Martinez', 'guarda@gpstrack.com', 'guarda123', 'GUARDA');


-- =========================
-- PUESTOS
-- =========================

INSERT INTO puesto
(nombre, cliente_id, direccion, activo)
VALUES
('Porteria Principal', 1, 'Entrada principal edificio', true),

('Zona Parqueadero', 1, 'Parqueadero visitantes', true),

('Control Vehicular', 2, 'Entrada empresa transporte', true);


-- =========================
-- VEHICULOS
-- =========================

INSERT INTO vehiculo
(placa, marca, modelo, color, tipo, propietario, autorizado)
VALUES
('ABC123', 'Toyota', 'Hilux 2024', 'Blanco', 'Camioneta', 'Seguridad Andina SAS', true),

('XYZ789', 'Chevrolet', 'Tracker 2023', 'Negro', 'SUV', 'Transportes Santander', true);


-- =========================
-- RONDAS
-- =========================

INSERT INTO ronda
(descripcion, fecha_hora_inicio, fecha_hora_fin, tipo, estado)
VALUES
('Recorrido zona norte', '2026-07-25 08:00:00', '2026-07-25 10:00:00', 'DIURNA', 'COMPLETADA'),

('Revisión perímetro nocturno', '2026-07-25 22:00:00', '2026-07-26 00:00:00', 'NOCTURNA', 'PENDIENTE');


-- =========================
-- REPORTES
-- =========================

INSERT INTO reporte
(titulo, descripcion, fecha_hora, tipo, estado)
VALUES
('Puerta abierta', 'Se encontró puerta lateral abierta', '2026-07-25 09:30:00', 'NOVEDAD', 'PENDIENTE'),

('Vehiculo autorizado ingreso', 'Ingreso registrado correctamente', '2026-07-25 11:00:00', 'CONTROL', 'CERRADO');


-- =========================
-- NOVEDADES
-- =========================

INSERT INTO novedad
(titulo, descripcion, fecha_hora, estado)
VALUES
('Falla iluminación', 'Zona parqueadero sin luz', '2026-07-25 20:00:00', 'PENDIENTE'),

('Alarma activada', 'Sensor detectó movimiento', '2026-07-25 23:00:00', 'EN_PROCESO');


-- =========================
-- VISITANTES
-- =========================

INSERT INTO visitante
(nombre, documento, telefono, empresa, motivo_visita, fecha_hora_ingreso, fecha_hora_salida)
VALUES
('Andres Lopez', '1098765432', '3105554433', 'Proveedor ABC', 'Entrega de equipos',
'2026-07-25 10:00:00',
'2026-07-25 11:30:00'),

('Maria Torres', '1022334455', '3208887766', 'Cliente XYZ', 'Reunión',
'2026-07-25 14:00:00',
'2026-07-25 15:00:00');