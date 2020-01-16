package es.uca.iw.okto.backend.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import es.uca.iw.okto.backend.models.Activity;
import es.uca.iw.okto.backend.models.City;
import es.uca.iw.okto.backend.models.Scale;
import es.uca.iw.okto.backend.models.Service;
import es.uca.iw.okto.backend.models.Ship;
import es.uca.iw.okto.backend.models.Tip;
import es.uca.iw.okto.backend.models.Tour;
import es.uca.iw.okto.backend.models.Trip;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.ActivityRepository;
import es.uca.iw.okto.backend.repositories.CityRepository;
import es.uca.iw.okto.backend.repositories.ScaleRepository;
import es.uca.iw.okto.backend.repositories.ServiceRepository;
import es.uca.iw.okto.backend.repositories.ShipRepository;
import es.uca.iw.okto.backend.repositories.TipRepository;
import es.uca.iw.okto.backend.repositories.TourRepository;
import es.uca.iw.okto.backend.repositories.TripRepository;
import es.uca.iw.okto.backend.repositories.UserRepository;;

@Component
public class Seeder implements ApplicationListener<ContextRefreshedEvent> {
  private boolean alreadySetup = false;

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private TripRepository tripRepository;
  @Autowired
  private ActivityRepository actRepository;
  @Autowired
  private ServiceRepository serviceRepository;
  @Autowired
  private ShipRepository shipRepository;
  @Autowired
  private ScaleRepository scaleRepository;
  @Autowired
  private CityRepository cityRepository;
  @Autowired
  private TourRepository tourRepository;
  @Autowired
  private TipRepository tipRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  private Faker faker = new Faker();

  @Override
  @Transactional
  public void onApplicationEvent(final ContextRefreshedEvent event) {
    realData();
  }

  void realData() {
    createUserIfNotFound("admin@okto.com", "Admin", "Okto", "okto", "00000000U", "000000000",
        User.Role.ADMIN);
    createUserIfNotFound("user@okto.com", "User", "Okto", "okto", "00000000V", "000000001",
        User.Role.USER);
    createUserIfNotFound("manager@okto.com", "Manager", "Okto", "okto", "00000000W", "000000002",
        User.Role.MANAGER);
    createUserIfNotFound("user1@okto.com", "Carlos Rodrigo", "Sanabria Flores", "krosf",
        "12345678A", "111111111", User.Role.USER);
    createUserIfNotFound("user2@okto.com", "Félix", "Rodríguez Pericacho", "frpericacho",
        "12345678B", "222222222", User.Role.USER);
    createUserIfNotFound("user3@okto.com", "Álvaro", "Braza Andrades", "albran", "12345678C",
        "333333333", User.Role.USER);
    createUserIfNotFound("user4@okto.com", "Borja", "Romero Fernández", "bjiro", "12345678D",
        "444444444", User.Role.USER);
    createUserIfNotFound("user5@okto.com", "Juan", "Ruiz Bonald", "wenwtf", "12345678E",
        "555555555", User.Role.USER);
    createUserIfNotFound("user6@okto.com", "Rubén", "Montero Domínguez", "rubentao", "12345678F",
        "666666666", User.Role.USER);
    createUserIfNotFound("user7@okto.com", "Carmen del Mar", "Ruiz de Celis", "dece1998",
        "12345678G", "777777777", User.Role.USER);
    createUserIfNotFound("user8@okto.com", "Esperanza", "Cano Canalejas", "alpHope26", "12345678H",
        "888888888", User.Role.USER);
    createUserIfNotFound("user9@okto.com", "Paloma", "Martínez-Esparza Castro", "lightwood17",
        "12345678I", "999999999", User.Role.USER);
    createUserIfNotFound("user10@okto.com", "Kevin", "López Cala", "666K3r04n98", "12345678J",
        "101010101", User.Role.USER);
    createUserIfNotFound("user11@okto.com", "Rafael", "Román Aguilar", "rafX356", "12345678K",
        "110110110", User.Role.USER);
    createUserIfNotFound("user12@okto.com", "Claudia", "Soriano Roldán", "AirPilot97", "12345678L",
        "121212121", User.Role.USER);
    createUserIfNotFound("user13@okto.com", "Pedro", "Soriano Ruiz", "333OhVish333", "12345678M",
        "131313131", User.Role.USER);
    createUserIfNotFound("user14@okto.com", "Raúl", "Escribano Corrales", "rescoX18", "12345678N",
        "141414141", User.Role.USER);
    createUserIfNotFound("user15@okto.com", "Pablo", "Granados Valencia", "granadEr0", "12345678O",
        "151515151", User.Role.USER);
    createUserIfNotFound("user16@okto.com", "Marta", "Rendón Salvador", "MaRt2335", "12345678P",
        "161616161", User.Role.USER);
    createUserIfNotFound("user17@okto.com", "Luis", "de Celis Muñoz", "90LdCM90", "12345678Q",
        "171717171", User.Role.USER);
    createUserIfNotFound("user18@okto.com", "José María", "Castaño Torres", "J0s3M4rI3lM3J0R",
        "12345678R", "181818181", User.Role.USER);
    createUserIfNotFound("user19@okto.com", "Antonio", "Espinosa Barrios", "98StrawHat",
        "12345678S", "191919191", User.Role.USER);
    createUserIfNotFound("user20@okto.com", "Pablo", "López Márquez", "d4rth", "12345678T",
        "202020202", User.Role.USER);

    Ship ship1 = createShipIfNotFound("Mayflower II");
    Ship ship2 = createShipIfNotFound("Dampfer");
    Ship ship3 = createShipIfNotFound("Arcadia");
    Ship ship4 = createShipIfNotFound("Pequod");
    Ship ship5 = createShipIfNotFound("Musashi");

    City shangai = createCityIfNotFound("Shanghai", "China");
    City singapore = createCityIfNotFound("Singapore", "Singapur");
    City busan = createCityIfNotFound("Busan", "South Korea");
    City la = createCityIfNotFound("Los Angeles", "USA");
    City ny = createCityIfNotFound("New York", "USA");
    City tokio = createCityIfNotFound("Tokio", "Japan");
    City valencia = createCityIfNotFound("Valencia", "Spain");
    City barcelona = createCityIfNotFound("Barcelona", "Spain");
    City santos = createCityIfNotFound("Santos", "Brasil");
    City roterdam = createCityIfNotFound("Rotterdam", "Netherlands");
    City amberes = createCityIfNotFound("Amberes", "Belgium");
    City jeddah = createCityIfNotFound("Jeddah", "Saudi Arabia");
    City colon = createCityIfNotFound("Colón", "Panama");
    City istambul = createCityIfNotFound("Istanbul", "Turkey");
    City hamburg = createCityIfNotFound("Hamburg", "Germany");

    createTipIfNotFound(shangai, "Try the street food of Shanghai");
    createTipIfNotFound(shangai, "Visit Longhua Temple");
    createTipIfNotFound(singapore, "Visit the Gardens by the Bay");
    createTipIfNotFound(singapore, "Use the public Transport of Singapore");
    createTipIfNotFound(busan, "Visit Beomoesa Temple");
    createTipIfNotFound(busan, "Explore Busan's specialty food");
    createTipIfNotFound(la, "Visit Beverly Hills");
    createTipIfNotFound(la, "Walk down Hollywood's Walk of Fame");
    createTipIfNotFound(ny, "Visit Time's Square");
    createTipIfNotFound(ny, "Visit the Empire State Building");
    createTipIfNotFound(tokio, "Visit Senso-Ji temple");
    createTipIfNotFound(tokio, "Visit Akihabara");
    createTipIfNotFound(valencia, "Visit the City of Arts and Sciences");
    createTipIfNotFound(valencia, "Try VAlencia's best Horchata");
    createTipIfNotFound(barcelona, "Visit the 'Sagrada Familia'");
    createTipIfNotFound(barcelona, "Visit the Güell park");
    createTipIfNotFound(santos, "Visit the Brazilian Coffee Museum");
    createTipIfNotFound(santos, "Walk down Santo's beaches");
    createTipIfNotFound(roterdam, "Take a water taxi");
    createTipIfNotFound(roterdam, "Visit Rotterdam's Fotomuseum");
    createTipIfNotFound(amberes, "Be careful, public smoking is forbidden");
    createTipIfNotFound(amberes, "Visit Ambere's Central Station");
    createTipIfNotFound(jeddah, "Visit the Arabian Wings Gallery");
    createTipIfNotFound(jeddah, "Research Jeddah's Laws and understand them");
    createTipIfNotFound(colon, "Visit Gatun Locks");
    createTipIfNotFound(colon, "Visit Potobelo");
    createTipIfNotFound(istambul, "Visit the Blue Mosque");
    createTipIfNotFound(istambul, "Enter the Underground Cistern");
    createTipIfNotFound(hamburg, "Visit the Kunsthalle museum");
    createTipIfNotFound(hamburg, "Take Ferry 62 for a harbour tour");

    createActivityIfNotFound(faker.date().birthday(18, 60), faker.date().birthday(18, 60),
        "Pool party", "Party by the ship's pool side", 0.00, ship1);
    createActivityIfNotFound(faker.date().birthday(18, 60), faker.date().birthday(18, 60),
        "Dinner with the Captain", "Dinner at the restaurant with the captain", 0.00, ship2);
    createActivityIfNotFound(faker.date().birthday(18, 60), faker.date().birthday(18, 60),
        "Kid's games", "Animation for the kids", 0.00, ship3);
    createActivityIfNotFound(faker.date().birthday(18, 60), faker.date().birthday(18, 60),
        "Movie: La La Land", "La La Land at the movie theatre", 0.00, ship4);
    createActivityIfNotFound(faker.date().birthday(18, 60), faker.date().birthday(18, 60),
        "Movie: John Wick", "John Wick at the movie theatre", 0.00, ship5);
    createActivityIfNotFound(faker.date().birthday(18, 60), faker.date().birthday(18, 60),
        "Movie: Toy Story", "Toy Story at the movie theatre", 0.00, ship1);
    createActivityIfNotFound(faker.date().birthday(18, 60), faker.date().birthday(18, 60),
        "Exercise at the Pool", "Exercise inside the pool with our animators", 0.00, ship2);
    createActivityIfNotFound(faker.date().birthday(18, 60), faker.date().birthday(18, 60),
        "Yoga classes", "Yoga classes at the ship's gym", 0.00, ship3);
    createActivityIfNotFound(faker.date().birthday(18, 60), faker.date().birthday(18, 60),
        "Dj party", "Dj party by the ship's pool side", 0.0, ship4);
    createActivityIfNotFound(faker.date().birthday(18, 60), faker.date().birthday(18, 60),
        "Karaoke night", "Karaoke night at the theatre", 0.00, ship5);
    createActivityIfNotFound(faker.date().birthday(18, 60), faker.date().birthday(18, 60),
        "Fire Show", "Fire show by the pool", 0.00, ship1);
    createActivityIfNotFound(faker.date().birthday(18, 60), faker.date().birthday(18, 60),
        "Reading club", "Reading club at the main lobby", 0.00, ship2);
    createActivityIfNotFound(faker.date().birthday(18, 60), faker.date().birthday(18, 60),
        "Wave pool", "Wave pool created at the ship's pool", 0.00, ship3);
    createActivityIfNotFound(faker.date().birthday(18, 60), faker.date().birthday(18, 60),
        "Disco night", "Disco night at the ship's disco", 0.00, ship4);
    createActivityIfNotFound(faker.date().birthday(18, 60), faker.date().birthday(18, 60),
        "Evacuation test", "Evacuation test in case of emergency", 0.0, ship5);

    createServiceIfNotFound(ship1, 5.50, "Cocktails", "Cocktails at the bar");
    createServiceIfNotFound(ship2, 30.00, "Spa", "Access to the ship's spa");
    createServiceIfNotFound(ship3, 10.00, "Daycare", "Daycare for the smaller ones of the family");
    createServiceIfNotFound(ship4, 50.00, "Beauty Care",
        "Beauty care done by our team of professional therapists");
    createServiceIfNotFound(ship5, 6.50, "VIP Lounge", "Access to the VIP Lounge");
    createServiceIfNotFound(ship1, 29.99, "Room Service",
        "Full room service for the duration of the trip");
    createServiceIfNotFound(ship2, 80.00, "Full massage", "Full massage on the ship's spa");
    createServiceIfNotFound(ship3, 1.50, "Internet Access",
        "Access to the ship's Internet Network");
    createServiceIfNotFound(ship4, 10.00, "Gym", "Access to the ship's Gym");
    createServiceIfNotFound(ship5, 5.00, "Movie Theatre", "Access to the ship's movie theatre");
    createServiceIfNotFound(ship1, 19.99, "Pool Service",
        "Full service by the pool for the duration of the trip");
    createServiceIfNotFound(ship2, 50.00, "Back massage", "Back massage on the ship's spa");
    createServiceIfNotFound(ship3, 9.00, "Souvenir", "Souvenirs from the ship's gift shop");
    createServiceIfNotFound(ship4, 35.00, "Table reservation",
        "Table reservation at the ship's dining hall");
    createServiceIfNotFound(ship5, 15.00, "Towel reservation",
        "Reserve a towel for the day at the ship's pool");

    Scale scale1 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), shangai);
    Scale scale2 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), singapore);
    Scale scale3 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), busan);
    Scale scale4 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), tokio);
    Scale scale5 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), barcelona);
    Scale scale6 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), valencia);
    Scale scale7 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), jeddah);
    Scale scale8 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), istambul);
    Scale scale9 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), roterdam);
    Scale scale10 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), amberes);
    Scale scale11 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), hamburg);
    Scale scale12 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), ny);
    Scale scale13 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), santos);
    Scale scale14 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), colon);
    Scale scale15 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), la);
    Scale scale16 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), la);
    Scale scale17 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), tokio);
    Scale scale18 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), busan);
    Scale scale19 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), istambul);
    Scale scale20 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), valencia);
    Scale scale21 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), roterdam);
    Scale scale22 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), hamburg);
    Scale scale23 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), ny);
    Scale scale24 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), santos);
    Scale scale25 = createScaleIfNotFound(LocalDate.now(), LocalDate.now(), colon);

    Collection<Scale> scales1 = new ArrayList<>(4);
    scales1.add(scale1);
    scales1.add(scale2);
    scales1.add(scale3);
    scales1.add(scale4);
    Collection<Scale> scales2 = new ArrayList<>(4);
    scales1.add(scale5);
    scales1.add(scale6);
    scales1.add(scale7);
    scales1.add(scale8);
    Collection<Scale> scales3 = new ArrayList<>(3);
    scales1.add(scale9);
    scales1.add(scale10);
    scales1.add(scale11);
    Collection<Scale> scales4 = new ArrayList<>(4);
    scales1.add(scale12);
    scales1.add(scale13);
    scales1.add(scale14);
    scales1.add(scale15);
    Collection<Scale> scales5 = new ArrayList<>(10);
    scales1.add(scale16);
    scales1.add(scale17);
    scales1.add(scale18);
    scales1.add(scale19);
    scales1.add(scale20);
    scales1.add(scale21);
    scales1.add(scale22);
    scales1.add(scale23);
    scales1.add(scale24);
    scales1.add(scale25);


    Trip trip1 = createTripIfNotFound(LocalDate.now(), LocalDate.now(), ship1, "Asia", scales1);
    Trip trip2 =
        createTripIfNotFound(LocalDate.now(), LocalDate.now(), ship2, "Mediterranean", scales2);
    Trip trip3 =
        createTripIfNotFound(LocalDate.now(), LocalDate.now(), ship3, "Northern Seas", scales3);
    Trip trip4 = createTripIfNotFound(LocalDate.now(), LocalDate.now(), ship4, "Atlantic", scales4);
    Trip trip5 =
        createTripIfNotFound(LocalDate.now(), LocalDate.now(), ship5, "Around the World", scales5);

    createTourIfNotFound(LocalDate.now(), LocalDate.now(), scale1, "Shangai Tour",
        "Tour around Shangai", 10.00, ship1);
    createTourIfNotFound(LocalDate.now(), LocalDate.now(), scale3, "Busan Tour",
        "Tour around Busan", 30.00, ship1);
    createTourIfNotFound(LocalDate.now(), LocalDate.now(), scale14, "Colon Tour",
        "Tour around Colon", 20.00, ship4);
    createTourIfNotFound(LocalDate.now(), LocalDate.now(), scale7, "Jeddah Tour",
        "Tour around Jeddah", 20.00, ship2);
    createTourIfNotFound(LocalDate.now(), LocalDate.now(), scale6, "Valencia Tour",
        "Tour around Valencia", 20.00, ship2);
    createTourIfNotFound(LocalDate.now(), LocalDate.now(), scale8, "Istambul Tour",
        "Tour around Istambul", 20.00, ship2);
    createTourIfNotFound(LocalDate.now(), LocalDate.now(), scale19, "Istambul Tour",
        "Tour around Istambul", 20.00, ship5);
    createTourIfNotFound(LocalDate.now(), LocalDate.now(), scale22, "Hamburg Tour",
        "Tour around Hamburg", 20.00, ship5);
    createTourIfNotFound(LocalDate.now(), LocalDate.now(), scale4, "Tokio Tour",
        "Tour around Tokio", 20.00, ship1);
    createTourIfNotFound(LocalDate.now(), LocalDate.now(), scale5, "Barcelona Tour",
        "Tour around Barcelona", 20.00, ship2);
    createTourIfNotFound(LocalDate.now(), LocalDate.now(), scale16, "LA Tour", "TOur around LA",
        20.00, ship5);
    createTourIfNotFound(LocalDate.now(), LocalDate.now(), scale11, "Hamburg Tour",
        "Tour around Hamburg", 20.00, ship3);
    createTourIfNotFound(LocalDate.now(), LocalDate.now(), scale1, "Shangai Tour night",
        "Tour around Shangai at night", 20.00, ship1);
    createTourIfNotFound(LocalDate.now(), LocalDate.now(), scale10, "Amberes Tour",
        "Tour around Amberes", 20.00, ship3);
    createTourIfNotFound(LocalDate.now(), LocalDate.now(), scale21, "Rotterdam Tour",
        "Tour around Rotterdam", 20.00, ship5);
  }

  void fakeData() {
    if (!alreadySetup) {
      createUserIfNotFound("admin@okto.com", "Test", "Test", "okto", "00000000O", "000000000",
          User.Role.ADMIN);
      createUserIfNotFound("user@okto.com", "Test", "Test", "okto", "00000000O", "000000000",
          User.Role.USER);
      createUserIfNotFound("manager@okto.com", "Test", "Test", "okto", "00000000O", "000000000",
          User.Role.MANAGER);
      alreadySetup = true;

      for (int i = 0; i < 10; ++i) {
        createUserIfNotFound(faker.internet().safeEmailAddress(), faker.name().firstName(),
            faker.name().lastName(), faker.internet().password(), faker.bothify("########?"),
            faker.numerify("6########"), User.Role.USER);

        Ship ship1 = createShipIfNotFound(faker.name().name());

        createActivityIfNotFound(faker.date().birthday(18, 60), faker.date().birthday(18, 60),
            faker.name().name(), faker.name().name(), 0.0, ship1);

        Ship ship2 = createShipIfNotFound(faker.name().name());
        createServiceIfNotFound(ship2, faker.random().nextDouble(), faker.name().firstName(),
            faker.name().name());

        createCityIfNotFound(faker.name().name(), faker.name().name());

        Ship ship3 = createShipIfNotFound(faker.name().name());
        City city = createCityIfNotFound(faker.name().name(), faker.name().name());
      }
    }
  }

  @Transactional
  void createUserIfNotFound(final String email, final String firstName, final String lastName,
      final String password, final String dni, final String phone, final String role) {
    User user = userRepository.findByEmailIgnoreCase(email);
    if (user == null) {
      user = new User();
      user.setEmail(email);
      user.setFirstName(firstName);
      user.setLastName(lastName);
      user.setPassword(passwordEncoder.encode(password));
      user.setDni(dni);
      user.setPhone(phone);
      user.setRole(role);
      user.setEnabled(true);
      userRepository.save(user);
    }
  }

  @Transactional
  Trip createTripIfNotFound(final LocalDate start, final LocalDate end, final Ship ship,
      final String name, final Collection<Scale> scales) {
    Trip trip = tripRepository.findByStartAfter(start);
    if (trip == null) {
      trip = new Trip();
      trip.setStart(start);
      trip.setEnd(end);
      trip.setShip(ship);
      trip.setName(name);
      trip.setScales(scales);
      tripRepository.save(trip);
    }
    return trip;
  }

  @Transactional
  void createActivityIfNotFound(final Date start, final Date end, final String name,
      final String description, final Double price, final Ship ship) {
    Activity act = actRepository.findByNameIgnoreCase(name);
    if (act == null) {
      act = new Activity();
      act.setStart(start);
      act.setEnd(end);
      act.setName(name);
      act.setDescription(description);
      act.setPrice(price);
      act.setShip(ship);
      actRepository.save(act);
    }
  }

  @Transactional
  void createServiceIfNotFound(final Ship ship, final Double price, final String name,
      final String description) {
    Service service = serviceRepository.findByNameIgnoreCase(name);
    if (service == null) {
      service = new Service();
      service.setDescription(description);
      service.setName(name);
      service.setPrice(price);
      service.setShip(ship);
      serviceRepository.save(service);
    }
  }

  @Transactional
  Ship createShipIfNotFound(final String name) {
    Ship ship = shipRepository.findByNameIgnoreCase(name);
    if (ship == null) {
      ship = new Ship();
      ship.setName(name);
      shipRepository.save(ship);
    }
    return ship;
  }

  @Transactional
  Scale createScaleIfNotFound(final LocalDate start, final LocalDate end, final City city) {
    Scale scale = scaleRepository.findByStartAfter(start);
    if (scale == null) {
      scale = new Scale();
      scale.setStart(start);
      scale.setEnd(end);
      scale.setCity(city);
      scaleRepository.save(scale);
    }
    return scale;
  }

  @Transactional
  City createCityIfNotFound(final String name, final String description) {
    City city = cityRepository.findByNameIgnoreCase(name);
    if (city == null) {
      city = new City();
      city.setName(name);
      city.setDescription(description);
      cityRepository.save(city);
    }
    return city;
  }

  @Transactional
  void createTourIfNotFound(final LocalDate start, final LocalDate end, final Scale scale,
      final String name, final String description, final Double price, final Ship ship) {
    Tour tour = tourRepository.findByStartAfter(start);
    if (tour == null) {
      tour = new Tour();
      tour.setStart(start);
      tour.setEnd(end);
      tour.setScale(scale);
      tour.setName(name);
      tour.setDescription(description);
      tour.setPrice(price);
      tour.setShip(ship);
      tourRepository.save(tour);
    }
  }

  @Transactional
  void createTipIfNotFound(final City city, final String description) {
    Tip tip = tipRepository.findByDescriptionIgnoreCase(description);
    if (tip == null) {
      tip = new Tip();
      tip.setCity(city);
      tip.setDescription(description);
      tipRepository.save(tip);
    }
  }
}
