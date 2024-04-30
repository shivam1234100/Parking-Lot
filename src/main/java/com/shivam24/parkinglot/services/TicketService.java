package com.shivam24.parkinglot.services;

import com.shivam24.parkinglot.exceptions.InvalidGateException;
import com.shivam24.parkinglot.models.Gate;
import com.shivam24.parkinglot.models.Ticket;
import com.shivam24.parkinglot.models.VehicleType;
import com.shivam24.parkinglot.repositories.GateRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gate;

    public TicketService(GateRepository gate) {
        this.gate = gate;
    }

    public Ticket issueTicket(Long gateId, String vehicleNumber, VehicleType vehicleType, String ownerName) throws InvalidGateException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Optional<Gate> optionalGate = gate.findById(gateId);

        if (optionalGate.isEmpty()) {
            throw new InvalidGateException("Invalid gate Id");
        }

        Gate gate = optionalGate.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getOperator());

        // TODO: add vehicle.


        return null;
    }
}
