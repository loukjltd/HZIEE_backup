package com.loukjltd.demofragments;

import java.util.List;

public interface OnInteractionListener {
    public User getUser();
    public List<User> getFriends();
    public void addFriend(User user);
}
