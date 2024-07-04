package eis.adapters.broker;

import eis.core.models.Appointment;
import eis.core.usecases.ports.output.Publisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PublisherImpl implements Publisher {

    @Override
    public Appointment publish(Appointment appointment) {
        try {
            log.info("{} adapter layer", appointment.toString());
            return appointment;

        } catch (Exception exception) {
            log.error("Error while send:{}", appointment, exception);
            throw new RuntimeException();
        }
    }
}
