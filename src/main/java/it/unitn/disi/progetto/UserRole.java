package it.unitn.disi.progetto;

public enum UserRole {
    ADMIN("Admin"),
    ADERENTE("Aderente"),
    SIMPATIZZANTE("Simpatizzante");

    public final String label;

    private UserRole(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}


