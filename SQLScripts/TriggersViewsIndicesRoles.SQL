CREATE TRIGGER EncryptNameAddressUnPwOnInsert 
	BEFORE INSERT ON Person
    FOR EACH ROW SET NEW.Name = AES_Encrypt(NEW.Name, '27y64m22k'),
					 NEW.Address = AES_Encrypt(NEW.Address, '27y64m22k'),
					 NEW.Username = AES_Encrypt(NEW.Username, '27y64m22k'),
                     NEW.Password = AES_Encrypt(NEW.Password, '27y64m22k');

CREATE TRIGGER EncryptPersonPhoneOnInsert
	BEFORE INSERT ON Person_Phone
    FOR EACH ROW SET NEW.Phone = AES_ENCRYPT(NEW.Phone, '27y64m22k');

CREATE TRIGGER EncryptPersonEmailOnInsert
	BEFORE INSERT ON Person_Email
    FOR EACH ROW SET NEW.Email = AES_ENCRYPT(NEW.Email, '27y64m22k');

CREATE TRIGGER EncryptNameAddressUnPwOnUpdate
	BEFORE UPDATE ON Person
    FOR EACH ROW SET NEW.Name = AES_Encrypt(NEW.Name, '27y64m22k'),
					 NEW.Address = AES_Encrypt(NEW.Address, '27y64m22k'),
                     NEW.Username = AES_Encrypt(NEW.Username, '27y64m22k'),
                     NEW.Password = AES_Encrypt(NEW.Password, '27y64m22k');
    
CREATE TRIGGER EncryptPersonPhoneOnUpdate
	BEFORE UPDATE ON Person_Phone
    FOR EACH ROW SET NEW.Phone = AES_ENCRYPT(NEW.Phone, '27y64m22k');

CREATE TRIGGER EncryptPersonEmailOnUpdate
	BEFORE UPDATE ON Person_Email
    FOR EACH ROW SET NEW.Email = AES_ENCRYPT(NEW.Email, '27y64m22k');
    
CREATE TRIGGER EncryptVendorUnPwOnInsert
	BEFORE INSERT ON Vendor
	FOR EACH ROW SET NEW.Username = AES_Encrypt(NEW.Username, '27y64m22k'),
                     NEW.Password = AES_Encrypt(NEW.Password, '27y64m22k');

CREATE TRIGGER EncryptVendorUnPwOnUpdate
	BEFORE UPDATE ON Vendor
	FOR EACH ROW SET NEW.Username = AES_Encrypt(NEW.Username, '27y64m22k'),
                     NEW.Password = AES_Encrypt(NEW.Password, '27y64m22k');

DROP VIEW IF EXISTS PersonDetails;
CREATE VIEW PersonDetails AS
SELECT DISTINCT P.PID, CAST(AES_DECRYPT( P.Name, '27y64m22k') AS CHAR(100) CHARACTER SET utf8) AS Name, CAST(AES_DECRYPT( P.Address, '27y64m22k') AS CHAR(100) CHARACTER SET utf8) AS Address, 
				CAST(AES_DECRYPT( E.Email, '27y64m22k') AS CHAR(100) CHARACTER SET utf8) AS Email, CAST(AES_DECRYPT(H.Phone, '27y64m22k') AS CHAR(100) CHARACTER SET utf8) AS Phone
FROM Person AS P, Person_Email AS E, Person_Phone AS H
WHERE E.PID = P.PID AND H.PID = P.PID;

DROP VIEW IF EXISTS PersonLogin;
CREATE VIEW PersonLogin AS
SELECT DISTINCT P.PID, CAST(AES_DECRYPT( P.Username, '27y64m22k') AS CHAR(100) CHARACTER SET utf8) AS Username, CAST(AES_DECRYPT( P.Password, '27y64m22k') AS CHAR(100) CHARACTER SET utf8) AS Password
FROM Person AS P;

DROP VIEW IF EXISTS VendorLogin;
CREATE VIEW VendorLogin AS
SELECT DISTINCT V.VID, CAST(AES_DECRYPT( V.Username, '27y64m22k') AS CHAR(100) CHARACTER SET utf8) AS Username, CAST(AES_DECRYPT( V.Password, '27y64m22k') AS CHAR(100) CHARACTER SET utf8) AS Password
FROM Vendor AS V;

CREATE INDEX ProductID ON Product(UPC);
CREATE INDEX InstrumentID ON Instrument(UPC);
CREATE INDEX PID ON Person(PID);
CREATE INDEX ItemID ON Item(SKU);
CREATE INDEX VendorID ON Vendor(VID);

DELIMITER $$
CREATE TRIGGER OnSale
AFTER DELETE ON Item
FOR EACH ROW UPDATE Store SET Store.Sales = Store.Sales + 
										(SELECT Price
										FROM Product
										WHERE OLD.UPC = Product.UPC)
		WHERE Store.LID = OLD.LID;
$$
DELIMITER ;

DROP ROLE IF EXISTS DBA;
DROP ROLE IF EXISTS Customer;
DROP ROLE IF EXISTS Vendor;
DROP ROLE IF EXISTS Employee;
DROP ROLE IF EXISTS Manager;
CREATE ROLE DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Person TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Person_Email TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Person_Phone TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Customer TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Warranty TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Employee TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Store TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Warehouse TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Item TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Vendor TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Vendor_Phone TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Vendor_Email TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Product TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Instrument TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Strings TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Electric TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Electric_Outputs TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Electric_Inputs TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Electric_Effects TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Electric_Electronics TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Wind TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Wind_Materials TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Percussion TO DBA;
GRANT DROP, ALTER, INDEX, DELETE, UPDATE, INSERT, SELECT ON  Keyboards TO DBA;

CREATE ROLE Customer;
GRANT SELECT ON Product TO Customer;
GRANT SELECT ON Instrument TO Customer;
GRANT SELECT ON Strings TO Customer;
GRANT SELECT ON Electric TO Customer;
GRANT SELECT ON Electric_Effects TO Customer;
GRANT SELECT ON electric_electronics TO Customer;
GRANT SELECT ON electric_inputs TO Customer;
GRANT SELECT ON electric_outputs TO Customer;
GRANT SELECT ON Wind TO Customer;
GRANT SELECT ON wind_materials TO Customer;
GRANT SELECT ON percussion TO Customer;
GRANT SELECT ON keyboards TO Customer;

CREATE ROLE Vendor; 
GRANT SELECT, INSERT, DELETE, UPDATE ON Vendor TO Vendor;
GRANT SELECT, INSERT, DELETE, UPDATE ON Vendor_Phone TO Vendor; 
GRANT SELECT, INSERT, DELETE, UPDATE ON Vendor_Email TO Vendor;
GRANT SELECT, INSERT ON Product TO Vendor;
GRANT SELECT, INSERT ON Instrument TO Vendor;
GRANT SELECT, INSERT ON Strings TO Vendor;
GRANT SELECT, INSERT ON Electric TO Vendor;
GRANT SELECT, INSERT ON Electric_Outputs TO Vendor;
GRANT SELECT, INSERT ON Electric_Inputs TO Vendor;
GRANT SELECT, INSERT ON electric_effects TO Vendor; 
GRANT SELECT, INSERT ON electric_electronics TO Vendor;
GRANT SELECT, INSERT ON Wind TO Vendor;
GRANT SELECT, INSERT ON Wind_Materials TO Vendor;
GRANT SELECT, INSERT ON Percussion TO Vendor;
GRANT SELECT, INSERT ON Keyboards TO Vendor;

CREATE ROLE Employee;
GRANT SELECT, INSERT, UPDATE, DELETE ON Person TO Employee;
GRANT SELECT, INSERT, UPDATE, DELETE ON Person_Email TO Employee;
GRANT SELECT, INSERT, UPDATE, DELETE ON Person_Phone TO Employee;
GRANT SELECT, INSERT, UPDATE, DELETE ON Customer TO Employee;
GRANT SELECT, INSERT, UPDATE, DELETE ON Item TO Employee;
GRANT SELECT, INSERT ON Warranty TO Employee;
GRANT SELECT ON Store TO Employee;
GRANT SELECT ON Warehouse TO Employee;
GRANT SELECT ON Vendor TO Employee;
GRANT SELECT ON Vendor_Email TO Employee;
GRANT SELECT ON Vendor_Phone TO Employee;
GRANT SELECT ON Product TO Employee;
GRANT SELECT ON instrument TO Employee;
GRANT SELECT ON Strings TO Employee;
GRANT SELECT ON Electric TO Employee;
GRANT SELECT ON electric_effects TO Employee;
GRANT SELECT ON electric_electronics TO Employee;
GRANT SELECT ON electric_inputs TO Employee;
GRANT SELECT ON electric_outputs TO Employee;
GRANT SELECT ON Wind to Employee;
GRANT SELECT ON wind_materials to Employee;
GRANT SELECT ON Percussion to Employee;
GRANT SELECT ON keyboards to Employee;
GRANT SELECT, INDEX ON PersonDetails TO Employee;

CREATE ROLE Manager;
GRANT SELECT, INSERT, UPDATE, DELETE ON Person TO Manager;
GRANT SELECT, INSERT, UPDATE, DELETE ON Person_Email TO Manager;
GRANT SELECT, INSERT, UPDATE, DELETE ON Person_Phone TO Manager;
GRANT SELECT, INSERT, UPDATE, DELETE ON Customer TO Manager;
GRANT SELECT, INSERT, UPDATE, DELETE ON Item TO Manager;
GRANT SELECT, INSERT, UPDATE, DELETE ON Employee TO Manager;
GRANT SELECT, INSERT, UPDATE, DELETE ON Warranty TO Employee;
GRANT SELECT ON Store TO Manager;
GRANT SELECT ON Warehouse TO Manager;
GRANT SELECT ON Vendor TO Manager;
GRANT SELECT, UPDATE ON Vendor_Email TO Manager;
GRANT SELECT, UPDATE ON Vendor_Phone TO Manager;
GRANT SELECT ON Product TO Manager;
GRANT SELECT ON instrument TO Manager;
GRANT SELECT ON Strings TO Manager;
GRANT SELECT ON Electric TO Manager;
GRANT SELECT ON electric_effects TO Manager;
GRANT SELECT ON electric_electronics TO Manager;
GRANT SELECT ON electric_inputs TO Manager;
GRANT SELECT ON electric_outputs TO Manager;
GRANT SELECT ON Wind to Manager;
GRANT SELECT ON wind_materials to Manager;
GRANT SELECT ON Percussion to Manager;
GRANT SELECT ON keyboards to Manager;
GRANT SELECT, INDEX ON PersonDetails TO Employee;