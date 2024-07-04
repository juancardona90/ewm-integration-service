package eis.core.usecases.ports.input;

import eis.core.models.Appointment;

public interface AppointmentNotification {
    Appointment notifyAppointment(Appointment appointment);
}
