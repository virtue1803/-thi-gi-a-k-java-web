package dev.skyherobrine.giuaky_t4_t1315.enums;

import javax.management.relation.Role;

public enum Roles {
    ADMINISTRATOR(1), STAFF(2), MANAGER(3), EXECUTIVE(4);

    private int value;

    Roles(int value) {
        this.value = value;
    }

    public static Roles getRole(String role) {
        if(role.toUpperCase().equalsIgnoreCase(ADMINISTRATOR.toString()))
            return ADMINISTRATOR;
        else if(role.toUpperCase().equalsIgnoreCase(STAFF.toString()))
            return STAFF;
        else if(role.toUpperCase().equalsIgnoreCase(MANAGER.toString()))
            return MANAGER;
        else return EXECUTIVE;
    }
}
