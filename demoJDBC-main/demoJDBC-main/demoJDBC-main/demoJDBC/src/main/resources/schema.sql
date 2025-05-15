CREATE TABLE IF NOT EXISTS personas (
                                        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                        nombre VARCHAR(255),
                                        apellidos VARCHAR(255),
                                        edad INT
);

CREATE TABLE IF NOT EXISTS producto (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        nombre VARCHAR(255) NOT NULL,
                                        descripcion TEXT,
                                        precio DECIMAL(10, 2) NOT NULL
);