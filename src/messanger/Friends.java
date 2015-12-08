/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messanger;

import java.util.List;

/**
 *
 * @author Jakub
 */
public class Friends {
    public List<Integer> friends_id;

    public List<Integer> getFriends_id() {
        return friends_id;
    }

    public void setFriends_id(int id) {
        friends_id.add(id);
    }
    
    
}
