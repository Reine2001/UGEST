package com.example.ugest;

public enum MenuItemId {
    HOME(R.id.home),
    SHORTS(R.id.shorts),
    SUBSCRIPTIONS(R.id.subscriptions),
    LIBRARY(R.id.library);

    private final int id;

    MenuItemId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static MenuItemId fromId(int id) {
        for (MenuItemId menuItemId : MenuItemId.values()) {
            if (menuItemId.id == id) {
                return menuItemId;
            }
        }
        throw new IllegalArgumentException("Invalid MenuItemId ID: " + id);
    }

}
