INSERT INTO Vendor (VID, Name, Address, Username, Password) VALUES
('GIB00001', 'Gibson', '5691 Surrey Square St, Houston, TX 77017', "Gibson45", "3dc10517"),
('YMH00040', 'Yamaha', '6600 Orangethorpe Ave, Buena Park, CA 90620', "Yamaha71", "c258a212"),
('S&R00801', 'Scherl & Roth', '2917 Mayfield Rd, Cleveland, OH 44118', "ScherlRoth", "975c1e0c1"),
('BCH00197', 'Vincent Bach Stradivarius', '37 W 57th St 8th floor, New York, NY 10019', "Bach600", "6e71d27"),
('BCR00138', 'Buffet Crampon', '307 7th Ave Suite 401, New York, NY 10001', "Crampon81", "46aed97"),
('CGC0229', 'C. G. Conn', '1020 NASA Road 1 Suite 138, Webster, TX 77598', "Conn59", "caf9de1f"),
('BEH01975', 'Behringer', 'Mühlweg 101, 90427 Nürnberg, Germany', "Berhringer39", "f152349a9"),
('NRD40881', 'Nord', '2951 Marina Bay Dr #130-401, League City, TX 77573', "NordJell16",  "8bd39985"),
('DWP23230', 'DW Drums', '3450 Lunar Court, Oxnard, CA 93030', "Drums4Life", "5ebd458b"),
('EMG01971', 'Lakland', '1811 W Berteau Ave, Chicago, IL 60613', "Slowlak91", "baf6757d"),
('ERB01959', 'Ernie Ball', '1993 Cranberry Creek Road, Ireland, FL 49805', "Ballin69", "afaab8a2"),
('VAN1236', 'Vandoren', '1973 Hancock Way, Chameleon, NY 15698', "Vans88", "5bb6a801"),
('VTA05679', 'Vater American', '1986 Rippington Road, Aspen, CO 01369', "Murica76", "b45923c4"),
('FEN00002', 'Fender', '1546 Yellow Creek Court, Kalamazoo, MI 35648', "LeoPJ54", "Fen1Gib0");

INSERT INTO Product (UPC, ProductName, ProductDescription, ProductType, SpaceRequired, Price, VID)
VALUES
(000206030066, 'Gibson ES-335', 'Legendary classic Guitar that is popular even in the solid body era.', 'Electric Guitar', 2760, 3999.00, 'GIB00001'),
(000304083496, 'Yamaha TRBX-174', 'New offering, helping many begin their bass journey.', 'Electric Bass Guitar', 3264, 259.99, 'YMH00040'),
(000614078921, 'Scherl & Roth 4/4 Sarabande', 'Intermediate level violin from old vendor.', 'Acoustic Violin', 828, 1499.99, 'S&R00801'),
(001803792430, 'Bach Stradivarius', 'Professional shining silver trumpet. Named for musical heritage.', 'Trumpet', 912, 3249.00, 'BCH00197'),
(001336445875, 'Buffet Crampon R13', 'More recently developed professional clarinet.', 'Clarinet', 840, 3973.00, 'BCR00138'),
(001220100829, 'C.G. Conn 8D CONNstellation', 'Higher-end development of a common French Horn.', 'French Horn', 4096.00, 5139.00, 'CGC0229'),
(019770821635, 'Behringer Crave Analog Synthesizer', 'Modern take on classic synthesizer with a sequencer.', 'Synthesizer', 182, 199.00, 'BEH01975'),
(048819473684, 'Nord Stage 4 88', 'The professional standard when it comes to stage keyboards.', 'Keyboard', 3456, 5699.00, 'NRD40881'),
(070200098756, 'Yamaha P22', 'Piano of the type you would likely find in a school or studio.', 'Piano', 64800, 9199.00, 'YMH00040'),
(142289879852, 'DW Performance Series Bass Drum', 'Exclusive bass drum usable alone or in a kit.', 'Bass Drum', 6776, 1150.00, 'DWP23230'),
(161688256139, 'DW Performace Series Floor Tom', 'Exclusive tom usable alone or in a kit.', 'Floor Tom', 4096, 700.00, 'DWP23230'),
(500056498856, 'Geezer Butler Signature P/J Bass Pickups', 'Black pickups inspired by the early days of Black Sabbath bassist Geezer', 'Pickups', 10, 179.00, 'EMG01971'),
(510000564654, 'Ernie Ball 2221 Regular Slinky', 'Nickel Wound Electric Guitar Strings .010-.046 Gauge.', 'Electric Guitar Strings', 5, 5.99, 'ERB01959'),
(520001548998, 'Yamaha CBB-101', 'Carbon fiber violin bow with leather grip from prolific manufacturer.', 'Violin Bow', 30, 279.99, 'YMH00040'),
(530874988969, 'Bach 3C Mouthpiece', 'Common mouthpiece from a musical heritage manufacturer', 'Mouthpiece', 5, 65.00, 'BCH00197'),
(540548949813, 'Vandoren CR8035 V21', '10 pack of clarinet reeds', 'Reeds', 5, 37.79, 'VAN1236'),
(551216565489, 'C.G. Conn 121 French Horn Mute', 'Stone lined Non-Transposing French Horn Mute', 'Mute', 160, 29.99, 'CGC0229'),
(561894894456, 'Behringer Line2USB DUAL', '2-Channel USB Audio Interface', 'Audio Interface', 36, 29.00, 'BEH01975'),
(571897946497, 'Vater American Hickory Drumsticks', '16 inch 7A wooden drum sticks with small round tip.', 'Drumsticks', 32, 7.95, 'VTA05679'),
(583545687411, 'Fender 351 Celluloid Guitar Picks - Thin', '12 pack of various colored thin picks', 'Picks', 4, 5.99, 'FEN00002'),
(583545687412, 'Fender 351 Celluloid Guitar Picks - Medium', '12 pack of various colored medium picks', 'Picks', 4, 5.99, 'FEN00002');


INSERT INTO Instrument(UPC, Weight)
VALUES
(000206030066, 7.86),
(000304083496, 9.25),
(000614078921, 1.10),
(001803792430, 2.20),
(001336445875, 1.76),
(001220100829, 6.12),
(019770821635, 3.3),
(048819473684, 10.80),
(070200098756, 527.00),
(142289879852, 16.50),
(161688256139, 12.65);

INSERT INTO Strings (UPC, NumberOfStrings, Scale, Body, Neck, Frets)
VALUES
(000206030066, 6, 24.75, 'Semi-Hollow, Poplar', 'Mahogany, Rosewood Fingerboard', 22),
(000304083496, 4, 34, 'Solid, Alder', 'Maple, Sonokeling Fingerboard', 24),
(000614078921, 4, 23, 'Hollow, Maple and Spruce', 'Maple, Ebony Fingerboard', 0);


INSERT INTO Wind(UPC, Tuning)
VALUES
(001803792430, 'Bb'),
(001336445875, 'Bb'),
(001220100829, 'F');


INSERT INTO Keyboards(UPC, NumberOfKeys, KeyType)
VALUES
(048819473684, 88, 'Fully Weighted'),
(070200098756, 88, 'Weighted');


INSERT INTO Percussion(UPC, Diameter, Depth, Construction)
VALUES
(142289879852, 22, 14, '8-ply HVX'),
(161688256139, 16, 16, '8-ply');


INSERT INTO Wind_Materials(UPC, Material)
VALUES
(001803792430, 'Brass'),
(001803792430, 'Silver'),
(001803792430, 'Pearl'),
(001336445875, 'Grenadilla'),
(001336445875, 'Nickel'),
(001220100829, 'Nickel-Silver');

INSERT INTO Electric(UPC, Polyphony)
VALUES
(000206030066, '6 Note'),
(000304083496, '4 Note'),
(019770821635, '16 Note'),
(048819473684, '120 Note');

INSERT INTO Electric_Electronics (UPC, ElectricComponent)
VALUES
(000206030066, 'T-Type Rhythm Humbucker'),
(000206030066, 'T-Type Lead Humbucker'),
(000304083496, 'Ceramic Split Single-Coil'),
(000304083496, 'Ceramic Single-Coil'),
(019770821635, 'Analog 3340 VCO'),
(019770821635, 'Lowpass/Highpass 24dB Ladder Filter'),
(019770821635, 'Analog LFO'),
(019770821635, 'Noise Generator'),
(019770821635, 'Envelope Generator');

INSERT INTO Electric_Outputs(UPC, Output)
VALUES
(000206030066, 'Standard Electric Guitar Lead'),
(000304083496, 'Standard Electric Bass Lead'),
(019770821635, '1/8 inch VCA'),
(019770821635, '1/8 inch Headphones'),
(019770821635, '18 x 14 I/O matrix'),
(019770821635, 'USB Type B'),
(048819473684, '4 x 1/4 inch'),
(048819473684, '1/4 inch Headphones'),
(048819473684, 'USB Type B');

INSERT INTO Electric_Inputs(UPC, Input)
VALUES
(019770821635, '1/8 inch external'),
(019770821635, '18 x 14 I/O matrix'),
(019770821635, 'USB Type B'),
(048819473684, '1/8 inch monitor'),
(048819473684, '5 x 1/4 inch'),
(048819473684, '2 x 6-pin'),
(048819473684, 'USB Type B');

INSERT INTO Electric_Effects(UPC, Effect)
VALUES
(019770821635, 'Noise'),
(019770821635, 'Sawtooth'),
(019770821635, 'Pulse'),
(019770821635, 'Triangle'),
(019770821635, 'Square'),
(019770821635, 'Modulation'),
(019770821635, 'Arpeggiator'),
(048819473684, 'Reverb'),
(048819473684, 'Delay'),
(048819473684, 'Amp'),
(048819473684, 'Modulation'),
(048819473684, 'Arpeggiator');

INSERT INTO Warehouse(LID, Address, Phone, SpaceAvailable, Capacity)
VALUES
(1, "1700 Bay Area Boulevard Houston, Texas", 3308991300, 5000, 10000),
(2, "2100 El Dorado Boulevard Houston, Texas", 4434874078, 2000, 4000),
(3, "1100 El Camino Real Houston, Texas", 3197296910, 1000, 2000),
(4, "500 Space Center Boulevard Houston, Texas", 8155225245, 7500, 10000),
(5, "750 League City Parkway League City, Texas", 2604825675, 3000, 6000),
(6, "150 NASA Road One Houston, Texas", 5612562495, 2500, 4000),
(7, "250 Galveston Road Houston, Texas", 7314457767, 3500, 7000),
(8, "500 Saturn Lane Webster, Texas", 9792985916, 1000, 4000),
(9, "2000 Gemini Avenue Webster, Texas", 9089727281, 5000, 7500),
(10, "3000 Medical Center Boulevard Houston, Texas", 9162677654, 2000, 3000);

INSERT INTO Store(LID, Address, Phone, SpaceAvailable, Capacity, Sales)
VALUES
(1, "1800 Bay Area Boulevard Houston, Texas", 3308991301, 500, 1000, 250000),
(2, "2200 El Dorado Boulevard Houston, Texas", 4434874079, 250, 500, 500000),
(3, "1200 El Camino Read Houston, Texas", 3197296911, 200, 400, 1000000),
(4, "600 Space Center Boulevard Houston, Texas", 8155225246, 300, 500, 2000000),
(5, "850 League City Parkway League City, Texas", 2604825676, 100, 200, 200000),
(6, "250 NASA Road One Houston, Texas", 5612562496, 150, 200, 350000),
(7, "250 Galveston Road Houston, Texas", 7314457767, 200, 300, 400000),
(8, "600 Saturn Lane Webster, Texas", 9792985917, 100, 150, 100000),
(9, "2100 Gemini Avenue Webster, Texas", 9089727282, 500, 750, 600000),
(10, "3100 Medical Center Boulevard Houston, Texas", 9162677655, 600, 800, 1500000);

INSERT INTO Person(PID, Name, Address, Username, Password)
VALUES
('Person01', "Person One", "1600 Bay Area Boulevard Houston, Texas","Project01","35f82d0a9e"),
('Person02', "Person Two", "2000 El Dorado BOulevard Houston, Texas","Project02","219b5467b1c"),
('Person03', "Person Three", "1000 El Camino Real Houston, Texas","Project03","12d688f37"),
('Person04', "Person Four", "250 Space Center Boulevard Houston, Texas","Project04","0644dfd0a"),
('Person05', "Person Five", "500 League City Parkway League City, Texas","Project05","81ac452c4b"),
('Person06', "Person Six", "100 NASA Road One Houston, Texas","Project06","ba43fe598e"),
('Person07', "Person Seven", "200 Galveston Road Houston, Texas","Project07","f788cf281"),
('Person08', "Person Eight", "350 Saturn Lane Webster, Texas","Project08","9756bb14"),
('Person09', "Person Nine", "1500 Gemini Avenue Webster, Texas","Project09","d0f6fb7f00d"),
('Person10', "Dev On", "2500 Medical Center Boulevard Houston, Texas","TenOutta10","Testin01");

INSERT INTO Customer(PID, Credit)
VALUES
('Person01', 1000),
('Person02', 10000),
('Person03', 5000),
('Person04', 15000),
('Person05', 3000),
('Person06', 4000),
('Person07', 7500),
('Person08', 12500),
('Person09', 4500),
('Person10', 5500);

INSERT INTO Employee(PID, Salary, Position, LID)
VALUES
('Person01', 50000, "Worker", 1),
('Person02', 100000, "Engineer", 2),
('Person03', 250000, "Manager", 3),
('Person04', 500000, "Executive", 4),
('Person05', 300000, "Salesperson", 5),
('Person06', 150000, "Expert", 6),
('Person07', 300000, "Teacher", 7),
('Person08', 1000000, "President", 8),
('Person09', 2000000, "CEO", 9),
('Person10', 125000, "Web Master", 10);

INSERT INTO Warranty(UPC, SerialNumber, PID, Coverage)
VALUES
(000206030066, 0123456789, 'Person01', 500),
(000304083496, 1234567890, 'Person02', 1000),
(000614078921, 2345678901, 'Person03', 2000),
(001803792430, 3456789012, 'Person04', 3000),
(001336445875, 4567890123, 'Person05', 4000),
(001220100829, 5678901234, 'Person06', 5000),
(019770821635, 6789012345, 'Person07', 6000),
(048819473684, 7890123456, 'Person08', 7000),
(070200098756, 8901234567, 'Person09', 8000),
(142289879852, 9012345678, 'Person10', 9000);

INSERT INTO Item(SKU, SerialNumber, UPC, LID, OnHand_Order)
VALUES
(1, 0123456784, 000206030066, 1, 0),
(2, 1234567885, 000304083496, 2, 1),
(3, 2345678896, 000614078921, 3, 0),
(4, 3456789007, 001803792430, 4, 1),
(5, 4567890118, 001336445875, 5, 0),
(6, 5678901229, 001220100829, 6, 1),
(7, 6789012340, 019770821635, 7, 0),
(8, 7890123451, 048819473684, 8, 1),
(9, 8901234562, 070200098756, 9, 0),
(10, 9012345673, 142289879852, 10, 1);

-- Error Code: 1452. Cannot add or update a child row: a foreign key constraint fails (`project`.`item`, CONSTRAINT `item_ibfk_1` FOREIGN KEY (`UPC`) REFERENCES `product` (`UPC`) ON DELETE CASCADE ON UPDATE CASCADE)

INSERT INTO Person_Email (PID, Email) VALUES
('Person01', 'person1@person.com'),
('Person02', 'person2@person.com'),
('Person03', 'person3@person.com'),
('Person04', 'person4@person.com'),
('Person05', 'person5@person.com'),
('Person06', 'person6@person.com'),
('Person07', 'person7@person.com'),
('Person08', 'person8@person.com'),
('Person09', 'person9@person.com'),
('Person10', 'person10@person.com');

INSERT INTO Person_Phone (PID, Phone) VALUES
('Person01', 1231230001),
('Person02', 1231230002),
('Person03', 1231230003),
('Person04', 1231230004),
('Person05', 1231230005),
('Person06', 1231230006),
('Person07', 1231230007),
('Person08', 1231230008),
('Person09', 1231230009),
('Person10', 1231230010);

INSERT INTO Vendor_Email (VID, Email) VALUES
('GIB00001', 'service@gibson.com'),
('YMH00040', 'service@yamaha.com'),
('S&R00801', 'service@scherlandroth.com'),
('BCH00197', 'service@vincentbachstradivarius.com'),
('BCR00138', 'service@buffetcrampon.com'),
('CGC0229', 'service@cgconn.com'),
('BEH01975', 'service@behringer.com'),
('NRD40881', 'service@nord.com'),
('DWP23230', 'service@dwdrums.com'),
('EMG01971', 'service@lakland.com');

INSERT INTO Vendor_Phone(VID, Phone) VALUES
('GIB00001', 18004442766),
('YMH00040', 7145229000),
('S&R00801', 8002224700),
('BCH00197', 2815570505),
('BCR00138', 19048210234),
('CGC0229', 5742956730),
('BEH01975', 7028008290),
('NRD40881', 4684427360),
('DWP23230', 8882345450),
('EMG01971', 17738719637);

