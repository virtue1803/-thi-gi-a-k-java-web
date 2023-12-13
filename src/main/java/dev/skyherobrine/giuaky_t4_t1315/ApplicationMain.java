package dev.skyherobrine.giuaky_t4_t1315;

import dev.skyherobrine.giuaky_t4_t1315.enums.Roles;
import dev.skyherobrine.giuaky_t4_t1315.models.Candidate;
import dev.skyherobrine.giuaky_t4_t1315.models.Experience;
import dev.skyherobrine.giuaky_t4_t1315.services.impl.CandidateService;
import dev.skyherobrine.giuaky_t4_t1315.services.impl.ExperienceService;

import java.time.LocalDate;
import java.util.Arrays;

public class ApplicationMain {
    public static void main(String[] args) {
        Candidate[] candidates = new Candidate[3];
        candidates[0] = new Candidate("John Smith", "john@gmail.com", "0123456789");
        candidates[1] = new Candidate("Henry Smith", "henry@gmail.com", "0987654321");
        candidates[2] = new Candidate("Torch Kaimun", "torch@gmail.com", "0864213579");

        Experience[] experiences = new Experience[9];
        experiences[0] = new Experience("IT Services", LocalDate.of(2022, 1, 1),
                LocalDate.of(2023, 1, 1), Roles.EXECUTIVE, "Build Website by Java Full Stack", candidates[0]);
        experiences[1] = new Experience("IT Services", LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 5, 1), Roles.STAFF, "Build Website by Java Full Stack", candidates[0]);
        experiences[2] = new Experience("IT Services", LocalDate.of(2023, 5, 1),
                LocalDate.of(2023, 12, 1), Roles.MANAGER, "Build Website by Java Full Stack", candidates[0]);

        experiences[3] = new Experience("Mosh IT", LocalDate.of(2020, 5, 10),
                LocalDate.of(2020, 9, 20), Roles.EXECUTIVE, "Development Mobile Application", candidates[1]);
        experiences[4] = new Experience("Mosh IT", LocalDate.of(2020, 5, 11),
                LocalDate.of(2020, 12, 1), Roles.MANAGER, "Development Mobile Application", candidates[1]);
        experiences[5] = new Experience("Mosh IT", LocalDate.of(2020, 12, 2),
                LocalDate.now(), Roles.ADMINISTRATOR,"Development Mobile Application", candidates[1]);

        experiences[6] = new Experience("Intel Company", LocalDate.of(2015, 3, 20),
                LocalDate.of(2016, 3, 20), Roles.EXECUTIVE, "Product CPU", candidates[2]);
        experiences[7] = new Experience("Intel Company", LocalDate.of(2016,3 ,21),
                LocalDate.of(2017, 3, 21), Roles.STAFF, "Product CPU", candidates[2]);
        experiences[8] = new Experience("Intel Company", LocalDate.of(2017, 3, 22),
                LocalDate.now(), Roles.MANAGER, "Product CPU", candidates[2]);

        Arrays.stream(candidates).forEach(target -> {
            new CandidateService().insert(target);
        });

        Arrays.stream(experiences).forEach(target -> {
            new ExperienceService().insert(target);
        });
    }
}
