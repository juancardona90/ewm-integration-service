package eis.core.usecases.ports.output;

import eis.core.models.Appointment;

public interface Publisher {

    Appointment publish(Appointment appointment);
}
