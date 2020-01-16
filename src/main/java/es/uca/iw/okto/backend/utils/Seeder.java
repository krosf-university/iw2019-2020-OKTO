package es.uca.iw.okto.backend.utils;

import java.time.LocalDate;

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
    createUserIfNotFound("admin@okto.com", "Admin", "Okto", "okto", "00000000U", "000000000", User.Role.ADMIN);
    createUserIfNotFound("user@okto.com", "User", "Okto", "okto", "00000000V", "000000001", User.Role.USER);
    createUserIfNotFound("manager@okto.com", "Manager", "Okto", "okto", "00000000W", "000000002", User.Role.MANAGER);
    createUserIfNotFound("user1@okto.com", "Carlos Rodrigo", "Sanabria Flores", "krosf", "12345678A", "111111111", User.Role.USER);
    createUserIfNotFound("user2@okto.com", "Félix", "Rodríguez Pericacho", "frpericacho", "12345678B", "222222222", User.Role.USER);
    createUserIfNotFound("user3@okto.com", "Álvaro", "Braza Andrades", "albran", "12345678C", "333333333", User.Role.USER);
    createUserIfNotFound("user4@okto.com", "Borja", "Romero Fernández", "bjiro", "12345678D", "444444444", User.Role.USER);
    createUserIfNotFound("user5@okto.com", "Juan", "Ruiz Bonald", "wenwtf", "12345678E", "555555555", User.Role.USER);
    createUserIfNotFound("user6@okto.com", "Rubén", "Montero Domínguez", "rubentao", "12345678F", "666666666", User.Role.USER);
    createUserIfNotFound("user7@okto.com", "Carmen del Mar", "Ruiz de Celis", "dece1998", "12345678G", "777777777", User.Role.USER);
    createUserIfNotFound("user8@okto.com", "Esperanza", "Cano Canalejas", "alpHope26", "12345678H", "888888888", User.Role.USER);
    createUserIfNotFound("user9@okto.com", "Paloma", "Martínez-Esparza Castro", "lightwood17", "12345678I", "999999999", User.Role.USER);
    createUserIfNotFound("user10@okto.com", "Kevin", "López Cala", "666K3r04n98", "12345678J", "101010101", User.Role.USER);
    createUserIfNotFound("user11@okto.com", "Rafael", "Román Aguilar", "rafX356", "12345678K", "110110110", User.Role.USER);
    createUserIfNotFound("user12@okto.com", "Claudia", "Soriano Roldán", "AirPilot97", "12345678L", "121212121", User.Role.USER);
    createUserIfNotFound("user13@okto.com", "Pedro", "Soriano Ruiz", "333OhVish333", "12345678M", "131313131", User.Role.USER);
    createUserIfNotFound("user14@okto.com", "Raúl", "Escribano Corrales", "rescoX18", "12345678N", "141414141", User.Role.USER);
    createUserIfNotFound("user15@okto.com", "Pablo", "Granados Valencia", "granadEr0", "12345678O", "151515151", User.Role.USER);
    createUserIfNotFound("user16@okto.com", "Marta", "Rendón Salvador", "MaRt2335", "12345678P", "161616161", User.Role.USER);
    createUserIfNotFound("user17@okto.com", "Luis", "de Celis Muñoz", "90LdCM90", "12345678Q", "171717171", User.Role.USER);
    createUserIfNotFound("user18@okto.com", "José María", "Castaño Torres", "J0s3M4rI3lM3J0R", "12345678R", "181818181", User.Role.USER);
    createUserIfNotFound("user19@okto.com", "Antonio", "Espinosa Barrios", "98StrawHat", "12345678S", "191919191", User.Role.USER);
    createUserIfNotFound("user20@okto.com", "Pablo", "López Márquez", "d4rth", "12345678T", "202020202", User.Role.USER);

    Ship ship1 = createShipIfNotFound("Mayflower II");
    Ship ship2 = createShipIfNotFound("Dampfer");
    Ship ship3 = createShipIfNotFound("Arcadia");
    Ship ship4 = createShipIfNotFound("Pequod");
    Ship ship5 = createShipIfNotFound("Musashi");

    Trip trip1 = createTripIfNotFound(LocalDate.now(), LocalDate.now(), ship1);
    Trip trip2 = createTripIfNotFound(LocalDate.now(), LocalDate.now(), ship2);
    Trip trip3 = createTripIfNotFound(LocalDate.now(), LocalDate.now(), ship3);
    Trip trip4 = createTripIfNotFound(LocalDate.now(), LocalDate.now(), ship4);
    Trip trip5 = createTripIfNotFound(LocalDate.now(), LocalDate.now(), ship5);

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

    createActivityIfNotFound(LocalDate.now(), LocalDate.now(), "Pool party");
    createActivityIfNotFound(LocalDate.now(), LocalDate.now(), "Dinner with the Captain");
    createActivityIfNotFound(LocalDate.now(), LocalDate.now(), "Kid's games");
    createActivityIfNotFound(LocalDate.now(), LocalDate.now(), "Movie: La La Land");
    createActivityIfNotFound(LocalDate.now(), LocalDate.now(), "Movie: John Wick");
    createActivityIfNotFound(LocalDate.now(), LocalDate.now(), "Movie: Toy Story");
    createActivityIfNotFound(LocalDate.now(), LocalDate.now(), "Exercise at the Pool");
    createActivityIfNotFound(LocalDate.now(), LocalDate.now(), "Yoga classes");
    createActivityIfNotFound(LocalDate.now(), LocalDate.now(), "Dj party");
    createActivityIfNotFound(LocalDate.now(), LocalDate.now(), "Karaoke night");
    createActivityIfNotFound(LocalDate.now(), LocalDate.now(), "Fire Show");
    createActivityIfNotFound(LocalDate.now(), LocalDate.now(), "Reading club");
    createActivityIfNotFound(LocalDate.now(), LocalDate.now(), "Wave pool");
    createActivityIfNotFound(LocalDate.now(), LocalDate.now(), "Disco");
    createActivityIfNotFound(LocalDate.now(), LocalDate.now(), "Evacuation test");

    createServiceIfNotFound(ship1, 5.50, "Cocktails", "Cocktails at the bar");
    createServiceIfNotFound(ship2, 30.00, "Spa", "Access to the ship's spa");
    createServiceIfNotFound(ship3, 10.00, "Daycare", "Daycare for the smaller ones of the family");
    createServiceIfNotFound(ship4, 50.00, "Beauty Care", "Beauty care done by our team of professional therapists");
    createServiceIfNotFound(ship5, 6.50, "VIP Lounge", "Access to the VIP Lounge");
    createServiceIfNotFound(ship1, 29.99, "Room Service", "Full room service for the duration of the trip");
    createServiceIfNotFound(ship2, 80.00, "Full massage", "Full massage on the ship's spa");
    createServiceIfNotFound(ship3, 1.50, "Internet Access", "Access to the ship's Internet Network");
    createServiceIfNotFound(ship4, 10.00, "Gym", "Access to the ship's Gym");
    createServiceIfNotFound(ship5, 5.00, "Movie Theatre", "Access to the ship's movie theatre");
    createServiceIfNotFound(ship1, 19.99, "Pool Service", "Full service by the pool for the duration of the trip");
    createServiceIfNotFound(ship2, 50.00, "Back massage", "Back massage on the ship's spa");
    createServiceIfNotFound(ship3, 9.00, "Souvenir", "Souvenirs from the ship's gift shop");
    createServiceIfNotFound(ship4, 35.00, "Table reservation", "Table reservation at the ship's dining hall");
    createServiceIfNotFound(ship5, 15.00, "Towel reservation", "Reserve a towel for the day at the ship's pool");

    createScaleIfNotFound(trip1, LocalDate.now(), LocalDate.now(), shangai);
    createScaleIfNotFound(trip1, LocalDate.now(), LocalDate.now(), singapore);
    createScaleIfNotFound(trip1, LocalDate.now(), LocalDate.now(), busan);
    createScaleIfNotFound(trip1, LocalDate.now(), LocalDate.now(), tokio);
    createScaleIfNotFound(trip2, LocalDate.now(), LocalDate.now(), barcelona);
    createScaleIfNotFound(trip2, LocalDate.now(), LocalDate.now(), valencia);
    createScaleIfNotFound(trip2, LocalDate.now(), LocalDate.now(), jeddah);
    createScaleIfNotFound(trip2, LocalDate.now(), LocalDate.now(), istambul);
    createScaleIfNotFound(trip3, LocalDate.now(), LocalDate.now(), roterdam);
    createScaleIfNotFound(trip3, LocalDate.now(), LocalDate.now(), amberes);
    createScaleIfNotFound(trip3, LocalDate.now(), LocalDate.now(), hamburg);
    createScaleIfNotFound(trip4, LocalDate.now(), LocalDate.now(), ny);
    createScaleIfNotFound(trip4, LocalDate.now(), LocalDate.now(), santos);
    createScaleIfNotFound(trip4, LocalDate.now(), LocalDate.now(), colon);
    createScaleIfNotFound(trip4, LocalDate.now(), LocalDate.now(), la);
    createScaleIfNotFound(trip5, LocalDate.now(), LocalDate.now(), la);
    createScaleIfNotFound(trip5, LocalDate.now(), LocalDate.now(), tokio);
    createScaleIfNotFound(trip5, LocalDate.now(), LocalDate.now(), busan);
    createScaleIfNotFound(trip5, LocalDate.now(), LocalDate.now(), istambul);
    createScaleIfNotFound(trip5, LocalDate.now(), LocalDate.now(), valencia);
    createScaleIfNotFound(trip5, LocalDate.now(), LocalDate.now(), roterdam);
    createScaleIfNotFound(trip5, LocalDate.now(), LocalDate.now(), hamburg);
    createScaleIfNotFound(trip5, LocalDate.now(), LocalDate.now(), ny);
    createScaleIfNotFound(trip5, LocalDate.now(), LocalDate.now(), santos);
    createScaleIfNotFound(trip5, LocalDate.now(), LocalDate.now(), colon);

    createTourIfNotFound(LocalDate.now(), LocalDate.now());
    createTourIfNotFound(LocalDate.now(), LocalDate.now());
    createTourIfNotFound(LocalDate.now(), LocalDate.now());
    createTourIfNotFound(LocalDate.now(), LocalDate.now());
    createTourIfNotFound(LocalDate.now(), LocalDate.now());
    createTourIfNotFound(LocalDate.now(), LocalDate.now());
    createTourIfNotFound(LocalDate.now(), LocalDate.now());
    createTourIfNotFound(LocalDate.now(), LocalDate.now());
    createTourIfNotFound(LocalDate.now(), LocalDate.now());
    createTourIfNotFound(LocalDate.now(), LocalDate.now());
    createTourIfNotFound(LocalDate.now(), LocalDate.now());
    createTourIfNotFound(LocalDate.now(), LocalDate.now());
    createTourIfNotFound(LocalDate.now(), LocalDate.now());
    createTourIfNotFound(LocalDate.now(), LocalDate.now());
    createTourIfNotFound(LocalDate.now(), LocalDate.now());
  }

  void fakeData() {
    if (!alreadySetup) {
      createUserIfNotFound("admin@okto.com", "Test", "Test", "okto", "00000000O", "000000000", User.Role.ADMIN);
      createUserIfNotFound("user@okto.com", "Test", "Test", "okto", "00000000O", "000000000", User.Role.USER);
      createUserIfNotFound("manager@okto.com", "Test", "Test", "okto", "00000000O", "000000000", User.Role.MANAGER);
      alreadySetup = true;

      for (int i = 0; i < 10; ++i) {
        createUserIfNotFound(faker.internet().safeEmailAddress(), faker.name().firstName(), faker.name().lastName(), faker.internet().password(), faker.bothify("########?"), faker.numerify("6########"), User.Role.USER);

        Ship ship1 = createShipIfNotFound(faker.name().name());
        createTripIfNotFound(LocalDate.now(), LocalDate.now(), ship1);

        createActivityIfNotFound(LocalDate.now(), LocalDate.now(), faker.name().name());

        Ship ship2 = createShipIfNotFound(faker.name().name());
        createServiceIfNotFound(ship2, faker.random().nextDouble(), faker.name().firstName(), faker.name().name());

        createCityIfNotFound(faker.name().name(), faker.name().name());

        Ship ship3 = createShipIfNotFound(faker.name().name());
        Trip trip = createTripIfNotFound(LocalDate.now(), LocalDate.now(), ship3);
        City city = createCityIfNotFound(faker.name().name(), faker.name().name());
        createScaleIfNotFound(trip, LocalDate.now(), LocalDate.now(), city);

        createTourIfNotFound(LocalDate.now(), LocalDate.now());
      }
    }
  }

  @Transactional
  void createUserIfNotFound(final String email, final String firstName, final String lastName, final String password, final String dni, final String phone, String role) {
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
  Trip createTripIfNotFound(final LocalDate start, final LocalDate end, Ship ship) {
    Trip trip = tripRepository.findByStartAfter(start);
    if (trip == null) {
      trip = new Trip();
      trip.setStart(start);
      trip.setEnd(end);
      trip.setShip(ship);
      tripRepository.save(trip);
    }
    return trip;
  }

  @Transactional
  void createActivityIfNotFound(final LocalDate start, final LocalDate end, final String name) {
    Activity act = actRepository.findByNameIgnoreCase(name);
    if (act == null) {
      act = new Activity();
      act.setStart(start);
      act.setEnd(end);
      act.setName(name);
      actRepository.save(act);
    }
  }

  @Transactional
  void createServiceIfNotFound(Ship ship, final Double price, final String name, final String description) {
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
  void createScaleIfNotFound(Trip trip, final LocalDate start, final LocalDate end, City city) {
    Scale scale = scaleRepository.findByStartAfter(start);
    if (scale == null) {
      scale = new Scale();
      scale.setStart(start);
      scale.setEnd(end);
      scale.setCity(city);
      scaleRepository.save(scale);
    }
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
  void createTourIfNotFound(final LocalDate start, final LocalDate end) {
    Tour tour = tourRepository.findByStartAfter(start);
    if (tour == null) {
      tour = new Tour();
      tour.setStart(start);
      tour.setEnd(end);
      tourRepository.save(tour);
    }
  }

  @Transactional
  void createTipIfNotFound(final City city, final String description) {
    Tip tip = tipRepository.findByDescription(description);
    if (tip == null) {
      tip = new Tip();
      tip.setCity(city);
      tip.setDescription(description);
      tipRepository.save(tip);
    }
  }
}