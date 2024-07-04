package eis.core.usecases;

import eis.core.models.Appointment;
import eis.core.usecases.ports.input.AppointmentNotification;

import eis.core.usecases.ports.output.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentNotificationImpl implements AppointmentNotification {

    private final Publisher publisher;

    @Override
    public Appointment notifyAppointment(Appointment appointment) {
        return publisher.publish(appointment);
    }
}
