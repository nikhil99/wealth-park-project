package employee.data;

import employee.data.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {

            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Bilbo",
                    "Baggins",
                    new DateTime().withDate(1992,2,5).getMillis(),
                    "501 New Heights Azabu",
                    2L,
                    750000d))));
            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Gilbert",
                    "Gurar",
                    new DateTime().withDate(1975,2,5).getMillis(),
                    "202 Maison Matsuda",
                    2L,
                    850000d))));
            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Pandurang",
                    "Parmar",
                    new DateTime().withDate(1992,2,5).getMillis(),
                    "201 Maison Matsuda",
                    0L,
                    100000d))));
            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Pandurang",
                    "Parmar",
                    new DateTime().withDate(1992,2,5).getMillis(),
                    "201 Maison Matsuda",
                    0L,
                    100000d))));
            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Pandurang",
                    "Parmar",
                    new DateTime().withDate(1992,2,5).getMillis(),
                    "201 Maison Matsuda",
                    0L,
                    100000d))));
            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Pandurang",
                    "Parmar",
                    new DateTime().withDate(1992,2,5).getMillis(),
                    "201 Maison Matsuda",
                    0L,
                    100000d))));
            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Pandurang",
                    "Parmar",
                    new DateTime().withDate(1992,2,5).getMillis(),
                    "201 Maison Matsuda",
                    0L,
                    100000d))));
            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Pandurang",
                    "Parmar",
                    new DateTime().withDate(1992,2,5).getMillis(),
                    "201 Maison Matsuda",
                    0L,
                    100000d))));
            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Pandurang",
                    "Parmar",
                    new DateTime().withDate(1992,2,5).getMillis(),
                    "201 Maison Matsuda",
                    0L,
                    100000d))));
            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Pandurang",
                    "Parmar",
                    new DateTime().withDate(1992,2,5).getMillis(),
                    "201 Maison Matsuda",
                    0L,
                    100000d))));
            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Pandurang",
                    "Parmar",
                    new DateTime().withDate(1992,2,5).getMillis(),
                    "201 Maison Matsuda",
                    0L,
                    100000d))));
            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Pandurang",
                    "Parmar",
                    new DateTime().withDate(1992,2,5).getMillis(),
                    "201 Maison Matsuda",
                    0L,
                    100000d))));
            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Pandurang",
                    "Parmar",
                    new DateTime().withDate(1992,2,5).getMillis(),
                    "201 Maison Matsuda",
                    0L,
                    100000d))));
            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Pandurang",
                    "Parmar",
                    new DateTime().withDate(1992,2,5).getMillis(),
                    "201 Maison Matsuda",
                    0L,
                    100000d))));
            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Pandurang",
                    "Parmar",
                    new DateTime().withDate(1992,2,5).getMillis(),
                    "201 Maison Matsuda",
                    0L,
                    100000d))));
            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Pandurang",
                    "Parmar",
                    new DateTime().withDate(1992,2,5).getMillis(),
                    "201 Maison Matsuda",
                    0L,
                    100000d))));
            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Pandurang",
                    "Parmar",
                    new DateTime().withDate(1992,2,5).getMillis(),
                    "201 Maison Matsuda",
                    0L,
                    100000d))));
            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Pandurang",
                    "Parmar",
                    new DateTime().withDate(1992,2,5).getMillis(),
                    "201 Maison Matsuda",
                    0L,
                    100000d))));
            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Pandurang",
                    "Parmar",
                    new DateTime().withDate(1992,2,5).getMillis(),
                    "201 Maison Matsuda",
                    0L,
                    100000d))));
            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Pandurang",
                    "Parmar",
                    new DateTime().withDate(1992,2,5).getMillis(),
                    "201 Maison Matsuda",
                    0L,
                    100000d))));
            log.info(String.format("Preloading %s", repository.save(new Employee(
                    "Pandurang",
                    "Parmar",
                    new DateTime().withDate(1992,2,5).getMillis(),
                    "201 Maison Matsuda",
                    0L,
                    100000d))));
        };
    }
}