CREATE TABLE if not exists airport
(
    airportID BIGINT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(100) NOT NULL,
    city      VARCHAR(100) NOT NULL,
    country   VARCHAR(100) NOT NULL,
    iata_code CHAR(3)      NOT NULL,
    icao_code CHAR(4)      NOT NULL
);

CREATE TABLE if not exists airline
(
    airlineID BIGINT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(100) NOT NULL,
    country   VARCHAR(100) NOT NULL,
    iata_code CHAR(2)      NOT NULL,
    icao_code CHAR(3)      NOT NULL,
    callsign  VARCHAR(50)
);
CREATE TABLE if not exists passenger
(
    passengerID   BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name    VARCHAR(100) NOT NULL,
    last_name     VARCHAR(100) NOT NULL,
    date_of_birth DATE         NOT NULL,
    email         VARCHAR(100) NOT NULL,
    phone         VARCHAR(15)
);

CREATE TABLE if not exists aircraft
(
    aircraftID          BIGINT PRIMARY KEY AUTO_INCREMENT,
    model               VARCHAR(100) NOT NULL,
    manufacturer        VARCHAR(100) NOT NULL,
    seating_capacity    INT          NOT NULL,
    fly_range           INT          NOT NULL,
    registration_number VARCHAR(50)  NOT NULL,
    airlineID           BIGINT,
    FOREIGN KEY (airlineID) REFERENCES airline (airlineID)
);

CREATE TABLE if not exists flight
(
    flightID             BIGINT PRIMARY KEY AUTO_INCREMENT,
    flight_number         VARCHAR(10) NOT NULL,
    airlineID            BIGINT,
    aircraftID           BIGINT,
    origin_airportID      BIGINT,
    destination_airportID BIGINT,
    departure_time       DATETIME    NOT NULL,
    arrival_time         DATETIME    NOT NULL,
    status               VARCHAR(20) NOT NULL,
    FOREIGN KEY (airlineID) REFERENCES airline (airlineID),
    FOREIGN KEY (aircraftID) REFERENCES aircraft (aircraftID),
    FOREIGN KEY (origin_airportID) REFERENCES airport (airportID),
    FOREIGN KEY (destination_airportID) REFERENCES airport (airportID)
);

CREATE TABLE if not exists reservation
(
    reservationID    BIGINT PRIMARY KEY AUTO_INCREMENT,
    passengerID      BIGINT,
    flightID         BIGINT,
    reservation_date DATETIME    NOT NULL,
    status           VARCHAR(20) NOT NULL,
    FOREIGN KEY (passengerID) REFERENCES passenger (passengerID),
    FOREIGN KEY (flightID) REFERENCES flight (flightID)
);

CREATE TABLE if not exists seat
(
    seatID        BIGINT PRIMARY KEY AUTO_INCREMENT,
    reservationID BIGINT,
    seat_number   VARCHAR(5)  NOT NULL,
    seat_class    VARCHAR(20) NOT NULL,
    is_available  BOOLEAN     NOT NULL DEFAULT TRUE,
    FOREIGN KEY (reservationID) REFERENCES reservation (reservationID)
);