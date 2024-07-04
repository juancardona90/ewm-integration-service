package eis.entrypoints;

import eis.core.models.Appointment;
import eis.core.usecases.ports.input.AppointmentNotification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static eis.entrypoints.util.ControllersUtil.buildAppointment;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TestControllerAppointment {

    @InjectMocks
    private AppointmentController appointmentController;

    @Mock
    private AppointmentNotification appointmentNotification;

    @Test
    void shouldSaveAnAppointment_when_sendAppointmentModel() {
        var appointment = buildAppointment();
        when(appointmentNotification.notifyAppointment(appointment)).thenReturn(appointment);
        ResponseEntity<Appointment> notified = appointmentController.notify(appointment);
        assertEquals(appointment, notified.getBody());
    }
}