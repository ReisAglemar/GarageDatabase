package edu.reis.garageDatabase.model;

import edu.reis.garageDatabase.erro.register.ExceptionRegister;

public enum NumberPiston {

    UM_PISTAO("1"),
    DOIS_PISTOES("2"),
    TRES_PISTOES("3"),
    QUATRO_PISTOES("4"),
    CINCO_PISTOES("5"),
    SEIS_PISTOES("6"),
    OITO_PISTOES("8"),
    DEZ_PISTOES("10"),
    ELETRICO("electric"),
    ;

    private String description;

    NumberPiston(String description) {
        this.description = description;
    }

    public static NumberPiston fromDescription(String description) throws ExceptionRegister {
        for (NumberPiston type : NumberPiston.values()) {
            if (type.description.equals(description)) {
                return type;
            }
        }
        throw new ExceptionRegister("O tipo de motor cadastrado não existe");
    }
}
