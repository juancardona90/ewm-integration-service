package eis.entrypoints;

import eis.core.models.Appointment;
import eis.core.usecases.ports.input.AppointmentNotification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/appointments")
public class AppointmentController {

    private final AppointmentNotification appointmentNotification;

    @PostMapping("/notify")
    public ResponseEntity<Appointment> notify(@RequestBody Appointment appointment) {
        return new ResponseEntity<>(appointmentNotification.notifyAppointment(appointment), HttpStatus.OK);
    }
}
