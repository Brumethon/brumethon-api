package com.brumethon.app.domain.referent;

import com.brumethon.app.domain.user.User;
import com.brumethon.kernel.Entity;

public class Referent extends Entity<Long> {

    private final boolean isOffLine;

    private final int distanceMax;

    private final User user;

    public Referent(Long id, boolean isOffLine, int distanceMax, User user) {
        super(id);
        this.isOffLine = isOffLine;
        this.distanceMax = distanceMax;
        this.user = user;
    }

    public boolean isOffLine() {
        return isOffLine;
    }

    public int getDistanceMax() {
        return distanceMax;
    }

    public User getUser() {
        return user;
    }
}
