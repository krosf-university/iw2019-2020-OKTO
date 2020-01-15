package es.uca.iw.okto.backend.utils;

import java.time.LocalDate;
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
import es.uca.iw.okto.backend.models.Tour;
import es.uca.iw.okto.backend.models.Trip;
import es.uca.iw.okto.backend.models.User;
import es.uca.iw.okto.backend.repositories.ActivityRepository;
import es.uca.iw.okto.backend.repositories.CityRepository;
import es.uca.iw.okto.backend.repositories.ScaleRepository;
import es.uca.iw.okto.backend.repositories.ServiceRepository;
import es.uca.iw.okto.backend.repositories.ShipRepository;
import es.uca.iw.okto.backend.repositories.TourRepository;
import es.uca.iw.okto.backend.repositories.TripRepository;
import es.uca.iw.okto.backend.repositories.UserRepository;


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
  private PasswordEncoder passwordEncoder;

  private Faker faker = new Faker();

  @Override
  @Transactional
  public void onApplicationEvent(final ContextRefreshedEvent event) {
    fakeData();
  }

  void realData(){
    
  }

  
  void fakeData(){
    if (!alreadySetup) {
      createUserIfNotFound("admin@okto.com", "Test", "Test", "okto", "00000000O", "000000000",
          User.Role.ADMIN);
      createUserIfNotFound("user@okto.com", "Test", "Test", "okto", "00000000O", "000000000",
          User.Role.USER);
      createUserIfNotFound("gerente@okto.com", "Test", "Test", "okto", "00000000O", "000000000",
          User.Role.GERENTE);
      alreadySetup = true;

      for (int i = 0; i < 10; ++i) {
        createUserIfNotFound(
          faker.internet().safeEmailAddress(),
          faker.name().firstName(),
          faker.name().lastName(),
          faker.internet().password(),
          faker.bothify("########?"), 
          faker.numerify("6########"),
          User.Role.USER
        );

        Ship ship1 = createShipIfNotFound(faker.name().name());
        createTripIfNotFound(
          LocalDate.now(),
          LocalDate.now(),
          ship1,
          faker.name().name()
        );
        
        createActivityIfNotFound(
          faker.date().birthday(18, 60), 
          faker.date().birthday(18, 60), 
          faker.name().name()
        );
        
        Ship ship2 = createShipIfNotFound(faker.name().name());
        createServiceIfNotFound(
          ship2,
          faker.random().nextDouble(),
          faker.name().firstName(),
          faker.name().name()
        );

        createCityIfNotFound(
          faker.name().name(),
          faker.name().name()
        );

        Ship ship3 = createShipIfNotFound(faker.name().name());
        Trip trip = createTripIfNotFound(LocalDate.now(),LocalDate.now(), ship3, faker.name().name());
        City city = createCityIfNotFound(faker.name().name(),faker.name().name());
        createScaleIfNotFound(
          trip,
          LocalDate.now(),
          LocalDate.now(),
          city
        );

        createTourIfNotFound(
          LocalDate.now(),
          LocalDate.now()
        );
      }
    }
  }

  @Transactional
  void createUserIfNotFound(final String email, final String firstName, final String lastName,
      final String password, final String dni, final String phone, String role) {
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
  Trip createTripIfNotFound(final LocalDate start, final LocalDate end, Ship ship,final String name) {
    Trip trip = tripRepository.findByStartAfter(start);
    if (trip == null) {
      trip = new Trip();
      trip.setStart(start);
      trip.setEnd(end);
      trip.setShip(ship);
      trip.setName(name);
      tripRepository.save(trip);
    }
    return trip;
  }

  @Transactional
  void createActivityIfNotFound(final Date start, final Date end, final String name) {
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

}
