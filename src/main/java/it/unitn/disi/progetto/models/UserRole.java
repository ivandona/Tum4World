package it.unitn.disi.progetto.models;

public enum UserRole {
    AMMINISTRATORE("Amministratore"),
    ADERENTE("Aderente"),
    SIMPATIZZANTE("Simpatizzante");

    public final String label;

    private UserRole(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.name();
    }
}


